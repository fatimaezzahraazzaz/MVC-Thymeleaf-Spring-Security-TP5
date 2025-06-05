# Rapport MVC-thymeleaf-Spring -Security TP5

Cette application Web JEE basée sur Spring Boot permet de gérer une liste de produits avec des fonctionnalités  sécurité, suppression ,edit ,ajout  et validation. Elle a été réalisée dans le cadre d'un TP.

##  Objectif

Créer une application Web complète avec les technologies suivantes :

-  Spring Boot
-  Spring MVC
-  Spring Data JPA + Hibernate
- Thymeleaf
- Spring Security
- Spring Validation
- H2
- Bootstrap 5


---

##  Fonctionnalités implémentées

1. **Création du projet Spring Boot** avec les dépendances :
   - Spring Web
   - Spring Data JPA
   - H2 
   - Thymeleaf
   - Lombok
   - Spring Security
   - Spring Validation

2. **Création de l'entité `Product`**
3. **Création de `ProductRepository`**
4. **Création des pages Thymeleaf + contrôleurs Spring MVC** :
   -  Liste des produits
   - Suppression d’un produit
   - Ajout d’un produit avec validation
   - Édition et mise à jour d’un produit
   - Mise en page avec layout Thymeleaf + Bootstrap
7. **Sécurisation avec Spring Security**
   - Utilisateurs en mémoire : `user1`,`user2`,`admin`
   - Accès restreint par rôle
8. **Fonctionnalités supplémentaires*
   -  Édition d’un produit
   

---

##  Sécurité

| Utilisateur | Mot de passe | Rôle     |
|------------|--------------|----------|
| user1      | 1234         | USER     
| user2     | 1234         | USER    |
| admin      | 1234         | ADMIN    |

---


### Page de connexion personnalisé:

![image](https://github.com/user-attachments/assets/3214e41d-5f97-48f5-8d52-2f43fdb02fed)


### Liste des produits
![image](https://github.com/user-attachments/assets/57a34fca-279c-4601-baa0-2babeca5d6d5)

![image](https://github.com/user-attachments/assets/496f0035-b210-4725-b382-049918ce8bc2)


### Formulaire d’ajout avec validation
![image](https://github.com/user-attachments/assets/b0dcd731-b02b-490d-b1bc-8c1159aee57a)
![image](https://github.com/user-attachments/assets/d7d07496-deea-4371-b0ff-3c2f6e1b95c3)


###  Formulaire d’édition
![image](https://github.com/user-attachments/assets/28fd8d47-b5c8-4feb-a1ed-0658ee95f0cb)
![image](https://github.com/user-attachments/assets/87e80cd4-002f-416a-975d-fe6cea44d6db)

###  La suppression pour admin 
- suppression du produit 4 :
- ![image](https://github.com/user-attachments/assets/bceae774-ef79-4618-92e6-e8af4816a8a1)

### La suppresion pour user :
 - avant de changer avec post le user pourvez supprimze un produit a apartir de "http://localhost:8090/admin/delete?id=3"
   ![Capture d'écran 2025-06-05 104920](https://github.com/user-attachments/assets/957051ba-ce3a-40e9-aa35-07697c54cddc)
   -apres l'utilisitation de PostMapping:
   ![Capture d'écran 2025-06-05 112947](https://github.com/user-attachments/assets/dab8d014-eee3-4767-9370-6dd0a5b32e78)

###  La'ajout d'un produit a partir d'un user :
![image](https://github.com/user-attachments/assets/07a51df1-9b34-4c79-8d97-d1d0a324718b)


## Conclusion
Ce projet a permis de mettre en pratique l'ensemble des concepts fondamentaux du développement d'applications Web JEE avec le framework Spring Boot. À travers la réalisation de cette application de gestion de produits,
j'ai pu intégrer les différents modules de l'écosystème Spring tels que Spring MVC, Spring Data JPA, Spring Security et Thymeleaf, tout en respectant les bonnes pratiques de structuration, de validation et de sécurité.


