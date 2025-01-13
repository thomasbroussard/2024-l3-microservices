package fr.epita.cards;

import fr.epita.cards.datamodel.Round;
import fr.epita.cards.services.data.impl.jpa.RoundJPADAO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@Transactional
public class TestRoundJPADAO {

    @Autowired
    RoundJPADAO dao;

    @Test
    public void test(){
        Round round = new Round();

        dao.create(round);

        //TODO assertion

    }
}
