package com.billgo.uncheck.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class VisitFAQButton {
  public static Target FAQ_BUTTON = Target.the("Visit FAQ Button").located(By.name("visitFAQ"));
}
