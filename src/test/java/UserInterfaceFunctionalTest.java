import UserInterfaceFunctional.PageFactory.BankHomePage;
import UserInterfaceFunctional.Utility.TestBase;
import UserInterfaceFunctional.Utility.RetryFailed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import javax.annotation.Nullable;

/**
 * UI Test
 */
public class UserInterfaceFunctionalTest extends TestBase {
    private BankHomePage bankHomePage;
    WebDriver driver;

    @Nullable
    @BeforeSuite
    public void setUp() {
        initialization("firefox");
        driver = getDriver();
        bankHomePage = new BankHomePage(driver);
    }
    @BeforeMethod
    public void quickReset(){
        driver.navigate().refresh();
    }

    @Test(retryAnalyzer = RetryFailed.class,dataProvider = "customers",priority = 1)
    public void validateCustomerEntryInList(String firstName,String lastName, String postCode){
        implicitWait(driver);
        String customerId = bankHomePage.clickOnBankManagerLogin().createCustomer(firstName,lastName,postCode).getId(driver);
        Assert.assertEquals(customerId,"6");
        String [] result = bankHomePage.searchRecordsByPostCode(driver, postCode, false);
        Assert.assertEquals(firstName,result[0]);
        Assert.assertEquals(lastName,result[1]);
        Assert.assertEquals(postCode,result[2]);
    }

    @Test(priority = 2, dependsOnMethods = "validateCustomerEntryInList", dataProvider = "customers")
    public void validateCustomerAccountAndDelete(String firstName,String lastName, String postCode){
        implicitWait(this.driver);
        bankHomePage.selectCustomer(driver,firstName+" "+lastName);
        bankHomePage.selectCurrency(driver);
        bankHomePage.clickOnProcess();
        String accountCreatedMessage = bankHomePage.getAccountMessage();
        String [] splitMessage = accountCreatedMessage.split(":");
        Assert.assertTrue(accountCreatedMessage.startsWith(configProp.getProperty("accountMessage")));
        String [] result = bankHomePage.searchRecordsByPostCode(driver,postCode, false);
        Assert.assertEquals(firstName,result[0]);
        Assert.assertEquals(lastName,result[1]);
        Assert.assertEquals(postCode,result[2]);
        Assert.assertEquals(splitMessage[1],result[3]);
        bankHomePage.searchRecordsByPostCode(driver,postCode, true);
        Assert.assertEquals(0,bankHomePage.getNoOfRowsVisible());
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
