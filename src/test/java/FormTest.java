import org.example.pages.RegistrationFormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {
    private RegistrationFormPage registrationFormPage;
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][] {{"Sasha"}, {"NotSasha"}};
    }
    @BeforeClass
    public void startPage() {
        registrationFormPage = new RegistrationFormPage(driver);
    }
    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormData(String name) {
        registrationFormPage.enterFirstName(name);
        registrationFormPage.enterLastName("Zin");
        registrationFormPage.clickMaleRadioButton();
        registrationFormPage.enterMobileNumber("1234567890");
        registrationFormPage.clickSubmitButton();
        Assert.assertTrue(registrationFormPage.getUserDataText().contains(name));
    }
}
