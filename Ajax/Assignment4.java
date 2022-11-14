package Ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/windows']")).click();
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        Set<String> windows = driver.getWindowHandles();//[parentID, childID]
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());

    }
}
