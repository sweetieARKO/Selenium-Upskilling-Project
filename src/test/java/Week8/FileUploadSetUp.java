package Week8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploadSetUp {
    private final WebDriver driver;
    private final By fileUploadIcon = By.xpath("//a[normalize-space()='File Upload']");
    private final By fileeUploadSpace = By.xpath("//input[@id='file-upload']");
    public FileUploadSetUp(WebDriver driver) {
        this.driver = driver;
    }

    public void setFileUploadIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fileUploadIcon));

        scrollToElement(element);

        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Normal click failed. Trying JavaScript click...");
            javascriptClick(element);
        }
    }

    private void javascriptClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void uploading(){
        driver.findElement(fileeUploadSpace).sendKeys("C:\\Users\\AbigailNyameyieArko\\OneDrive - AmaliTech gGmbH\\Desktop\\First upskilling project\\src\\main\\resources\\test casee.PNG");
    }
}
