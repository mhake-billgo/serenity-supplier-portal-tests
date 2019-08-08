package com.billgo.uncheck.tasks;

import com.billgo.uncheck.ui.VisitFAQButton;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickFAQButton implements Task {

  @Step("CLick FAQ Button")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(VisitFAQButton.FAQ_BUTTON));
  }

  public static ClickFAQButton click() {
    return instrumented(ClickFAQButton.class);
  }
}
