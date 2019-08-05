package co.grandcircus.CoffeeShop.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import co.grandcircus.CoffeeShop.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
}
