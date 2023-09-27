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
    TypeArme(3, 80, 54, 2),
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
    TypeArme(1,10,10,3),
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
        defense = 4,
        vitesse = 11,
        endurance = 6,
        arme = shhhhhhhuuuuut,
        armure = jTeProtege

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
        pointDeVie = 900,
        pointDeVieMax = 900,
        attaque = 40,
        defense = 39,
        vitesse = 40,
        endurance = 40,
        arme = enma,
        armure = JsaisPas

    )



    val destructor = Personnage(
        "Le père vert",
        pointDeVie = 99999,
        pointDeVieMax = 999999,
        attaque = 99999,
        defense = 99999,
        vitesse = 99999,
        endurance = 99999,
        arme = epee_dophile,
        armure= antiPolice,
        )



    val molo = item.Bombe(
        nombreDeDes =3,
        maxDe =8,
        nom = "molo",
        description = "sa brule aie"
    )

    // TODO Intermission 1 Ajouter d'autres monstres
    //On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin, cyclope, Zoro, destructor))
    //Lancement du jeu
    jeu.lancerCombat()
}
