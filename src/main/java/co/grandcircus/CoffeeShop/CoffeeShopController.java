package co.grandcircus.CoffeeShop;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.CoffeeShop.dao.ProductDao;
import co.grandcircus.CoffeeShop.dao.UserDao;
import co.grandcircus.CoffeeShop.dao.UserRepository;
import co.grandcircus.CoffeeShop.entity.Product;
import co.grandcircus.CoffeeShop.entity.User;

@Controller
public class CoffeeShopController {
	@Autowired
	private ProductDao dao;

	@RequestMapping("/")
	public ModelAndView index() {
		List<Product> Products = dao.findAll();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("products", Products);
		return mv;

	}

	@RequestMapping("/register")
	public ModelAndView showRegister(User user) {
		return new ModelAndView("register");
	}
	

	@Autowired
	private UserDao daoUser;
	
	@Autowired
	private UserRepository das;

	@PostMapping("/register-result")
	public ModelAndView addRegisterResult(User yourname, HttpSession session) {
		daoUser.create(yourname);
		session.setAttribute("preference", yourname);
		return new ModelAndView("register-result");

	}

	@RequestMapping("/admin")
	public ModelAndView admin() {
		List<Product> Products = dao.findAll();
		ModelAndView mv = new ModelAndView("admin");
		mv.addObject("products", Products);
		return mv;

	}

	@RequestMapping
	public ModelAndView addproduct() {
		return new ModelAndView("add");
	}

	@PostMapping("/add")
	public ModelAndView addproduct(Product product) {
		dao.create(product);
		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping("/delete")
	public ModelAndView remove(@RequestParam("id") Long id) {
		dao.delete(id);
		return new ModelAndView("redirect:/admin");
	}
	@RequestMapping("/login")
	public ModelAndView showLogin() {
		return new ModelAndView("login-form");
	}
	
	@PostMapping("/login")
	public ModelAndView submitLogin(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session
			) {
		
		User user = das.findByUsernameAndPassword(username, password);
		System.out.println(user);
		
		if (user == null) {
			return new ModelAndView("login-form", "message", "Incorrect username or password.");
		}
		
		session.setAttribute("preference", user);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		// This clears the session and starts a brand new clean one.
		session.invalidate();
		
		return new ModelAndView("redirect:/");
}
}