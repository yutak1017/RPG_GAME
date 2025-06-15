package Characters;

public class Archer extends Hero {
    public Archer(String name) {
        super(name, 1, 70, 30, 13, 15);
    }

 
    public int attack() {
        return level * 8 + power * 2;
    }

    public int skillAttack(int choice) {
        if (choice == 2 && mp >= 10) {
            useMp(10);
            System.out.println("[스킬] 화살비! (MP 10 소모)");
            return attack() + 15;
        } else if (choice == 3 && level >= 3 && mp >= 20) {
            useMp(20);
            System.out.println("[스킬] 저격! (MP 20 소모, 레벨 3 이상)");
            return attack() + 35;
        } else {
            System.out.println("MP 부족 또는 조건 미달 - 일반 공격 발동");
            return attack();
        }
    }
}
