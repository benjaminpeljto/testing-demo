package ba.ibu.edu.week11;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximizedTest {

    private static WebDriver webDriver;
    private static JavascriptExecutor js;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Benjamin Peljto/web_engineering/selenium/chromedriver.exe"); // specify the path to chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        js = (JavascriptExecutor) webDriver;
    }

    @Test
    public void testMax() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/");
        Thread.sleep(1500);
        js.executeScript("alert('Hello, World!');");
        Thread.sleep(1500);
    }

    @Test
    public void lejla() throws InterruptedException {
            webDriver.get("http://www.uitestingplayground.com/sampleapp");
            Thread.sleep(1000);
            WebElement userNameInput = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][2]/div/input[@name='UserName']"));
            WebElement passwordInput = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][3]/div/input[@name='Password']"));
            userNameInput.sendKeys("wrong");
            Thread.sleep(800);
            passwordInput.sendKeys("credentials");
            Thread.sleep(800);
            WebElement loginBtn = webDriver.findElement(By.xpath("//button[@id='login']"));
            loginBtn.click();
            Thread.sleep(2000);
            WebElement element = webDriver.findElement(By.xpath("/html/body/section/div[@class='container']/div[@class='row'][1]/div/label[@id='loginstatus']"));
            assertEquals("Invalid username/password", element.getText());
    }

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
