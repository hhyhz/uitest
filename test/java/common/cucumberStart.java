package common;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {"@acceptance,@live"},features = "test/java/modules/", plugin = { "pretty", "html:target/cucumber-html-report",
        "json:target/operation.json" },glue={"modules","common.step_definitions"})

public class cucumberStart {
}
