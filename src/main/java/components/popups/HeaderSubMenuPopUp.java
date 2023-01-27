package components.popups;

import com.sun.org.apache.bcel.internal.generic.ISUB;
import components.AbsBaseComponent;
import data.menu.HeaderMenuItemData;
import data.menu.ISubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class HeaderSubMenuPopUp extends AbsBaseComponent implements ISubMenuPopUp {


    public HeaderSubMenuPopUp(WebDriver driver) {
        super(driver);
    }

    private String headerSubMenuPopUPSelector = "[data-name='%s'].js-header3-popup";
    private String subMenuItemByNameLocator = "(//*[contains(@class, 'header3__nav-item-popup-content')]//a[contains(@href, '%s')])[1]";

    @Override
    public void popUpShouldNotBeVisible(HeaderMenuItemData headerMenuItemData) {
        String selector = String.format(headerSubMenuPopUPSelector, headerMenuItemData.getName().toLowerCase());
        Assertions.assertTrue(waiter.waitForCondition(
                ExpectedConditions.attributeContains($(By.cssSelector(selector)),
                "style", "none")
        ), String.format("Popup '%s' should not be visible", headerMenuItemData.getName()));
    }

    @Override
    public void popUpShouldBeVisible(HeaderMenuItemData headerMenuItemData) {
        String selector = String.format(headerSubMenuPopUPSelector, headerMenuItemData.getName().toLowerCase());
        Assertions.assertTrue(waiter.waitForCondition(
                ExpectedConditions.not(
                ExpectedConditions.attributeContains($(By.cssSelector(selector)),
                "style", "none"))
        ), String.format("Popup '%s' should be visible", headerMenuItemData.getName()));
    }

    public void clickSubMenuItemByName(ISubMenu subMenuItemData) {
        String locator = String.format(subMenuItemByNameLocator, subMenuItemData.getName().toLowerCase(Locale.ROOT));
        $(By.xpath(locator)).click();
    }
}
