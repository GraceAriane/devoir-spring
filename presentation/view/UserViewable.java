package devoir.presentation.view;


import devoir.presentation.controller.UserController;

public interface UserViewable {
    
    public void showMenuAndGetChoice();
    public void promptForAddUsers();
    public void promptDeleteUser();
    public void showAllUsers();
    
    public void something();
    public void setController(UserController uc);
    
}
