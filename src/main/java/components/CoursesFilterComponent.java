package components;

import data.CategoryData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class CoursesFilterComponent extends AbsBaseComponent{

    public CoursesFilterComponent(WebDriver driver){
        super(driver);
    }

    private String courseCategoryCheckBoxLocator = "//div[./label[text()='%s']]//input[@type='checkbox']";

    public CoursesFilterComponent coursesFilterState(CategoryData categoryData, boolean state){
        String locator = String.format(courseCategoryCheckBoxLocator, categoryData.getName().toLowerCase(Locale.ROOT));
        Assertions.assertEquals(state, $(By.xpath(locator)).isSelected());
        return this;
    }
}
