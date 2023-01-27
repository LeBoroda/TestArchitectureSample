package otus.main;

import components.TeachersBlock;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class TeacherBlockTest {

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
    public void clickTeacherTile(){
        new MainPage(driver)
                .open();

        TeachersBlock teachersBlock = new TeachersBlock(driver);
        String teacherName = teachersBlock
                .getTeacherNameByIndex(1);

        teachersBlock
                .clickTeacherTile(1)
                .teacherNameShouldBeSameAs(teacherName);
    }
}
