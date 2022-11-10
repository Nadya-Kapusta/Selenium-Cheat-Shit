package SelLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ParentChild {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //Sibling - Child to Parent traverse
//        //header/div/button[1]/following-sibling::button[1]

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        Sibling to sibling
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
//        Child to Parent
//        //header/div/button[1]/parent::div/parent::header/a
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[1]")).getText());

    }
}
