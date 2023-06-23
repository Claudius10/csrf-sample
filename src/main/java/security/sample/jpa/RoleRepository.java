package security.sample.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import security.sample.models.Role;

import java.util.Optional;

@Repository
public class RoleRepository {

	private final EntityManager em;

	public RoleRepository(EntityManager em) {
		this.em = em;
	}


	public void create(Role role) {
		em.persist(role);
	}

	public Optional<Role> findByName(String roleName) {
		TypedQuery<Role> query = em.createQuery("select r from Role r where r.name = :roleName", Role.class);
		query.setParameter("roleName", roleName);
		return query.getResultStream().findFirst();
	}
}
