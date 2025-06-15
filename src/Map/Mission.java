package Map;

public class Mission {
    private boolean raccoonDefeated = false;
    private boolean slimeDefeated = false;
    private boolean wolfDefeated = false;
    private boolean bearDefeated = false;

    public void checkAndStartMission(Characters.Hero hero) {
        System.out.println("--- 현재 수행 가능한 레벨 미션 ---");
        System.out.println("----------------------------------");

        if (hero.getLevel() >= 2 && !raccoonDefeated) {
            System.out.println("[레벨 미션] 너구리를 처치하세요! (보상: 50골드)");
        }
        if (hero.getLevel() >= 3 && !slimeDefeated) {
            System.out.println("[레벨 미션] 살쾡이를 처치하세요! (보상: 70골드)");
        }
        if (hero.getLevel() >= 4 && !wolfDefeated) {
            System.out.println("[레벨 미션] 늑대를 처치하세요! (보상: 100골드)");
        }
        if (hero.getLevel() >= 5 && !bearDefeated) {
            System.out.println("[레벨 미션] 곰을 처치하세요! (보상: 150골드)");
        }
    }


    public void completeMission(Characters.Hero hero, String monsterName) {
        if (monsterName.equals("너구리") && !raccoonDefeated && hero.getLevel() >= 2) {
            raccoonDefeated = true;
            System.out.println("[미션 완료] 너구리를 처치했습니다! 보상으로 50골드를 획득합니다.");
            hero.addMoney(50);
        } else if (monsterName.equals("살쾡이") && !slimeDefeated && hero.getLevel() >= 3) {
            slimeDefeated = true;
            System.out.println("[미션 완료] 살쾡이를 처치했습니다! 보상으로 70골드를 획득합니다.");
            hero.addMoney(70);
        } else if (monsterName.equals("늑대") && !wolfDefeated && hero.getLevel() >= 4) {
            wolfDefeated = true;
            System.out.println("[미션 완료] 늑대를 처치했습니다! 보상으로 100골드를 획득합니다.");
            hero.addMoney(100);
        } else if (monsterName.equals("곰") && !bearDefeated && hero.getLevel() >= 5) {
            bearDefeated = true;
            System.out.println("[미션 완료] 곰을 처치했습니다! 보상으로 150골드를 획득합니다.");
            hero.addMoney(150);
        }
    }
}
