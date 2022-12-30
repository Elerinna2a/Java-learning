package objets.conso;

import objets.Objet;

abstract class Consommable extends Objet {
    public Consommable(String name, int value, int weight, int quantity) {
        super(name, value, weight, quantity);
    }
}
