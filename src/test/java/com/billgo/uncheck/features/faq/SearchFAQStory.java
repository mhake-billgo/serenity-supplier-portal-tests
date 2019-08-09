package com.billgo.uncheck.features.faq;

import com.billgo.uncheck.tasks.ClickFAQButton;
import com.billgo.uncheck.tasks.ViewSupplierPortal;
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

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class SearchFAQStory {

  Actor potentialSupplier = Actor.named("Interested Supplier");

  @Managed(uniqueSession = true)
  public WebDriver browser;

  @Steps
  ViewSupplierPortal viewSupplierPortal;

  @Before
  public void canBrowseTheWeb() {
    potentialSupplier.can(BrowseTheWeb.with(browser));
  }

  @Test
  public void view_faqs() {
    givenThat(potentialSupplier).wasAbleTo(viewSupplierPortal);

    when(potentialSupplier).attemptsTo(Scroll.to(LandingPage.FAQ_BUTTON));
    and(potentialSupplier).attemptsTo(ClickFAQButton.click());
    and(potentialSupplier).should(eventually(seeThat(TheWebPage.title(), containsString("BillGO"))));

  }

}
