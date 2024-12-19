package ba.ibu.edu.week11;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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

    @AfterAll
    public static void tearDown() {
        webDriver.quit();
    }
}
