package FunctionalTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CardShopping {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        List<String> productItems = new ArrayList<>();
        productItems.add("Cucumber");
        productItems.add("Brocolli");

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        int j = 0;
        int size = products.size();
            for (int i = 0; i <= products.size(); i++){
            System.out.println("meow");
            String[] name = products.get(i).getText().split(" ");
            System.out.println(name);
            if (productItems.contains(name[0])) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j==2){
                    break;
                }
            }
        }
    }
}
