package common.step_definitions;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Date;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static common.browserConfiguration.init;
import static java.lang.System.err;
import static java.lang.System.out;



public class common {
    public common() {
    }

    @Given("^open the old DevOps app sign in page$")
    public void openOldSignInPage(String browerData) {
        init(browerData);
        //open("http://localhost:8080/login");
        //Selenide.$(By.xpath("//button")).click();
        //open("http://52.15.62.127:9090/login;JSESSIONID=6ecdab49-7e8b-4519-9783-d0d1c8b1a9c3");
    }

    @Given("^open the new DevOps app sign in page and try to sign in with the (.*) URL$")
    public void openNewSignInPage(String browerData ) {
        init(browerData);
        wait_until_page_load(5000);
        $(By.cssSelector("[class= 'ivu-btn ivu-btn-primary ivu-btn-long ivu-btn-large']")).click();
        long end_time = new Date().getTime()+ 20000;
        while(!VerifySignStatus() ) {
            if (!$(By.cssSelector("[class='ivu-btn ivu-btn-primary ivu-btn-long ivu-btn-large ivu-btn-loading']")).exists() && !$(By.cssSelector("[class='ivu-icon ivu-icon-logo-buffer']")).exists())
                $(By.cssSelector("[class= 'ivu-btn ivu-btn-primary ivu-btn-long ivu-btn-large']")).click();
            sleep(1);
            if (new Date().getTime()>end_time){
                err.println("超时仍未登录系统");
                break;
            }
        }
    }

    @Given("^the user status is signed in devops system$")
    public void signedInDevops(String browerData){
        init(browerData);
        wait_until_page_load(3000);
        String js = "function setCookie(name,value) \n" +
                "{ \n" +
                "    var Days = 30; \n" +
                "    var exp = new Date(); \n" +
                "    exp.setTime(exp.getTime() + Days*24*60*60*1000); \n" +
                "    document.cookie = name + \"=\"+ escape (value) + \";expires=\" + exp.toGMTString(); \n" +
                "} \n" +
                "setCookie('token', 'XXXXXXXdsfsdf')";
        executeJavaScript(js,browser);
        refresh();
    }

    static public boolean  VerifySignStatus(){
        //检测是否登录成功
        //refresh();
        if ($(By.cssSelector("[class='ivu-btn ivu-btn-primary ivu-btn-long ivu-btn-large ivu-btn-loading']")).exists() && !$(By.cssSelector("[class='ivu-icon ivu-icon-logo-buffer']")).exists())
        {
            out.println("没有登录devops系统");
            return false;
        }
        else{
            out.println("成功登录devops系统");
            return true;
        }
    }

     static public void wait_until_page_load(long time) {
        boolean complete = executeJavaScript("return document.readyState").equals("complete");
        long end_time = new Date().getTime()+ time;
        do {
            sleep(1);
            if (new Date().getTime()> end_time) {
                complete = executeJavaScript("return document.readyState").equals("complete");
                break;
            }
        } while (!complete);
        if (!complete )
            out.println("The page didn't finish loading after #{time} seconds");
        else
            out.println("The page finished loading");
    }

    static public void checkTabName(String tabName){
        Assert.assertEquals($(By.cssSelector("[class='ivu-tag-text']")).getText(), tabName);
    }

    static public boolean verifyHomePage(){
        if ($(By.cssSelector("[class='ivu-icon ivu-icon-logo-buffer']")).exists() ) {
            out.println("The current page is home page");
            return true;
        }
        else {
            out.println("The current page is not home page");
            return false;
        }
    }

    static public boolean verifyBuildManagementPage(){
        if ($(By.cssSelector("[class='flow--side__title']")).exists() && $(By.cssSelector("[class='flow--side__title']")).getText().equals("History")) {
            out.println("The current page is build management page");
            return true;
        }
        else {
            out.println("The current page is not build management page");
            return false;
        }
    }

    static public boolean verifyProjectManagementPage(){
        if ($(By.cssSelector("[class='ivu-btn ivu-btn-primary']")).exists() && $(By.cssSelector("[class='ivu-icon ivu-icon-md-add']")).exists()) {
            out.println("The current page is project management page");
            return  true;
        }
        else {
            out.println("The current page is not project management page");
            return false;
        }
    }

    static public boolean verifyAddProjectPage(){
        if ($(By.cssSelector("[class='ivu-form-item-label']")).exists() && $(By.cssSelector("[class='ivu-form-item-label']")).getText().equals("Project Name:")) {
            out.println("The current page is add project page");
            return  true;
        }
        else {
            out.println("The current page is not add project page");
            return false;
        }
    }

    static public void waitUntil( String page,long time){
        boolean complete=checkPage(page);
        long end_time = new Date().getTime()+ time;
        do {
            sleep(1);
            if (new Date().getTime()> end_time) {
                complete=checkPage(page);
                break;
            }
        } while (!complete);
    }

    static public boolean checkPage(String page){
        boolean complete=false;
        switch (page) {
            case "Home Page":
                complete = verifyHomePage();
                break;
            case "Add Project Page":
                complete =verifyAddProjectPage();
                break;
            case "Build Management Page":
                complete =verifyBuildManagementPage();
                break;
            case "Project Management Page":
                complete =verifyProjectManagementPage();
                break;
            default:
                out.println("Not get the page");
                break;
        }
        return complete;
    }
}
