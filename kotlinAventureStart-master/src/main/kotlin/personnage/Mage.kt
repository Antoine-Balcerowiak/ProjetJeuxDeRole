package personnage

import item.Armes
import item.Armures


class Mage (
    nom: String,
    pointDeVie:Int,
    pointDeVieMax: Int,
    attaque: Int,
    defense: Int,
    endurance: Int,
    vitesse: Int,
    armure : Armures?,
    arme : Armes?,
    val grimoire:MutableList<Sort> = mutableListOf<Sort>(),


    ):Personnage(nom,pointDeVie,pointDeVieMax,attaque,defense,endurance,vitesse,armure=null,arme=null,)
{

    fun afficherGrimoire(){
        var n = 0
        for (elt in grimoire)
        {
            println("$n => ${elt.nom} effet : ${elt.effet}")
            n++
        }

    }
    fun choisirEtLancerSort(cible : Personnage){
        afficherGrimoire()
        print("choisir un sort : ")

        var choix =readln().toInt()
        while (choix > grimoire.size-1 || choix < 0){
            print("choisir un sort valide : ")
            choix = readln().toInt()
        }
        var sortChoisi :Sort= this.grimoire[choix]
        print("choisir la cible (1. joueur ou 2. monstre) : ")
        val cibleChoix = readln()
        var cibleSort : Personnage = cible
        if (cibleChoix.toInt() == 1) cibleSort = this
        else if (cibleChoix.toInt() == 2) cibleSort = cible

        sortChoisi.effet(this,cibleSort)
    }


}