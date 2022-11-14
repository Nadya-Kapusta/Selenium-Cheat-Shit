package SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("meow");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("meow@miu.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("meowmiu");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement staticDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex((int) (Math.floor(Math.random() * 2)));
        driver.findElement(By.cssSelector("#inlineRadio1")).click();
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("13111999");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
    }
}
