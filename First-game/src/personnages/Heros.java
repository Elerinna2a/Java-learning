package personnages;

import objets.Arme;
import objets.Armure;
import objets.Objet;
import objets.conso.LifePotion;
import objets.conso.MagicPotion;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public class Heros {
    String nom;
    Random rand = new Random();
    private boolean vivant = true;

    public Heros(String name) {
        this.nom = name;
        LifePotion lifepotion = new LifePotion("Life potion",2,2,2);
        MagicPotion magicpotion = new MagicPotion("Magic potion", 2,2,2);
        inventory.add(lifepotion);
        inventory.add(magicpotion);
    }

    public void nomPersonnages() {
        System.out.println("je m'appel " + this.nom + ".");

    }

    int pv = 100;
    int endurance = 100;
    int pMagie = 100;
    int level = 1;
    int xp = 0;
    int force = 10;
    int intelligence = 10;
    int agility = 10;
    int silver = 2000;
    public Arme weapon = new Arme("Hache en bois", 10, 1, 5, 100, 1);
    public Armure armor = new Armure("Leather torso", 10, 2, 2, 100, 1);

    public ArrayList<Objet> inventory = new ArrayList<>();
    public ArrayList<Arme> armes = new ArrayList<>();





    public void setArmor(Armure newArmor) {
        this.armor = newArmor;
    }

    public void setArmor() {
        this.armor = null;
    }

    public void setArme(Arme newArme) {
        this.weapon = newArme;
    }

    public void setArme() {
        this.weapon = null;
    }

    public void changeArme(Arme arme) {
        inventory.add(this.weapon);
        setArme(arme);
        System.out.println("Vous venez d'équipé : " + arme.name);
    }

    public void reset() {
        this.pv = 100;
        this.endurance = 100;
        this.pMagie = 100;
        this.level = 1;
        this.xp = 0;
        this.force = 10;
        this.intelligence = 10;
        this.agility = 10;
        this.silver = 0;
    }



    public void afficherInventaire() {
        System.out.println("Inventaire : ");
        Stack stack = new Stack();
        for (int i = 0; i < this.inventory.size(); i++) {
            System.out.println("--------------");
            System.out.println("L'objet s'appel : " + this.inventory.get(i).name);
            System.out.println(" pese : " + this.inventory.get(i).weight + "kg,");
            System.out.println(" Et a une valeur de " + this.inventory.get(i).value + " gold.");
            System.out.println(" Et j'en ai : " + this.inventory.get(i).quantity);
        }
        System.out.println("--------------");
        System.out.println("L'inventaire contient " + inventory.size() + " objets.");
        System.out.println("--------------");
        System.out.println("Je dispose de : " + this.silver + " silver à dépenser.");
    }

    public void afficherWeight() {
        int weight = 0;
        for (Objet objet : this.inventory) {
            weight += objet.getWeight();
        }
        System.out.println("Poids total des objets: " + weight);
    }

    public void addLoot(Objet loot) {
        this.inventory.add(loot);
    }


    public void mourir() {
        if (this.pv == 0) {
            this.vivant = false;
            reset();
        }
    }

    public void Stats() {
        System.out.println("Pv : " + pv);
        System.out.println("Endurance :" + endurance);
        System.out.println("Point de magie :" + pMagie);
        System.out.println("Level : " + level);
        System.out.println("Xp : " + xp);
        System.out.println("J'ai " + force + " force \n" + intelligence + " intelligence \n" + agility + " agilité.");
    }

//    int random = (int) (Math.random() *3);

    public void levelUp() {
        this.level = this.level + 1;
        this.pv = 100;
        this.endurance = 100;
        this.pMagie = 30;
        int select = rand.nextInt(3);
        if (select == 1) {
            this.force += 1;
            System.out.println(" Tu viens d'obtenir 1 point en force ");
        } else if (select == 2) {
            this.intelligence += 1;
            System.out.println("Tu viens d'ajouter 1 en intelligence");
        } else {
            this.agility += 1;
            System.out.println("Tu viens d'ajouter 1 en agilité");
        }
    }


    public void winXp(int newXp) {
        if (newXp < 0) {
            System.out.println("Ajoute un bon nombre d'xp");
            newXp = 0;
        } else {
            this.xp += newXp;
            while (this.xp >= this.level * 50) {
                this.xp -= this.level * 50;
                this.levelUp();
            }
        }
    }

    public void seReposer(int newEndurance) {
        if (newEndurance < 0) {
            System.out.println("Pas de négatif !");
        } else if (this.endurance >= 100) {
            this.endurance = 100;
        } else {
            this.endurance += newEndurance;
        }
    }

    public void potionSoin() {
        if (this.pv >= 100) {
            this.pv = 100;
        } else if (this.inventory.get(0).quantity <= 0) {
            System.out.println("Tu ne peux pas regen, sale pauvre");
        } else {
            this.pv = 100;
            this.inventory.get(0).quantity--;
            }
        }

    public void potioPm() {
        if (this.pMagie >= 100) {
            this.pMagie = 100;
        } else if (this.inventory.get(1).quantity <= 0) {
                System.out.println("tu ne peux pas regen tes pm, sale double pauvre");
            } else {
                this.pMagie = 100;
                this.inventory.get(1).quantity--;
            }
        }

    public void attaquer(Ennemi ennemi) {
        if (this.endurance < 50 - this.agility) {
            System.out.println("Je n'ai passez d'endurance, repose toi péon.");
        } else {
            this.endurance -= (50 - this.agility);
            System.out.println("J'ai infliger " + this.force * 0.5 + " point de dégats");
            System.out.println("il me reste " + this.endurance + " point d'endurance.");
            if (this.weapon == null) {
                ennemi.pointVie -= this.force * 0.5;
            } else {
                ennemi.pointVie -= this.force * 0.5 + this.weapon.getValAttack();
                this.weapon.setDurability(this.weapon.getDurability() - 2);
            }
            if (ennemi.pointVie <= 0) {
                ennemi.mourir(this);
            }
            System.out.println("il reste " + ennemi.pointVie + " pv a l'ennemi");
        }
    }

    public void sort(Ennemi ennemi) {
        if (this.pMagie < 50 - this.intelligence) {
            System.out.println("Je n'ai pas assez de mana, utilser une potion plz.");
        } else {
            System.out.println("j'ai infliger " + this.intelligence * 0.25 + " point de dégats de sort");
            this.pMagie -= (50 - this.intelligence);
            System.out.println("il me reste " + this.pMagie + "point de mana.");
            ennemi.pointVie -= this.intelligence * 0.25;
            this.pv -= ennemi.ptDamage;
            System.out.println("il reste " + ennemi.pointVie + " pv a l'ennemi");
        }
    }

    public void combatPm(Ennemi ennemi) {
        while (ennemi.pointVie > 0) {
            this.sort(ennemi);
            ennemi.ennemiAttaque(this);
            if (this.intelligence < 50 - intelligence) {
                potioPm();
            }
            if (this.pv == 0) {
                mourir();
                System.out.println("Votre héros est mort");
            } else {
                ennemi.mourir(this);
//                System.out.println("L'ennemi est mort");
            }
        }
    }

    public void combat(Ennemi ennemi) {
        if (!ennemi.getVivant()) {
            System.out.println("Votre ennemi est déjà mort!");
        }
        while (ennemi.pointVie > 0) {
            seReparer(this.armor,this.weapon);
            if (this.endurance < 50 - agility) {
                sort(ennemi);
            } else {
            this.attaquer(ennemi);
            }

            if (!ennemi.getVivant()) {
                break;
            }
            if (this.endurance < 50 - agility && this.intelligence < 50 - intelligence) {
                this.seReposer(100);
                this.potioPm();
            }
            if (this.pv < 50) {
                this.potionSoin();
            }
            if (this.pv <= 0) {
                this.mourir();
                System.out.println("Votre héros est mort");
            }
            ennemi.ennemiAttaque(this);
            if (this.inventory.get(0).quantity == 0 && this.inventory.get(1).quantity <= 0) {
                System.out.println("Fuis, sale mécréant");
                break;
            }
        }
    }

    public void showWeapon() {
        for (Objet objet : inventory) {
            if (objet instanceof Arme) {
                armes.add((Arme) objet);
            }
        }
        int cpt = 0;
        System.out.println("Inventaire d'armes : ");
        for (Arme arme : armes) {
            System.out.println(cpt + " : " + arme.name);
            cpt += 1;
        }
    }

    public void triInventaire(ArrayList<Objet> objet) {
        ArrayList<Arme> armes = new ArrayList<>();
        for (Objet i : objet) {
            if (i instanceof Arme) {
                armes.add((Arme) i);
            }
        }
        int i = 0;
        for (Arme arme : armes) {
            System.out.println(i + " : " + arme.name);
            i += 1;
        }
        Scanner scanner = new Scanner(System.in);
        int choix = scanner.nextInt();
        this.changeArme(armes.get(choix));
        this.inventory.remove(armes.get(choix));
    }


    public void recupArme() {
        triInventaire(this.inventory);
        afficherInventaire();
    }

    public void addSilver(int silver) {
        this.silver += silver;
    }

    public void seReparer(Armure armure, Arme arme) {
        int cost;
        if (armure.getDurability() <= 20){
            cost = (100 - armure.getDurability());
            armure.setDurability(100);
            System.out.println("Je viens de réparer mon armure...");
        } else if (arme.getDurability() <= 20){
            cost = (100-arme.getDurability());
            arme.setDurability(100);
            System.out.println("Je viens de réparer mon arme...");
        } else {
            System.out.println("Pas besoin de réparer...");
        }
    }

    public boolean checkPotionPV(ArrayList<Objet> inventory) {
        if (this.inventory.get(1).quantity <= 3) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkPotionPM(ArrayList<Objet> inventory) {
        if (this.inventory.get(0).quantity <= 3) {
            return false;
        } else {
            return true;
        }
    }

    public void buyPotion(ArrayList<Objet> inventory) {
        if (!checkPotionPM(this.inventory)) {
            if (this.silver > 50) {
                System.out.println("Je t'ai acheter des potion PM!");
                this.inventory.get(1).quantity++;
                this.silver -= 10;
            } else {
                System.out.println("Tu n'as pas assez d'argent fucking péon");
            }
        }
        if (!checkPotionPV(this.inventory)) {
            if (this.silver > 50) {
                System.out.println("Je t'ai acheter des potion PV!");
                this.inventory.get(0).quantity++;
                this.silver -= 10;
            } else {
                System.out.println("Tu n'as pas assez d'argent fucking péon");
            }
        }
    }
}