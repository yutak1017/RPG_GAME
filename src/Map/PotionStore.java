package Map;

public class PotionStore {
    public void showMenu(Characters.Hero hero) {
        System.out.println("[포션 상점]");
        System.out.println("1. 불굴의 포션 (공격력 +5) - 30골드");
        System.out.println("2. 강철의 포션 (HP +50) - 40골드");
        System.out.println("3. 마력의 포션 (MP +30) - 25골드");
        System.out.println("현재 보유 골드: " + hero.getMoney());
    }

    public void buyPotion(int choice, Characters.Hero hero) {
        int before = hero.getMoney();
        switch (choice) {
            case 1:
                if (before >= 30) {
                    hero.addMoney(-30);
                    hero.addPower(5);
                    System.out.println("불굴의 포션 사용! Power +5");
                } else {
                    System.out.println("골드가 부족합니다.");
                    return;
                }
                break;
            case 2:
                if (before >= 40) {
                    hero.addMoney(-40);
                    hero.recoverHp(50);
                    System.out.println("강철의 포션 사용! HP +50");
                } else {
                    System.out.println("골드가 부족합니다.");
                    return;
                }
                break;
            case 3:
                if (before >= 25) {
                    hero.addMoney(-25);
                    hero.useMp(-30);
                    System.out.println("마력의 포션 사용! MP +30");
                } else {
                    System.out.println("골드가 부족합니다.");
                    return;
                }
                break;
            default:
                System.out.println("잘못된 선택입니다.");
                return;
        }
        System.out.println("[골드 변화] 구매 전: " + before + " → 구매 후: " + hero.getMoney());
    }
}
