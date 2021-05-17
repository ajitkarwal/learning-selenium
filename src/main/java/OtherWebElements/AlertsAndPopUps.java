package OtherWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AlertsAndPopUps {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

//        WebDriverManager.edgedriver().setup();
//        WebDriver driver = new EdgeDriver();

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        System.out.println(driver.getTitle());

        driver.findElement(By.name("proceed")).click();

        Thread.sleep(5000);

        Alert alert= driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.accept(); //This method is used to click on the 'Ok' button of the alert.

//        alert.dismiss();  if there is a cancel button

    }
}
