package devoir;

import devoir.application.usecase.UserServiceImpl;
import devoir.persistence.repository.RepositoryImpl;
import devoir.persistence.repository.UserRepositoryMySQLImpl;
import devoir.presentation.controller.UserController;
import devoir.presentation.view.CommandLineView;

public class Main {
    public static void main(String[] args) {

        // UserController uc = new UserController(new UserServiceImpl(new RepositoryImpl()), new CommandLineView());
        UserController uc = new UserController(new UserServiceImpl(new UserRepositoryMySQLImpl()), new CommandLineView());
        uc.run();

    }
}
