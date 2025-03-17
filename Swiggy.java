import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Swiggy {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        try {
            driver.get("https://www.swiggy.com/");
            driver.manage().window().maximize();

            // Login Process
            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/div/div[1]/div/div/div/a")));
            login.click();
            
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mobile']")));
            input.sendKeys("6291736165");
            
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='overlay-sidebar-root']/div/div/div[2]/div/div/div/form/div[2]/a")));
            submitButton.click();
            
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='otp']")));
            System.out.println("Enter the OTP manually on the webpage...");
            Thread.sleep(30000);
            
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='overlay-sidebar-root']/div/div/div[2]/div/div/div/div[2]/form/div[2]/div[2]/a")));
            clickWithRetry(driver, wait, nextButton);
            
            // Search & Select Food Item
            WebElement searchin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]")));
            searchin.click();
            
            WebElement roll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[3]/div[1]/div[3]/div/div/div[2]/div/div/div[1]/button")));
            clickWithRetry(driver, wait, roll);
            
            Thread.sleep(5000);
            
            WebElement rollButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/button[1]")));
            clickWithRetry(driver, wait, rollButton);
            
            WebElement food = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[4]/div[1]/div/div[2]/div/div[2]/div/div/div/div[1]/div/button[2]")));
            clickWithRetry(driver, wait, food);
        
            
            WebElement addItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div[4]/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/button[2]")));
            clickWithRetry(driver, wait, addItem);
            
            Thread.sleep(2000);
            
            // Hover over the cart div where checkout button appears
            WebElement cartDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("_3Dpmd")));
            actions.moveToElement(cartDiv).perform();
            
            // Wait for the checkout button to appear and click it
            WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("_3DIDC")));
            clickWithRetry(driver, wait, cartButton);

            //Click on the address
            WebElement addr= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div[1]/div/div[2]/div[4]")));
            addr.click();

            // Proceed to Payment
            WebElement proceedToPay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div/div[2]/div/button")));
            clickWithRetry(driver, wait, proceedToPay);

            //Add UPI
            WebElement upi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div")));
            clickWithRetry(driver, wait, upi);

            //Adding UPI ID
            WebElement upi_id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/div[1]/div/input")));
            upi_id.sendKeys("atrayeeban02@okaxis");

            WebElement proceed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/button")));
            clickWithRetry(driver, wait, proceed);
            
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void clickWithRetry(WebDriver driver, WebDriverWait wait, WebElement element) {
        int attempts = 3;
        for (int i = 0; i < attempts; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying click due to stale element. Attempt " + (i + 1));
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                element = wait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element click intercepted, using JavaScript click...");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                return;
            }
        }
        System.out.println("Failed to click element after multiple attempts.");
    }
}
