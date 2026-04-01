package Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class implicitWait {
    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        /*se cambio 6, TimeUnit.SECONDS por que la versión de selenium que no era compatible*/


        driver.get(url);

        try {
            WebElement button = driver.findElement(By.id("visibleAfter"));
            button.click();
            System.out.println("Boton clikeado");
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.quit();
    }
}
