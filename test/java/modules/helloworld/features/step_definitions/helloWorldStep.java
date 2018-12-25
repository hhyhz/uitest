package modules.helloworld.features.step_definitions;


import com.codeborne.selenide.Selenide;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import static common.browserConfiguration.init;
import static common.step_definitions.common.wait_until_page_load;


public class helloWorldStep {

    @Given("^the user go to the hello world page with the (.*) URL$")
    public void visitDemoPage(String browserData){
        init(browserData);
    }

    @Then("^show hello world page to the user$")
    public void verifyHelloworldPage(){
        wait_until_page_load(5000);
        Assert.assertEquals("Wellcome",Selenide.title());
     }
}
