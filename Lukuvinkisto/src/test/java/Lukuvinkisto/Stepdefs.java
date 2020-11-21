package Lukuvinkisto;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class Stepdefs {
    Book book;
    
    @Given("Book is initialized")
    public void bookIsInitialized() {
        book = new Book("Testi", "Testinen",77);
    }

    @Then("the author should be {string}")
    public void theAuthorShouldBe(String val) {
        assertEquals(val, book.getAuthor());
    }
    
    @Then("the title should be {string}")
    public void theTitleShouldBe(String val) {
        assertEquals(val, book.getTitle());
    }

    @Then("the pagecount should be {int}")
    public void thePagecountShouldBe(int val) {
        assertEquals(val, book.getPages());
    }

}