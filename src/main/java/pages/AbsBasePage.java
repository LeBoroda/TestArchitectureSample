package pages;

import org.openqa.selenium.WebDriver;
import pageobject.PageObject;

public abstract class AbsBasePage extends PageObject {

    private String baseUrl = System.getProperty("base.url");
    private String path;

    public AbsBasePage(WebDriver driver, String path){
        super(driver);
        this.path = path;
    }
    public void open(){
        if(!path.startsWith("/")){
            path +="/";
        }
        driver.get(baseUrl.replaceAll("\\/$","") + path);
    }
}
