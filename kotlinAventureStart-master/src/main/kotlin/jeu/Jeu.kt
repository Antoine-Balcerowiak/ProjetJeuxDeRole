package jeu

import item.*
import personnage.Personnage


class Jeu(monstres: List<Personnage>) {
    lateinit var joueur: Personnage
    var combats: MutableList<Combat> = mutableListOf()
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres) {
            // On créer un combat
            val unCombat = Combat(this, unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        println("Création votre personnage:")
        // TODO Mission 1.1
        print("Saisir le nom du personnage : ")
        val nom = readln()
        println("Vous avez 40 points à attribuer a votre personnage (en attaque,defense,endurance et vitesse")
        var points = 40
        var attaque = 0
        var defense = 0
        var endurance = 0
        var vitesse = 0
        var choix: Int
        var stats = 0
        do {
            println("point restant: $points")
            println("Stat : ")
            println("1. attaque ($attaque) : ")
            println("2. defense ($defense) : ")
            println("3. endurance ($endurance) : ")
            println("4. vitesse ($vitesse) : ")
            println("5. terminer ")
            print("choix : ")
            choix = readln().toInt()

            if (choix == 1) { // augmentation stat attaque
                print("stats attaque : ")
                stats = readln().toInt()
                while (stats > points) {
                    println("stat trop élevé")
                    print("stats attaque : ")
                    stats = readln().toInt()
                }
                attaque += stats
                points -= stats
            }

            if (choix == 2) { // augmentation stat defense
                print("stats defense : ")
                stats = readln().toInt()
                while (stats > points) {
                    println("stat trop élevé")
                    print("stats defense : ")
                    stats = readln().toInt()
                }
                defense += stats
                points -= stats
            }

            if (choix == 3) { // augmentation stat endurance
                stats = readln().toInt()
                print("stats endurance : ")
                while (stats > points) {
                    println("stat trop élevé")
                    print("stats endurance : ")
                    stats = readln().toInt()
                }
                endurance += stats
                points -= stats
            }

            if (choix == 4) { // augmentation stat vitesse
                print("stats vitesse : ")
                stats = readln().toInt()
                while (stats > points) {
                    println("stat trop élevé")
                    print("stats vitesse : ")
                    stats = readln().toInt()
                }
                vitesse += stats
                points -= stats
            }

        } while (choix != 5)
        val pdv = 100 + (endurance * 10)
        val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
        val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
        val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
        val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

        val hero = Personnage(nom, 3000, 3000, attaque, defense, endurance, vitesse, arme = null , armure = null)
        this.joueur = hero
        return hero
    }
}