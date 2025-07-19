import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
   protected WebDriver driver ;
   protected  LoginPage loginPage ;

   @BeforeClass
   public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
       loginPage = new LoginPage(driver);

     }

   @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }



}

