package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitDriver {

    public WebDriver driver;

    public InitDriver(WebDriver driver){
        init(driver);
    }

    private void init(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
