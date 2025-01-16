package Week5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class windowframes {
    WebDriver driver;
    @BeforeTest
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void handleWindow(){
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        // Store the current window handle
        String currentWindow = driver.getWindowHandle();

// Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles: " + windowHandles);

        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();

            // Check if the handle is not the parent window
            if (!childWindow.equalsIgnoreCase(currentWindow)) {
                // Switch to the child window
                driver.switchTo().window(childWindow);
                System.out.println("Switched to child window: " + childWindow);

                // Perform any actions on the child window
                System.out.println("Title of the child window: " + driver.getTitle());

                // Break the loop after switching
                break;
            }
        }

// Optional: Close the child window and switch back to the parent window
        driver.close(); // Close the current child window
        driver.switchTo().window(currentWindow); // Switch back to the parent window
        System.out.println("Switched back to parent window.");

    }
    @AfterTest
    public void after(){
        driver.quit();
    }
        }
