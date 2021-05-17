package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    WebDriver driver;

    public LaunchBrowser(WebDriver driver) {
        this.driver = driver;
        this.driver = new ChromeDriver();
    }


    public void setup(WebDriver driver){

        WebDriverManager.chromedriver().setup();

    }
}
