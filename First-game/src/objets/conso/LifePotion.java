package objets.conso;

public class LifePotion extends Consommable{
    public LifePotion(String name, int value, int weight, int quantity) {
        super(name, value, weight, quantity);

    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }
}
