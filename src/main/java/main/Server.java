package main;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.transaction.TransactionalOps;

import modelo.user.SysAdmin;
import modelo.user.User;
import modelo.user.UserRepository;
import spark.Spark;
import spark.debug.DebugScreen;

public class Server implements TransactionalOps, WithGlobalEntityManager{
	public static void main(String[] args) {
		Spark.port(getHerokuAssignedPort());
		DebugScreen.enableDebugScreen();
		Router.configure();
	}

	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 9000;
    }
}
