package com.example.secapp.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService register;
    private Logger log = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/registration")
    public String registerForm(Model model, AccountDto accountDto) {
        model.addAttribute("accountDto", accountDto);
        return "registration/create";
    }

    @PostMapping("/registration")
    public String savePublicRegistration(@Valid @ModelAttribute AccountDto accountDto,
                                         BindingResult result, Model model) {
        log.info("username: ", accountDto.getUsername());
        result.getAllErrors().forEach(
                er -> log.info("error {}", er.toString())
        );
        if (result.hasErrors()) {
            return "registration/create";
        }

        try {
            register.saveNew(accountDto);
        } catch (Exception ex) {
            log.info("excception {}", ex.getMessage());
            model.addAttribute("exception", ex.getMessage());
            return "registration/create";
    }
//        success
        return "redirect:/login";
    }
}
