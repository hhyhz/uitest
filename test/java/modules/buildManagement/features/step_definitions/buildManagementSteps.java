package modules.buildManagement.features.step_definitions;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static common.step_definitions.common.*;
import static modules.buildManagement.features.support.common.closeMessageNotification;


public class buildManagementSteps {

    public void setup(){
    }

    @Then("^a project will show on github specific space$")
    public void verifyGithubPath(){
//       if success
//         check git
//       else
//          get error message showing
    }

    @Then("^show project pipeline on build management page$")
    public void checkProjectBuildPipeline(){
        boolean exitStatus = true;
        while( exitStatus ){
            if (!VerifySignStatus()) {
                //refresh();
                $(By.cssSelector("[class= 'ivu-btn ivu-btn-primary ivu-btn-long ivu-btn-large']")).click();
            }
            else {
                waitUntil("Home Page",5000);
                wait_until_page_load(5000);
                $(By.cssSelector("[class='ivu-icon ivu-icon-logo-buffer']")).click();  //点击CICD管理
                $(By.cssSelector("[class='ivu-icon ivu-icon-ios-cube']")).click(); //点击项目管理
                $(By.cssSelector("[class='ivu-icon ivu-icon-md-analytics']")).click();//点击构建管理
                waitUntil("Build Management Page",5000);
                wait_until_page_load(5000);
                Assert.assertEquals($(By.cssSelector("[class='flow--side__item item-active']")).$(By.cssSelector("[class='flow--side__item--title']")).getText(),$(By.cssSelector("[class='pipeline--container__title']")).getText());
                exitStatus=false;
            }
        }
    }
}
