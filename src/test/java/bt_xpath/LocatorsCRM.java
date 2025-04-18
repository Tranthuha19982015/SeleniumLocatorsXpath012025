package bt_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsCRM {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");

//        Xpath trang Login
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='remember']")).click();
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
//        driver.findElement(By.xpath("//a[normalize-space() = 'Forgot Password?']")).click();

//        Xpath menu Customer
        driver.findElement(By.xpath("//ul//a[@href='https://crm.anhtester.com/admin/clients']")).click();
        driver.findElement(By.xpath("//div/a[contains(@href,'https://crm.anhtester.com/admin/clients/client')]")).click();

//        Xpath Add New Customer
        driver.findElement(By.xpath("//input[@id='company' and @name='company']")).sendKeys("HA_COMPANY_1");
        driver.findElement(By.xpath("//input[@id='vat' and @name='vat']")).sendKeys("10%");
        driver.findElement(By.xpath("//input[@id='phonenumber']")).sendKeys("0965994307");
        driver.findElement(By.xpath("//input[@id='website']")).sendKeys("https://hatest.com");
        // select Groups
        driver.findElement(By.xpath("//div//button[starts-with(@data-id,'groups_in[]')]")).click();
        driver.findElement(By.xpath("//div[@app-field-wrapper = 'groups_in[]']//input[@type='search']")).sendKeys("Information Technology");
        driver.findElement(By.xpath("//ul/li[1]/a/span[normalize-space()='Information Technology']")).click();
        //select Currency
        driver.findElement(By.xpath("//div//button[@data-id='default_currency']")).click();
        driver.findElement(By.xpath("//div[@app-field-wrapper = 'default_currency']//input[@type='search']")).sendKeys("USD");
        driver.findElement(By.xpath("//a/span[text()='USD']")).click();
        //select Default Language
        driver.findElement(By.xpath("//div//button[@data-id='default_language']")).click();
        driver.findElement(By.xpath("//ul//span[normalize-space()='Vietnamese']")).click();

        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys("Hà Nội");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Nodo");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("state abc");
        driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("zip abc");
        //select Country
        driver.findElement(By.xpath("//div//button[starts-with(@data-id,'country')]")).click();
        driver.findElement(By.xpath("//div[@app-field-wrapper = 'country']//input[@type='search']")).sendKeys("Vietnam");
        driver.findElement(By.xpath("//a/span[normalize-space()='Vietnam']")).click();

//        driver.findElement(By.xpath("//button[normalize-space()='Save' and contains(@class,'customer-form-submiter')]")).click();

//        Xpath menu Project
        driver.findElement(By.xpath("//span[normalize-space()='Projects']/ancestor::a[@href='https://crm.anhtester.com/admin/projects']")).click();


        Thread.sleep(3000);
        driver.quit();
    }
}
