package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Constants.AppConstant;
import io.qameta.allure.Allure;

public abstract class TestBase {
    //#region Used Page Objects

    //#endregion

    //#region Business Flows

    //#endregion

    //#region System Methods
    @BeforeMethod
    @Parameters("browser")
    protected void beforeMethod(@Optional("chrome") String browser) {
       this.setBrowser(browser);
       this.maximizeWindow();
    }

    @AfterMethod
    protected void afterMethod() {
        this.closeBrowser();
    }
    
    protected void step(String name) {
        System.out.println(name);
        Allure.step(name);
    }

    protected void step(String name, Runnable action) {
        System.out.println(name);
        Allure.step(name, () -> {
            action.run();
        });
    }
    
    protected void vp(String name, Runnable action) {
        System.out.println("VP: " + name);
        Allure.attachment("Verification Point", name);
        action.run();
    }
    //#endregion
    
    //#region Internal Methods
    private void setBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                AppConstant.WEBDRIVER = new ChromeDriver();
                break;
            case "firefox":
                AppConstant.WEBDRIVER = new FirefoxDriver();
                break;
            case "edge":
                AppConstant.WEBDRIVER = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
    
    private void maximizeWindow() {
        AppConstant.WEBDRIVER.manage().window().maximize();
    }
    
    private void closeBrowser() {
        if (AppConstant.WEBDRIVER != null) {
            AppConstant.WEBDRIVER.quit();
        }
    }
    //#endregion
}
