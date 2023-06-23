package security.sample.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import security.sample.models.User;

import java.util.Optional;

@Repository
public class UserRepository {

	private final EntityManager em;

	public UserRepository(EntityManager em) {
		this.em = em;
	}

	public void create(User user) {
		em.persist(user);
	}

	public Optional<User> findByUsername(String username) throws RuntimeException {
		TypedQuery<User> query = em.createQuery("select u from User u where u.username = :Username", User.class);
		query.setParameter("Username", username);
		return query.getResultStream().findFirst();
	}
}
