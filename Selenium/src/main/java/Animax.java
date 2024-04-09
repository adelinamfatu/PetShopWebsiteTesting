import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.sleep;

public class Animax {

    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://animax.ro/");
        driver.manage().window().maximize();
    }

    @Test
    public void testBrand() throws Exception {
        try {
            driver.findElement(By.linkText("Accept")).click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement meniuCategoriePrincipala = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/sticky-header/div[2]/div[4]/div/div[1]/div/nav/div/div[2]/a")));

            Actions action = new Actions(driver);
            action.moveToElement(meniuCategoriePrincipala).perform();

            driver.findElement(By.xpath("//*[@id=\"header\"]/sticky-header/div[2]/div[4]/div/div[1]/div/nav/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/a")).click();

            driver.findElement(By.xpath("/html/body/main/div/div/div/div[3]/div/div/div[2]/div[2]/div[3]/div/div/div[3]/product-item/div/form/div[1]")).click();

            driver.findElement(By.xpath("//*[@id=\"shopify-section-template--18983833207122__main\"]/div[2]/div/div/div/single-product/div/div[2]/div[1]/form/div[9]/div[1]/button")).click();

            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement button = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hrana-uscata-pentru-caini-devora-grain-free-cu-cal-7-5-kg-animax-ro\"]/div[7]/div[3]/div/div[2]/div[2]/div[3]/a[2]")));
            button.click();


        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Test passed!");
        }
    }

    @Test
    public void testComment() throws Exception {

        try {
            driver.findElement(By.linkText("Accept")).click();

            driver.findElement(By.xpath("//*[@id=\"header\"]/sticky-header/div[2]/div[2]/div/div[3]/a[2]")).click();

            driver.findElement(By.id("CustomerEmail")).sendKeys("roxana_enescu9@yahoo.com");
            driver.findElement(By.id("CustomerPassword")).sendKeys("12345678");
            driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div/input")).click();

            driver.findElement(By.xpath("//*[@id=\"MainContent\"]/div[3]/div/div[2]/div[2]/div[1]/span")).click();

            WebElement inputPrenume = driver.findElement(By.id("profile_first_name"));
            inputPrenume.clear();
            inputPrenume.sendKeys("Roxana-Andreea");

            driver.findElement(By.xpath("//*[@id=\"MainContent\"]/div[3]/div/div[2]/form/div[8]/span[1]")).click();

            driver.findElement(By.xpath("//*[@id=\"header\"]/sticky-header/div[2]/div[2]/div/div[2]/div/a")).click();

            driver.findElement(By.xpath("//*[@id=\"header\"]/sticky-header/div[2]/div[2]/div/div[3]/a[2]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Test passed!");
        }
    }
}

