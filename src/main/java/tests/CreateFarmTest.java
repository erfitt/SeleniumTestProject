package tests;

import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

@Listeners({ScreenShooter.class})
public class CreateFarmTest extends BaseTest {

    private final String farmName = "MyNewFarm3";
    private final String country = "Israel";
    private final String state = "Haifa";
    private final String timezone = "(UTC+02:00) Beirut";
    private final boolean isSunday = true;


    @Test
    public void firstUserTest() {
        farmTest("KlOfE", "Aa123456");
    }

    @Test
    public void secondUserTest() {
        farmTest("asdasdCompanyUser123", "asdasdCompanyUser123");
    }

    private void farmTest(String username, String password) {
        new LoginPage().logIn(username, password)
                .createFarm()
                .selectLocationOnTheMap(120, 200)
                .clickNext()
                .createFarm(farmName, country, state, timezone, isSunday)
                .verifySuccessMessage()
                .goToFarmInfoPage()
                .verifyFarmInfo(farmName, country, state, timezone, isSunday)
                .logOut();
    }


}
