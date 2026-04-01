package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {
    public static void main(String [] args){
        //System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //Abrir el navegador
        driver.get("https://www.saucedemo.com/v1/");

        //Maximizar el navegador
        driver.manage().window().maximize();

        //Credenciales
        String usuario = "standard_user";
        String password = "secret_sauce";

        //Localizador by ID
        WebElement usuarioInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        //WebElement loginBtn = driver.findElement(By.id("login-button"));

        //Locator by Class Name
        //WebElement loginBtn = driver.findElement(By.className("btn_action"));

        //Locator by name
        //WebElement loginBtn = driver.findElement(By.name("login-button"));

        //Locator XPATH
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        //Locator by CSS selector
        //WebElement loginBtn = driver.findElement(By.cssSelector());

        //Loggin
        usuarioInput.sendKeys(usuario);
        passwordInput.sendKeys(password);
        loginBtn.click();

        //driver.quit();

    }
}
