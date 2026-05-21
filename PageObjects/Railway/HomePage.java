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
    public static HomePage open() {
        Utilities.open(AppConstant.RAILWAY_URL);
        return new HomePage();
    }

    public String getWelcomeMsg() {
        return Utilities.getText(_welcomeMsg);
    }

    public String getTitle() {
        return Utilities.getText(_title);
    }

    @SuppressWarnings("null")
    private By getLinkByText(String text) {
        return By.linkText(text);
    }

    public boolean checkLinkDisplayedByText(String text) {
        return Utilities.findElement(getLinkByText(text)).isDisplayed();
    }

    public RegisterPage clickLinkByText(String text) {
        Utilities.click(Utilities.findElement(getLinkByText(text)));

        return new RegisterPage();
    }
    // #endregion

}
