package otus.main;

import components.CoursesFilterComponent;
import components.HeaderMenuComponent;
import components.popups.HeaderSubMenuPopUp;
import data.CategoryData;
import data.menu.HeaderMenuItemData;
import data.menu.SubMenuCategoryCourseItemData;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class HeaderMenuTest {
    private WebDriver driver;
    @BeforeAll
    public static void setUpDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().createDriver();
    }

    @AfterEach
    public void close(){
        if(driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void clickCourseCategoryHeaderMenu(){
        new MainPage(driver).open();

        HeaderSubMenuPopUp headerSubMenuPopUP = new HeaderSubMenuPopUp(driver);
        headerSubMenuPopUP.popUpShouldNotBeVisible();

        new HeaderMenuComponent(driver)
                .moveCursorToHeaderItem(HeaderMenuItemData.LEARNING);

        headerSubMenuPopUP.popUpShouldBeVisible();
        headerSubMenuPopUP.clickSubMenuItemByName(SubMenuCategoryCourseItemData.GAMEDEV);

        new CoursesFilterComponent(driver)
                .coursesFilterState(CategoryData.GAMEDEV, true);
    }
}
