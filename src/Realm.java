import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Realm {
    private static BufferedReader br;
    private static FantasyCharacter player = null;
    private static BattleScene battleScene = null;
    private Merchant merchant = new Merchant();


    public static void main(String[] args) {

        br = new BufferedReader(new InputStreamReader(System.in));
        battleScene = new BattleScene();
        System.out.println("Как тебя зовут, воин?");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    private static void printNavigation() {
        System.out.println("Куда мне отправиться?");
        System.out.println("1. К Торговцу.");
        System.out.println("2. В путешствие.");
        System.out.println("3. Выход из игры.");
        System.out.println("0. Показать характеристики героя.");
    }

    private static void command(String string) throws IOException {
        Merchant merchant = new Merchant();

        if (player == null) {
            player = new Hero(string, 100, 20, 20, 0, 0,1);
            System.out.println(String.format("У нас появился новый герой, его имя %s! Поприветствуем же его!", player.getName()));
            printNavigation();
        }
        switch (string) {
            case "1": {
                merchant.menu();
                merchant.equip(merchant.equipProduct());
                printNavigation();
                if (merchant.getProducts()[0].getClass().equals(HealPotion.class)){
                    HealPotion healPotion = new HealPotion();
                    player.setHealthPoints(player.getHealthPoints() + healPotion.getHealths());
                }
                if (merchant.getProducts()[0].getClass().equals(StrengthPotion.class)){
                    StrengthPotion strengthPotion = new StrengthPotion();
                    player.setStrength(player.getStrength() + strengthPotion.getStrength());
                }
            }
            break;
            case "2": {
                commitFight();
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "0":
                System.out.println("Жизни героя: " + player.getHealthPoints());
                System.out.println("Сила героя: " + player.getStrength());
                System.out.println("Опыт героя: " + player.getXp());
                System.out.println("Ловкость героя: " + player.getDexterity());
                System.out.println("Золото героя: " + player.getGold());
                System.out.println("Уровень героя: " + player.getLevel());
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }
        command(br.readLine());
    }


    private static void commitFight() {
        battleScene.fight(player, createMonster(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь вы получаете %d опыта и %d золота, а также у вас осталось %d едениц здоровья.", player.getName(), player.getXp(), player.getGold(), player.getHealthPoints()));
                System.out.println("Хотите продолжить путешествие? (да/нет)");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {

            }
        });
    }


    private static FantasyCharacter createMonster() {
        int random = (int) (Math.random() * 3);
        if (random == 0) return new Goblin("Гоблин", 50, 10, 10, 100, 20,1);
        if (random == 1) return new Skeleton("Скелет", 25, 20, 20, 100, 10,1);
        if (random == 2) return new Zombie("Зомби",40,30,5,300,50,1);
        return null;
}

    interface FightCallback {
        void fightWin();
        void fightLost();
    }
}