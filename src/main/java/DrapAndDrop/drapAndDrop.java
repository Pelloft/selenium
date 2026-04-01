package DrapAndDrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class drapAndDrop {
    public static void main(String[] args) {
        String url = "https://demoqa.com/droppable";

        //System.setProperty("webdriver.chrome.driver", "\\src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        Actions action = new Actions(driver);


        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        //action.dragAndDrop(from, to).build().perform();


        action.dragAndDropBy(from, 279, 36).build().perform();
    }
}
