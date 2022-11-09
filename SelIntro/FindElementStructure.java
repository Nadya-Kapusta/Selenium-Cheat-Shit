package SelIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementStructure {
    public static void main(String[] args) throws InterruptedException {
        //Web driver methods +  class methodss
        // Chrome driver implements webDriver - driver object can access WebDriver methods
        // Like this driver won't be able to access methods in other browsers than Chrom
//        ChromeDriver driver = new ChromeDriver();
        // Therefore we define driver2 as WebDriver and now it has access only to WebDriver Interface methods
        //Web driver methods
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //aka driver2
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); //if something is not showing on the page we r asking Selenium yo wait at least 4 seconds
        // defining driver3 like that will cause rewriting of WebDriver Interface
        //WebDriver driver3 = new WebDriver() {}

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
//        ID, XPath, CSS selector, name, Class Name, Tag Name, Link Text, Partial Link Text
        driver.findElement(By.id("inputUsername")).sendKeys("meow");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("signInBtn")).click(); // incorrect username or pasword message
//        need to capture the message

//        CSS selector - Class name -> tagname.classname
//        <input type="text" placeholder="Username" id="inputUsername" value="">
//        ID -> tagname#id. -> input#inputUsername

//        tagname.classname

//        to make sure that the tagname is unique we need Browser Developer Tools plug ins: ChroPath or SelectorsHub

//        Tagname[attribute='value']
//        <input type="text" placeholder="Username" id="inputUsername" value="">
//        input[placeholder='Username']
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
//        to look for element in console BDT $('p.error')
        driver.findElement(By.linkText("Forgot your password?")).click();

//        XPath - //tagname[@attribute='value']    //a[@href='#']
//        console: $x('a[@href="#"]')
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("meow");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("meow@miau.mñu");
//        //input[@type='text'][2] -   it takes the second element from the selection (it selected 3 matches, so it will go for the second one)
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("meow@miau.miu"); //checked through console cause hidden element
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8923472352");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();         // //div[@class='forgot-pwd-btn-conainer']/button[2]
        System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());

        driver.findElement(By.cssSelector("button[class*='login']")).click(); // //div[@class='forgot-pwd-btn-conainer']/button[1]

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("meow");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); //regexp cssSelector
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //regexp xpath
    }
}
