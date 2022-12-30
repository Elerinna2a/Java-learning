import objets.Arme;
import objets.Armure;
import objets.Objet;
import objets.conso.LifePotion;
import personnages.Ennemi;
import personnages.Heros;

import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        // initialisation heros / ennemi
        Heros newHero = new Heros("Elerinna");
        Ennemi newEnnemi = new Ennemi();
        Ennemi illidan = new Ennemi();
        Ennemi derrichter = new Ennemi();
        newHero.nomPersonnages();

        ArrayList<Objet> inventory = new ArrayList<>();

        newHero.setArmor();
        newHero.combat(newEnnemi);
        newHero.combat(illidan);
        newHero.combat(derrichter);

        Armure steelarmor = new Armure("Steel torso", 10, 2, 2, 100, 1);
        Arme ironsword = new Arme("Epee de fer", 10,1,3,100, 1);
        Arme steelsword = new Arme("Epée d'acier", 50, 1, 10, 100, 1);
        Arme ultima = new Arme("Ultima", 100,3,30,100, 1);


        newHero.setArme(ironsword);
        newHero.changeArme(steelsword);
        System.out.println(newHero.weapon.name);
        newHero.changeArme(ultima);
        System.out.println(newHero.weapon.name);
        newHero.afficherInventaire();
        newHero.recupArme();
        newHero.buyPotion(inventory);
        newHero.afficherInventaire();
    }
}