package lesson3.Dz;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Vita {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://vitaexpress.ru/");
        driver.manage().window().maximize();
        login(driver);
        ChangeCity(driver);
    }

    public static void login(WebDriver driver){
       // ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--disable-notification"); // отключение вспдывающих сообщений
        driver.findElement(By.cssSelector(".help-city__links .pointer:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".enterRegister ")).click();
        driver.findElement(By.cssSelector("#user-form .inputGroup [type=\"text\"]")).sendKeys("sun.q@mail.ru");
        driver.findElement(By.cssSelector("#user-form .inputGroup [type=\"password\"]")).sendKeys("123456");
        driver.findElement(By.cssSelector(".form-bottom .buttonDefault")).click();
    }
    public static void ChangeCity(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("selectCity")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(".list-city__item:nth-child(5) a")).click();




    }
}
