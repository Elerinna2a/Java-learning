package objets;
import java.util.ArrayList;

public class Armure extends Objet{
    int defense;
    int durability;
    public Armure(String name, int value, int weight, int defense, int durability, int quantity) {
        super(name, value, weight, quantity);
        this.defense = defense;
        this.durability = durability;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getDurability() {
        return this.durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
