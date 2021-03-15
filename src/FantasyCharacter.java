public abstract class FantasyCharacter implements Fighter {

    private String name;

    private int healthPoints;
    private int strength;
    private int dexterity;

    private int xp;
    private int gold;
    private int level;

    public FantasyCharacter(String name, int healthPoint,int strength,int dexterity,int xp,int gold, int level) {
        this.name = name;
        this.healthPoints = healthPoint;
        this.strength = strength;
        this.dexterity = dexterity;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
    }

    @Override
    public int attack(){
        if(dexterity*3>getRandomValue()) return strength;
        else return 0;
    }
    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }
    public int getHealthPoints(){
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints){
        this.healthPoints = healthPoints;
    }
    public int getStrength(){
        return strength;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public int getDexterity(){
        return dexterity;
    }
    public void setDexterity(int dexterity){
        this.dexterity = dexterity;
    }
    public int getXp(){
        return xp;
    }
    public void setXp(int xp){
        this.xp = xp;
    }
    public int getGold(){
        return gold;
    }
    public void setGold(int gold){
        this.gold = gold;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
    private int getRandomValue(){
        return (int)(Math.random()*100);
    }
       void increaseByLevel(){
           setStrength(getStrength() + 10);
           setDexterity(getDexterity() + 10);
    }

    @Override
    public String toString(){
        return String.format("%s здоровье:%d",name,healthPoints);
    }
}
