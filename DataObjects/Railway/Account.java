package Railway;

import Common.Random;
import Constants.AppConstant;
import Constants.ValidAccount;

public class Account {
    // #region Properties
    private String email;
    private String password;
    private String pid;
    // #endregion

    // #region Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
    // #endregion

    // #region Methods
    Account(String email, String password, String pid) {
        this.email = email;
        this.password = password;
        this.pid = pid;
    }

    Account(String email, String password) {
        this.email = email;
        this.password = password;
        this.pid = AppConstant.COMMON_PID;
    }

    Account(String email) {
        this.email = email;
        this.password = ValidAccount.PASSWORD;
        this.pid = AppConstant.COMMON_PID;
    }

    public static Account getRandom() {
        String randomMail = Random.generateEmail(AppConstant.MAIL_HOST);
        return new Account(randomMail);
    }

    public static Account getValid() {
        return new Account(ValidAccount.EMAIL, ValidAccount.PASSWORD);
    }
    // #endregion
}
