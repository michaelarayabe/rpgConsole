import java.util.Scanner;

public class GameEngine {
    private Player player;
    private Scanner scanner;

    public GameEngine(){
        scanner = new Scanner(System.in);
    }

    public void startGame(){
        System.out.println("Welcome to RPG console game");
        System.out.println("1. New Game");
        System.out.println("2. Load Game");
        System.out.println("Choose an option: ");
        int option = scanner.nextInt();

        scanner.nextLine();

        if(option == 2){
            player = GameFileHandler.loadGame();
            if(player == null){
                System.out.println("Starting new game instead. ");
                createNewPlayer();
            }
        } else {
            createNewPlayer();
        }

        boolean running = true;
        while (running){
            System.out.println("Choose an action: ");
            System.out.println("1. Explore");
            System.out.println("2. Check stats");
            System.out.println("3. Save Game");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> explore();
                case 2 -> checkStats();
                case 3 -> GameFileHandler.saveGame(player);
                case 4 -> {
                    System.out.println("Good bye");
                    running = false;
                }
                default -> System.out.println("Invalid input, try again");
            }
        }
    }

    private void createNewPlayer() {
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        player = new Player(name);
    }

    private Monster generateRandomMonster(){
        String[] monsterNames = {"Goblin", "Orc", "Skeleton"};
        String name = monsterNames[(int) (Math.random() * monsterNames.length)];
        int health = (int) (Math.random() * 20) + 30;
        int attack = (int) (Math.random()*5) + 5;
        return new Monster(name, health, attack);
    }

    private void checkStats() {
        System.out.println("\nPlayer stats: ");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Attack: " + player.getAttack());
        System.out.println("Defense: " + player.getDefense());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Experience: " + player.getExperience());
    }

    private void explore() {
        System.out.println("You are walking into the wild");
        if(Math.random() < 0.5){
            System.out.println("A monster appears!");
            Monster monster = generateRandomMonster();
            battel(monster);
        } else {
            System.out.println("The area is peaceful. Enjoy while it last");
        }
    }

    private void battel(Monster monster){
        System.out.println("You are fighting a " + monster.getName() + "!");
        while(!monster.isDefeated() && player.getHealth() > 0){
            System.out.println("1. Attack 2. Heal");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> {
                    monster.takeDamage(player.getAttack());
                    System.out.println("You deal " + player.getAttack() + " damage!");
                }
                case 2 -> {
                    player.heal(10);
                    System.out.println("You healed for 10 health");
                }
                default -> System.out.println("Invalid action");
            }

            if(!monster.isDefeated()){
                player.takeDamage(monster.getAttack());
                System.out.println("The " + monster.getName() + " hit you for " + monster.getAttack() + " damage!");
            }
        }

        if(monster.isDefeated()){
            System.out.println("You defeated the " + monster.getName() + "!");
            player.gainExperience(10);
        } else {
            System.out.println("You were defeated");
        }
    }

    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.startGame();
    }

}
