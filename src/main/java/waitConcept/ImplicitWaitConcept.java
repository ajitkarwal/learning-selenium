package waitConcept;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//it is a dynamic wait
public class ImplicitWaitConcept {
    public static void main(String[] args) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get("https://www.ebay.com/");

// Sets the amount of time to wait for a page load to complete before throwing an error.
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// it takes 40 seconds to load then gives error

        //This for the elements. Specifies the amount of time the driver should wait when searching
        // for an element if it is not immediately present.
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);// this global wait

        WebElement search = driver.findElement(By.xpath("//input[@id='gh-btn']"));



            driver.quit();
        }
}
