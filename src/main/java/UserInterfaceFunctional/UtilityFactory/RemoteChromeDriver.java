package UserInterfaceFunctional.UtilityFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Remote Chrome Web Driver for Docker
 */
public class RemoteChromeDriver implements DriverFactory {
    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    URL url;
    DesiredCapabilities desiredCapabilities;
    ChromeOptions chromeOptions;
    @Override
    public void initializeBrowser() {
        try {
            //desiredCapabilities = DesiredCapabilities.chrome();
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--ignore-ssl-errors=yes");
            chromeOptions.addArguments("--ignore-certificate-errors");
            url = new URL("http://localhost:4444/wd/hub");
            this.driver.set(new RemoteWebDriver(url,chromeOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setDriver(WebDriver driver) {
        //this.driver.set(driver);
    }

    @Override
    public WebDriver getDriverInstance() {
        return driver.get();
    }
}
