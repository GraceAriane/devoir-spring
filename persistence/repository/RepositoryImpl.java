package devoir.persistence.repository;

import java.util.List;
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

    /** 
     * @param user
     */
    public void save(User user){

    }

    /** 
     * @param id
     * @return Optional<User>
     */
    public Optional<User> findById(Long id){

    }

    /** 
     * @return List<User>
     */
    public List<User> findAll(){

    }

    /** 
     * @param id
     */
    public void delete(Long id){
        
    }
}
