package Characters;

public class Hero extends Character {
    protected int power;
    protected int defense;
    protected int experience;
    protected int money;
    protected Weapon weapon;

    public Hero(String name, int level, int hp, int mp, int power, int defense) {
        super(name, level, hp, mp);
        this.power = power;
        this.defense = defense;
        this.experience = 0;
        this.money = 100;
        this.weapon = null;
    }

    public int getPower() { 
    	return power;
    	}
    public int getDefense() { 
    	return defense; 
    	}
    public int getExperience() { 
    	return experience; 
    	}
    public int getMoney() { 
    	return money; 
    	}
    public Weapon getWeapon() { 
    	return weapon; 
    	}

    public void addExperience(int exp) {
        experience += exp;
        if (experience >= level * 50) {
            level++;
            experience = 0;
            System.out.println("레벨업! 현재 레벨: " + level);
        }
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void addPower(int amount) {
        power += amount;
    }

    public void recoverHp(int amount) {
        hp += amount;
    }

    public void useMp(int amount) {
        mp -= amount;
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int attack() {
        int weaponPower = (weapon != null) ? weapon.getPower() : 0;
        return level * 5 + power + weaponPower;
    }


    public void attacked(int damage) {
        int realDamage = damage - defense;
        if (realDamage < 1) realDamage = 1;
        hp -= realDamage;
        System.out.println(name + "이(가) " + realDamage + "의 피해를 입었습니다. 현재 HP: " + hp);
    }
}
