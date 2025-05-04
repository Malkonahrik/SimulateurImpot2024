**Projet de Réusinage du Simulateur d'Impôts**

Contexte
========
Ce projet vise à réusiner le code initial du simulateur d'impôts pour améliorer sa modularité et sa lisibilité. L'objectif est de s'assurer que les tests initiaux fonctionnent toujours via un adaptateur vers le nouveau code. Le projet doit également atteindre une couverture de code par les tests d'au moins 90 % et passer l'analyse de code avec CheckStyle sans erreurs ni avertissements, en utilisant le fichier de règles fourni par l'IUT.

Objectifs
=========
- Modularité : Refactoriser le code pour le rendre plus modulaire.
- Lisibilité : Améliorer la lisibilité du code.
- Tests : Assurer une couverture de code par les tests d'au moins 90 %.
- Conformité CheckStyle : Passer l'analyse de code avec CheckStyle sans erreurs ni avertissements.
- Traçabilité : Montrer la traçabilité vers les exigences dans le code avec des commentaires.

Structure du Projet
====================
- src/main/java/com/kerware/simulateurreusine : Contient le code source du simulateur réusiné.
- src/test/java/simulateur/simulateurreusine : Contient les tests unitaires.

Configuration du Projet
=======================

Prérequis
---------
- Java 17 ou version ultérieure
- Maven 3.6 ou version ultérieure

Compilation et Exécution
------------------------
Exécutez automatisation-qualite-code.bat
