package item

import jeu.TirageDes
import personnage.Personnage

//class Armes constructor( name : String, description : String ){
//
//
//
//
//}

class Armes(
    val name : String,
    val description : String,
    val type : TypeArme,
    val qualite : Qualite,

){
    fun calculDegats(){
        var desDegat = TirageDes(1,8)
        var desCrit = TirageDes(1,20)
        var degats = 0
        if (desCrit.lance()  >= this.type.activationCritique){ // Si le résultat du lancer est >= activationCritique du type d'arme alors le coup est critique
            degats = desDegat.lance()*this.type.multiplicateirCritique+this.qualite.bonusQualite // Dégats correspond au lanceur * multiplicateur critique de l'arme
            println("Coup Critique")
        }
        else {
            degats = desDegat.lance()+this.qualite.bonusQualite
        }

    }
    fun utiliser(cible:Personnage){
    }
}


























































