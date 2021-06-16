package bindings;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinition
{
    WebDriver driver = new ChromeDriver();
    WebDriverWait wdWait = new WebDriverWait(driver,20);

    @Before
    public void init()
    {
        driver.manage().window().maximize();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Given("^I navigate to QA Revealed homepage$")
    public void i_navigate_to_QA_Revealed_homepage()
    {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.qarevealed.com/");
    }

    @When("^I click on Nas tim link in menu$")
    public void i_click_on_Nas_tim_link_in_menu()
    {
        // Write code here that turns the phrase above into concrete actions
        WebElement nasTim = driver.findElement(By.id("comp-kggecc8g5label"));
        nasTim.click();
    }

    @Then("^page with team members is opened$")
    public void page_with_team_members_is_opened() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("comp-kggf11xo1")));
        WebElement title = driver.findElement(By.id("comp-kggf11xo1"));
        System.out.println(title.getText());
        Assert.assertTrue(title.getText().contains("NAŠ TIM"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.qarevealed.com/nas-tim"));
        Thread.sleep(4000); // left for visual confirmation
    }



    @Given("^I am on HerokuApp login page$")
    public void iAmOnHerokuAppLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("^I enter \"([^\"]*)\" in username field$")
    public void iEnterInUsernameField(String username) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    @And("^I enter \"([^\"]*)\" in password field$")
    public void iEnterInPasswordField(String passInput) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        WebElement usernameField = driver.findElement(By.id("password"));
        usernameField.sendKeys(passInput);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        WebElement loginButton = driver.findElement(By.className("fa-sign-in"));
        loginButton.click();
    }

    @Then("^I am logged in$")
    public void iAmLoggedIn() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        WebElement banner = driver.findElement(By.id("flash"));
        WebElement logoutButton = driver.findElement(By.className("icon-signout"));

        Assert.assertTrue(banner.getText().contains("d into a secure ar"));
        Assert.assertTrue(logoutButton.getText().contains("Logout"));
    }

    @Given("^I am on Loginpage$")
    public void iAmOnLoginpage() {
        driver.get("https://the-internet.herokuapp.com/secure");
    }

    @When("^I click Logout$")
    public void iClickLogout() {
       WebElement logout = driver.findElement(By.className("icon-signout"));
       logout.click();
    }
}
