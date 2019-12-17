package pl.sda.spiring.miniblog12;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.spiring.miniblog12.service.CurrentDateTimeProvider;
import pl.sda.spiring.miniblog12.service.CurrentDateTimeService;
import pl.sda.spiring.miniblog12.service.UserSessionService;

import java.util.Set;

//@Component
@Controller
public class MainController {

    @Autowired
    private CurrentDateTimeService currentDateTimeService;

    @Autowired
    private UserSessionService userSessionService;

    @Autowired
    private Set<MessageProvider> messageProvider;


    @RequestMapping(value = {"/", "/home"}) //sciezka na ktora spirong wywola ta medode
    public String home(Model model ) {
        model.addAttribute("userLogged", userSessionService.isLogged());
        messageProvider.forEach(mp -> System.out.println(mp.getMessage()));
        model.addAttribute("date", currentDateTimeService.getMessage());
        return "homePage";
    }

//    @RequestMapping("/hello")
//    public String hello(Model model) {
//        model.addAttribute("name", "Adam");
//        return "helloPage";
//    }

    //@RequestMapping(name="/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(required = false, name = "name") String nameParam) {

        model.addAttribute("name", nameParam);
        System.out.println("Hello " + nameParam);
        model.addAttribute("date", currentDateTimeService.getMessage());
        return "helloPage";
    }


    @RequestMapping("/params")
    public String params(@RequestParam(required = false, name = "test") String testParam) {
        System.out.println("Param test: " + testParam);
        return "params";
    }



}
