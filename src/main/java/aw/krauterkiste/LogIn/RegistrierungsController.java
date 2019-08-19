package aw.krauterkiste.LogIn;


import aw.krauterkiste.Model.UserDto;
import aw.krauterkiste.Model.UserEntity;
import aw.krauterkiste.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class RegistrierungsController {

    private final RegisterService registerService;

    @Autowired
    public RegistrierungsController(IUserRepository userRepository, RegisterService registerService) {
        this.registerService = registerService;
    }

    /* beim Klicken des Registrierungsbuttons erstellen wir uns im Kontext einen neuen UserEntity und legen diesen im Kontext + weiterleiten zur registration.html*/
    @GetMapping(value = "/registrierung_neuerUser")
    public String registrierung_neuerUser(Model model,
                                          @RequestParam("error") String error) {
        model.addAttribute("neuerUser", new UserDto());
        model.addAttribute("error",error);
        return "registration";
    }

    @PostMapping(value = "/registrierungAbschliessen")
    public String registrierungAbschliessen(
            Model model,
            RedirectAttributes redirectAttributes,
            @ModelAttribute("neuerUser") UserDto neuerUser
            /* wir übergeben hier noch einen String Parameter, um die Passwörter zu vergleichen*/) {
        if(registerService.userCanBeRegistered(neuerUser)){
            registerService.registerUser(neuerUser);
            return "redirect:/";
        } else {
            redirectAttributes.addAttribute("error", "User exists or passwords mismatch!");
            return "redirect:/registrierung_neuerUser";
        }
    }
}
