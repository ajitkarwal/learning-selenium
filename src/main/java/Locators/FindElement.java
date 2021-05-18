package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        List<WebElement> links = driver.findElements(By.tagName("a"));

        //get the count of links on the page and
        System.out.println("No of links in the page = " + links.size());

        //text of each link

        //WHILE LOOP
//        Iterator<WebElement> itr = links.iterator();//An iterator over a collection.
//        while (itr.hasNext()) {
//            System.out.println(itr.next().getText());
//
//        }

        //While Loop without iterator.
        int j = 0;
        while (j < links.size()) {
            String text = links.get(j).getText();
            if(text.length()!=0) { // to print only non-null strings i.e. not to print empty <a> tags
                System.out.print(text + "  ");
                System.out.println(text.length());
            }

            j++;
        }

        //OR using for loop with iterator
//        for (Iterator<WebElement> it = links.iterator(); it.hasNext(); ) {
//            System.out.println(it.next().getText());
//        }

        //For Loop without iterator
//        for(int i=0;i<links.size();i++){
//            String text = links.get(i).getText();
//            System.out.println(text);
//        }

        driver.quit();
    }
}
