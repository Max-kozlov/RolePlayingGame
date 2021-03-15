public class StrengthPotion implements Product {
    private int cost = 60;
    private int strength = 15;

    public int getStrength() {
        return strength;
    }

    @Override
    public int getCost() {
        return cost;
    }
}

