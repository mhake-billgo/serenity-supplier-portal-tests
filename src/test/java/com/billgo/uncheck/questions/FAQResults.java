package com.billgo.uncheck.questions;

import com.billgo.uncheck.ui.FAQsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

@Subject("the displayed FAQs")
public class FAQResults implements Question<List<String>> {

  @Override
  public List<String> answeredBy(Actor actor) {
    return Text.of(FAQsPage.TITLES)
            .viewedBy(actor)
            .asList();
  }

  public static Question<List<String>> titles() { return new FAQResults(); }

}
