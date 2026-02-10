package devoir.domain.repository;

import java.util.List;
import java.util.Optional;

import devoir.domain.model.User;

/**
 *  Interface définissant les opérations d'accès aux données pour les utilisateurs.
 * <p>
 * Cette interface abstrait la couche de persistance et permet
 * de récupérer, sauvegarder et supprimer des
 * utilisateurs sans exposer les détails de stockage.
 * </p>
*/

public interface UserRepository {

    /**
     * Enregistre un nouvel utilisateur ou met à jour un utilisateur existant.
     *
     * @param user l'utilisateur à sauvegarder
    */
    public void save(User user);

    /**
     * Récupère un utilisateur à partir de son identifiant.
     *
     * @param id identifiant unique de l'utilisateur
     * @return un {@link Optional} contenant l'utilisateur s'il existe,
     *         ou vide s'il n'existe pas
    */
    public Optional<User> findById(Long id);

    /**
     * Récupère tous les utilisateurs.
     *
     * @return List<User> pour contiendra une liste d'utilisateurs.
    */
    public List<User> findAll();

    /**
     * Supprime un utilisateur à partir de son identifiant.
     *
     * @param id identifiant unique de l'utilisateur à supprimer
    */
    public void delete(Long id);

} 
