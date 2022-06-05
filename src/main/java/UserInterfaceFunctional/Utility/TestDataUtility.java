package UserInterfaceFunctional.Utility;

import org.testng.annotations.DataProvider;

/**
 * @author Ankur
 */
public class TestDataUtility {
    public static TestDataUtility DataConnection;

    public TestDataUtility() {
    }

    /**
     * Function to create connection for Data Utility for Data Driven Run
     * @return Test Data Connection instance
     */
    public static TestDataUtility getInstance(){
        if(DataConnection == null){
            DataConnection = new TestDataUtility();
        }
        return DataConnection;
    }

    /**
     * Data Provider Test NG capability to modify data as accepted by Test Methods
     * @return Test Data in 2D Matrix format for Test Customers Data
     */
    @DataProvider(name = "customers")
    public static Object[][] customersData() {
        return new Object[][] {{"TrellaFS","TrellaLS","151001"}};
    }




}
