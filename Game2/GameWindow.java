package Game2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static GameWindow gameWindow;
    private static Image background;
    private static Image game_over;
    private static Image item1;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        item1 = ImageIO.read(GameWindow.class.getResourceAsStream("utyg.png"));
        gameWindow = new GameWindow();
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocation(200,100);
        gameWindow.setSize(907,479);
        gameWindow.setResizable(false);
        GameField game_field = new GameField();
        gameWindow.add(game_field);
        gameWindow.setVisible(true);
    }

    private static void onRepaint(Graphics g){
        g.drawImage(background, 0,0,null);
        g.drawImage(item1, 100, 100, null);
        g.drawImage(game_over, 280, 120, null);
        g.drawLine(10,110,907,110);
    }

    private static class GameField extends JPanel{

        @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
            onRepaint(g);
        }
    }
}
