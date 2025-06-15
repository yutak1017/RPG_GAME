package Characters;

public class Character {
    protected String name;
    protected int level;
    protected int hp;
    protected int mp;

    public Character(String name, int level, int hp, int mp) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.mp = mp;
    }

    public int attack() {
        return 0;
    }

    public void attacked(int damage) {
        hp -= damage;
        System.out.println(name + "이(가) " + damage + "의 피해를 입었습니다. 현재 HP: " + hp);
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHp() { return hp; }
    public int getMp() { return mp; }
}
