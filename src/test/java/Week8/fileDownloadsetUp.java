package Week8;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class fileDownloadsetUp {
    private final WebDriver driver;
private final By downloadButtonLocator=By.xpath("//a[normalize-space()='File Download']");
private final  By downloadOne = By.xpath("//a[@class='wpdm-download-link download-on-click btn btn-primary ']");
private final By downloadTwo = By.xpath("//a[@class='wpdm-download-link wpdm-download-locked btn btn-primary ']");
    public fileDownloadsetUp(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnDownloadButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(downloadButtonLocator));
        scrollToElement(element);
        try {
            element.click();
        }
        catch (Exception e){
            System.out.println("Normal click failed");
            javascriptClick(element);
        }
        String CurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(CurrentUrl, "https://practice-automation.com/file-download/");
    }
    private void scrollToElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    private void javascriptClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",element );
    }
    public void clickOnDownloadFirst(){
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(downloadOne));
        button.click();

    }
    public void clickDownloadSecond(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(downloadTwo));
        button.click();
    }

}
