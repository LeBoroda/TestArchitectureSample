package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeacherCardPage extends AbsBasePage{

    public TeacherCardPage(WebDriver driver){
        super(driver, "");
    }

    private String teacherNameLocator = "//div[text()='%s']";

    public TeacherCardPage teacherNameShouldBeSameAs(String teacherName){
        String locator = String.format(teacherNameLocator, teacherName);

        Assertions.assertEquals(
                teacherName,
                driver.findElement(By.xpath(locator)).getText(),
                String.format("Teacher name should be %s", teacherName)
        );
        return this;
    }
}
