package lesson3.Dz;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson3.CrmTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class crm {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        driver.manage().window().maximize();
        login(driver);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));
        WebElement expenseMenuItem = menuItems.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get(); //находим нужный элемент

        Actions actions = new Actions(driver);
        actions.moveToElement(expenseMenuItem).build().perform(); //навести курсор
        driver.findElement(By.xpath("//span[.='Мои проекты']")).click();

        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn-group .back")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector(".controls [data-name='field__name']")).sendKeys("Test");

        driver.findElement(By.cssSelector(".company-container .select2-chosen")).click();
        Thread.sleep(3000);

        List<WebElement> orgs =driver.findElements(By.cssSelector(".select2-results-dept-0"));
        WebElement org =   orgs.get(3);
        org.click();

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");
        Select selectBusinessCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectBusinessCurator.selectByVisibleText("Амелин Владимир");
        Select selectBusinessRp = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectBusinessRp.selectByVisibleText("Амелин Владимир");
        Select selectBusinessManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectBusinessManager.selectByVisibleText("Антонов Дмитрий");

        driver.findElement(By.cssSelector(".btn-group:nth-child(4)")).click();
        driver.quit();

        test2();
    }

    public static void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        driver.manage().window().maximize();
        login(driver);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));
        WebElement expenseMenuItem = menuItems.stream().filter(e -> e.getText().equals("Контрагенты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expenseMenuItem).build().perform(); //навести курсор
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn-group .back")).click();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("[data-name=\"field__last-name\"]")).sendKeys("Тест");
        driver.findElement(By.cssSelector("[data-name=\"field__first-name\"]")).sendKeys("Тест2");
        driver.findElement(By.cssSelector(".company-container .select2-chosen")).click();
        Thread.sleep(3000);
        List<WebElement> orgs =driver.findElements(By.cssSelector(".select2-results-dept-0"));
        WebElement org =   orgs.get(3);
        org.click();
        driver.findElement(By.cssSelector("[data-name=\"field__job-title\"]")).sendKeys("Должность");
        driver.findElement(By.cssSelector(".btn-group:nth-child(4)")).click();
        driver.quit();

    }

        static void login(WebDriver driver) {
            WebElement element = driver.findElement(By.id("prependedInput"));
            element.sendKeys("Applanatest1");
            driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
            driver.findElement(By.id("_submit")).click();
        }

}
