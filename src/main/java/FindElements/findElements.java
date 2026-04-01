package FindElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElements {
    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        String url = "https://www.saucedemo.com/v1/";
        WebDriver driver = new ChromeDriver();

        driver.get(url);
    }
}
