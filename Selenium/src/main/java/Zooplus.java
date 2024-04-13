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

public class Zooplus {

    private WebDriver driver;
    @Before
    public void setUp() throws Exception {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.zooplus.ro/");
        driver.manage().window().maximize();
    }

    @Test
    public void newslatterAbonation() throws Exception{
        // Așteaptă până când pop-up-ul de cookie-uri devine vizibil
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ot-sdk-container")));

        // Faceți clic pe butonul "Acceptă și continuă" dacă este prezent
        try {
            WebElement acceptButton = cookiePopup.findElement(By.id("onetrust-accept-btn-handler"));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Butonul 'Acceptă și continuă' nu a fost găsit sau nu este vizibil.");
        }

        WebElement myZooplusButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("srh-account")));


        myZooplusButton.click();

        // Introducerea adresei de e-mail
        WebElement emailInput = driver.findElement(By.id("username"));
        emailInput.sendKeys("stephenievlouvv@gmail.com");

        // Introducerea parolei
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("D@buleni$789");

        // Trimiterea formularului prin clic pe butonul de login
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click();


        // Așteptați până când starea paginii devine "complet încărcată"
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

        // Apoi derulați până la sfârșitul paginii
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Navigarea la formularul de abonare la newsletter
        WebElement newsletterButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid=newsletter-box]")));
        newsletterButton.click();


        // Find the dropdown trigger button
        WebElement dropdownTrigger = driver.findElement(By.cssSelector("[data-zta=dropdownMenuTriggerButton]"));
        dropdownTrigger.click();

        WebElement dogCheckbox = driver.findElement(By.cssSelector("input#dog"));

        if (!dogCheckbox.isSelected()) {
            dogCheckbox.click();
        }

        // Find the "Salvează" button by its data-zta attribute
        WebElement saveButton = driver.findElement(By.cssSelector("button[data-zta='pet-checkbox-confirm-btn']"));

        // Click on the "Salvează" button
        saveButton.click();

        // Find the "Abonează-te" button by its data-zta attribute
        WebElement subscribeButton = driver.findElement(By.cssSelector("button[data-zta='subscription-button']"));

        // Click on the "Abonează-te" button
        subscribeButton.click();
    }

    @Test
    public void calculateTransportation() throws Exception{

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookiePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ot-sdk-container")));


        try {
            WebElement acceptButton = cookiePopup.findElement(By.id("onetrust-accept-btn-handler"));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Butonul 'Acceptă și continuă' nu a fost găsit sau nu este vizibil.");
        }

        WebElement myZooplusButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("srh-account")));
        myZooplusButton.click();
        WebElement emailInput = driver.findElement(By.id("username"));
        emailInput.sendKeys("vircan.raluca@gmail.com");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("D@buleni$789");
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click();
        WebElement navigationMenu = driver.findElement(By.className("LowerBar_desktopNavigation__2OEG7"));
        Actions actions = new Actions(driver);
        actions.moveToElement(navigationMenu).perform();
        WebElement buttonElement = driver.findElement(By.cssSelector("button[aria-labelledby='category-button-label-Câini']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonElement);
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/shop/caini']")));
        linkElement.click();
        WebElement linkHranaCaini= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-zta='category-link'][href='/shop/caini/hrana_uscata_caini']")));
        linkHranaCaini.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        WebElement increaseButton = driver.findElement(By.cssSelector("button[data-zta='quantityStepperIncrementButton']"));
        increaseButton.click();
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[data-zta='add-to-cart']"));
        addToCartButton.click();
        JavascriptExecutor derulareinapoi = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");
        WebElement cartButton = driver.findElement(By.cssSelector("a[data-testid='MiniCartLink']"));
        cartButton.click();
    }

}
