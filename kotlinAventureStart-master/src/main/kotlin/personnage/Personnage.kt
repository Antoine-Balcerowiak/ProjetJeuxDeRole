package personnage

import item.Armes
import item.Armures

class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armure : Armures,
    var arme : Armes,
) {

     fun calculeDefense():Int{
         //TODO Mission 4.2
        return this.defense/2;
     }

     // Méthode pour attaquer un adversaire
     fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
       val degats= this.attaque/2
         adversaire.pointDeVie-=degats
        println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
    }

     fun passeTour() {
         println("$nom à passé son tour")
     }

    override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }


}