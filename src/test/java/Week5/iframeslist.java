package Week5;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class iframeslist {
    WebDriver driver;
    public iframeslist(WebDriver driver){
        this.driver=driver;
    }

    By iframeLink = By.xpath("//a[normalize-space()='Iframes']");
    By iframeOne = By.xpath("//iframe[@id='iframe-1']");
    By getStarted = By.linkText("GET STARTED");
    By iframeTwo = By.xpath("//iframe[@id='iframe-2']");
    By RegisterLink = By.xpath("//a[@href='/documentation']");

    // Method to click on the iframe link


    // Method to click on the iframe link
    public void clickOnIframes() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait until the iframe link element is visible
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLink));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the iframe link element using scrollIntoView
        js.executeScript("arguments[0].scrollIntoView(true);", iframeElement);

        // Additional wait to ensure it's clickable
        wait.until(ExpectedConditions.elementToBeClickable(iframeElement));

        // Log element state
        System.out.println("Iframe link element found: " + iframeElement.isDisplayed());
        System.out.println("Iframe link element clickable: " + iframeElement.isEnabled());

        // Click on the iframe link element using JavaScript (as a fallback)
        js.executeScript("arguments[0].click();", iframeElement);           }

public void switchIframe(){
    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(30));
    WebElement iframeElement = wait.until(ExpectedConditions.elementToBeClickable(iframeOne));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true)", iframeElement);
    driver.switchTo().frame(iframeElement);
    WebElement getStartedElement = wait.until(ExpectedConditions.elementToBeClickable(getStarted));
    getStartedElement.click();
    driver.switchTo().defaultContent();
}
}