package co.grandcircus.CoffeeShop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.CoffeeShop.entity.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	EntityManager em;

	public List<User> findAll() {
		List<User> users = em.createQuery("FROM User", User.class).getResultList();
		return users;
	}

	public User findbyId(Long id) {
		return em.find(User.class, id);
	}

	public void create(User user) {
		em.persist(user);
	}

	public void update(User user) {
		em.merge(user);
	}

	public void delete(Long id) {
		User user = em.getReference(User.class, id);
				em.remove(user);
	}
}
