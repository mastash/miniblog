package pl.sda.spiring.miniblog12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.sda.spiring.miniblog12.form.UserRegisterForm;
import pl.sda.spiring.miniblog12.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {


    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("userRegisterForm", new UserRegisterForm());
        return "user/registerForm";
    }

    @PostMapping("/register")
    public String handleRegisterForm(@ModelAttribute @Valid UserRegisterForm userRegisterForm, BindingResult bindingResult) {
        //model.addAttribute("firstName", firstNamme);
        //System.out.println(firstName + ", " + lastName+ ", " + email+ ", " + password);

        if (bindingResult.hasErrors()) {
            return "user/registerForm";
        }

        //    System.out.println(userRegisterForm);

        userService.registerUser(userRegisterForm);
        return "redirect:/home";
    }



    @GetMapping("/loginForm")
    public String handleLoginForm(@RequestParam String username, @RequestParam String password) {

        boolean userLogged = userService.loginUser(username,password);

        if (!userLogged) {
            return "user/loginForm";
        }
        return "redirect:/";
    }
}
