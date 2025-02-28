package week15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TakingScreenShot {
    WebDriver driver;

    @BeforeTest
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-automation.com/");
    }

    @Test
    public void screenShot() throws IOException {
        WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Form Fields']"));

        // Take full-page screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Read the full screenshot image
        BufferedImage fullImage = ImageIO.read(screenshot);

        // Get element position and size
        Point location = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        // Crop the image to the element
        BufferedImage elementScreenshot = fullImage.getSubimage(location.getX(), location.getY(), width, height);

        // Define the file location
        File destinationFile = new File("C:\\Users\\AbigailNyameyieArko\\OneDrive - AmaliTech gGmbH\\Desktop\\First upskilling project\\src\\main\\resources\\pictures");

        // Ensure the directory exists
        Files.createDirectories(destinationFile.getParentFile().toPath());

        // Save the cropped image
        ImageIO.write(elementScreenshot, "png", destinationFile);

        System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
