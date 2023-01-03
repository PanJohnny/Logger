import org.junit.Test;

public class LoggerTest {
    @Test
    public void testLoggerV2() {
        System.Logger logger = System.getLogger("TEST");

        logger.log(System.Logger.Level.INFO, "Did you know that a {0} gives {1}", "cow", "milk");
        logger.log(System.Logger.Level.WARNING, "Don't touch that button!");
        logger.log(System.Logger.Level.DEBUG, "User pressed the button");
        logger.log(System.Logger.Level.ERROR, "I said don't press it. OMG!");
        logger.log(System.Logger.Level.OFF, "Look what you've done", new Exception("Button exception"));
    }
}
