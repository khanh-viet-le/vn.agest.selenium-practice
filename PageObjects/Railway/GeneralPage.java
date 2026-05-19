package Railway;

import Common.Utilities;
import Constants.MenuItem;

public class GeneralPage {
    // #region Locators
    protected String _menu = "//*[@id='menu']//a[span[contains(text(), '%s')]]";

    // #endregion

    // #region Methods
    @SuppressWarnings("unchecked")
    protected <T extends GeneralPage> T goToPage(MenuItem item) {
        selectTab(item);

        switch (item) {
            case HOME:
                return (T) new HomePage();

            case LOGIN:
                return (T) new LoginPage();

            default:
                throw new IllegalArgumentException("Invalid Menu item");
        }
    }

    protected void selectTab(MenuItem item) {
        Utilities.click(Utilities.getLocatorElement(_menu, item.getText()));
    }
    // #endregion
}
