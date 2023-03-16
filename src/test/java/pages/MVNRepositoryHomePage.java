package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MVNRepositoryHomePage {

    public MVNRepositoryHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
