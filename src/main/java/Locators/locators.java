package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
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


            WebElement inventory = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container"))
            );

            System.out.println("Login");

            // Ejemplo: hacer clic en un producto
            WebElement producto = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
            producto.click();

            Thread.sleep(2000); // solo para visualizar

            // Agregar al carrito
            WebElement addToCart = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
            addToCart.click();

            Thread.sleep(2000);

            // Ir al carrito
            WebElement carrito = driver.findElement(By.id("shopping_cart_container"));
            carrito.click();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
