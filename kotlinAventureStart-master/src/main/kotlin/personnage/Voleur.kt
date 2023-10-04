package personnage

import item.Armes
import item.Armures
import item.Item
import jeu.TirageDes

class Voleur (
    nom: String,
    pointDeVie:Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armure : Armures?,
    arme : Armes?
    ):Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,armure=null,arme=null,)
{
        fun volerItem(cible: Personnage):Boolean { // Fonction pour voler un item à l'adversaire
            if (cible.inventaire.isNotEmpty()) {
                val de = TirageDes(0,cible.inventaire.size-1)
                var voler :Item
                val tirage = de.lance() // Lance un de pour obtnir un nombre aléatoire qui correspond aux index des items de l'adversaire
                var item = cible.inventaire[tirage]
                    if (item.equals(cible.arme)) { // Si notre tirage correspond à l'arme principal de l'adversaire alors l'arme de l'adversaire devient null
                    cible.arme = null
                }
                else if (item.equals(cible.armure)) {// Pareil que l'arme
                    cible.armure = null
                }

                voler = cible.inventaire[tirage]
                this.inventaire.add(cible.inventaire[tirage]) // Ajoute l'item volé à notre inventaire
                cible.inventaire.remove(cible.inventaire[tirage])// Retire l'item de l'inventaire de l'adversaire

                println("${voler} Volé")
                return true
            }
            else {
                println("Inventaire de la cible VIDE")
                return false
            }
        }

    }