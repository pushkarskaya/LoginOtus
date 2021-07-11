import org.junit.*;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.swing.*;

public class LoginOtus{
private WebDriver driver;
private Logger logger = LogManager.getLogger(LoginOtus.class);


@BeforeClass
public static void setupClass() {
    WebDriverManager.chromedriver().setup();
}

@Before
    public void setupTest(){
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

//        wait for loading page
    driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);

//         wait for an asynchronous script to finish execution
    driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
}

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
        public void LogOtus(){
        logger.info("Старт теста");
        driver.get("https://otus.ru/");
        WebElement loginButton= driver.findElement(By.xpath("//button[contains(text(),'Вход')]"));
        loginButton.click();
        WebElement putEmail=driver.findElement(By.xpath("//input[@type='text' and @name='email' and @placeholder='Электронная почта']"));
        putEmail.click();
        putEmail.sendKeys("testpushkarskaya@yandex.ru");
        WebElement putPassword=driver.findElement(By.xpath("//input[contains(@type,'password')]"));
        putPassword.click();
        putPassword.sendKeys("testpushkarskaya2018");
        driver.findElement((By.xpath("//button[@class='new-button new-button_full new-button_blue new-button_md' and contains(text(), 'Войти')]"))).click();
        WebElement imgSova=driver.findElement(By.xpath("//div[contains(concat(' ',@class,' '),' header2-menu__icon-img ic-blog-default-avatar ')]"));
//        Actions actions= new Actions(driver);
//        actions.moveToElement(imgSova);
        imgSova.click();
        WebElement lk=driver.findElement(By.xpath("//a[@class=\"header2-menu__dropdown-link header2-menu__dropdown-link_no-wrap\" and @href=\"/learning/\"]"));
        lk.click();
        //logger.info(driver.getTitle());
        WebElement about=driver.findElement(By.xpath("//a[@title='О себе']"));
        about.click();
    }

    private void TreadSleep(int i) {
    }


}
