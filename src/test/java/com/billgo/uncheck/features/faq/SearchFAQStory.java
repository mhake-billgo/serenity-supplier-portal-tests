package com.billgo.uncheck.features.faq;

import com.billgo.uncheck.questions.FAQResults;
import com.billgo.uncheck.tasks.ClickFAQButton;
import com.billgo.uncheck.tasks.SearchFAQs;
import com.billgo.uncheck.tasks.ViewSupplierPortal;
import com.billgo.uncheck.ui.LandingPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SerenityRunner.class)
public class SearchFAQStory {

  Actor potentialSupplier = Actor.named("Interested Supplier");

  @Managed(uniqueSession = true)
  public WebDriver browser;

  @Steps
  ViewSupplierPortal viewSupplierPortal;

  @Steps
  ClickFAQButton clickFAQButton;

  @Before
  public void canBrowseTheWeb() {
    potentialSupplier.can(BrowseTheWeb.with(browser));
  }

  @Test
  public void searchFAQ() {
    givenThat(potentialSupplier).wasAbleTo(viewSupplierPortal);
    when(potentialSupplier).attemptsTo(Scroll.to(LandingPage.FAQ_BUTTON));
    and(potentialSupplier).attemptsTo(clickFAQButton);
    when(potentialSupplier).attemptsTo(SearchFAQs.forCharacters("opt-out"));
    then(potentialSupplier).should(eventually(seeThat("FAQ Titles", FAQResults.titles(),
            containsInAnyOrder("Can I opt-out?"))));
  }

}
