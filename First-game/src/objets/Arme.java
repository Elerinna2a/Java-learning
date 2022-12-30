package objets;

import java.util.ArrayList;

public class Arme extends Objet {
     int valAttack;
     int durability;
     public ArrayList<Objet> inventoryWeapon = new ArrayList<>();
    public Arme(String name, int value, int weight, int valAttack, int durability, int quantity) {
        super(name, value, weight, quantity);
        this.valAttack = valAttack;
        this.durability = durability;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }


    // getter
    public int getValAttack() {
        return valAttack;
    }

    public int getDurability() {
        return durability;
    }


}
