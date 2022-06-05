package UserInterfaceFunctional.UtilityFactory;

import org.openqa.selenium.WebDriver;

public abstract class DriverFactory {

    abstract void initializeBrowser();
    abstract void setDriver(WebDriver driver);
    abstract WebDriver getDriverInstance();
}
