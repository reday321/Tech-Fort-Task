import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Login_SignUp {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @Order(1)
    @DisplayName("User can sign up successfully")
    public void SignUp() throws InterruptedException {

        driver.get("https://career.techforing.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        List<WebElement> button = driver.findElements(By.className("MuiButton-root"));
        button.get(2).click();

        driver.findElement(By.id("fullName")).sendKeys("Testing");
        driver.findElement(By.cssSelector("[type='tel']")).sendKeys("01794520583");

        WebElement dateInput = driver.findElement(By.xpath("//div[@class='signup_form_dateofbirth']/input[@type='date']"));
        dateInput.sendKeys(Keys.CONTROL, "a");
        dateInput.sendKeys(Keys.DELETE);
        dateInput.sendKeys("10-8-1999");
        dateInput.sendKeys(Keys.ENTER);

        WebElement genderDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[text()='Gender']/following-sibling::div//div[contains(@class,'MuiSelect-select')]")
                )
        );
        genderDropdown.click();

        WebElement maleOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//li[@role='option' and text()='Male']"))
        );
        maleOption.click();

        driver.findElement(By.id("email")).sendKeys("testRed@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Reday221902026");
        driver.findElement(By.name("confirm_password")).sendKeys("Reday221902026");

        //Waiting for manual CAPTCHA input
        Thread.sleep(10000);

        WebElement verifyButton = driver.findElement(By.xpath("//button[text()='Verify Captcha']"));
        verifyButton.click();

        Thread.sleep(2000);


    }

    @Test
    @Order(2)
    @DisplayName("User can login successfully")
    public void login() {

        driver.get("https://career.techforing.com/");

        List<WebElement> button = driver.findElements(By.className("MuiButton-root"));
        button.get(1).click();
        driver.findElement(By.id("email")).sendKeys("reday.gub@gmail.com");
        driver.findElement(By.id("password")).sendKeys("6CZyf@cT@RuL55w");

        driver.findElement(By.cssSelector("[type='submit']")).click();


    }

    }
