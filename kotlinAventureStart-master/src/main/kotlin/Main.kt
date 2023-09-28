import item.*
import jeu.Jeu
import personnage.Personnage

//instanciation des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

// Armes

val shhhhhhhuuuuut = Armes(
    "shhhhhhhuuuuut",
    "tire des balles silencieuses",
    TypeArme(3, 50, 2, 2),
    qualiteLegendaire,
)

val epee_dophile = Armes(
    name = "l'Epee d'ophile",
    description = "l'epee preféré de tk , norman et amaru",
    type = TypeArme(78, 5000000, 45, 1),
    qualiteLegendaire,
)

val enma = Armes(
    "Enma",
    description = "Enma est un Meito ayant appartenu à Kozuki Oden, qui l'utilisait de paire avec un autre Meito, Ame no Habakiri. Kozuki Hiyori l'a hérité de son père et c'est le katana qui a donné sa seule cicatrice à Kaido,[2] d'abord avec Oden puis avec Zoro.\n" +
            "L'épée a été forgée par Shimotsuki Kozaburo.[3] Hiyori l'a donné à Zoro en échange du Shusui.[2]",
    TypeArme(1,100,13,3),
    qualiteLegendaire,
)



// Armures

val jTeProtege = Armures(
    "jTeProtege",
    "meme pas mal",
    TypeArmure("cailloux", 132),
    qualiteLegendaire
)

val antiPolice = Armures(
    "evite la prison",
    "peux utiler l'epee sans risquer la prison",
    TypeArmure("enfants", 999999999),
    qualiteLegendaire
)

val JsaisPas = Armures(
    "jTeProtegePasJSP",
    "une armure indescise",
    TypeArmure("CPeutEtreMoi", 200),
    qualiteLegendaire
)
fun main(args: Array<String>) {

    //Instantiation des monstres
    val gobelin = Personnage(
        "XXX le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 0,
        vitesse = 11,
        endurance = 6,
        arme = shhhhhhhuuuuut,
        armure = null,
        inventaire = mutableListOf(
            Armes(
                "lance",
                description = "fait mal",
                TypeArme(1,10,10,3),
                Qualite("legendaire", 3, "\u001B[33m"),),

            Armures(
                "JeReflechis",
                "une armure indescise",
                TypeArmure("CPeutEtreMoi", 200),
                Qualite("legendaire",3,"\u001B[33m")),
            Potions(30, "petite potion" , "soigne 30hp"),
            Potions(70, "moyenne potion" , "soigne 70hp")
        )

    )

    val cyclope = Personnage(
        "BigC le Cyclope",
        pointDeVie = 100,
        pointDeVieMax = 100,
        attaque = 4,
        defense = 7,
        vitesse = 2,
        endurance = 4,
        armure = jTeProtege,
        arme = shhhhhhhuuuuut
    )

    val Zoro = Personnage(
        " Roronoa Zoro ",
        pointDeVie = 1,
        pointDeVieMax = 1,
        attaque = 1,
        defense = 1,
        vitesse = 1,
        endurance = 1,
        arme = enma,
        armure = JsaisPas

    )

    val destructor = Personnage(
        "le pere vert",
        pointDeVie = 99999,
        pointDeVieMax = 999999,
        attaque = 9999999,
        defense = 99999,
        vitesse = 999999999,
        endurance = 0,
        arme = epee_dophile,
        armure= antiPolice,
        )





    // TODO Intermission 1 Ajouter d'autres monstres
    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( destructor,Zoro, cyclope,gobelin))
    //Lancement du jeu
    jeu.lancerCombat()
}
