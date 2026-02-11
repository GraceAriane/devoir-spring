package devoir.persistence.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import devoir.domain.model.User;
import devoir.domain.repository.UserRepository;
import devoir.persistence.datasource.Database;


/**
 *  Classe qui implémente le UserRepository.
 * <p>
 * Cette classe va implémenter ses méthodes donc on va pouvoir 
 * récupérer, sauvegarder et supprimer des
 * utilisateurs sans exposer les détails de stockage et envoyer dans la base de données MySQL
 * </p>
 */

public class UserRepositoryMySQLImpl implements UserRepository {


    /** 
     * @param user qui représente un utilisateur
     */
    public void save(User user){

        String sql = "INSERT INTO users(nom, email) VALUES (?, ?)";

        try(Connection conn = Database.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
            
        }catch(SQLException e){
            throw new RuntimeException("Erreur lors de l'enregistrement :", e);
        }
       
    }

    /** 
     * @param id qui represente l'identifiant d'un utilisateur
     * @return Optional<User> qui veut dire ici que ça peut retourner un 
     * utilisateur ou bien null si ça ne trouve pas
     */
    public Optional<User> findById(Long id){

        String sql = "SELECT nom, email FROM users WHERE id = ?";

        try(Connection conn = Database.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                User user = new User(nom, email);
                return Optional.of(user); //on retourne un optional
            }else{
                return Optional.empty(); //aucun utilisateur trouvé
            }

            
        }catch(SQLException e){
            throw new RuntimeException("Erreur lors la recherche :", e);
        }

    }

    /** 
     * @return List<User> l'ensemble de tous les utilisateurs sous formes de liste
     */
    public List<User> findAll(){

        String sql = "SELECT * FROM users";
        List<User> allUsers = new ArrayList<>();

        try(Connection conn = Database.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
                
            while(rs.next()){
                allUsers.add(new User(rs.getString("nom"), rs.getString("email")));
            }
            
        }catch(SQLException e){
            throw new RuntimeException("Erreur lors l'affichage :", e);
        }
        return allUsers;
    }

    /** 
     * @param id qui est l'id à supprimer 
     */
    public void delete(Long id){

        String sql = "DELETE FROM users WHERE id = ?";

        try(Connection conn = Database.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, id);
            stmt.executeUpdate();
            
        }catch(SQLException e){
            throw new RuntimeException("Erreur lors la suppression :", e);
        }

    
    }  
}
