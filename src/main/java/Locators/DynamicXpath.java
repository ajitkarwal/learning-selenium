package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DynamicXpath {

    public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

// BASIC XPATHS:
        //using 'id' attribute in xpath
        //    WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));

        //using 'class' attribute in xpath
     //   WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));

//CONTAINS() METHOD:
    // using 'contains()' method in xpath. to check if an attribute contains some text.
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]"));

        searchBox.sendKeys("Java");
        Thread.sleep(2000);


        System.out.println("Entered Java in the Search Box");
//DYNAMIC IDs:
        //sometimes id is dynamic, and changes everytime like :
        // id = 'test_1234  OR         // id = 'test_abcd  OR         // id = 'test_1a

        //this is when contains() is very helpful,

        driver.findElement(By.xpath("//input[@id='test_']"));
        // this means that find a particular input tag in which the id starts with test_

//Starts-With() METHOD:
        driver.findElement(By.xpath("//input[starts-with(@id,'test')]"));
        //it will try to find 'id' attribute in 'input' tag whose value starts with 'test'.

//FOR LINKS (all the links are represented by <a> tag:
        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));



        driver.quit();
        }
}
