public class Monster {
    private String name;
    private int health;
    private int attack;

    public Monster(String name, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public boolean isDefeated(){
        return health <= 0;
    }

    public void takeDamage(int damage){
        health -= damage;
        if(health < 0){
            health = 0;
        }

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }
}
