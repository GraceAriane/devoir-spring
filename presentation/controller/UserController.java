package devoir.presentation.controller;



import java.util.List;

import devoir.application.service.Service;
import devoir.domain.model.User;
import devoir.presentation.model.UserChoice;
import devoir.presentation.view.UserViewable;


public class UserController {
    Service service;
    UserViewable view;


    UserChoice userChoice ;

    public UserController(Service service, UserViewable view){
        this.service = service;
        this.view = view;
        view.setController(this);
        userChoice = UserChoice.MENU;
    }

    public void run(){
        while(userChoice == UserChoice.MENU){
            view.showMenuAndGetChoice();
        }

        switch (userChoice) {
            case CREATE_USER:
                view.promptForAddUsers();
                break;
        
            case LIST_USERS:
                view.something();
                break;
        
            case DELETE_USER:
                view.something();
                break;
        
            default:
                break;
        }
    }

    public void addUser(String name, String email){
        
        service.addUser(new User(name, email));
        view.something();

    }

    public List<User> getUsers(){
        return service.getAllUsers();
    }

    public void deleteUser(Long id){
        service.deleteUser(id);
    }
}
