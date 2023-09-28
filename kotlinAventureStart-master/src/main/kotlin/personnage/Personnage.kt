package personnage

import item.*
import jeu.TirageDes

class Personnage(
    val nom: String,
    var pointDeVie:Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armure : Armures?,
    var arme : Armes?,
    //val inventaire: MutableList<Item> = mutableListOf<Item>()
    val inventaire: MutableList<Item> = mutableListOf<Item>(
        Armes(
            "Enma",
            description = "Enma est un Meito ayant appartenu à Kozuki Oden, qui l'utilisait de paire avec un autre Meito, Ame no Habakiri. Kozuki Hiyori l'a hérité de son père et c'est le katana qui a donné sa seule cicatrice à Kaido,[2] d'abord avec Oden puis avec Zoro.\n" +
                    "L'épée a été forgée par Shimotsuki Kozaburo.[3] Hiyori l'a donné à Zoro en échange du Shusui.[2]",
            TypeArme(1,10,10,3),
            Qualite("legendaire", 3, "\u001B[33m"),),

        Armures(
                "jTeProtegePasJSP",
        "une armure indescise",
        TypeArmure("CPeutEtreMoi", 200),
        Qualite("legendaire",3,"\u001B[33m")),

        Armes(
            "shhhhhhhuuuuut",
            "tire des balles silencieuses",
            TypeArme(3, 80, 54, 2),
            Qualite("legendaire",3,"\u001B"),
        ),

        Armures(
            "HEHEHEHE",
            "une armure rigole",
            TypeArmure("marrant", 30),
            Qualite("legendaire",3,"\u105B[50m"))
        ,
        Bombe(
            nombreDeDes =3,
    maxDe =8,
    nom = "molo",
    description = "sa brule aie"
),
        Bombe(
            nombreDeDes =3,
            maxDe =16,
            nom = "bombe",
            description = "aaaaaaaaaaaaaaaaaaie"
        ),

        Potions(30, "petite potion" , "soigne 30hp"),
        Potions(70, "moyenne potion" , "soigne 70hp")

    )
) {

     fun calculeDefense():Int {
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

    fun stats() {
        println("arme : ${this.arme}")
        println("armure : ${this.armure}")
        println("PV : ${this.pointDeVie}")

    }

    fun equipeArme( arme:Item) {
        if (arme in this.inventaire && arme is Armes)
            this.arme = arme
        println("${this.nom} equipe ${this.arme!!.nom}")
    }

    fun equipeArmure( armure:Item) {
        if (armure in this.inventaire && armure is Armures)
            this.armure = armure
        println("${this.nom} equipe ${this.armure!!.nom}")
    }

    fun selctionInventaire (monstre:Personnage) :Boolean {
        println("Selectionner un item : ")
        val selection = readln().toInt()
        val item = this.inventaire[selection]
        var actionValide = false
        
        if (item is Armes) {
            this.arme = item
        }

        else if (item is Armures) {
            this.armure = item
        }

        else if (item is Bombe) {
            var cible = monstre
            item.utiliser(cible)
            this.inventaire.remove(item)
            actionValide = true

        }
        else if (item is Potions) {
            val cible = this
            item.utiliser(cible)
            this.inventaire.remove(item)
            actionValide = true
        }
        return actionValide
    }

    fun ouvrirInventaire(monstre: Personnage,): Boolean {
        for (i in 0..this.inventaire.size - 1) {
            println("$i. ${this.inventaire[i]}")
        }


        return selctionInventaire(monstre)
    }

    fun avoirPotion():Boolean {
        var potions = false
        for (elt in inventaire){
            if (elt is item.Potions){
                potions = true
            }
        }
        return potions
    }

    fun avoirBombe():Boolean {
        var Bombe = false
        for (elt in inventaire){
            if (elt is item.Bombe){
                Bombe = true
            }
        }
        return Bombe
    }

    fun loot(adversaire: Personnage){
        if (adversaire.pointDeVie < 0){
            val de = TirageDes(1,10)
            val result = de.lance()
            if (result == 1 || result == 0){
                println("Felicitation vous avez loot l'inventaire de ${adversaire.nom}")
                println(adversaire.inventaire)
                this.inventaire += adversaire.inventaire
            }
        }
    }

    fun boirePotion(){
        if (avoirPotion())
        {
            for (elt in inventaire){
                if (elt is item.Potions){
                    pointDeVie += elt.soin
                    if (pointDeVie > pointDeVieMax) pointDeVie=pointDeVieMax
                }
            }

        }
    }






    /*override fun toString(): String {
        return "$nom (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse, arme: $arme, armure: $armure)"
    }*/


}