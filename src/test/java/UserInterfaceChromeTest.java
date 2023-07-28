import UserInterfaceFunctional.PageFactory.BankHomePage;
import UserInterfaceFunctional.Utility.RetryFailed;
import UserInterfaceFunctional.Utility.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.annotation.Nullable;

/**
 * UI Test
 */
public class UserInterfaceChromeTest extends TestBase {
    private BankHomePage bankHomePage;
    WebDriver driver;
    SoftAssert softAssert;

    @Nullable
    @BeforeSuite
    public void setUp() {
        initialization("chrome");
        driver = getDriver();
        bankHomePage = new BankHomePage(driver);
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void quickReset() {
        getDriver().get(configProp.getProperty("testEnv"));
    }

    @Test(retryAnalyzer = RetryFailed.class, dataProvider = "customers", priority = 1)
    public void validateCustomerEntryInList(String firstName, String lastName, String postCode) {
        implicitWait(driver);
        String customerId = bankHomePage.clickOnBankManagerLogin().createCustomer(firstName, lastName, postCode).getId(driver);
        softAssert.assertEquals(customerId, "6");
        String[] result = bankHomePage.searchRecordsByPostCode(driver, postCode, false);
        Assert.assertEquals(firstName, result[0]);
        Assert.assertEquals(lastName, result[1]);
        Assert.assertEquals(postCode, result[2]);
    }

    @Test(priority = 2, dependsOnMethods = "validateCustomerEntryInList", dataProvider = "customers", enabled = false)
    public void validateCustomerAccountAndDelete(String firstName, String lastName, String postCode) {
        implicitWait(this.driver);
        bankHomePage.selectCustomer(driver, firstName + " " + lastName);
        bankHomePage.selectCurrency(driver);
        bankHomePage.clickOnProcess();
        String accountCreatedMessage = bankHomePage.getAccountMessage();
        String[] splitMessage = accountCreatedMessage.split(":");
        softAssert.assertTrue(accountCreatedMessage.startsWith(configProp.getProperty("accountMessage")));
        String[] result = bankHomePage.searchRecordsByPostCode(driver, postCode, false);
        softAssert.assertEquals(firstName, result[0]);
        softAssert.assertEquals(lastName, result[1]);
        softAssert.assertEquals(postCode, result[2]);
        softAssert.assertEquals(splitMessage[1], result[3]);
        bankHomePage.searchRecordsByPostCode(driver, postCode, true);
        Assert.assertEquals(0, bankHomePage.getNoOfRowsVisible());
    }

    @AfterMethod
    public void afterMethod() {
        driver.navigate().refresh();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
