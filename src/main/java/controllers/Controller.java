package controllers;

import spark.utils.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import modelo.user.User;
import modelo.user.UserRepository;
import spark.Request;

public abstract class Controller implements WithGlobalEntityManager, TransactionalOps {
  public User currentUser(Request req) {
    return UserRepository.getInstance().getById(Long.valueOf(req.cookie("UserId")));
  }

  public Long id(Request req) {
    return Long.valueOf(req.params("id"));
  }
}
