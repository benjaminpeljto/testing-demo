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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LabMaterials {

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
    public void testSignupForm() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba/offices/it-support-office");

        WebElement textBelow = webDriver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div[1]/div[4]/div/p[3]"));
        System.out.println(textBelow.getText());
        WebElement inputForEmail = webDriver.findElement(RelativeLocator.with(By.tagName("input")).above(textBelow));
        inputForEmail.sendKeys("jane.doe@gmail.com");
        Thread.sleep(5000);
    }




    @Test
    public void testLabIntro(){
        // find a single element; throw error if it doesn't exist
        WebElement element = webDriver.findElement(By.name("username"));

        //find ALL elements that match the locator; return empty array if none are found
        List<WebElement> elements = webDriver.findElements(By.className("form-control"));
    }

    @Test
    void testDeanName() throws InterruptedException {
        webDriver.get("https://www.ibu.edu.ba");
        Thread.sleep(1000);
        webDriver.navigate().to("https://www.ibu.edu.ba/faculty-of-engineering-natural-and-medical-sciences");
        WebElement deanFooter = webDriver.findElement(By.className("dean__footer"));
        assertTrue(deanFooter.getText().contains("Jasmin Kevrić"));
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
