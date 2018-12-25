package common;

import com.codeborne.selenide.Configuration;
import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import com.codeborne.selenide.Selenide;

public class browserConfiguration extends Configuration {

     static private void setBrowser(){
         switch (System.getProperty("selenide.browser")){
             case "chrome":
                 chromeCapabilities();
                 break;
             case "firefox":
                 firefoxCapabilities();
                 break;
             case "ie":
                 ieCapabilities();
                 break;
             default:
                 chromeCapabilities();
                 break;
         }
    }


     static private void chromeCapabilities( ){
         headless = true;
         startMaximized=true;
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--headless");
         options.addArguments("--disable-gpu");
         options.addArguments("window-size=1024,768");
         options.addArguments("--no-sandbox");
         options.addArguments("--disable-dev-shm-usage");
         options.addArguments("--ignore-certificate-errors");
         options.addArguments("--disable-popup-blocking");
         options.addArguments("--disable-translate");
         options.addArguments("--disable-logging");
         options.addArguments("--test-type");
         options.addArguments("--touch-events");
         Map<String, Object> prefs = new HashMap<String, Object>();
         prefs.put("credentials_enable_service", false);
         prefs.put("profile.password_manager_enabled", false);
         options.setExperimentalOption("prefs", prefs);
         WebDriver webDriver = new ChromeDriver(options);
         setWebDriver(webDriver);
     }

     static private void firefoxCapabilities() {

     }

     static private void ieCapabilities(){

     }

   static private void setDriverPath(){
       switch (System.getProperty("selenide.browser")){
           case "chrome":
               System.setProperty("webdrivier.chrome.driver","/usr/bin/chromedriver");
               break;
           case "firefox":
               System.setProperty("webdriver.gecko.driver","");
               break;
           case "ie":
               System.setProperty("webdriver.gecko.driver","");
               break;
           default:
               System.setProperty("webdriver.gecko.driver","");
               break;
       }
    }


    static public void init(String browserData){
       setBrowser();
       setDriverPath();
       open(browserData);
    }
}
