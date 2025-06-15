package Characters;

public class Monster extends Character {
    protected int power;
    protected int defense;
    protected int experience;
    protected int money;

    public Monster(String name, int level, int hp, int mp, int power, int defense, int experience, int money) {
        super(name, level, hp, mp);
        this.power = power;
        this.defense = defense;
        this.experience = experience;
        this.money = money;
    }

    
    public int attack() {
        return power;
    }

    
    public void attacked(int damage) {
        int realDamage = damage - defense;
        if (realDamage < 1) realDamage = 1;
        hp -= realDamage;
        System.out.println(name + "이(가) " + realDamage + "의 피해를 입었습니다. 현재 HP: " + hp);
    }

    public int getExperience() { return experience; }
    public int getMoney() { return money; }
}
