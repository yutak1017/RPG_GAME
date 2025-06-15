package Characters;

public class Mage extends Hero {
    public Mage(String name) {
        super(name, 1, 60, 60, 18, 10);
    }

    public int attack() {
        return level * 5 + power * 2;
    }

    public int skillAttack(int choice) {
        if (choice == 2 && mp >= 20) {
            useMp(20);
            System.out.println("[스킬] 파이어볼 발사! (MP 20 소모)");
            return attack() + 30;
        } else if (choice == 3 && level >= 3 && mp >= 40) {
            useMp(40);
            System.out.println("[스킬] 메테오 스트라이크! (MP 40 소모, 레벨 3 이상)");
            return attack() + 60;
        } else {
            System.out.println("MP 부족 또는 조건 미달 - 기본 공격 발동");
            return attack();
        }
    }
}
