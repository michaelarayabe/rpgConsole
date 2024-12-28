import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int level;
    private int experience;
    private List<String> inventory;

    public Player(String name){
        this.name = name;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.attack = 10;
        this.defense = 5;
        this.level = 1;
        this.experience = 0;
        this.inventory = new ArrayList<>();
    }

    public void takeDamage(int damage){
        health -= Math.max(0, damage - defense);
        if(health < 0) health = 0;
    }

    public void gainExperience(int xp){
        experience += xp;
        while(experience >= level * 10) {
            experience -= level * 10;
            levelUp();
        }
    }

    private void levelUp() {
        level++;
        maxHealth += 10;
        attack += 2;
        defense += 1;
        health = maxHealth;
        System.out.println("You leveled up to level " + level + "!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
    }

    public void heal(int amount) {
        health += amount;
        if(health > maxHealth){
            health = maxHealth;
        }
        System.out.println(name + " healed for " + amount + " health points. Current health: " + health);
    }
}
