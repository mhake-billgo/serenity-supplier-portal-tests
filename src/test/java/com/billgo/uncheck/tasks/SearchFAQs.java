package com.billgo.uncheck.tasks;
import com.billgo.uncheck.ui.FAQsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import static org.openqa.selenium.Keys.ENTER;

public class SearchFAQs implements Task {

  private final String searchTerm;

  protected SearchFAQs(String searchTerm) {
    this.searchTerm = searchTerm;
  }

  @Step("Search for #searchTerm")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            Enter.theValue(searchTerm)
                    .into(FAQsPage.SEARCH_FIELD)
                    .thenHit(ENTER)
    );
  }

  public static SearchFAQs forCharacters(String searchTerm) {
    return Instrumented.instanceOf(SearchFAQs.class).withProperties(searchTerm);
  }

}

