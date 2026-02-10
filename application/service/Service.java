package devoir.application.service;

import java.util.List;

import devoir.domain.model.User;

/**
 * Service métier responsable de la gestion des utilisateurs.
 * <p>
 * Cette interface définit les opérations principales liées aux utilisateurs,
 * comme l'ajout, la récupération, et la suppression.
 * </p>
 */

public interface Service {
    
    /**
     * Ajoute un nouvel utilisateur
     *
     * @param user l'utilisateur à ajouter
    */
    public void addUser(User user);

    /**
     * Recupérer un utilisateur existant
     *
     * @param id l'utilisateur à récupérer
     * @return User
    */
    public User getUser(Long id);

    /**
     * Recupérer tous les utilisateurs
     *
     * @return List<User>
    */
    public List<User> getAllUsers();

    /**
     * Supprimer un utilisateur grâce à son identifiant
     *
     * @param id
    */
    public void deleteUser(Long id);

}
