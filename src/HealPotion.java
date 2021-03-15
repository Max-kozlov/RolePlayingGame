public class HealPotion implements Product{
    private int cost = 50;
    private int healths = 20;

    public int getHealths() {
        return healths;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
