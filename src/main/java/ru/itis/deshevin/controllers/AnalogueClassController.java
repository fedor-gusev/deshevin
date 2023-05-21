package ru.itis.deshevin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.deshevin.dto.AnalogueClassDto;
import ru.itis.deshevin.dto.CategoryDto;
import ru.itis.deshevin.security.details.UserEntityDetails;
import ru.itis.deshevin.services.AnalogueClassService;

import java.util.UUID;

@Controller
@RequestMapping("/analogue")
@RequiredArgsConstructor
public class AnalogueClassController {

    private final AnalogueClassService analogueClassService;

    @GetMapping
    public String getAnalogueClassPage(@AuthenticationPrincipal UserEntityDetails userEntityDetails, Model model) {
        model.addAttribute("user", userEntityDetails.getUserEntity());
        model.addAttribute("analogues", analogueClassService.getAllAnalogueClass());
        return "analogue";
    }

    @PostMapping
    public String saveAnalogueClass(@ModelAttribute AnalogueClassDto analogueClassDto) {
        analogueClassService.saveAnalogueClass(analogueClassDto);
        return "redirect:analogue";
    }

    @DeleteMapping
    public String deleteCategory(@RequestParam UUID id) {
        analogueClassService.deleteAnalogueClass(id);
        return "redirect:analogue";
    }
}
