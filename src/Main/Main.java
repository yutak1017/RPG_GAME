package Main;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("영웅의 이름을 입력하세요: ");
        String name = scanner.nextLine();

        Characters.Hero hero = chooseJob(scanner, name);
        Map.Mission mission = new Map.Mission();
        Map.PotionStore potionStore = new Map.PotionStore();
        Map.WeaponStore weaponStore = new Map.WeaponStore();

        while (true) {
            System.out.println("\n===== 메인 메뉴 =====");
            System.out.println("1. 상태 보기");
            System.out.println("2. 포션 상점");
            System.out.println("3. 무기 상점 및 강화");
            System.out.println("4. 사냥터 (미션 포함)");
            System.out.println("0. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printStatus(hero);
                    break;
                case 2:
                    potionStore.showMenu(hero);
                    System.out.print("아이템 번호 선택: ");
                    int p = scanner.nextInt();
                    potionStore.buyPotion(p, hero);
                    break;
                case 3:
                    weaponStore.showWeapons(hero);
                    System.out.print("무기 번호 또는 강화 선택: ");
                    int w = scanner.nextInt();
                    weaponStore.buyWeapon(w, hero);
                    break;
                case 4:
                    mission.checkAndStartMission(hero);  // 미션 확인 먼저 출력
                    huntMonster(scanner, hero, mission);
                    break;
                case 0:
                    System.out.println("게임을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static Characters.Hero chooseJob(java.util.Scanner scanner, String name) {
        System.out.println("직업을 선택하세요:");
        System.out.println("1. 전사  2. 마법사  3. 궁수");
        int job = scanner.nextInt();
        scanner.nextLine();

        switch (job) {
            case 1: return new Characters.Warrior(name);
            case 2: return new Characters.Mage(name);
            case 3: return new Characters.Archer(name);
            default:
                System.out.println("잘못된 선택입니다. 기본값으로 전사 선택.");
                return new Characters.Warrior(name);
        }
    }

    public static void printStatus(Characters.Hero hero) {
        System.out.println("--- 현재 상태 ---");
        System.out.println("이름: " + hero.getName());
        System.out.println("레벨: " + hero.getLevel());
        System.out.println("HP: " + hero.getHp());
        System.out.println("MP: " + hero.getMp());
        System.out.println("공격력: " + hero.getPower());
        System.out.println("방어력: " + hero.getDefense());
        System.out.println("경험치: " + hero.getExperience());
        System.out.println("골드: " + hero.getMoney());
        if (hero.getWeapon() != null) {
            System.out.println("무기: " + hero.getWeapon().getName() + " (공격력: " + hero.getWeapon().getPower() + ", 강화: +" + hero.getWeapon().getEnhancementLevel() + ")");
        } else {
            System.out.println("무기: 없음");
        }
    }

    public static void huntMonster(java.util.Scanner scanner, Characters.Hero hero, Map.Mission mission) {
        System.out.println("=== 사냥할 몬스터 선택 ===");
        System.out.println("1. 너구리  2. 살쾡이  3. 늑대  4. 곰");
        int m = scanner.nextInt();

        Characters.Monster monster = null;
        switch (m) {
            case 1: monster = new Characters.Raccoon(); break;
            case 2: monster = new Characters.Slime(); break;
            case 3: monster = new Characters.Wolf(); break;
            case 4: monster = new Characters.Bear(); break;
            default:
                System.out.println("잘못된 몬스터 선택입니다.");
                return;
        }

        System.out.println(monster.getName() + "와 전투를 시작합니다!");

        while (monster.getHp() > 0 && hero.getHp() > 0) {
            System.out.println("\n공격을 선택하세요:");
            if (hero instanceof Characters.Warrior) {
                System.out.println("1. 기본 공격");
                System.out.println("2. 회전베기 (MP 15)");
                System.out.println("3. 지면 강타 (레벨 3 이상, MP 30)");
            } else if (hero instanceof Characters.Mage) {
                System.out.println("1. 기본 공격");
                System.out.println("2. 파이어볼 (MP 20)");
                System.out.println("3. 라이트닝 스트라이크 (레벨 3 이상, MP 35)");
            } else if (hero instanceof Characters.Archer) {
                System.out.println("1. 기본 공격");
                System.out.println("2. 화살비 (MP 10)");
                System.out.println("3. 저격 (레벨 3 이상, MP 20)");
            }

            int action = scanner.nextInt();

            int heroDmg = 0;
            if (hero instanceof Characters.Warrior) {
                heroDmg = ((Characters.Warrior) hero).skillAttack(action);
            } else if (hero instanceof Characters.Mage) {
                heroDmg = ((Characters.Mage) hero).skillAttack(action);
            } else if (hero instanceof Characters.Archer) {
                heroDmg = ((Characters.Archer) hero).skillAttack(action);
            } else {
                heroDmg = hero.attack();
            }

            monster.attacked(heroDmg);

            if (monster.getHp() <= 0) {
                System.out.println("몬스터 처치! 경험치 +" + monster.getExperience());
                hero.addExperience(monster.getExperience());
                hero.addMoney(monster.getMoney());
                mission.completeMission(hero, monster.getName());  // 보상 지급
                break;
            }

            int monsterDmg = monster.attack();
            hero.attacked(monsterDmg);

            if (hero.getHp() <= 0) {
                System.out.println("당신은 쓰러졌습니다... 게임 오버");
                return;
            }
        }
    }
}
