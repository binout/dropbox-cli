package io.github.binout.dropbox.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict=true, plugin = {"json:target/cucumber.json"} )
public class DropboxCliTest {
}
