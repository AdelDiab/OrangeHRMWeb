package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver ;
    private  By userNameField =  By.name("username") ;
    private By passwordField = By.name("password") ;
    private By loginButton =  By.className("orangehrm-login-button") ;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


public void setUserName(String username){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(userNameField).sendKeys(username);

}
    public void setPassword (String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton () {
        driver.findElement(loginButton).click();
        return new DashboardPage(driver) ;
    }

}
