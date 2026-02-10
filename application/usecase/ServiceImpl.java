package devoir.application.usecase;

import java.util.List;

import devoir.application.service.Service;
import devoir.domain.model.User;

/**
 * Service qui implémente le Service métier responsable de la gestion des utilisateurs.
 * <p>
 * Cette classe va définir les méthodes liées aux utilisateurs,
 * comme l'ajout, la récupération, et la suppression.
 * </p>
*/

public class ServiceImpl implements Service{

    /** 
     * @param user
     */
    public void addUser(User user){

    }
    
    /** 
     * @param id
     * @return User
     */
    public User getUser(Long id){

    }
    
    /** 
     * @return List<User>
     */
    public List<User> getAllUsers(){

    }
    
    /** 
     * @param id
     */
    public void deleteUser(Long id){

    }
    
}
