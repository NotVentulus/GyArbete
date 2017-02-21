package gyarbete;

import javax.swing.*;
import java.awt.*;

public class World {

    private Rectangle[] blocks;
    private Image[] blockImg;
    private final int arrayNum = 225;
    //Block images
    private Image WALL, BACKGROUND, GOAL;

    private int x, y;

    public World(){
        WALL = new ImageIcon("C:/Users/svos14/IdeaProjects/GyArbete/images/wall.png").getImage();
        BACKGROUND = new ImageIcon("C:/Users/svos14/IdeaProjects/GyArbete/images/background.png").getImage();
        GOAL = new ImageIcon("C:/Users/svos14/IdeaProjects/GyArbete/images/goal.png").getImage();
        blocks = new Rectangle[225];
        blockImg = new Image[225];
    }

    private void loadArrays(){
        for(int i = 0; i < arrayNum; i++){
            if(x >= 225){
                x = 0;
                y += 15;
            }
            if(i >= 0 && i < 15){
                blockImg[i] = WALL;
                blocks[i] = new Rectangle(x, y, 32, 32);
            }


            x += 15;
        }
    }

}
