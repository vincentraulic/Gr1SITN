PMO-web (Project Management Online)
=============

Software of project management

Groupe par pair programming :
- Pseudos "rorolroland" et "vincentraulic" : Roland Srong & Vincent Raulic
- Pseudos "Quentin Combier" et "Nirv" : Quentin Combier & Thomas Bethelot

Technos/Frameworks utilisés pour le projet
-----------
- JSF pour les vues
- EJB pour les services
- CDI pour les services
- JPA pour la couche ORM entre l'application et la base de données
- Spring security 4 pour l'authentification et l'accès au site
- Prettyfaces pour la réécriture des urls
- Serveur Glassfish 4
- Base de données MySQL

Branches
-----------
- [projet en jsf](https://github.com/vincentraulic/Gr1SITN/tree/dev_jsf) La branche dev_jsf correspond à notre branche review
- [projet en Spring MVC](https://github.com/vincentraulic/Gr1SITN/tree/dev) Version obsolete

Installation
-----------

```
Eclipse :

- Importer le projet maven

Base de données :

- Exécuter le script script_database.sql

Connexion du serveur Glassfish à la base de données

- La data-source située dans le fichier persistence.xml s'appelle "jdbc/pmo_resource"

Aller sur :
- http://localhost:8080/pmo

Le mot de passe crypté est : 123456

```

Structure principale
-----------
```
    +-- java.com.pmo            # Classes Java
    ¦   +-- controller          # Controleurs JSF
    ¦   +-- dao		            # Couche ORM entre la base de données et l'application
    ¦   +-- model               # Objets métiers correspondant aux tables de la base données 
	¦   +-- service             # Services de l'application
    ¦   +-- user                # Classes spécifiques pour l'authentification avec Spring security	
    +-- webapp
	¦   +-- css		            # Style des vues
    ¦   +-- ressources          # Ressources pour les vues
    ¦   +-- view                # Templates des vues jsf
	¦   +-- service             # Services de l'application
	+-- test					# Test
```

Contact pour les questions
------------
rs.rolandit@gmail.com
vincent.raulic@gmail.com
quentin.combier@gmail.com
bethelot.thomas@gmail.com

Licence
------------

AdminLTE is an open source project by Almsaeed Studio that is licensed under MIT. Almsaeed Studio reserves the right to change the license of future releases.