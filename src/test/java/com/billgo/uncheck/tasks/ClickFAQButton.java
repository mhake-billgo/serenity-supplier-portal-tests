package com.billgo.uncheck.tasks;

import com.billgo.uncheck.ui.LandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ClickFAQButton implements Task {

  @Step("Click FAQ Button")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(LandingPage.FAQ_BUTTON));
  }
}
