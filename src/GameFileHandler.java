import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class GameFileHandler {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveGame(Player player, String fileName) {
        try(Writer writer = new FileWriter(fileName)) {
            gson.toJson(player, writer);
            System.out.println("Game saved successfully to " + fileName + "!");

        } catch (IOException e){
            System.out.println("Error saving the game: " + e.getMessage());
        }
    }

    public static Player loadGame(String fileName) {
        try(Reader reader = new FileReader(fileName)){
            Player player = gson.fromJson(reader, Player.class);
            System.out.println("Game loaded successfully from " + fileName + "!");
            return player;
        } catch (FileNotFoundException e){
            System.out.println("No saved game found with filename: " + fileName);

        } catch (IOException e){
            System.out.println("Error loading the game: " + e.getMessage());
        }
        return null;
    }
}
