package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseMovement {


    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.airmeet.com/");

//        WebElement solution = driver.findElement(By.xpath("//a[@id='sm-16210711256150603-1']"));
//
//        System.out.println(solution.getText());
//        //*[@id="menu-1-61787bd"]/li[2]

        List<WebElement> solutions = driver.findElements(By.xpath("//*[@id=\"menu-1-61787bd\"]/li[2]"));
        System.out.println(solutions.size());
        System.out.println(solutions.get(0).getTagName());
        WebElement sol1 = solutions.get(0);

        System.out.println(sol1.getAttribute("class"));

        Actions actions = new Actions(driver);

        actions.moveToElement(sol1).build().perform();

        Thread.sleep(4000);
        WebElement useCases = driver.findElement(By.linkText("Use cases"));

        actions.moveToElement(useCases).build().perform();

        Thread.sleep(4000);


        sol1.click();
        driver.quit();



    }
}
