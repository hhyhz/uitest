package modules.buildManagement.features.support;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class common {
    static public void closeMessageNotification(){
      if (Selenide.$(By.cssSelector("[class='ivu-tabs-nav-scroll']")).exists())
          Selenide.$(By.cssSelector("[class='ivu-icon ivu-icon-md-notifications-outline']")).click();
    }
}
