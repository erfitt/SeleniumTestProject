package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateFarmSuccessPage extends BasePage{

    public FarmPage verifySuccessMessage(){
        $(byClassName("title")).shouldHave(Condition.text("Your farm has been successfully created!"));

        return new FarmPage();
    }

}
