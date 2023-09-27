package item

import personnage.Personnage

class Armures(
    nom: String,
    description: String,
    val type: TypeArmure,
    val qualite: Qualite
):Item(nom,description) {
    fun calculProtection(): Int {
        return this.type.bonusType + this.qualite.bonusQualite
    }



}