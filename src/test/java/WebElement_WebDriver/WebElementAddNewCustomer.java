package WebElement_WebDriver;

import BT_Locators.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.chrono.ThaiBuddhistEra;

public class WebElementAddNewCustomer {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // truy cập link web CRM
        driver.get(LocatorsCRM.url);

        // Login CRM
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();

        Thread.sleep(3000);

        // Truy cập menu Customer
        driver.findElement(By.xpath(LocatorsCRM.linkMenuCustomer)).click();
        Thread.sleep(2000);

        //Nhấn nút New Customer
        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
        Thread.sleep(2000);

        // Nhập thông tin các trường ở tab Customer Detail
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("Hatest");
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("10%");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0965994325");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://hatest.com");


        //Chọn Groups
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("Information Technology");
        driver.findElement(By.xpath("//li[1]//span[normalize-space()='Information Technology']")).click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Groups']/following-sibling::div//div[@class='dropdown-menu open']")));

        // Chọn Currency
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD");
        driver.findElement(By.xpath("//span[contains(normalize-space(),'USD')]")).click();
        Thread.sleep(2500);

        // Chọn Default Language
        driver.findElement(By.xpath(LocatorsCRM.dropdownDefaultLanguage)).click();
        driver.findElement(By.xpath("//span[normalize-space()='Vietnamese']")).click();
        Thread.sleep(2500);

        driver.findElement(By.xpath(LocatorsCRM.inputAdress)).sendKeys("Thường Tín");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Hà Nội");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("State hatest");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("0001");


        //Chọn Country
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[normalize-space()='Vietnam']")).click();
        Thread.sleep(2500);

        // Nhập thông tin các trường ở tab Customer Detail
        driver.findElement(By.xpath(LocatorsCRM.linkSameAsCustomerInfo)).click();

        Thread.sleep(2000);
        driver.quit();
    }
}
