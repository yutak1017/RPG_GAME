package Characters;

public class Warrior extends Hero {
    public Warrior(String name) {
        super(name, 1, 80, 0, 15, 25);
    }

    public int attack() {
        return level * 10 + power * 3;
    }

    public int skillAttack(int choice) {
        if (choice == 2 && mp >= 15) {
            useMp(15);
            System.out.println("[스킬] 회전베기 사용! (MP 15 소모)");
            return attack() + 20;
        } else if (choice == 3 && level >= 3 && mp >= 30) {
            useMp(30);
            System.out.println("[스킬] 지면 강타! (MP 30 소모, 레벨 3 이상)");
            return attack() + 50;
        } else {
            System.out.println("MP 부족 또는 조건 미달 - 일반 공격 발동");
            return attack();
        }
    }
}
