package UserInterfaceFunctional.PageFactory;

import UserInterfaceFunctional.Utility.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class BankHomePage extends TestBase {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[h2='Banking']")
    WebElement bankingEntryBtn;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginBtn;

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerEntryPointBtn;

    @FindBy(xpath = "//input[@ng-model=\"fName\"]")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@ng-model=\"lName\"]")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@ng-model=\"postCd\"]")
    WebElement postCodeField;

    @FindBy(xpath = "//button[text()=\"Add Customer\"]")
    WebElement AddCustomerBtn;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customerTab;

    @FindBy(xpath = "//input[@ng-model=\"searchCustomer\"]")
    WebElement searchCustomerField;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processBtn;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccount;

    public BankHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 25);
    }

    /**
     * Entry point bank manager login screen
     *
     * @return
     */
    public BankHomePage clickOnBankManagerLogin() {
        bankManagerLoginBtn.click();
        return this;
    }

    /**
     * Function to navigate to Add Customer screen
     *
     * @return
     */
    public BankHomePage clickOnAddCustomer() {
        addCustomerEntryPointBtn.click();
        return this;
    }

    /**
     * Function to create new Customer
     *
     * @param firstName
     * @param lastName
     * @param postCode
     * @return
     */
    public BankHomePage createCustomer(String firstName, String lastName, String postCode) {
        clickOnAddCustomer();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
        AddCustomerBtn.click();
        return this;
    }

    /**
     * Function to fetch the customerId created from alert message
     *
     * @param driver
     * @return
     */
    public String getId(WebDriver driver) {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        String[] messageSplit = message.split(":");
        return messageSplit[1];
    }

    /**
     * Function to search Customer by PostCode (unique field) and optionally delete the record
     *
     * @param driver
     * @param postCode
     * @param delete
     * @return
     */
    public String[] searchRecordsByPostCode(WebDriver driver, String postCode, boolean delete) {
        customerTab.click();
        String[] result = new String[4];
        wait.until(ExpectedConditions.visibilityOf(searchCustomerField)).clear();
        searchCustomerField.sendKeys(postCode);
        if (driver.findElements(By.xpath("//table[@class=\"table table-bordered table-striped\"]/tbody/tr")).size() > 0) {
            result[0] = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped\"]/tbody/tr[1]/td[1]")).getText();
            result[1] = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped\"]/tbody/tr[1]/td[2]")).getText();
            result[2] = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped\"]/tbody/tr[1]/td[3]")).getText();
            result[3] = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped\"]/tbody/tr[1]/td[4]")).getText();
        }
        if (delete) {
            driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped\"]/tbody/tr[1]/td[5]/button")).click();
        }
        return result;
    }

    /**
     * Function to get number of rows visible in table
     *
     * @return
     */
    public int getNoOfRowsVisible() {
        return driver.findElements(By.xpath("//table[@class=\"table table-bordered table-striped\"]/tbody/tr")).size();
    }

    /**
     * Function to select customer from drop down
     *
     * @param driver
     * @param customerName
     * @return
     */
    public BankHomePage selectCustomer(WebDriver driver, String customerName) {
        openAccount.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userSelect")));
        Select customer = new Select(driver.findElement(By.id("userSelect")));
        customer.selectByVisibleText(customerName);
        return this;
    }

    /**
     * Function to select Currency randomly
     *
     * @param driver
     * @return
     */
    public BankHomePage selectCurrency(WebDriver driver) {
        Random random = new Random();
        int randomIndex = random.nextInt(4);
        Select customer = new Select(driver.findElement(By.id("currency")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("currency")));
        customer.selectByIndex(randomIndex);
        return this;
    }

    /**
     * Function to click on process button to create account
     */
    public void clickOnProcess() {
        processBtn.click();
    }

    /**
     * Function to get account creation alert message
     *
     * @return
     */
    public String getAccountMessage() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }

}
