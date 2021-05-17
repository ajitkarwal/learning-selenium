package OtherWebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;


import java.util.concurrent.TimeUnit;

public class HandlingFrames {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("name")).sendKeys("Hello");  //MAIN WEB PAGE


//        driver.switchTo().frame("frm1");// if we have id or name of the frame

        //if we do not have id or name we have to identify it by locators like xpath or css selectors.
        //coz frame is part of webpage that the drive have access but not its element. they are on another page.

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frm3']"));


        js.executeScript("arguments[0].scrollIntoView();", frame1);

        driver.switchTo().frame(frame1);
        System.out.println("Inside Frame 1");
        //now we are switched to frame 'frm1'. we can access its web elements
            Select courseDD = new Select(driver.findElement(By.id("course")));
            courseDD.selectByVisibleText("Java");

 //To go back to the parent page
        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).sendKeys("Welcome Back");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


 //NESTED FRAME... FRAME WITHIN THE FRAME

        driver.switchTo().frame(frame3);// frame3 is in the main page
        driver.switchTo().frame(frame1);
        System.out.println("Inside Frame 1 which inside frame 3");
        courseDD.selectByVisibleText("Java");

    }


}
