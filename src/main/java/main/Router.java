package main;

import controllers.HomeController;
import controllers.LoginController;
import controllers.MainController;
import controllers.EnterpriseController;
import controllers.IndicatorController;
import controllers.MethodController;
import static spark.Spark.*;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;

import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router implements WithGlobalEntityManager {

  public static void configure() {
    HandlebarsTemplateEngine engine = HandlebarsTemplateEngineBuilder.create().withDefaultHelpers()
        .withHelper("isTrue", BooleanHelper.isTrue).build();

    staticFiles.location("/public");

    LoginController loginController = new LoginController();
    EnterpriseController enterpriseController = new EnterpriseController();
    MethodController methodController = new MethodController();
    IndicatorController indicatorController = new IndicatorController();
    HomeController homeController = new HomeController();

    get("/", MainController::main, engine);
    get("/home", homeController::home, engine);

    get("/login", loginController::render, engine);
    get("/logout", loginController::logout, engine);
    post("/login", loginController::login);

    path("/enterprises", () -> {
      get("", enterpriseController::list, engine);
      get("/:id", enterpriseController::show, engine);
      delete("/:id", enterpriseController::delete);
    });

    post("/batch", enterpriseController::batchLoad);

    path("/indicators", () -> {
      get("", indicatorController::list, engine);
      post("", indicatorController::create);
      get("/evaluate", indicatorController::evaluate, engine);
      get("/new", indicatorController::renderNewForm, engine);
      get("/:id", indicatorController::show, engine);
      put("/:id", indicatorController::edit);
      delete("/:id", indicatorController::delete);
      get("/:id/edit", indicatorController::renderEditForm, engine);
    });

    path("/methods", () -> {
      get("", methodController::list, engine);
      post("", methodController::create);
      get("/new", methodController::renderNewForm, engine);
      get("/:id", methodController::show, engine);
      delete("/:id", methodController::delete);
      get("/:id/eval", methodController::eval, engine);
    });

    after((request, response) -> new Router().entityManager().close());
  }
}