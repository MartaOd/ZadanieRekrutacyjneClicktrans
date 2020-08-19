package org.example.testgda24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SeleniumBasics {

    private ChromeDriver webDriver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        this.webDriver = new ChromeDriver();
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.webDriver.get("https://dev-1.clicktrans.pl/register-test/courier");
        this.webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        this.webDriver.quit();
    }


    @Test
    public void testRegistrationPage() {

        WebElement registerCompanyInput = webDriver.findElement(By.xpath("/html//input[@id='user_register_company_name']"));
        registerCompanyInput.sendKeys("Bubblemix");

        WebElement registerEmailInput = webDriver.findElement(By.xpath("/html//input[@id='user_register_email']"));
        registerEmailInput.sendKeys("gaiamacsharry@indiatimes.com");

        WebElement firstNameInput = webDriver.findElement(By.id("user_register_name"));
        firstNameInput.sendKeys("Gaia MacSharry");

       WebElement phoneCode = webDriver.findElement(By.xpath("/html//select[@id='user_register_phoneCode']"));
        Select phoneCodeDropdown = new Select(phoneCode);
        phoneCodeDropdown.selectByValue("1");

        WebElement registerPhoneInput = webDriver.findElement(By.xpath("/html//input[@id='user_register_phone']"));
        registerPhoneInput.sendKeys("643453226");

        WebElement registerPasswordInput = webDriver.findElement(By.xpath("/html//input[@id='user_register_plainPassword']"));
        registerPasswordInput.sendKeys("GTMrJwiEi0");

        WebElement registerAgreementRegulations = webDriver.findElement(By.xpath("/html//input[@id='user_register_settings_agreementRegulations']"));
        registerAgreementRegulations.click();

        WebElement registerAgreementPersonalData = webDriver.findElement(By.name("user_register[settings][agreementPersonalData]"));
        registerAgreementPersonalData.click();

        WebElement submitRegisterSubmit = webDriver.findElement(By.xpath("//form[@id='user_register_form']//div[@class='column']"));
        submitRegisterSubmit.click();

        Assert.assertEquals(true, webDriver.findElementByXPath("/html/body/div[6]/div/i[@class='close icon']").isDisplayed());
        }
    }