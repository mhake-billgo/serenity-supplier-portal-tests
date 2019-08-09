package com.billgo.uncheck.features.faq;

import com.billgo.uncheck.questions.FAQResults;
import com.billgo.uncheck.tasks.ClickFAQButton;
import com.billgo.uncheck.tasks.ViewSupplierPortal;
import com.billgo.uncheck.ui.FAQsPage;
import com.billgo.uncheck.ui.LandingPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class ViewFAQStory {

  Actor potentialSupplier = Actor.named("Interested Supplier");

  @Managed(uniqueSession = true)
  public WebDriver browser;

  @Steps
  ViewSupplierPortal viewSupplierPortal;

  @Steps
  ClickFAQButton clickFAQButton;


  @Before
  public void canBrowseTheWeb() {
    givenThat(potentialSupplier).can(BrowseTheWeb.with(browser));
  }

  @Test
  public void view_faqs() {
    givenThat(potentialSupplier).wasAbleTo(viewSupplierPortal);
    andThat(potentialSupplier).wasAbleTo(Scroll.to(LandingPage.FAQ_BUTTON));
    when(potentialSupplier).attemptsTo(clickFAQButton);
    then(potentialSupplier).should(eventually(seeThat("FAQ Titles", FAQResults.titles(),
            containsInAnyOrder("How does UnCheck work?",
                    "How does my company benefit from using this service?",
                    "Are the payments guaranteed?",
                    "When is the money available in my bank account?",
                    "What information is needed in the enrollment process?",
                    "How do I enroll?",
                    "Is there a fee to enroll?",
                    "Is there a cost to receive payments?",
                    "Can I set a limit on the amount I want to receive electronically?",
                    "Can I opt-out?",
                    "Who is BillGO?",
                    "Do you share or sell my data?",
                    "Do I need to switch merchant services providers?",
                    "How is this different from a lockbox service?",
                    "If I give my email, will I receive unwanted notices?",
                    "Where did you get my information from?",
                    "Do you work directly with banks and credit unions?"))));

  }

}
