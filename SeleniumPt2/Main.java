package SeleniumPt2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Sibling - Parent to Child traverse
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        String name = "meow";
        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password); //regexp cssSelector
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //regexp xpath

        Thread.sleep(2000);

        try {
            Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
        } catch (AssertionError e) {
            System.out.println("Text \"You are successfully logged in.\" doesn't match the recieved one: \"" + driver.findElement(By.tagName("p")).getText() + "\"");
        }
        try {
            Assert.assertEquals(driver.findElement(By.cssSelector("div[class*=\"login\"] h2")).getText(), String.format("Hello %s,", name));
        } catch (AssertionError e) {
            System.out.println("Text \"" + String.format("Hello %s,", name) + "\" doesn't match the recieved one: \"" + driver.findElement(By.cssSelector("div[class*=\"login\"] h2")).getText() + "\"");
        }
        System.out.println(driver.findElement(By.tagName("p")).getText()); // cssSelector div[class*="login"] p
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();

        driver.close();
    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
        String[] passArray = passwordText.split("'");
        return passArray[1];
    }
}
