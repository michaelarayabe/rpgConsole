import java.io.*;
import java.util.List;

public class GameFileHandler {
    private static final String SAVE_FILE = "savegame.txt";

    public static void saveGame(Player player) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))){
            writer.write(player.getName() + "\n");
            writer.write(player.getHealth() + "\n");
            writer.write(player.getMaxHealth() + "\n");
            writer.write(player.getAttack() + "\n");
            writer.write(player.getDefense() + "\n");
            writer.write(player.getLevel() + "\n");
            writer.write(player.getExperience() + "\n");

            List<String> inventory = player.getInventory();
            writer.write(String.join(",", inventory) + "\n");

            System.out.println("Game saved successfully");
        } catch (IOException e){
            System.out.println("Error saving game" + e.getMessage());
        }
    }

    public static Player loadGame() {
        try(BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))){
            String name = reader.readLine();
            int health = Integer.parseInt(reader.readLine());
            int maxHealth = Integer.parseInt(reader.readLine());
            int attack = Integer.parseInt(reader.readLine());
            int defense = Integer.parseInt(reader.readLine());
            int level = Integer.parseInt(reader.readLine());
            int experience = Integer.parseInt(reader.readLine());

            String[] inventoryItems = reader.readLine().split(",");
            Player player = new Player(name);
            player.setHealth(health);
            player.setMaxHealth(maxHealth);
            player.setAttack(attack);
            player.setDefense(defense);
            player.setLevel(level);
            player.setExperience(experience);

            for (String item : inventoryItems){
                if(!item.isEmpty()){
                    player.addToInventory(item);
                }
            }

            System.out.println("Game loaded successfully");
            return player;
        } catch (FileNotFoundException e){
            System.out.println("No saved game found.");
        } catch (IOException | NumberFormatException e){
            System.out.println("Error loading the game: " + e.getMessage());
        }

        return null;
    }
}
