package item

import personnage.Personnage

class Armures(
    var nom: String,
    var description: String,
    val type: TypeArmure,
    val qualite: Qualite
) {
    fun calculProtection(): Int {
        return this.type.bonusType + this.qualite.bonusQualite
    }

    fun utiliser(cible: Personnage) {

    }

}