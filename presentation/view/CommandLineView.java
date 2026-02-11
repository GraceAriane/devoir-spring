package devoir.presentation.view;

import java.util.List;
import java.util.Scanner;

import devoir.domain.model.User;
import devoir.presentation.model.UserChoice;

public class CommandLineView implements UserViewable{

    Scanner keyboard = new Scanner(System.in);
    String choice;

    /** 
     * @return UserChoice qui va retenir le choix fait l'utilisateur
     */
    public UserChoice showMenuAndGetChoice(){
        System.out.println("Bienvenue dans le systeme des gestions d'utilisateurs: \n 1.Ajouter un utilisateur \n 2.Voir les utilisateurs \n 3.Supprimer un utilisateur \n Appuyez sur q pour quitter");
        System.err.print("Votre choix : ");

        this.choice = keyboard.nextLine();

        return switch(this.choice){

            case "1" -> UserChoice.CREATE_USER;
            case "2" -> UserChoice.LIST_USERS;
            case "3" -> UserChoice.DELETE_USER;
            case "q" -> UserChoice.EXIT;
            default -> throw new IllegalArgumentException("Choix invalide");

        };
        
    }

    /** 
     * @return User
     */
    public User promptForAddUsers(){

        System.out.println("Entrez le nom et l'email de l'utilisateur :");
        String name = keyboard.nextLine();
        String email = keyboard.nextLine();

        return new User(name, email);

    }

    /** 
     * @param users récupère les utilisateurs pour ensuite les afficher
     */
    public void showAllUsers(List<User> users){

        System.out.println("les utilisateurs enregistrés:");
        if(users.isEmpty()){
            System.out.println("Aucun utilisateur trouvé.");
        }else{
            for(User u: users){
                System.out.println(u.toString());
            }
        }


    }

    /** 
     * @return id de type long 
     */
    public Long promptDeleteUser(){

        System.out.println("Entrez l'ID de l'utilisateur à supprimer: ");
        Long id = keyboard.nextLong();
        keyboard.nextLine();
        return id;
    }

}
