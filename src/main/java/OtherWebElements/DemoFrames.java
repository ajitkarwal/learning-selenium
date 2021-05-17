package OtherWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoFrames {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().deleteAllCookies();
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        driver.manage().window().maximize();

        //driver.switchTo().frame("iframeResult");

        WebElement frame1 = driver.findElement(By.id("iframeResult"));
        System.out.println("Frame is located");
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        System.out.println("button is clicked");
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();

            driver.switchTo().defaultContent();// to go to parent page or frame or context
//        driver.switchTo().parentFrame();// this is also used to go to parent page or frame or context
        System.out.println("Title of the parent page"+driver.getTitle());




            driver.quit();

    }
}
