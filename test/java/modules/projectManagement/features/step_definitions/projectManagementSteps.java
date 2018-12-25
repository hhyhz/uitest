package modules.projectManagement.features.step_definitions;

import com.codeborne.selenide.Selenide;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static common.step_definitions.common.*;
import static java.lang.StrictMath.random;
import static modules.buildManagement.features.support.common.closeMessageNotification;

public class projectManagementSteps {

    public void setup(){
    }

    @When("^the user click the add project button and input (.*) project and repository address: (.*) to add a project$")
    public void addProject(String projectName,String repositoryAdd){
        boolean exitStatus = true;

        //sleep(5000);
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
                $(By.cssSelector("[class='ivu-icon ivu-icon-md-add']")).click(); //点击add按钮
                waitUntil("Add Project Page",5000);
                wait_until_page_load(5000);
                $$(By.cssSelector("[class='ivu-input ivu-input-default']")).get(0).setValue(projectName); //输入项目名称
                $$(By.cssSelector("[class= 'ivu-input ivu-input-default']")).get(1).setValue(repositoryAdd); //输入地址
                //closeMessageNotification();
                //$(By.xpath("//button")).click(); //点击创建项目按钮
                $(By.cssSelector( "[class='ivu-btn ivu-btn-primary']")).click();
                sleep(10000);
                exitStatus=false;
            }
        }
    }
    @Then("^a (.*) project will show on the project management page$")
    public void checkProjectStatus(String projectName) {
        boolean exitStatus = true;
        $(By.cssSelector("[class='ivu-icon ivu-icon-ios-cube']")).click();

        wait_until_page_load(5000);
        do{
            if (!VerifySignStatus()) {
                //refresh();
                $(By.cssSelector("[class= 'ivu-btn ivu-btn-primary ivu-btn-long ivu-btn-large']")).click();
            }
            else {
                Assert.assertEquals(projectName,$$(By.cssSelector("[class='ivu-table-row']")).get(0).$$(By.cssSelector("[class='ivu-table-cell']")).get(2).getText());
                Assert.assertEquals("Initial",$$(By.cssSelector("[class='ivu-table-row']")).get(0).$$(By.cssSelector("[class='ivu-table-cell']")).get(5).getText());
                exitStatus=false;
            }
        }while( exitStatus );

    }
}
