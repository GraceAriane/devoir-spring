package devoir.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import devoir.domain.model.User;
import devoir.domain.repository.UserRepository;

/**
 *  Classe qui implémente le UserRepository.
 * <p>
 * Cette classe va implémenter ses méthodes donc on va pouvoir 
 * récupérer, sauvegarder et supprimer des
 * utilisateurs sans exposer les détails de stockage.
 * </p>
 */

public class RepositoryImpl implements UserRepository {

    private Map<Long, User> users = new HashMap<>();

    /** 
     * @param user qui représente un utilisateur
     */
    public void save(User user){
        users.put(user.getId(), user);
    }

    /** 
     * @param id qui represente l'identifiant d'un utilisateur
     * @return Optional<User> qui veut dire ici que ça peut retourner un 
     * utilisateur ou bien null si ça ne trouve pas
     */
    public Optional<User> findById(Long id){
        return Optional.ofNullable(users.get(id));
        // Optional.ofNullable transforme null en Optional.empty() nous qui oblige à gérer le cas "pas de valeur"
        // get(key) retourne la valeur associé ou vide si pas trouvée

    }

    /** 
     * @return List<User> l'ensemble de tous les utilisateurs sous formes de liste
     */
    public List<User> findAll(){
        ArrayList<User> allUsers = new ArrayList<User>();
        for(User u: users.values()){
            allUsers.add(u);
        }
        return allUsers;
     
    }

    /** 
     * @param id qui est l'id à supprimer 
     */
    public void delete(Long id){

        users.remove(id);

    }

}
