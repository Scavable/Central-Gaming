import com.scavable.gui.LauncherFrame;
import com.scavable.objects.GameTile;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        LauncherFrame.getInstance().setVisible(true);
        System.out.println(new GameTile());
        System.out.println(new GameTile("Game 1", 100, 4, ImageIO.read(LauncherFrame.class.getResource("/Images/defaultImage.jpg"))));
    }
}
