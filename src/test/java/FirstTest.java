import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;


public class FirstTest {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");

    }

    @Test
    public void checkNavigation() {
        driver.findElement(By.xpath("//div[@class='top-links__left flex-wrap']//a[@href='/discount']")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

    }

    @Test
    public void CheckTitle() {
        String currentTitle = driver.getTitle();
        System.out.println("CurrentTitle->" + currentTitle);
        Assert.assertEquals(currentTitle, "AVIC™ - удобный интернет-магазин " +
                "бытовой техники и электроники в Украине. | Avic");
    }

    @Test
    public void checkElement() {
        driver.findElement(By.xpath("//div[@class='top-links__left flex-wrap']//a[@href='/discount']")).click();
        driver.findElement(By.xpath("//ul[@class='category-box__list']//a[@href='https://avic.ua/klaviaturyi/actions--3']")).click();

    }

    @Test
    public void checkCookies() {
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies->" + cookies);
    }

    @Test
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
        System.out.println("DeleteAllCookies->" + driver.manage().getCookies());
    }

    @Test
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("Карман для MacBook");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).submit();
    }

    @Test
    public void checkSignInClick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='header-bottom__right-icon']//i[@class='icon icon-user-big']"))).click();
    }

}


