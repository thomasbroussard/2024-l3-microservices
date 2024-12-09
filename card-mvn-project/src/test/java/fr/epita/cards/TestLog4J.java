package fr.epita.cards;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

public class TestLog4J {
    private static final Logger LOGGER = LogManager.getLogger(TestLog4J.class);

    @BeforeAll
    public static void globalSetUp(){
        LOGGER.info("beforeAll");
    }

    @BeforeEach
    public void setUp(){
        LOGGER.info("beforeEach");
    }


    @Test
    @DisplayName("REQ-001 This test shows how log4j is working")
    public void test(){

       LOGGER.error("when an error occurs");
       LOGGER.warn("when an warning is to be emitted");
       LOGGER.info("Test message in info");
       LOGGER.debug("for the developer");
       LOGGER.trace("maximum details");

    }

    @AfterEach
    public void cleanUp(){
        LOGGER.info("afterEach");
    }

    @AfterAll
    public static void globalCleanUp(){
        LOGGER.info("afterAll");
    }

}
