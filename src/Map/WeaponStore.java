package Map;

public class WeaponStore {
    public void showWeapons(Characters.Hero hero) {
        System.out.println("--- 무기 상점 ---");

        if (hero instanceof Characters.Warrior) {
            System.out.println("1. 청동검 (공격력: 10, 가격: 100골드)");
            System.out.println("2. 강철검 (공격력: 15, 가격: 200골드)");
        } else if (hero instanceof Characters.Mage) {
            System.out.println("1. 나무 지팡이 (공격력: 10, 가격: 120골드)");
            System.out.println("2. 마법봉 (공격력: 20, 가격: 250골드)");
        } else if (hero instanceof Characters.Archer) {
            System.out.println("1. 짧은 활 (공격력: 8, 가격: 90골드)");
            System.out.println("2. 강철 활 (공격력: 18, 가격: 210골드)");
        }

        System.out.println("3. 무기 강화 (비용: 50골드)");
    }

    public void buyWeapon(int choice, Characters.Hero hero) {
        Characters.Weapon selected = null;
        int price = 0;

        if (hero instanceof Characters.Warrior) {
            if (choice == 1) {
                selected = new Characters.Weapon("청동검", 10);
                price = 100;
            } else if (choice == 2) {
                selected = new Characters.Weapon("강철검", 15);
                price = 200;
            }
        } else if (hero instanceof Characters.Mage) {
            if (choice == 1) {
                selected = new Characters.Weapon("나무 지팡이", 10);
                price = 120;
            } else if (choice == 2) {
                selected = new Characters.Weapon("마법봉", 20);
                price = 250;
            }
        } else if (hero instanceof Characters.Archer) {
            if (choice == 1) {
                selected = new Characters.Weapon("짧은 활", 8);
                price = 90;
            } else if (choice == 2) {
                selected = new Characters.Weapon("강철 활", 18);
                price = 210;
            }
        }

        if (choice == 3) {
            Characters.Weapon weapon = hero.getWeapon();
            if (weapon == null) {
                System.out.println("장착한 무기가 없습니다.");
                return;
            }
            if (hero.getMoney() >= 50) {
                hero.addMoney(-50);
                weapon.enhance();
            } else {
                System.out.println("골드가 부족하여 강화할 수 없습니다.");
            }
            return;
        }

        if (selected != null) {
            if (hero.getMoney() >= price) {
                hero.addMoney(-price);
                hero.equipWeapon(selected);
                System.out.println(selected.getName() + " 무기를 구매하여 장착했습니다. (" + price + "골드 소모)");
            } else {
                System.out.println("골드가 부족하여 무기를 구매할 수 없습니다.");
            }
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }
}
