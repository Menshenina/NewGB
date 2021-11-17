package lesson3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumDevStart {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.quit(); // закрывает браузер
        //driver.close();  //закрывает текущую вкладку

        WebDriverManager.chromedriver().setup();
        WebDriver ffDriver = new ChromeDriver();
        ffDriver.get("https://ya.ru");
        Thread.sleep(5000);
        ffDriver.quit();
    }
}



