package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SetapBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox")
        .addArguments("--disable-notification") // отключение вспдывающих сообщений
        .addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)"); //робот,который проверяет страницу сайта
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(5000);
        driver.quit();
        //((JavascriptException)driver).executeScript("window.open()"); //открытие еще одной  вкладки
        //List<String> tabs = new ArrayList<>(driver.getWindowHandles()); // список вкладок будет располагаться в том же порядке,что и в браузере
        //driver.switchTo().window(tabs.get(0)); // переключиться обратно в первую вкладку
    }
}
