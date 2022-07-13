package pageObjects;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage{

    public FarmPage logIn(String username, String password){
        open("https://nbvxuserportalrc.z6.web.core.windows.net/");
        $(byXpath("//input[@placeholder='Username']")).setValue(username);
        $(byXpath("//input[@placeholder='Password']")).setValue(password);
        $(byXpath("//button[@type='submit']")).click();
        return new FarmPage();
    }

}
