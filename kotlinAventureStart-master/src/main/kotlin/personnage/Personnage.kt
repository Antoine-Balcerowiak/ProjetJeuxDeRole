package personnage

import item.Armes
import item.Armures
import item.Bombe
import item.Item

class Personnage(
    val nom: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armure : Armures?,
    var arme : Armes?,
    val inventaire: MutableList<Item> = mutableListOf<Item>()
) {

     fun calculeDefense():Int{
         //TODO Mission 4.2
         if (armure != null) {
             return (this.defense + this.armure!!.calculProtection()) / 2 ;
         }
         else return this.defense / 2;

     }

     // Méthode pour attaquer un adversaire
     fun attaque(adversaire: Personnage) {
        //TODO Mission 4.1
       if (arme != null ){
           val degats= this.arme!!.calculDegats() + this.attaque / 2
           adversaire.pointDeVie-=degats
           println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
       }
         else {
           val degats= this.attaque/2
           adversaire.pointDeVie-=degats
           println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
       }
    }

     fun passeTour() {
         println("$nom à passé son tour")
     }

    fun equipeArme( arme:Item) {
        if (arme in this.inventaire && arme is Armes)
            this.arme = arme
        println("${this.nom} equipe ${this.arme!!.nom}")
    }

    fun selctionInventaire ():Item {
        val selection = readln().toInt()

        val item =this.inventaire[selection]
        return item
    }

    fun ouvrirInventaire() {

        for (i in 0..this.inventaire.size - 1) {
            for (elt in this.inventaire) {
                println("$i. $elt")
            }
            println("Selectionner un item : ")
            selctionInventaire()
        }
    }




    /*override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse, arme: $arme, armure: $armure)"
    }*/


}