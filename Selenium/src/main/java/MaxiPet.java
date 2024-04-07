import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.sleep;

public class MaxiPet {
  private WebDriver driver;
  @Before
  public void setUp() throws Exception {
    Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    System.setProperty("webdriver.http.factory", "jdk-http-client");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    driver.get("https://www.maxi-pet.ro/");
    driver.manage().window().maximize();
  }

  /*
  @Test
  public void testBrand() throws Exception {
    try {
      driver.findElement(By.linkText("Accept")).click();
      driver.findElement(By.linkText("Animăluțul meu")).click();
      driver.findElement(By.xpath("//div[@id='block-id-template--19319120691481__c5e8e9da-f90e-4262-8c7e-36b8b409774f-16868083275a6fa75a-1']/div/a/div/div/img")).click();
      driver.findElement(By.xpath("//div[@id='shopify-section-template--20758087237913__main']/div/div[2]/div[3]/div/ul/li[2]/a")).click();
      WebElement productListContainer = driver.findElement(By.cssSelector(".collection-listing--main"));
      List<WebElement> productList = productListContainer.findElements(By.tagName("a"));
      if (!productList.isEmpty()) {
        productList.get(0).click();
      } else {
        System.out.println("No products found.");
        Assert.fail("No products found to select.");
      }
      WebElement brandLink = driver.findElement(By.xpath("//div[@class='vendor lightly-spaced-row']/a"));
      brandLink.click();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.urlContains("/collections/vendors"));

    } catch (Exception e) {
      System.out.println("Test failed: " + e.getMessage());
      Assert.fail("Test failed: " + e.getMessage());
    } finally {
      driver.quit();
      System.out.println("Test passed!");
    }
  }*/

  @Test
  public void testComment() throws Exception {
    try {
      driver.findElement(By.linkText("Accept")).click();
      driver.findElement(By.linkText("PROMOȚII")).click();
      driver.findElement(By.xpath("//div[@id='shopify-section-template--20758086189337__main']/div/div[2]/div/div[3]/span/div/button/span")).click();
      driver.findElement(By.linkText("Data, de la nou la vechi")).click();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
      WebElement productListContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.filters-adjacent.collection-listing.collection-listing--main")));
      List<WebElement> productList = productListContainer.findElements(By.tagName("a"));
      if (!productList.isEmpty()) {
        productList.get(0).click();
      } else {
        System.out.println("No products found.");
        Assert.fail("No products found to select.");
      }

      ((JavascriptExecutor)driver).executeScript("scroll(0,1500)");
      driver.findElement(By.cssSelector("svg.needsclick.kl-private-reset-css-Xuajs1 > circle")).click();
      driver.findElement(By.linkText("Scrie o părere")).click();
      driver.findElement(By.id("jdgm_review_body_71crgchbf")).click();
      driver.findElement(By.id("jdgm_review_body_71crgchbf")).sendKeys("Mâncare de încredere pentru animalul tău, sănătoasă și echilibrată.");
      driver.findElement(By.id("jdgm_review_reviewer_name_71crgchbf")).click();
      driver.findElement(By.id("jdgm_review_reviewer_name_71crgchbf")).sendKeys("Adelina");
      driver.findElement(By.id("jdgm_review_reviewer_email_71crgchbf")).click();
      driver.findElement(By.id("jdgm_review_reviewer_email_71crgchbf")).sendKeys("adelina1d16@gmail.com");
      driver.findElement(By.xpath("//input[@value='Depune părerea']")).click();
    } catch (Exception e) {
      System.out.println("Test failed: " + e.getMessage());
      Assert.fail("Test failed: " + e.getMessage());
    } finally {
      driver.quit();
      System.out.println("Test passed!");
    }
  }
}
