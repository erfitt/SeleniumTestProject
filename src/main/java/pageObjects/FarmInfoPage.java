package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FarmInfoPage extends BasePage{

    private final String farmName = "//*[@placeholder='Farm name']";
    private final String country = "//*[@formcontrolname='country']//input";
    private final String state = "//*[@formcontrolname='state']//input";
    private final String timezone = "//*[@formcontrolname='timeZone']//input";



    public CreateFarmSuccessPage createFarm(String farmName, String country, String state, String timezone,
                                              boolean isSunday){
        $(byXpath(this.farmName)).setValue(farmName);
        $(byXpath(this.country)).setValue(country).pressEnter();
        $(byXpath(this.state)).setValue(state).pressEnter();
        $(byXpath(this.timezone)).setValue(timezone).pressEnter();
        ElementsCollection radioButtons = $$(byXpath("//*[@formcontrolname='weekStart']//label"));
        if(isSunday)
            radioButtons.get(0).click();
        else
            radioButtons.get(1).click();

        $(byXpath("//*[@class='button flat-button ng-star-inserted']")).click();
        return new CreateFarmSuccessPage();
    }

    public FarmInfoPage verifyFarmInfo(String farmName, String country, String state, String timezone,
                                       boolean isSunday){
        $(byXpath(this.farmName)).shouldHave(Condition.value(farmName));
        $(byXpath(this.country)).click();
        Assert.assertEquals(getSelectedValue(),country);
        $(byXpath(this.state)).click();
        Assert.assertEquals(getSelectedValue(),state);
        $(byXpath(this.timezone)).click();
        Assert.assertEquals(getSelectedValue(),timezone);

        ElementsCollection radioButtons = $$(byXpath("//*[@formcontrolname='weekStart']//mat-radio-button"));
        if(isSunday)
            radioButtons.get(0).shouldHave(Condition.cssClass("mat-radio-checked"));
        else
            radioButtons.get(1).shouldHave(Condition.cssClass("mat-radio-checked"));
        return this;
    }

    public String getSelectedValue(){
        return $(byXpath("//*[@class='ng-option ng-option-selected ng-option-marked ng-star-inserted']/span")).getText();
    }

}
