package devoir.presentation.view;


import java.util.List;

import devoir.domain.model.User;
import devoir.presentation.controller.UserController;
import devoir.presentation.model.UserChoice;

public interface UserViewable {
    
    public UserChoice showMenuAndGetChoice();
    public void showAllUsers(List<User> users);
    
    public User promptForAddUsers();
    public Long promptDeleteUser();
    
}
