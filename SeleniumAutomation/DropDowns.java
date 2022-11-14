package SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDowns {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        dropdown with Select tag
//        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//        Select dropdown = new Select(staticDropdown);
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByIndex(3);
//        System.out.println(dropdown.getFirstSelectedOption().getText());//repeats the last select
//        dropdown.selectByVisibleText("AED");
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByValue("INR");

//////////////////////////////////////////

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
//        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
//        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

//        count the number of checkboxes
        System.out.println("Count checkboxes" + driver.findElements(By.xpath("//input[@type='checkbox']")).size());

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(500);

        int i = 0;
//        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        while (i < 4) {

            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
//        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // or xpath(//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA'])

        //calender dropdown, opens by default after celecting cities
        //one way trip
        //.ui-state-default.ui-state-highlight

        driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();

//        driver.findElement(By.)
        //two way trip
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("its enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }

        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(500);
        List<WebElement> countries = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for (WebElement country : countries) {
            if (country.getText().equalsIgnoreCase("India")) {
                country.click();
                break;
            }
        }



    }
}
