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

        //using 'id' attribute in xpath
        //    WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));


        //using 'class' attribute in xpath
     //   WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));

        //using 'contains()' method in xpath. to check if an attribute contains some text.
        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]"));

        searchBox.sendKeys("Java");
        Thread.sleep(2000);


        System.out.println("Entered Java in the Search Box");


        driver.quit();
        }
}
