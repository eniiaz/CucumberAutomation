package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tests.MyClass;

public class MyLogger {

    private static final Logger logger = LogManager.getLogger(MyClass.class);

   public static void info(String message){
       logger.info(message);
   }

   public static void warn(String message){
       logger.warn(message);
   }

   public static void error(String message){
       logger.error(message);
   }
}
