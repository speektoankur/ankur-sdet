package UserInterfaceFunctional.UtilityFactory;

import UserInterfaceFunctional.Utility.TestBase;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Remote Chrome Web Driver for Docker
 */
@Getter
@Setter
public class RemoteChromeDriver implements DriverFactory {
    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    URL url;
    ChromeOptions chromeOptions;
    @Override
    public void initializeBrowser() {
        try {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--ignore-ssl-errors=yes");
            chromeOptions.addArguments("--ignore-certificate-errors");
            url = new URL(TestBase.getProperty("config.properties","chromeRemote"));
            this.driver.set(new RemoteWebDriver(url, chromeOptions));
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
