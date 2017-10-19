package controllers;

import modelo.user.User;
import modelo.user.UserRepository;
import spark.Request;

public interface Controller {
	default public User currentUser(Request req){
		return UserRepository.getInstance().getById(Long.valueOf(req.cookie("UserId")));
	}
	
	default public Long id(Request req){
		return Long.valueOf(req.params("id"));
	}
}
