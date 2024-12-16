package week4.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ecomerce {
    WebDriver driver;
    private By userName = By.xpath("//input[@id='user-name']");
    private By password = By.xpath("//input[@id='password']");
    private By button = By.xpath("//input[@id='login-button']");
    private By firstItem = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By secondItem = By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    private By ThirdItem= By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']");
    private By FourthItem = By.xpath("//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
    private By remove = By.xpath("//button[@id='remove-test.allthethings()-t-shirt-(red)']");
    private By bag = By.xpath("//span[@class='shopping_cart_badge']");

    public ecomerce(WebDriver driver) {
        this.driver = driver;
    }

    public void EnterEmail() {
        driver.findElement(userName).sendKeys("standard_user");

    }

    public void EnterPassword() {
        driver.findElement(password).sendKeys("secret_sauce");
    }

    public void ClickOnButton() {
        driver.findElement(button).click();
      String actualTittle  =  driver.getTitle();
      String ExpectedTitle = "Swag Labs";
      Assert.assertEquals(actualTittle,ExpectedTitle);
        System.out.println(actualTittle);
    }

    public void ChooseFirstItem() {
        driver.findElement(firstItem).click();
        WebElement bags = driver.findElement(bag);
       String bagText = bags.getText();
        Assert.assertEquals(bagText, "1");
    }

    public void ChooseSecondItem() {

        driver.findElement(secondItem).click();

        WebElement bags = driver.findElement(bag);
        String bagText = bags.getText();
        Assert.assertEquals(bagText, "2");


    }
    public void ChooseThirdItem(){
        driver.findElement(ThirdItem).click();

        WebElement bags = driver.findElement(bag);
        String bagText = bags.getText();
        Assert.assertEquals(bagText, "3");
    }
    public void ChooseFourthItem(){
        driver.findElement(FourthItem).click();

        WebElement bags = driver.findElement(bag);
        String bagText = bags.getText();
        Assert.assertEquals(bagText, "4");
    }
    public void RemoveItem(){
        driver.findElement(remove).click();

        WebElement bags = driver.findElement(bag);
        String bagText = bags.getText();
        Assert.assertEquals(bagText, "3");
    }
}