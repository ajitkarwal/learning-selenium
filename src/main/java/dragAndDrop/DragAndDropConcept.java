package dragAndDrop;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://jqueryui.com/droppable/");

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

        driver.switchTo().frame(frame);

        System.out.println("switched frame");

        WebElement dragMe = driver.findElement(By.xpath("//p[contains(.,'Drag me to my target')]"));
        System.out.println("This is dragMe");

        WebElement dropOnMe = dragMe.findElement(By.xpath("//div[@id='droppable']"));
        System.out.println("This is dropOnMe");


        Actions actions = new Actions(driver);
        System.out.println("This is actions");

        actions.clickAndHold(dragMe)
                .moveToElement(dropOnMe).
                release().build()
                .perform();

        Thread.sleep(4000);

        driver.quit();
    }
}
