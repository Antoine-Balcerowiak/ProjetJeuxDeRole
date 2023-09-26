package jeu

import personnage.Personnage

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nom} (pv: ${this.jeu.joueur.pointDeVie}) ---")

        //TODO Mission 1.2
        println("1. Attaquer  2. Passer  3. Inventaire")
        var action = readln()// Entrer choix d'action
        if(action.toInt() == 1 ){// Si choix d'action est Attaquer
            this.jeu.joueur.attaque(monstre)
            action = "Attaquer"
        }
        else if (action.toInt() == 2 ){// Si choix d'action est passer le tour
            this.jeu.joueur.passeTour()
            action ="Passe le tour"
        }

        println(action)
        println("\u001b[0m")
    }

    // Méthode pour simuler un tour de combat du monstre
    fun tourDeMonstre() {
        var des = TirageDes(1,100) // Tire un nombre aléatoire entre 1 et 100
        println("\u001B[31m---Tour de ${monstre.nom} (pv: ${monstre.pointDeVie}) ---") // affiche le tour du monstre
        //TODO Mission 1.3
        if (des.lance() <= 70) { // Si le nombre tiré est inférieur à 70 le monstre attaque
            this.monstre.attaque(this.jeu.joueur)
        }
        else if (des.lance() > 70) { // Si le nombre tiré est superieur à 70 le monstre passe son tour
            this.monstre.passeTour()
        }
        println("\u001b[0m")
    }

    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nom} vs ${monstre.nom}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nom}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nom}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nom} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nom} a été vaincu !")
        }
    }
}