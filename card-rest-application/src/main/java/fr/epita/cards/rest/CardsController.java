package fr.epita.cards.rest;


import fr.epita.cards.services.data.impl.jpa.PlayerJPADAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @Autowired
    PlayerJPADAO jpadao;

    @GetMapping("/cards")
    public String test(){
        return "cards endpoint";
    }
}
