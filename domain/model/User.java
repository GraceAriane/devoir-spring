package devoir.domain.model;

/**
 * Represente un utilisateur du système
 * <p>
 * cette classe contient les informations essentielles d'un utilisateur
 * utilisées dans les processus métier.
 * </p>
 */

public class User {

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /** 
     * @return String
     */
    // getter et setter de name
    public String getName(){
        return this.name;
    }

    /** 
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /** 
     * @return String
     */
    // getter et setter de email
    public String getEmail(){
        return this.email;
    }

    /** 
     * @param email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /** 
     * @return String
     */
    public Long getId(){
        return this.id;
    }

    /** 
     * @param id
     */
    public void setId(Long id){
        this.id = id;
    }

    /** 
     * @return String
     */
    @Override
    public String toString(){
        return this.id + " | " + this.name + " --- " + this.email;
    }



    private Long id;
    private String name;
    private String email;
    
}


