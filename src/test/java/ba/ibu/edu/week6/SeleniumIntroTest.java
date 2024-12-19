package ba.ibu.edu.week6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumIntroTest {

    private static WebDriver webDriver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Benjamin Peljto/web_engineering/selenium/chromedriver.exe"); // specify the path to chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        baseUrl = "https://www.ibu.edu.ba";
    }

    @Test
    public void testTitle() throws InterruptedException {
        // Get the title of the page and check if it matches the expected title
        webDriver.get(baseUrl);
        String actualTitle = webDriver.getTitle();
        System.out.println("Actual title: " + actualTitle);
        assertEquals("International Burch University | IBU", actualTitle, "Title does not match");
        Thread.sleep(1000);
    }

    @Test
    void testRedirect() throws InterruptedException {
        webDriver.get("https://lms.ibu.edu.ba/");
        Thread.sleep(2000);
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        assertEquals("https://learning.ibu.edu.ba/", currentUrl);

    }

    @Test
    public void testContactForm() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/contact-us");
        webDriver.manage().window().maximize();


        Thread.sleep(3000);
        WebElement name = webDriver.findElement(By.name("fullName"));
        name.sendKeys("Jane Doe");


        WebElement email = webDriver.findElement(By.name("email"));
        email.sendKeys("jane.doe@ibu.edu.ba");


        WebElement subject = webDriver.findElement(By.name("subject"));
        subject.sendKeys("Hello from SVVT. :)");


        WebElement message = webDriver.findElement(By.name("message"));
        message.sendKeys("Hi, this is an automated test.");
        Thread.sleep(3000);
    }




    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (webDriver != null) {
            webDriver.quit();
        }
    }


}
