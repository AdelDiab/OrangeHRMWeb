package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    private WebDriver driver ;
   private By userNameSearchField = By.xpath("//label[text()='Username']/../following-sibling::div/input") ;
    private By searchButton = By.className("orangehrm-left-space") ;
    private By deleteIcon = By.className("bi-trash") ;
    private By usernameCell = By.xpath("//div[@role='row'][1]//div[@role='cell'][2]");
    private By userRoleCell = By.xpath("//div[@role='row'][1]//div[@role='cell'][3]");
    private By userStatusCell = By.xpath("//div[@role='row'][1]//div[@role='cell'][5]");
    private By numberOfRecords =By.className("orangehrm-vertical-padding") ;
    private  By toast = By.className("oxd-text--toast-message") ;
    private By resultRows = By.className("oxd-table-row--with-border");


    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchByUsername(String username) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(userNameSearchField).sendKeys(username);

    }






public int getNumberOfResultRows() {
    return driver.findElements(resultRows).size();
}
    public void clickSearchButtonAndWaitForRowCountChange(int previousCount) {
        driver.findElement(searchButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(resultRows).size() != previousCount);
    }
    public String getUserName(){
       return driver.findElement(usernameCell).getText();
    }

    public String getUserRole(){
        return driver.findElement(userRoleCell).getText();
    }
    public String getUserStatus(){
        return driver.findElement(userStatusCell).getText();
    }

    public String getNumberRecords(){
        return driver.findElement(numberOfRecords).getText();

    }

    public void clickDeleteButton() {driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(deleteIcon).click();
    }


    public String getToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(toast));
        return driver.findElement(toast).getText();

    }


}
