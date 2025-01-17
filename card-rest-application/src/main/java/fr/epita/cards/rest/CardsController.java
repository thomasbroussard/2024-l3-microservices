package fr.epita.cards.rest;


import fr.epita.cards.rest.messages.CardDTO;
import fr.epita.cards.services.data.impl.jpa.CardJPADAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController("/api/v1")
public class CardsController {

    public static final String API_CARDS = "/api/cards/";
    @Autowired
    CardJPADAO cardDAO;

    @GetMapping("/cards")
    public String test() {
        return "cards endpoint";
    }


    @PostMapping(value = "/cards",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public ResponseEntity<String> createCard(@RequestBody CardDTO card) {
        try {
            cardDAO.create(card);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        String id = String.valueOf(card.getId());
        URI location = URI.create(id);
        return ResponseEntity.created(location).build();
    }

}
