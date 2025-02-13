package Week8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class fileDownloadsetUp {
    private final WebDriver driver;
    private final By downloadButtonLocator = By.xpath("//a[normalize-space()='File Download']");
    private final By downloadOne = By.xpath("//a[@class='wpdm-download-link download-on-click btn btn-primary ']");
    private final By downloadTwo = By.xpath("//a[@class='wpdm-download-link wpdm-download-locked btn btn-primary ']");
    private final String downloadDir = "C:\\Downloads"; // specify your download folder

    public fileDownloadsetUp(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnDownloadButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(downloadButtonLocator));
        scrollToElement(element);
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Normal click failed");
            javascriptClick(element);
        }
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://practice-automation.com/file-download/");
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void javascriptClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickOnDownloadFirst() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(downloadOne));
        button.click();
    }

    public void clickDownloadSecond() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(downloadTwo));
        button.click();
    }
    public void SetPassword (String password){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for iframe and switch to it
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("wpdm-lock-frame")));
            driver.switchTo().frame(iframe);

            // Use JavaScript Executor to get the shadow root
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Find the shadow host element inside the iframe
            WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("css-selector-of-shadow-host")));

            // Get shadow root
            WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

            // Find the password field inside shadow DOM
            WebElement passwordField = (WebElement) js.executeScript(
                    "return arguments[0].querySelector('input[type=password]')", shadowRoot);

            // Find the submit button inside shadow DOM
            WebElement submitButton = (WebElement) js.executeScript(
                    "return arguments[0].querySelector('input[type=submit]')", shadowRoot);

            // Enter password and submit
            passwordField.sendKeys(password);
            submitButton.click();

            // Switch back to main page
            driver.switchTo().defaultContent();

            System.out.println("Password submitted successfully!");
        }


        // Method to verify if a specific file is downloaded
    public void FileVerify(String fileName) {
        File file = new File(downloadDir + "\\" + fileName);
        int attempts = 0;
        while (!file.exists() && attempts < 30) {
            try {
                Thread.sleep(1000); // wait for the file to appear
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }

        // Verify if the file exists
        if (file.exists()) {
            System.out.println("File downloaded successfully: " + fileName);
        } else {
            System.out.println("File download failed: " + fileName);
        }
    }
}
