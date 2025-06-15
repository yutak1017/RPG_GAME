package Characters;

public class Weapon {
    private String name;
    private int basePower;
    private int enhancementLevel;
    private int enhancementCost;

    public Weapon(String name, int basePower) {
        this.name = name;
        this.basePower = basePower;
        this.enhancementLevel = 0;
        this.enhancementCost = 50; 
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return basePower + enhancementLevel * 5;
    }

    public int getEnhancementLevel() {
        return enhancementLevel;
    }

    public int getEnhancementCost() {
        return enhancementCost;
    }

    public void enhance() {
        enhancementLevel++;
        enhancementCost += 30; 
        System.out.println("무기 강화 성공! 현재 강화 수치: +" + enhancementLevel);
    }
}
