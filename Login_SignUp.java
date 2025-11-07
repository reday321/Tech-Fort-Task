import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

        WebElement captchaElement = driver.findElement(By.id("canv"));
        String captchaText = CaptchaReader.readCaptcha(driver, captchaElement);
        System.out.println("Detected CAPTCHA: " + captchaText);

        try {

            WebElement captchaInput = driver.findElement(By.cssSelector("input[placeholder='Enter the characters you see above']"));
            captchaInput.clear();
            captchaInput.sendKeys(captchaText);


        } catch (Exception e) {
            System.out.println("Placeholder selector failed, trying alternative selectors...");
        }


        WebElement verifyButton = driver.findElement(By.xpath("//button[text()='Verify Captcha']"));
        verifyButton.click();

        Thread.sleep(2000);

        WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Sign Up']"));

        Thread.sleep(9000);


    }

    @Test
    @Order(2)
    public void login() {
        driver.get("https://career.techforing.com/");

        List<WebElement> button = driver.findElements(By.className("MuiButton-root"));

        button.get(1).click();

        driver.findElement(By.id("email")).sendKeys("reday.gub@gmail.com");
        driver.findElement(By.id("password")).sendKeys("6CZyf@cT@RuL55w");

        driver.findElement(By.cssSelector("[type='submit']")).click();
    }
}

