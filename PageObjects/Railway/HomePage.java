package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constants.AppConstant;

public class HomePage extends GeneralPage {
    // #region Locators
    private final By _welcomeMsg = By.xpath("//*[@id='banner']//*[@class='account']");

    private final By _title = By.cssSelector("#content h1");

    // #endregion

    // #region Methods
    public HomePage open() {
        Utilities.open(AppConstant.RAILWAY_URL);
        return this;
    }

    public String getWelcomeMsg() {
        return Utilities.getText(_welcomeMsg);
    }

    public String getTitle() {
        return Utilities.getText(_title);
    }
    // #endregion

}
