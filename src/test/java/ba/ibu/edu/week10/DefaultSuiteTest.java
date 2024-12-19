package ba.ibu.edu.week10;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class DefaultSuiteTest {

  private static WebDriver webDriver;
  private static Map<String, Object> vars;
  private static JavascriptExecutor js;

      @BeforeAll
      public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Benjamin Peljto/web_engineering/selenium/chromedriver.exe"); // specify the path to chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
      }



      @AfterAll
      public static void tearDown() {
        webDriver.quit();
      }

      @Test
      public void demoTestIDE() {
        webDriver.get("https://www.ibu.edu.ba/");
        webDriver.manage().window().setSize(new Dimension(1552, 840));
        webDriver.findElement(By.cssSelector(".menu__elem:nth-child(1) circle")).click();
        webDriver.findElement(By.cssSelector(".link__menu:nth-child(1)")).click();
        webDriver.findElement(By.cssSelector(".menu__link:nth-child(1) > span")).click();
        webDriver.findElement(By.linkText("Information Technology")).click();
        js.executeScript("window.scrollTo(0,430.3999938964844)");
        js.executeScript("window.scrollTo(0,472)");
        js.executeScript("window.scrollTo(0,7175.2001953125)");
        js.executeScript("window.scrollTo(0,7734.39990234375)");
        js.executeScript("window.scrollTo(0,8232.7998046875)");
        js.executeScript("window.scrollTo(0,8410.400390625)");
        webDriver.findElement(By.cssSelector(".input")).click();
        webDriver.findElement(By.cssSelector(".input")).click();
        {
          WebElement element = webDriver.findElement(By.cssSelector(".input"));
          Actions builder = new Actions(webDriver);
          builder.doubleClick(element).perform();
        }
        webDriver.findElement(By.cssSelector(".input")).sendKeys("hehe@me.com");
        webDriver.findElement(By.cssSelector(".btn__gold svg")).click();
      }
}
