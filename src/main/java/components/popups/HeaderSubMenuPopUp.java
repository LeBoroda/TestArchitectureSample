package components.popups;

import components.AbsBaseComponent;
import data.menu.ISubMenu;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Locale;

public class HeaderSubMenuPopUp extends AbsBaseComponent implements IPopUp{


    public HeaderSubMenuPopUp(WebDriver driver) {
        super(driver);
    }

    private String headerSubMenuPopUPSelector = "[data-name='%s'].js-header3-popup:not([style*='none'])";
    private String subMenuItemByNameLocator = "(//*[contains(@class, 'header3__nav-item-popup-content')]//a[contains(@href, '%s')])[1]";

    @Override
    public void popUpShouldNotBeVisible() {
        Assertions.assertTrue(waiter.waitForCondition(
                ExpectedConditions.attributeContains($(By.cssSelector(headerSubMenuPopUPSelector)),
                "style", "none")
        ));
    }

    @Override
    public void popUpShouldBeVisible() {
        Assertions.assertTrue(waiter.waitForCondition(
                ExpectedConditions.not(
                ExpectedConditions.attributeContains($(By.cssSelector(headerSubMenuPopUPSelector)),
                "style", "none"))
        ));
    }

    public void clickSubMenuItemByName(ISubMenu subMenuItemData) {
        String locator = String.format(subMenuItemByNameLocator, subMenuItemData.getName().toLowerCase(Locale.ROOT));
        $(By.xpath(locator)).click();
    }
}
