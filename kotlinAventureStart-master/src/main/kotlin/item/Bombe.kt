package item

import personnage.Personnage

class Bombe constructor(
    val nombreDeDes :Int,
    val maxDe :Int,
    val nom :String,
    val description :String
){


    fun utiliser(cible : Personnage){
        val des = jeu.TirageDes(nombreDeDes , maxDe)
        var degats = des.lance()
        val protec = cible.armure.calculProtection()
        degats -= protec
        if (degats<1) degats = 1
        cible.pointDeVie -= degats
    }



}