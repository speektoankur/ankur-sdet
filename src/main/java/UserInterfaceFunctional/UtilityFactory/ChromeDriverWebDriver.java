package UserInterfaceFunctional.UtilityFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Chrome Driver Instance
 *
 * @author Ankur
 */
public class ChromeDriverWebDriver implements DriverFactory {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Override
    public void initializeBrowser() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
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
