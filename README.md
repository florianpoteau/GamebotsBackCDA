# Présentation

**Gamebots** est une plateforme permettant aux participants d'interagir avec une IA pour discuter de jeux vidéo.

Ce projet représente notre fil rouge dans le cadre de la formation Concepteur Développeur d'Applications que nous
suivons chez Simplon Valenciennes.

Ce repository contient le backend, la conception et la base de données de notre application.

Pour le frontend et les maquettes réalisées avec Figma, consultez le repository GitHub
suivant : [Gamebots-Front](https://github.com/yoanbor/Gamebots-Front.git).

# Technologies

## Langages

Nous avons utilisé les langages suivants :

- Java
- Maven
- Lombok
- Spring (Spring Boot, MVC, JPA, Security, JWT)

La base de données est PostgreSQL.

## Sécurité

Pour assurer la sécurité, nous avons mis en place des tests unitaires et des tests d’intégration. Nous avons utilisé :

- H2 comme base de données de test
- Jacoco pour la couverture de code
- Spring Security Test pour les tests de sécurité

Nous avons également employé SonarQube, Qodana, Checkstyle et Snyk pour tester et garantir la qualité du code.

## CI / CD

Nous avons créé des images Docker pour le backend et le frontend en rédigeant les Dockerfiles correspondants. La
vérification de la qualité et des tests de notre application, ainsi que la création et l'envoi des images Docker sur
DockerHub, sont automatisés grâce à des GitHub Actions appliquées à la branche `develop` de nos repositories.

## Conteneurisation

Un fichier `docker-compose.yml` a été configuré pour conteneuriser :

- SonarQube
- La base de données PostgreSQL
- PGAdmin
- Les images du frontend et du backend récupérées depuis DockerHub

# Architectures

Le projet utilise une architecture n-tiers se décomposant en trois parties :

- **Frontend** (disponible dans le repository Frontend)
- **Backend**
- **Base de données**

Le backend est également divisé en trois parties :

- **Présentation** : contient les controllers, qui sont le point d’entrée de l’application
- **Business** : inclut les DTO (Data Transfer Objects), les converters (pour convertir les DTO en DO et vice versa) et
  les services (contenant la logique métier)
- **Persistence** : comprend les DO (Data Objects) et les repositories (pour les requêtes vers la base de données)

# Déploiement

Pour lancer le projet, suivez les étapes ci-dessous :

1. Clonez le repository :
   ```bash
   git clone https://github.com/yoanbor/Gamebots-Back.git
   ````

2. Accédez au dossier Docker :
   ```bash
    cd docker
   ````

3. Lancez le fichier docker-compose :
   ```bash
    docker-compose up
   ````

Vous pouvez accéder à PGAdmin à l'adresse suivante : http://localhost:5050/

Le frontend est disponible à cette adresse : http://localhost:5173/

# Auteurs

👤 **_Yoan Bor_**

<a href="https://github.com/yoanbor"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></img></a>
<a href="www.linkedin.com/in/yoan-bor"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></img></a>

👤 **_Florian Poteau_**

<a href="https://github.com/florianpoteau"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></img></a>
<a href="https://www.linkedin.com/in/florian-poteau-63a9a71a1?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3BABLcIT06SJ2grEBJmU4AFg%3D%3D"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></img></a>
