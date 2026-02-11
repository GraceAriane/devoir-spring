package devoir.application.usecase;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import devoir.application.service.Service;
import devoir.domain.model.User;
import devoir.domain.repository.UserRepository;

/**
 * Service qui implémente le Service métier responsable de la gestion des
 * utilisateurs.
 * <p>
 * Cette classe va définir les méthodes liées aux utilisateurs,
 * comme l'ajout, la récupération, et la suppression.
 * </p>
 */

public class UserServiceImpl implements Service {

    private final UserRepository userRepository;
    private Long nextId = (long) 1;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param user
     */
    public void addUser(User user) {
        user.setId(nextId++);
        userRepository.save(user);
    }

    // public void addUser(String name, String email) {
    //     User user = new User(nextId++, name, email);
    //     userRepository.save(user);
    // }

    /** 
     * @param id
     * @return User
     */
    public User getUser(Long id){
        
        return userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(""));
        // ceci siginifie que on trouve l'id par son identifiant sinon on revoie l'erreur grace la méthode utilisée

    }

    /**
     * @return List<User>
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * @param id
     */
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

}
