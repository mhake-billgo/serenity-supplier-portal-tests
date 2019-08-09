package com.billgo.uncheck.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FAQsPage {
  public static Target SEARCH_FIELD = Target.the("FAQs Search Field").located(By.name("faqSearchField"));
}
