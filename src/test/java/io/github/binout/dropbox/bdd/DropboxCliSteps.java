package io.github.binout.dropbox.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.binout.dropbox.Dropbox;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DropboxCliSteps {

    private String result;

    private static String executeCommand(String command) throws Exception {
        try {
            ByteArrayOutputStream content = new ByteArrayOutputStream();
            System.setOut(new PrintStream(content));
            org.tomitribe.crest.Main.main(command);
            return content.toString();
        } finally {
            System.setOut(null);
        }
    }

    @Given("^a dropbox api key$")
    public void a_dropbox_api_key() throws Throwable {
        assertThat(Dropbox.apiKey()).isNotNull();
    }

    @When("i type \"([^\"]*)\"")
    public void i_type_a_command(String command) throws Throwable {
        this.result = executeCommand(command);
    }

    @Then("^it should return my name$")
    public void it_should_return_my_name() throws Throwable {
        assertThat(result).contains("Benoît Prioux");
    }

    @Then("^it should return a list of path$")
    public void it_should_return_a_list_of_path() throws Throwable {
        Arrays.stream(result.split(System.lineSeparator())).forEach(p -> assertThat(p).startsWith("/"));
    }
}
