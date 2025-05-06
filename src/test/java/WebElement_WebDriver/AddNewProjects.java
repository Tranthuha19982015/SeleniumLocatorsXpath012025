package WebElement_WebDriver;

import BT_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class AddNewProjects {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // truy cập link web CRM
        driver.navigate().to(LocatorsCRM.url);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.linkMenuCustomer)));

        // Truy cập menu Projects
        driver.findElement(By.xpath(LocatorsCRM.linkMenuProjects)).click();

        // Nhấn nút New Project
        driver.findElement(By.xpath(LocatorsCRM.buttonNewProject)).click();

        // Nhập thông tin project mới
        driver.findElement(By.xpath(LocatorsCRM.inputProjectName)).sendKeys("PROJECT_HATEST1");

        driver.findElement(By.xpath(LocatorsCRM.dropdownCustomer)).click();
        // Mô tả lại thao tác nhập tên khách hàng để hệ thống tìm kiếm
        WebElement searchCustomer = driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer));
        searchCustomer.click();
        String customerValue = LocatorsCRM.customerName;
        for (char i : customerValue.toCharArray()) {
            searchCustomer.sendKeys(Character.toString(i));
            Thread.sleep(100);
        }
        driver.findElement(By.xpath("//span[normalize-space()='Hatest_01']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.dropdownBillingType)).click();
        driver.findElement(By.xpath("//span[normalize-space()='Fixed Rate']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.dropdownStatus)).click();
        driver.findElement(By.xpath("//span[normalize-space() = 'On Hold']")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputTotalRate)).sendKeys("100");
        driver.findElement(By.xpath(LocatorsCRM.inputEstimatedHours)).sendKeys("9");

        WebElement startDate = driver.findElement(By.xpath(LocatorsCRM.inputStartDate));
        startDate.clear();
        startDate.sendKeys("08-05-2025");
        driver.findElement(By.xpath("//body")).click();

        Thread.sleep(3000);

        WebElement deadLine = driver.findElement(By.xpath(LocatorsCRM.inputDeadline));
        deadLine.sendKeys("09-05-2025");
        deadLine.sendKeys(Keys.TAB);

        driver.findElement(By.xpath(LocatorsCRM.buttonSaveProjects)).click();

        Thread.sleep(2000);
        driver.quit();
    }
}
