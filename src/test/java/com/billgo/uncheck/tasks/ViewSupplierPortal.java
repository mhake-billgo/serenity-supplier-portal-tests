package com.billgo.uncheck.tasks;

import com.billgo.uncheck.ui.SupplierPortalLandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class ViewSupplierPortal implements Task {
  SupplierPortalLandingPage supplierPortalLandingPage;

  @Step("Open supplier portal")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.browserOn().the(supplierPortalLandingPage));
  }
}
