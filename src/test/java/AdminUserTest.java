import Pages.AdminPage;
import Pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminUserTest extends BaseTest{

    private String userName = "Admin" ;
    private String password = "admin123" ;
    private String numberOfRecords = "(1) Record Found" ;
    private String userRole = "Admin" ;
    private String userStatus = "Enabled";
    private  String toastMessage = "Cannot be deleted" ;

    @Test
    public void TestDeleteUser(){
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        DashboardPage  DashboardPage = loginPage.clickLoginButton();
        AdminPage AdminPage = DashboardPage.clickAdminTab();
        AdminPage.searchByUsername(userName);
        AdminPage.clickSearchButtonAndWaitForRowCountChange(AdminPage.getNumberOfResultRows());
        Assert.assertTrue(AdminPage.getNumberRecords().contains(numberOfRecords),
                "Expected number of records to be : " + numberOfRecords);
        Assert.assertEquals(AdminPage.getUserName(),userName, "Username should be : " + userName);
        Assert.assertEquals(AdminPage.getUserRole(),userRole,"Role should be : " + userRole);
        Assert.assertEquals(AdminPage.getUserStatus(),userStatus,"status should be : " +userStatus );
        AdminPage.clickDeleteButton();
        Assert.assertEquals(AdminPage.getToastMessage(),toastMessage,"Message should be : " + toastMessage );






    }

}
