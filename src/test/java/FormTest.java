import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
// import static org.testng.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class FormTest {
    private RegistrationFormPage registrationFormPage;
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://demoqa.com/automation-practice-form");
        registrationFormPage = new RegistrationFormPage(driver, wait);
    }

    @Test
    public void checkRegistrationFormData() {

        registrationFormPage.enterFirstName("Sasha");
        registrationFormPage.enterLastName("Zin");
        registrationFormPage.clickMaleRadioButton();
        registrationFormPage.enterMobileNumber("1234567890");
        registrationFormPage.clickSubmitButton();

        Assert.assertTrue(registrationFormPage.getUserDataText().contains("Sasha Zin"));

    }
    @Test
    public void checkRegistrationFormData2() {

        registrationFormPage.enterFirstName("Sasha");
        registrationFormPage.enterLastName("Zin");
        registrationFormPage.clickMaleRadioButton();
        registrationFormPage.enterMobileNumber("1234567890");

//        WebElement maleRadioButton = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
//        maleRadioButton.click();
//
//        WebElement mobileNumberField = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
//        mobileNumberField.sendKeys("1234567890");

//        WebElement stateDropDown = driver.findElement(By.id("state"));
//        stateDropDown.click();
//        Select dropState = new Select(driver.findElement(By.name()))

    }
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
