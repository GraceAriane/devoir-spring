package devoir;

import devoir.application.usecase.UserServiceImpl;
import devoir.persistence.repository.RepositoryImpl;
import devoir.presentation.controller.UserController;
import devoir.presentation.view.CommandLineView;

public class Main {
    public static void main(String[] args) {

        UserController uc = new UserController(new UserServiceImpl(new RepositoryImpl()), new CommandLineView());
        uc.run();

    }
}
