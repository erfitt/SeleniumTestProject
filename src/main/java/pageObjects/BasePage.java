package pageObjects;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class BasePage {


    protected BasePage() {
    }

    public CreateFarmFirstStepPage createFarm(){
        $(byXpath("//*[@class='usr-text']")).click();
        $$(byXpath("//*[@id='mat-menu-panel-0']//button")).get(0).click();
        return new CreateFarmFirstStepPage();
    }

    public CreateFarmFirstStepPage logOut(){
        $(byXpath("//*[@class='usr-text']")).click();
        $$(byXpath("//*[@id='mat-menu-panel-0']//button")).get(2).click();
        return new CreateFarmFirstStepPage();
    }

}
