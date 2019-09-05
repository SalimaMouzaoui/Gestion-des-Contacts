package dz.elit.contacts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dz.elit.dao.ContactRepository;
import dz.elit.entities.Contact;

@SpringBootApplication
//@EnableConfigurationProperties
@ComponentScan({"dz.elit.metier", "dz.elit.web"})
@EnableJpaRepositories(basePackages = "dz.elit.dao")
@EntityScan(basePackages = {"dz.elit.entities"})
public class ContactApplication implements CommandLineRunner{

	@Autowired
	private ContactRepository contactR;
	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactR.save(new Contact("Hassani", "Mohamed", df.parse("12/01/1998"), "hassani@gmail.com", 0661251320, "hassani.jpeg"));
		contactR.save(new Contact("ibrahimi", "khaled", df.parse("12/01/1998"), "ibrahimi@gmail.com", 0661251320, "ibrahimi.jpeg"));
		contactR.save(new Contact("Laairaichi", "kawtar", df.parse("12/01/1998"), "kawter@gmail.com", 0661251320, "kawter.jpeg"));
		contactR.findAll().forEach(c->{
			System.out.println(c.getNom());
		}
		);
	}

}

