package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Driver;

public class Phone {

    static Logger logger = LogManager.getLogger(Phone.class);

    public static void main(String[] args) {
        System.out.println("hi");
        logger.info("After hi");
        logger.error("error yo");
        logger.warn("warning");
    }
}
