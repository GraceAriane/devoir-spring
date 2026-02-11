package devoir.presentation.controller;



import java.util.List;

import devoir.application.service.Service;
import devoir.domain.model.User;
import devoir.presentation.model.UserChoice;
import devoir.presentation.view.UserViewable;


public class UserController {
    Service service;
    UserViewable view;

    UserChoice userChoice;

    public UserController(Service service, UserViewable view){
        this.service = service;
        this.view = view;
    }

    public void run(){
        while(true){
            userChoice = view.showMenuAndGetChoice();

            switch (userChoice) {
                case CREATE_USER:
                    addUser();
                    break;
            
                case LIST_USERS:
                    listUsers();
                    break;
            
                case DELETE_USER:
                    deleteUser();
                    break;
            
                default:
                    break;
            }
        }


    }

    public void addUser(){
        
        User user = view.promptForAddUsers();
        service.addUser(user);
        
    }

    public void listUsers(){
        view.showAllUsers(service.getAllUsers());
    }

    public void deleteUser(){
        service.deleteUser(view.promptDeleteUser());
    }

    public void exit(){
        System.out.println("operations terminees.");
        System.exit(0);
    }

}
