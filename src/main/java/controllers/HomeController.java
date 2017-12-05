package controllers;

import modelo.user.User;
import modelo.user.UserRepository;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController extends Controller {
  public ModelAndView home(Request req, Response res) {
    try {
      User user = withTransaction(() -> UserRepository.getInstance().getById(Long.valueOf(req.cookie("UserId"))));
      return new ModelAndView(user, user.homeView());
    } catch (NumberFormatException e) {
      return new ModelAndView(null, "login/login.hbs");
    }
  }

}
