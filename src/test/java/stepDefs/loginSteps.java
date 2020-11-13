package stepDefs;

import PageFactory.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);

    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);

    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage = new LoginPage(driver);
        loginPage.enterCredentials(email,password);


    }

    @When("User clicks on login")
    public void user_clicks_on_login() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
       loginPage.clickLogin();
        Thread.sleep(1000);

    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        String expectedTitle = title;
        String actualTitle = driver.getTitle();
        if(driver.getPageSource().contains("Login was unsuccessful.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else{
            Assert.assertEquals(expectedTitle,actualTitle);
        }
        Thread.sleep(1000);

    }

    @When("User clicks on logout link")
    public void user_clicks_on_logout_link() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLogout();
        Thread.sleep(1000);

    }

    @Then("Close the browser")
    public void close_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();

    }



}
