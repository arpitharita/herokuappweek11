package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter “tomsmith” username
        sendKeysToElement(By.xpath("//input[@id='username']"),"tomsmith");

        //* Enter “SuperSecretPassword!” password
        sendKeysToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword!");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //* Verify the text “Secure Area”
        String actualTest = getTextFromElement(By.xpath("//div[@class='example']"));
        String expectedTest = "Secure Area\n" +
                                   "Welcome to the Secure Area. When you are done click logout below.\n" +
                                    "Logout";
        Assert.assertEquals(expectedTest,actualTest);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){

        //* Enter “tomsmith1” username
        sendKeysToElement(By.xpath("//input[@id='username']"),"tomsmith1");

        //* Enter “SuperSecretPassword!” password
        sendKeysToElement(By.xpath("//input[@id='password']"),"");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //* Verify the error message “Your username is invalid!”
        String actualTest = getTextFromElement(By.xpath("//div[@class='flash error']"));
        String expectedTest = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(expectedTest,actualTest);
    }
    @Test
    public void verifyThePasswordErrorMessage(){

        //* Enter “tomsmith” username
        sendKeysToElement(By.xpath("//input[@id='username']"),"tomsmith");

        //* Enter “SuperSecretPassword” password
        sendKeysToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //* Verify the error message “Your password is invalid!”
        String actualTest = getTextFromElement(By.xpath("//div[@class='flash error']"));
        String expectedTest = "Your password is invalid!\n" +
                 "×";
        Assert.assertEquals(expectedTest,actualTest);
    }
    @After
    public void closebrowser(){
       // closebrowser();
    }
}
