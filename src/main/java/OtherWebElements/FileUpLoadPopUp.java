package OtherWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//How to handle file upload pop up. this is not part of browser or a java script pop-up.

//this is part of operating system. so selenium cannot handle it
public class FileUpLoadPopUp {

    public static void main(String[] args) {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get("https://html.com/input-type-file/");
//DO NOT CLICK ON 'Browse' or 'Select File' button,
// coz it will open a dialogue box which selenium cannot handle
            driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("/Users/mac/Desktop/index.html");


        }

}
