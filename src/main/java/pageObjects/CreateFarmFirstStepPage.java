package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CreateFarmFirstStepPage extends BasePage{

    public FarmInfoPage clickNext(){
        $(byXpath("//*[@class='button flat-button ng-star-inserted']")).click();
        return new FarmInfoPage();
    }

    public CreateFarmFirstStepPage selectLocationOnTheMap(int xOffset, int yOffset){
        SelenideElement canvas = $(byXpath("//canvas")).shouldBe(Condition.visible);
        $(byXpath("//*[@title='Zoom out']")).doubleClick().doubleClick();
        new Actions(BaseTest.getDriver()).moveToElement(canvas).moveByOffset(xOffset, yOffset).click().perform();
        return new CreateFarmFirstStepPage();
    }

}
