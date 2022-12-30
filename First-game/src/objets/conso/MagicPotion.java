package objets.conso;

public class MagicPotion extends Consommable{
    public MagicPotion(String name, int value, int weight, int quantity) {
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
