package Guerrillamai;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

import Common.Utilities;
import Constants.AppConstant;
import Constants.Timeout;

public class MailPage {
    // #region Locators
    private final By _setMailBtn = By.cssSelector("#inbox-id");
    private final By _setMailInput = By.cssSelector(".editable input");
    private final By _setMailAcceptBtn = By.cssSelector(".editable button.save");

    private final By _hostSelect = By.cssSelector("#gm-host-select");
    private final String _mailSubject = "//*[@id='email_list']//td[contains(text(),'%s')]";
    private final By _linkInMail = By.xpath("//div[@class='email_body']//a");
    // #endregion

    // #region Methods
    public static MailPage open() {
        Utilities.open(AppConstant.GURREILLAMAIL_URL);
        return new MailPage();
    }

    public void login(String email) {
        Utilities.click(_setMailBtn);
        Utilities.enter(_setMailInput, email);
        Utilities.click(_setMailAcceptBtn);
        Utilities.selectByVisibleText(_hostSelect, AppConstant.MAIL_HOST);
    }

    public void selectMailInbox(String subject) {
        @SuppressWarnings("null")
        By mailSubjectLocator = By.xpath(String.format(_mailSubject, subject));
        long endTime = System.currentTimeMillis() + (Timeout.MAX_WAIT * 1000);

        while (System.currentTimeMillis() < endTime) {
            try {
                Utilities.waitForVisible(mailSubjectLocator);
                Utilities.click(mailSubjectLocator);
                return;
            } catch (Exception e) {
                Utilities.reload();
            }
        }

        throw new NotFoundException("Mail not found");
    }

    public void clickLinkInMail() {
        Utilities.click(_linkInMail);
    }
    // #endregion
}