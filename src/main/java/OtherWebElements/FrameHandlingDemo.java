package OtherWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandlingDemo {
    public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get("https://ui.cogmento.com/");


            Thread.sleep(5000);
            WebElement email = driver.findElement(By.xpath("//input[@placeholder='E-mail address']"));
            email.sendKeys("karwal.50005@gmail.com");

            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            password.sendKeys("Jugnu1980");
            driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

            driver.quit();
    }
}
