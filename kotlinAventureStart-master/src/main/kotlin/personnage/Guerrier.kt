package personnage

import item.Armes
import item.Armures
import item.Item

class Guerrier (
     nom: String,
     pointDeVie:Int,
     pointDeVieMax: Int,
     attaque: Int,
     defense: Int,
     endurance: Int,
     vitesse: Int,
     armure : Armures?,
     arme : Armes?,
    var armeSecondaire : Armes?,
):Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,armure=null,arme=null,) {
//     fun afficherArmes(monstre: Personnage): Armes {
//          println("Les armes de ${this.nom}")
//          for (i in 1..this.inventaire.size - 1) {
//               if (i is Armes) {
//                    println("$i. ${this.inventaire[i]}")
//               }
//
//
//          }
//     }

     override fun equipe(arme:Armes){//Choix équiper arme principale ou secondaire
          println("1. Arme principale ou 2. Arme secondaire")
          var choix2 = readln()

          if (choix2.toInt() == 1){
               this.arme?.utiliser(this)//Equiper sur arme principale
          }
          else if (choix2.toInt() == 2){
               this.armeSecondaire?.utiliser(this)//Equiper sur arme secondaire
          }
     }

     override fun attaque(adversaire: Personnage) {//Attaque arme secondaire
          //TODO Mission 4.1
          super.attaque(adversaire)//Action de la page personnage(parent) puis cette page

          if (armeSecondaire != null ){
               var degats= this.armeSecondaire!!.calculDegats() + this.attaque - adversaire.defense
               if (degats>1){
                    adversaire.pointDeVie-=degats
                    println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
               }
               else {
                    degats = 1
                    adversaire.pointDeVie -= degats
                    println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
               }
          }
          else {
               if (this.attaque > 0) {
                    var degats = (this.attaque / 2) - adversaire.defense
                    if (degats > 1) {
                         adversaire.pointDeVie -= degats
                         println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
                    }
                    else {
                         degats = 1
                         adversaire.pointDeVie -= degats
                         println("$nom attaque ${adversaire.nom} avec une attaque de base et inflige $degats points de dégâts.")
                    }
               }
          }

     }



}