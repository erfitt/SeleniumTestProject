package pageObjects;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FarmPage extends BasePage{

    public FarmInfoPage goToFarmInfoPage(){
        $(byXpath("//a[contains(.,'Farm')]")).click();
        return new FarmInfoPage();
    }

}
