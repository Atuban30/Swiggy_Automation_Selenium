import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Swiggy {
    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        // Open Swiggy
        driver.get("https://www.swiggy.com/");
        driver.manage().window().maximize();
        
        // Set up explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait and Click Login Button
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/div/div[1]/div/div/div/a")));
        login.click();

        // Wait for Mobile Input Field and Enter Number
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='mobile']")));
        input.sendKeys("8697698113");

        // Wait for Submit Button and Click
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/form/div[2]/a")));
        button.click();

        // Wait for OTP Input Field to Appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='otp']")));
        System.out.println("Enter the OTP manually on the webpage...");

        // Wait for manual OTP entry (Adjust time as needed)
        try {
            Thread.sleep(30000); // 30 seconds delay for OTP entry
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The Next Button is clicked
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div/div/div[2]/form/div[2]/div[2]/a")));
        
        // Trying JavaScript click if regular click doesn't work
        try {
            nextButton.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", nextButton);
        }

        // Added wait to ensure the page transition is complete before proceeding
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='root']/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]")));
        
        // Resume automation after OTP entry
        WebElement searchin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]")));
        searchin.click();

        WebElement Roll = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[3]/div[1]/div[3]/div/div/div[2]/div/div/div[1]/button")));
        Roll.click();
        
        // Added wait to ensure the next elements load properly
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement Rollbut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/button[1]")));
        Rollbut.click();

        WebElement food = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div/div/div[4]/div[1]/div/div[2]/div/div[2]/div/div/div/div[1]/div/button[2]")));
        food.click();

        WebElement Cont = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div/div[3]/div/div[2]/div/button")));
        Cont.click();

        WebElement addItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']/div[1]/div/div[2]/div/div/div[4]/div[1]/div/div[2]/div/div[2]/div/div/div/div/div/button[2]")));
        addItem.click();

        // Wait for 2 seconds before navigating to the checkout page
        try {
            Thread.sleep(2000); // 2-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Navigate directly to the checkout page
        driver.get("https://www.swiggy.com/checkout");

        //Add new address
        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[1]/div/div[1]/div[2]/div/div/div/div[2]/div[2]\r\n")));
        address.click();

        //Added the Door
        WebElement Door = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"building\"]")));
        Door.sendKeys("32");

        //Added the Landmark
        WebElement Landmark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"building\"]")));
        Landmark.sendKeys("Sealdah");

        //Added the Address correctly
        WebElement SaveAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"overlay-sidebar-root\"]/div/div/div[2]/div/div[4]/div/div/a\r\n")));
        SaveAdd.click();

        //Click on Proceed to Pay
        WebElement ProceedtoPay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[1]/div/div[2]/div/button")));
        ProceedtoPay.click();

        // Pause for 5 seconds to observe the process
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
    }
}
