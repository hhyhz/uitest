package modules.signIn.features.step_definitions;

import com.codeborne.selenide.Selenide;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

public class signInSteps {
    public signInSteps() {
    }
    @When("^the user access the DevOps app sign in page with below parameter:$")
    public void sign(DataTable userdata){
        Selenide.$(By.name("userName")).sendKeys(userdata.cells(1).get(0).get(1));
        Selenide.sleep(5000);
        Selenide.$(By.name("password")).sendKeys(userdata.cells(1).get(1).get(1));
        Selenide.sleep(5000);
        Selenide.$(By.name("captcha")).sendKeys(userdata.cells(1).get(2).get(1));
        Selenide.sleep(5000);
        Selenide.$(By.xpath("//button")).click();
        Selenide.sleep(5000);
    }

    @Then("^sign-in module should work as expected$")
    public void checkSignModule(){
        common.step_definitions.common.VerifySignStatus();
    }

    @Then("^sign into DevOps system and go to the first page$")
    public void checkSignStatus(){
        common.step_definitions.common.VerifySignStatus();
    }
}