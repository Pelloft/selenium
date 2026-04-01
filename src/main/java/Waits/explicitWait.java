package Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class explicitWait {
    public static void main(String [] args) throws InterruptedException {
        String url = "https://demoqa.com/dynamic-properties";

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Problema con selenium en sintaxis linea 17 WebDriverWait(driver, 10);

        driver.get(url);
        driver.manage().window().maximize();


        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By. id("visibleAfter")));
            driver.findElement(By.id("visibleAfter")).click();
            System.out.println("Boton clikeado");
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.close();
    }
}
