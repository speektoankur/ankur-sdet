package UserInterfaceFunctional.UtilityFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Fire Fox Driver Instance
 * @author Ankur
 */
public class FireFoxWebDriver implements DriverFactory {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Override
    public void initializeBrowser() {
        WebDriverManager.firefoxdriver().setup();
        setDriver(new FirefoxDriver());
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @Override
    public WebDriver getDriverInstance() {
        return driver.get();
    }

}
