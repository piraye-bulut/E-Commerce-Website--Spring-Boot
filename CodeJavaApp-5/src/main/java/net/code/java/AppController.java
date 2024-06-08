package net.code.java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	private final UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserRepository repo;
  
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }


    @GetMapping("/signup_form")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }
   

    @PostMapping("/signup_form")
    public String signUp(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "login";
    }


    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword= encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";
    }
  
 
    @GetMapping("/products")
    public String viewUserList() {
    	return "products";
    }
    /**
    @GetMapping("/cosmetics")
    public String viewCosmeticsPage() {
    	return "cosmetics";
    }
   */
    @GetMapping("/login")
    public String showLoginForm() {
    
        return "login"; 
    }
  


}

