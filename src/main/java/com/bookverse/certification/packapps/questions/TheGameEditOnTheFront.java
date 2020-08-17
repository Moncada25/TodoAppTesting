package com.bookverse.certification.packapps.questions;

import static com.bookverse.certification.packapps.userinterfaces.FrontEditGame.DATE_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditGame.DESCRIPTION_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditGame.ID_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditGame.IMAGE_GAME;
import static com.bookverse.certification.packapps.userinterfaces.FrontEditGame.TITLE_GAME;

import com.bookverse.certification.packapps.models.Game;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

public class TheGameEditOnTheFront implements Question<Boolean> {

  public static TheGameEditOnTheFront correspondToTheOfTheService() {
    return new TheGameEditOnTheFront();
  }

  @Subject("Compare results of frontend with service for game to edit")
  @Override
  public Boolean answeredBy(Actor actor) {

    Type gameType = new TypeToken<Game>() {
    }.getType();
    Game gameFromService = SerenityRest.lastResponse().body().as(gameType);

    String id = Text.of(ID_GAME).viewedBy(actor).asString();
    String title = TITLE_GAME.resolveFor(actor).getAttribute("ng-reflect-model");
    String description = DESCRIPTION_GAME.resolveFor(actor).getAttribute("ng-reflect-model");
    String image = IMAGE_GAME.resolveFor(actor).getAttribute("src");
    String date = DATE_GAME.resolveFor(actor).getAttribute("value");

    Game gameFromFront = new Game();
    gameFromFront.setId(id.substring(0, id.indexOf(",")));
    gameFromFront.setTitle(title);
    gameFromFront.setDescription(description);
    gameFromFront.setImage(image);
    gameFromFront.setCreated_at(date);

    return gameFromFront.toString().equals(gameFromService.toString());
  }
}
