package hospitalSeeker.googleAPI;

/**
 * Created by oleg on 03.06.2016.
 */

import hospitalSeeker.BaseTest;
import hospitalSeeker.BrowserWrapper;
import hospitalSeeker.googleApi.NewHospitalPage;
import hospitalSeeker.googleApi.ValidateHospital;
import hospitalSeeker.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestValidateHospital extends BaseTest {

    ValidateHospital validateHospital;
    NewHospitalPage newHospitalPage;
    LoginPage loginPage;
    BrowserWrapper browserWrapper;
    List<WebElement> td_collection;


    @BeforeMethod
    public void beforeMethod() {
        validateHospital = PageFactory.initElements(browser.getDriver(), ValidateHospital.class);
        newHospitalPage = PageFactory.initElements(browser.getDriver(), NewHospitalPage.class);
        loginPage = PageFactory.initElements(browser.getDriver(), LoginPage.class);
        //validateHospital.actionsButton.click();
        // validateHospital.checkButton.click();
        browser.goTo(LOGIN_URL);
        loginPage.emailLogin.sendKeys(ADMIN_LOGIN);
        loginPage.passwordLogin.sendKeys(ADMIN_PASSWORD);
        loginPage.loginButton.click();
        browser.goTo(VALIDATE_URL);

    }


    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * go to validate url
	 * check if google api is present
	 * check if "validate" button is present
	 * click "validate" button
	 * wait for 4 seconds
	 * check if add button is present
	 * @requires true
	 * @effects all elements must be present
	 * </p>
	 */
    @Test
    public void isElementsPresent() {

        assertTrue(browser.isElementPresent(validateHospital.googleApi), "Dude, Google Api is not present");
        browser.waitUntilElementIsPresent(By.cssSelector("button.btn.btn-default"));
        assertTrue(browser.isElementPresent(validateHospital.getGooglePoi), "Button for google poi is not present");
        validateHospital.getGooglePoi.click();
        validateHospital.getGooglePoi.click();
        assertTrue(browser.isElementPresent(validateHospital.tables), "Table is not present");
        assertTrue(browser.isElementPresent(validateHospital.addValidateHospital), "Button for addvalidate hospital is not present");
        assertTrue(browser.isElementPresent(validateHospital.showOnMap), "Button for addvalidate hospital is not present");
    }
    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * * @requires true
	 * @effects Log in
    *     </p>
     */


    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * goto validate url
	 * click on "validate" for check
	 *  @requires true
	 * @effects button must be clickable
    *     </p>
     */
    @Test
    public void checkTableIsVisible() {
        validateHospital.googlePoiButtonClick();
        assertTrue(browser.isElementPresent(validateHospital.table), "Table with validate hospital is not present");
    }

    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * goto validate url
	 * click on "validate" for check
	 * wait for 4 second
	 * click addHospital
	 *  @requires true
	 * @effects button must be clickable
	 *
    *     </p>
     */
    @Test
    public void checkShowOnMapButton() {
        validateHospital.googlePoiButtonClick();
        browser.waitUntilElementIsPresent(By.xpath("(//button[@type='button'])[2]"));
        validateHospital.findValidateHospitalClick();
    }

    /*
    *<p>
    *
	 * go to login page
	 * input e-mail
	 * input password
	 * click on button "Log in"
	 * goto validate url
	 * click on "validate" for check
	 * wait for 4 second
	 * click addHospital
	 *  * wait for 4 second
	 *  check if page url has been changed
	 *  @requires true
	 * @effects Page url has been changed
	 *
    *     </p>
     */
    @Test
    public void checkAddvValidateHospitals() {
        validateHospital.googlePoiButtonClick();
        browser.waitUntilElementIsPresent(By.xpath("(//button[@type='button'])[2]"));
        validateHospital.addValidateHospitalClick();
        assertEquals(false, (browser.getCurrentUrl() == VALIDATE_URL));
    }
}
