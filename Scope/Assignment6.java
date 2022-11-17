package Scope;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String label = driver.findElement(By.cssSelector("label[for='benz']")).getText();
        driver.findElement(By.id("checkBoxOption2")).click();

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select d = new Select(dropdown);
        d.selectByVisibleText(label);
        driver.findElement(By.id("name")).sendKeys(label);
        driver.findElement(By.id("alertbtn")).click();

        String[] alertmsg = driver.switchTo().alert().getText().split(",");
        driver.switchTo().alert().accept();
        System.out.println(alertmsg[0].split(" ")[1]);

    }
}
