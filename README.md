# projet-godwin-qalilab

## Objectifs du Projet

1. **Automatisation des tests fonctionnels** : Tester les fonctionnalités principales de l'application OrangeHRM, telles que l'authentification et la gestion des employés.
2. **Utilisation de Selenium WebDriver** : Automatiser les interactions avec l'interface utilisateur.
3. **Gestion des tests avec TestNG** : Structurer et exécuter les tests en utilisant le framework TestNG.

## Fonctionnalités Testées

- **Authentification** :
  - Connexion avec des identifiants valides.
  - Connexion avec des identifiants invalides.
- **Gestion des employés** :
  - Ajout d'un nouvel employé.
 
## Prérequis

Avant d'exécuter ce projet, assurez-vous d'avoir les éléments suivants installés sur votre machine :

1. **Java Development Kit (JDK)** : Version 17 ou supérieure.
2. **Maven** : Pour gérer les dépendances et exécuter le projet.
3. **Google Chrome** : Navigateur utilisé pour les tests.
4. **ChromeDriver** : Compatible avec la version de Google Chrome installée.
5. **IDE** : IntelliJ IDEA, Eclipse ou Visual Studio Code (optionnel).

## Installation

1. Clonez le dépôt du projet :
   ```bash
   git clone https://github.com/DereckBoss/projet-godwin-qalilab.git
   ```
2. Installez les dépendances Maven :
```bash
mvn clean install
```   
## Structure du Projet
- **src/main/java** : Contient le code principal du projet.
- **Main.java**: Point d'entrée du projet.
- **src/test/java** : Contient les tests automatisés.
- **OrangeHRMTests.java** : Classe de tests pour l'application OrangeHRM.
- **testng.xml** : Fichier de configuration TestNG.
- **pom.xml** : Fichier de configuration Maven. 

Dépendances Principales
- **Selenium Java** : Version 4.29.0
- **TestNG** : Version 7.11.0
 
