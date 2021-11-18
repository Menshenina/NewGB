package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CrmTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);
        //Thread.sleep(5000);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));
        WebElement expenseMenuItem = menuItems.stream().filter(e -> e.getText().equals("Расходы")).findFirst().get(); //находим нужный элемент


        Actions actions = new Actions(driver);
        actions.moveToElement(expenseMenuItem).build().perform(); //навести курсор
        driver.findElement(By.xpath("//span[.='Заявки на расходы']")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать заявку на расход']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("crm_expense_request[description]")).sendKeys("test");

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");

        Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
        expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

        driver.findElement(By.xpath("//input[contains(@id, 'datePlan') and @placeholder='Укажите дату']")).click();
        driver.findElement(By.xpath("//a[.='21']")).click();
        driver.findElement(By.xpath("//input[contains(@id, 'crm_expense_request_sumPlan-uid')]")).sendKeys("100");
        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
        //driver.quit();
    }

    static void login(WebDriver driver){
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }

}
