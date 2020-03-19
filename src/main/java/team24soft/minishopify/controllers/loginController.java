package team24soft.minishopify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team24soft.minishopify.models.User;
import team24soft.minishopify.repositories.CartRepository;
import team24soft.minishopify.repositories.ProductRepository;
import team24soft.minishopify.repositories.ShopRepository;
import team24soft.minishopify.repositories.UserRepository;

@Controller()
public class loginController {

    @Autowired
    ShopRepository shopRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam(name="username", required = true) String username,
                        @RequestParam(name="password", required = true) String password, Model model) {

        if (userRepository.findByUsername(username) == null) {

            model.addAttribute("msg", "User does not exist, register");

            return "index";
        }
        if (userRepository.findByUsername(username).getPassword().equals(password)) {
            User user = userRepository.findByUsername(username);
            user.setOnline(true);
            userRepository.save(user);
            model.addAttribute("user", user);
            return "welcome";
        }

        model.addAttribute("msg", "Either password or username are wrong");

        return "index";
    }

    @PostMapping("/register")
    public String register(@RequestParam(name="username", required = true) String username,
                           @RequestParam(name="password", required = true) String password,
                           @RequestParam(name="passwordRepeated", required = true) String passwordRepeated,
                           Model model){

        if(username.equals("") || password.equals("") || passwordRepeated.equals("")){
            model.addAttribute("msg", "There are empty fields");
            return "registration";
        }
        if(!password.equals(passwordRepeated)) {
            model.addAttribute("msg", "Passwords do not match");
            return "registration";
        }

        User user = new User(username, password);
        user.setOnline(true);
        userRepository.save(user);
        model.addAttribute("user", user);

        return "welcome";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        model.addAttribute("message", "");

        return "registration";
    }

    @GetMapping("/signOut")
    public String signOut(@RequestParam(name="userId", required = true) long userId, Model model){

        User user = userRepository.findById(userId);
        user.setOnline(false);
        userRepository.save(user);

        return "index";
    }


}
