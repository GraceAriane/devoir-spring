
# Gestion d'utilisateurs - Projet Java MVC

## Objectif

L'objectif de ce projet est de développer une application simple de gestion d'utilisateurs en utilisant le modèle **MVC (Modèle-Vue-Contrôleur)**.  
Deux versions de l'application ont été réalisées :  

1. Version utilisant une **Map** comme base de données.  
2. Version utilisant **MySQL** pour la persistance.



## Architecture et organisation des dossiers

Le projet est structuré selon le modèle MVC avec séparation claire des responsabilités :

```

src/
├── presentation/
│    ├── controller/      # Gestion des interactions utilisateur
│    │    └── UserController.java
│    ├── view/            # Affichage et récupération des données
│    │    └── CommandLineView.java
│    └── model/           # Modèles pour l'UI si nécessaire
│         └── UserUiModel.java
│
├── application/
│    ├── service/         # Interfaces de services
│    │    └── UserService.java
│    └── usecase/         # Implémentation de la logique métier
│         └── UserServiceImpl.java
│
├── domain/
│    ├── model/           # Entités métier
│    │    └── User.java
│    └── repository/      # Interfaces de repository
│         └── UserRepository.java
│
├── persistence/
│    ├── repository/      # Implémentations des repositories
│    │    ├── UserRepositoryImpl.java   # Version Map
│    │    └── UserRepositoryMySQLImpl.java
│    └── datasource/      # Gestion des connexions à la base de données
│         └── Database.java
│
└── lib/                  # Bibliothèques externes (ex : MySQL Connector)


```

## Partie 1 : Version avec Map

### 1. Modèle (Model)
- **Classe User** : représente un utilisateur avec les attributs :
  - `Long id`
  - `String name`
  - `String email`
- Méthodes :
  - Getters et Setters
  - `toString()`

### 2. Repository
- **Interface UserRepository** :
  ```java
  void save(User user);
  Optional<User> findById(Long id);
  List<User> findAll();
  void delete(Long id);
````

* **Optional** : utilisé pour indiquer qu’un utilisateur peut être trouvé ou non, évitant les `null`.

### 3. RepositoryImpl

* Implémente `UserRepository` avec une `Map<Long, User>` comme stockage.
* Méthodes pour ajouter, rechercher, lister et supprimer des utilisateurs.

### 4. Service

* **Interface UserService** :

  ```java
  void addUser(User user);
  User getUser(Long id);
  List<User> getAllUsers();
  void deleteUser(Long id);
  ```

### 5. ServiceImpl

* Implémente l’interface `UserService`.
* Contient la logique métier (ex : génération automatique de l’ID).

### 6. Contrôleur (Controller)

* **UserController** :

  * Interagit avec le service pour ajouter, récupérer ou supprimer des utilisateurs.
  * Interagit avec la vue pour afficher les informations à l’utilisateur.
* Sépare clairement les responsabilités :

  * La vue s’occupe uniquement de l’affichage et de la saisie.
  * Le service gère la logique métier.
  * Le repository gère la persistance.

---

## Partie 2 : Migration vers MySQL

### 1. Configuration

* Créer un fichier `application.properties` pour gérer les paramètres de connexion MySQL :

  ```
  db.url=jdbc:mysql://localhost:3306/gestionUtilisateurs
  db.user=root
  db.password=
  ```
* Classe `Database.java` :

  * Gère la connexion à la base.
  * Charge le driver MySQL avec `Class.forName("com.mysql.cj.jdbc.Driver")`.
  * Utilise `DriverManager.getConnection` pour obtenir la connexion.

### 2. Repository avec MySQL

* **UserRepositoryMySQLImpl** remplace la Map par des opérations SQL :

  * `INSERT` pour ajouter un utilisateur.
  * `SELECT` pour rechercher ou lister des utilisateurs.
  * `DELETE` pour supprimer.

### 3. Service et Contrôleur

* La logique reste identique au niveau du service et du contrôleur.
* L’interface reste la même, permettant de changer le repository sans modifier le reste du code.

---

## Compilation et exécution

### 1. Compilation

```bash
javac -cp "lib/*" -d bin $(Get-ChildItem -Recurse unDossier\devoir\*.java).FullName
```

### 2. Exécution

```bash
java -cp "bin;lib/*" devoir.Main
```

> Assurez-vous que MySQL est démarré et que la base `gestionUtilisateurs` existe.






