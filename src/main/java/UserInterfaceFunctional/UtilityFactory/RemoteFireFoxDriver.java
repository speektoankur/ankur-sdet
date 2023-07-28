package UserInterfaceFunctional.UtilityFactory;

import UserInterfaceFunctional.Utility.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFireFoxDriver extends TestBase implements DriverFactory {
    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    URL url;
    FirefoxOptions firefoxOptions;

    @Override
    public void initializeBrowser() {
        try {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--ignore-ssl-errors=yes");
            firefoxOptions.addArguments("--ignore-certificate-errors");
            url = new URL(TestBase.getProperty("config.properties","firefoxRemote"));
            this.driver.set(new RemoteWebDriver(url, firefoxOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDriver(WebDriver driver) {

    }

    @Override
    public WebDriver getDriverInstance() {
        return null;
    }
}
