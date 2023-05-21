package ru.itis.deshevin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.deshevin.security.details.UserEntityDetails;
import ru.itis.deshevin.services.FavouritesService;;import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/favourites")
public class FavouritesController {
    private final FavouritesService favouritesService;

    @GetMapping
    public String getFavouritesPage(@AuthenticationPrincipal UserEntityDetails userEntityDetails, Model model) {
        model.addAttribute("user", userEntityDetails.getUserEntity());
        model.addAttribute("favourites", favouritesService.getFavouriteDrugs(
                userEntityDetails.getUserEntity().getId()));
        return "favourites";
    }

    @GetMapping("/add-to-favourites/{drugId}")
    public String addItemToFavourites(@AuthenticationPrincipal UserEntityDetails userEntityDetails,
                                      @PathVariable("drugId") UUID drugId, Model model) {
        model.addAttribute("user", userEntityDetails.getUserEntity());
        favouritesService.addDrugToFavourites(userEntityDetails.getUserEntity().getId(), drugId);
        return "redirect:/favourites";
    }

    @GetMapping("/delete-from-favourites/{drugId}")
    public String deleteItemFromFavourites(@AuthenticationPrincipal UserEntityDetails userEntityDetails,
                                           @PathVariable("drugId") UUID drugId, Model model) {
        model.addAttribute("user", userEntityDetails.getUserEntity());
        favouritesService.deleteDrugFromFavourites(userEntityDetails.getUserEntity().getId(), drugId);
        return "redirect:/favourites";
    }
}
