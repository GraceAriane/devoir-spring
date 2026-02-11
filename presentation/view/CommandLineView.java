package devoir.presentation.view;

import java.util.Scanner;


import devoir.presentation.controller.UserController;

public class CommandLineView implements UserViewable{

    UserController controller;
    Scanner keyboard = new Scanner(System.in);
    int choice;

    public void setController(UserController uc){
        this.controller = uc;
    }

    public void showMenu(){


    }
    public void showMenuAndGetChoice(){
        System.out.println("Bienvenue dans le systeme des gestions d'utilisateurs: \n 1.Ajouter un utilisateur \n 2.Voir les utilisateurs \n 3.Supprimer un utilisateur \n 4.Appuyez sur q pour quitter");
        System.err.print("Votre choix : ");

        this.choice = keyboard.nextInt();
        
    }
    public void something(){


    }

}
