package ba.ibu.edu.week7;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lab {
    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Benjamin Peljto/web_engineering/selenium/chromedriver.exe"); // specify the path to chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        // * base url
    }

    @Test
    void testDeanName(){
        webDriver.get("https://www.ibu.edu.ba/faculty-of-engineering-natural-and-medical-sciences");
        WebElement pDean = webDriver.findElement(By.className("dean__footer"));
        System.out.println(pDean.getText());
        assertTrue(pDean.getText().contains("Jasmin Kevrić"));
    }

    @Test
    public void testSignupForm() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/offices/it-support-office");

        WebElement textBelow = webDriver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div[1]/div[4]/div/p[3]"));
        WebElement inputForEmail = webDriver.findElement(RelativeLocator.with(By.tagName("input")).above(textBelow));
        inputForEmail.sendKeys("jane.doe@gmail.com");
        Thread.sleep(5000);
    }



    @AfterAll
    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
