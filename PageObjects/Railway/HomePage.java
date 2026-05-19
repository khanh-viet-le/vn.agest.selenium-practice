package Railway;

import Common.Utilities;
import Constants.AppConstant;

public class HomePage extends GeneralPage {
    // #region Locators

    // #endregion

    // #region Methods
    public HomePage open() {
        Utilities.open(AppConstant.RAILWAY_URL);
        return this;
    }
    // #endregion

}
