package org.example.pages;

import org.example.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormPage extends BasePage {
    public RegistrationFormPage(WebDriver driver) {
    }
    @FindBy(id = "firstName")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//label[@for=\"gender-radio-1\"]")
    private WebElement maleRadioButton;
    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    private WebElement mobileNumberField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//tr[1]/td[1]/following-sibling::td")
    WebElement userDataText;
    public void enterFirstName(String firstName) {
        Waiters.waitForVisibility(firstNameField);
        firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }
    public void clickMaleRadioButton() {
        maleRadioButton.click();
    }
    public void enterMobileNumber(String mobileNumber) {
        mobileNumberField.sendKeys(mobileNumber);
    }
    public void clickSubmitButton() {
        submitButton.sendKeys(Keys.RETURN);
    }
    public String getUserDataText() {
        return userDataText.getText();
    }
}