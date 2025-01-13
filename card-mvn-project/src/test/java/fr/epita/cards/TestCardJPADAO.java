package fr.epita.cards;

import fr.epita.cards.datamodel.Card;
import fr.epita.cards.services.data.impl.jpa.CardJPADAO;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@Transactional
public class TestCardJPADAO {


    @Autowired
    CardJPADAO dao;

    @Test
    public void test(){
        Card card = new Card(6, "HEART");

        dao.create(card);

        Assertions.assertThat(dao.get(card.getId())).isNotNull();
    }




}
