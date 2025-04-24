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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.linkMenuCustomer)));

        // Truy cập menu Customer
        driver.findElement(By.xpath(LocatorsCRM.linkMenuCustomer)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.buttonNewCustomer)));
//        Thread.sleep(2000);

        //Nhấn nút New Customer
        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.inputCompany)));

        // Nhập thông tin các trường ở tab Customer Detail
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("Hatest");
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("10%");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0965994325");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://hatest.com");


        //Chọn Groups
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("Information Technology");
        driver.findElement(By.xpath("//li[1]//span[normalize-space()='Information Technology']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.dropdownCurrency)));

        // Chọn Currency
        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD");
        driver.findElement(By.xpath("//span[contains(normalize-space(),'USD')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.dropdownDefaultLanguage)));

        // Chọn Default Language
        driver.findElement(By.xpath(LocatorsCRM.dropdownDefaultLanguage)).click();
        driver.findElement(By.xpath("//span[normalize-space()='Vietnamese']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorsCRM.inputAdress)));

        driver.findElement(By.xpath(LocatorsCRM.inputAdress)).sendKeys("Thường Tín");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Hà Nội");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("State hatest");
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("0001");


        //Chọn Country
        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam");
        driver.findElement(By.xpath("//span[normalize-space()='Vietnam']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//select[@id='country']/following-sibling::div[@class='dropdown-menu open']")));

        // Nhấn tab Billing & Shipping
        driver.findElement(By.xpath(LocatorsCRM.tabBillingShipping)).click();

        // Nhập thông tin các trường ở tab Customer Detail
        driver.findElement(By.xpath(LocatorsCRM.linkSameAsCustomerInfo)).click();

        // kiểm tra xem các input đã được lấy đúng dữ liệu từ tab Customer Detail chưa
        String customerAddress = driver.findElement(By.xpath(LocatorsCRM.inputAdress)).getAttribute("value");
        String billingStreet = driver.findElement(By.xpath(LocatorsCRM.inputBillingStreet)).getAttribute("value");

        String customerCity = driver.findElement(By.xpath(LocatorsCRM.inputCity)).getAttribute("value");
        String billingCity = driver.findElement(By.xpath(LocatorsCRM.inputBillingCity)).getAttribute("value");

        String stateCustomer = driver.findElement(By.xpath(LocatorsCRM.inputState)).getAttribute("value");
        String billingState = driver.findElement(By.xpath(LocatorsCRM.inputBillingState)).getAttribute("value");

        String customerZipCode = driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).getAttribute("value");
        String billingZipCode = driver.findElement(By.xpath(LocatorsCRM.inputBillingZipCode)).getAttribute("value");

        String customerCountry = driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).getAttribute("value");
        String billingCountry = driver.findElement(By.xpath(LocatorsCRM.dropdownBillingCountry)).getAttribute("value");

        if (billingStreet.equals(customerAddress) &&
                billingCity.equals(customerCity) &&
                billingState.equals(stateCustomer) &&
                billingZipCode.equals(customerZipCode) &&
                billingCountry.equals(customerCountry)) {
            System.out.println("Billing đã được lấy đúng dữ liệu từ tab Customer Detail");
        } else {
            System.out.println("Billing chưa được lấy đúng dữ liệu từ tab Customer Detail");
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
