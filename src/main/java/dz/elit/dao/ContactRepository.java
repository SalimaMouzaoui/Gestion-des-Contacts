package dz.elit.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dz.elit.entities.Contact;
@Transactional
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	@Query("select c from Contact c where c.nom like :x")
	public Page<Contact> chercher(@Param("x") String mc, Pageable pageable);

}
