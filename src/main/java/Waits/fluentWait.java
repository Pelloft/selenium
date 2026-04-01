package Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.function.Function;
//import java.util.NoSuchElementException;
import org.openqa.selenium.NoSuchElementException;

public class fluentWait {
    public static void main(String []args) throws InterruptedException{
        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        driver.get(url);
        driver.manage().window().maximize();


        try {

            WebElement button = wait.until(new Function<WebDriver, WebElement>() {

                public WebElement apply(WebDriver webDriver) {
                    return driver.findElement(By.id("visibleAfter"));
                }
            });
            button.click();
            System.out.printf("Click hecho");

        } catch (Exception e) {
            System.out.println(e);
        }

        driver.close();
    }
}
