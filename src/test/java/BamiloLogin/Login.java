package BamiloLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by leila on 10/20/2017.
 */
public class Login {

    private WebDriver driver = null;
    private static int BROWSER=1;

    @BeforeTest
    public void intBrowser() {

        if(BROWSER==1) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\leila\\Desktop\\Firefox\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
            driver = new ChromeDriver(options);
        }
        else if (BROWSER==2)
        {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\leila\\Desktop\\Firefox\\geckodriver.exe");
            DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
            desiredCapabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();
        }
    }

    @Test(priority = 1)
    public void Register() throws InterruptedException {

        driver.get("http://www.bamilo.com/");


        Thread.sleep(15000);

        WebElement close = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/i"));
        close.click();

        WebElement myProfile = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div[2]/div[2]/div[1]/a/span[2]"));
        myProfile.click();

        Thread.sleep(15000);

        WebElement register = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/a"));
        register.click();

        Thread.sleep(15000);


        WebElement gender = driver.findElement(By.xpath("//*[@id=\"RegistrationForm_gender\"]/option[3]"));
        gender.click();

        WebElement nationalId = driver.findElement(By.xpath("//*[@id=\"RegistrationForm_national_id\"]"));
        nationalId.sendKeys("1234567890");

        WebElement name = driver.findElement(By.xpath("//*[@id=\"RegistrationForm_first_name\"]"));
        name.sendKeys("leila");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"RegistrationForm_email\"]"));
        email.sendKeys("leila@yahoo.com");

        WebElement newPass = driver.findElement(By.xpath("//*[@id=\"RegistrationForm_password\"]"));
        newPass.sendKeys("leila@123");

        WebElement repeatPass = driver.findElement(By.xpath("//*[@id=\"RegistrationForm_password2\"]"));
        repeatPass.sendKeys("leila@123");

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"send\"]"));
        submit.click();
        Thread.sleep(15000);

        WebElement topMessag=driver.findElement(By.xpath("//*[@id=\"messagesContainer\"]/div"));
        String topMessageText=topMessag.getText();
        Assert.assertEquals(topMessageText, "ثبت نام ناموفق، لطفا موارد خواسته شده را به دقت تکمیل نمایید\u200F.\u200F");





    }


}
