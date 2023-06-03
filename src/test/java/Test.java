import com.scavable.objects.GameTile;
import com.scavable.util.Configuration;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        GameTile gameTile = new GameTile("Test");
        LinkedList<GameTile> gameTiles = new LinkedList<>();
        gameTiles.add(gameTile);
        Configuration.setGames(gameTiles);
        System.out.println(Configuration.getGames());
        System.out.println(Configuration.getGamesMap());
    }
}
