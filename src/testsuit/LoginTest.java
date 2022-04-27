package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;


public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //find Username field and insert value
        
        getTextFromElement(By.id("username"));
        sendTextToElement(By.id("username"),"tomsmith");

        //find password field and insert value

        getTextFromElement(By.id("password"));
        sendTextToElement(By.id("password"),"\"SuperSecretPassword!\"");

        //find login button and click it

        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));

        //Verify the text “Secure Area”
        WebElement secureArea = driver.findElement(By.xpath("//div[@class='example']//h2"));

        // System.out.println(secureArea.getText());

        String acutalMessage = getTextFromElement(By.xpath("//div[@class='example']//h2"));

        //Verify the text “Secure Area”
        Assert.assertEquals("Incorrect Login detail", "Secure Area", acutalMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //find Username field and insert value

        getTextFromElement(By.id("username"));
        sendTextToElement(By.id("username"),"tomsmith1");

//find password field and insert value

        getTextFromElement(By.id("password"));
        sendTextToElement(By.id("password"),"\"SuperSecretPassword!\"");


        //find login button and click it

        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));


        //Verify the text “Error message”


        String acutalMessage = getTextFromElement(By.xpath("//div[@id='flash']"));

        //Verify the text “Your username is invalid!” appear
        Assert.assertEquals("Error message appear...", "Your username is invalid!", acutalMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
    //find Username field and insert value
        //driver.findElement(By.id("username")).sendKeys("tomsmith");
        getTextFromElement(By.id("username"));
        sendTextToElement(By.id("username"),"tomsmith");

//find password field and insert value

        getTextFromElement(By.id("password"));
        sendTextToElement(By.id("password"),"\"SuperSecretPassword\"");

        //find login button and click it

        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));


        //Verify the text “Error message”

        String acutalMessage = getTextFromElement(By.xpath("//div[@id='flash']"));

        //Verify the text “Your Password is invalid!” appear
        Assert.assertEquals("Error message appear...", "Your Password is invalid!", acutalMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
