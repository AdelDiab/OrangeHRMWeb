package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    private WebDriver driver ;
   private By adminTab = By.xpath("//span[text()='Admin']") ;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public AdminPage clickAdminTab() {
        driver.findElement(adminTab).click();
        return new AdminPage(driver) ;
    }

}
