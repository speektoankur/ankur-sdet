package UserInterfaceFunctional.UtilityFactory;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {

    abstract void initializeBrowser();
    abstract void setDriver(WebDriver driver);
    abstract WebDriver getDriverInstance();
}
