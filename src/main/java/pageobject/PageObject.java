package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import waiters.StandardWaiter;

public abstract class PageObject {

    protected Actions actions;
    protected WebDriver driver;
    protected StandardWaiter waiter;

    public PageObject(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
        waiter = new StandardWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    protected WebElement $(By by) {
        return driver.findElement(by);
    }

}
