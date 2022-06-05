package UserInterfaceFunctional.Utility;

import UserInterfaceFunctional.UtilityFactory.ChromeDriverWebDriver;
import UserInterfaceFunctional.UtilityFactory.FireFoxWebDriver;
import UserInterfaceFunctional.UtilityFactory.RemoteChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Ankur
 */
public class TestBase extends TestDataUtility{
    public ThreadLocal <WebDriver> driver = new ThreadLocal<>();
    public static Properties configProp;
    public EventFiringWebDriver e_driver;
    public WebEventListener eventListener;
    public ChromeDriverWebDriver chrome;
    public FireFoxWebDriver firefox;
    public RemoteChromeDriver remoteChrome;

    public TestBase() {
        try {
            configProp = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/Properties"
                    + "/config.properties");
            try {
                configProp.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns Thread local driver instance set by initialisation() Function
     * @return
     */
    public WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Setting Thread local driver instance
     * @param driver
     */
    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    /**
     * Driver Initialisation
     * @param browserName Type of WebDriver Instance
     */
    public void initialization(String browserName) {
        if (browserName.equals("chrome")) {
            chrome = new ChromeDriverWebDriver();
            chrome.initializeBrowser();
            setDriver(chrome.getDriverInstance());
        } else if (browserName.equals("firefox")) {
            firefox = new FireFoxWebDriver();
            firefox.initializeBrowser();
            setDriver(firefox.getDriverInstance());
        }
        else if(browserName.equals("remote")){
            remoteChrome = new RemoteChromeDriver();
            remoteChrome.initializeBrowser();
            setDriver(remoteChrome.getDriverInstance());
        }
        e_driver = new EventFiringWebDriver(getDriver());
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        setDriver(e_driver);
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().get(configProp.getProperty("testEnv"));

    }

    /**
     * Function to take screenshot
     * @throws IOException
     */
    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    /**
     * Implicit Wait generic function
     * @param driver
     */
    public void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /**
     * Function to get element state
     * @param whatToCheck
     * @param webElement
     * @return
     */
    public boolean checkElementState(String whatToCheck, WebElement webElement){
        if(whatToCheck.equalsIgnoreCase("visible")){
            return webElement.isDisplayed();
        }
        else if(whatToCheck.equalsIgnoreCase("enable")){
            return webElement.isEnabled();
        }
        return false;
    }

    /**
     * Enum Options for Get Elements method
     */
    public enum FindByValue{
        ID,XPATH,CSS
    }

    /**
     * Get Elements with specific identifier
     * @param driver
     * @param findBy
     * @param selector
     * @return
     */
    public List<WebElement> getElements(WebDriver driver, FindByValue findBy, String selector){
        List<WebElement> elementList = null;
        switch(findBy){
            case XPATH:
                elementList = driver.findElements(By.xpath(selector));
                break;
            case ID:
                elementList = driver.findElements(By.id(selector));
                break;
            case CSS:
                elementList = driver.findElements(By.cssSelector(selector));
                break;
        }
        return elementList;
    }

    /**
     * Switch to desired windowHandle for uninterrupted execution
     * @param title
     * @param driver
     */
    public void switchWindow(String title, WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        for(String window:windowHandles){
            if(driver.switchTo().window(window).getTitle().contains(title)){
                break;
            }
        }
    }

    /**
     * Util function to fetch text from alert
     * @param driver
     */
    public void getTextFromAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        driver.switchTo().defaultContent();
    }

}
