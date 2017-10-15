package main;

import modelo.user.User;
import modelo.user.UserRepository;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server {
	public static void main(String[] args) {
		UserRepository.getInstance().addElement(new User("asd", "asdasd"));
		Spark.port(9000);
		DebugScreen.enableDebugScreen();
		Router.configure();
	}

}
