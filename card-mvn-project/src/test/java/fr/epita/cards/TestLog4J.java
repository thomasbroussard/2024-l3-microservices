package fr.epita.cards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestLog4J {
    private static final Logger LOGGER = LogManager.getLogger(TestLog4J.class);


    @Test
    public void test(){

       LOGGER.error("when an error occurs");
       LOGGER.warn("when an warning is to be emitted");
       LOGGER.info("Test message in info");
       LOGGER.debug("for the developer");
       LOGGER.trace("maximum details");

    }
}
