package controllers;

import modelo.user.User;
import modelo.user.UserRepository;
import spark.Request;

public interface Controller {
	default public User currentUser(Request req){
		System.out.println(req.cookie("UserId"));
		return UserRepository.getInstance().getById(Long.valueOf(req.cookie("UserId")));
	}
}
