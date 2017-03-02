package gyarbete;

import javax.swing.*;
import java.awt.*;

public class World {

    private Rectangle[] blocks;
    private Image[] blockImg;
    private final int arrayNum = 225;
    //Block images
    //private Image WALL, BACKGROUND, GOAL;
    private Image[] Tiles;

    private int x, y;

    public World(){
        //WALL = new ImageIcon("images/wall.png").getImage();
        //BACKGROUND = new ImageIcon("images/background.png").getImage();
        //GOAL = new ImageIcon("images/goal.png").getImage();
        Tiles = new Image[4];
        Tiles[0] = new ImageIcon("images/background.png").getImage();
        Tiles[1] = new ImageIcon("images/wall.png").getImage();
        Tiles[2] = new ImageIcon("images/goal.png").getImage();
        Tiles[3] = new ImageIcon("images/player.png").getImage();
        blocks = new Rectangle[225];
        blockImg = new Image[225];

        loadArrays();
    }

    int[] map = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,0,0,0,0,0,0,0,1,0,0,0,1,
            1,3,0,0,0,0,0,0,1,0,0,0,1,0,1,
            1,1,1,1,0,1,1,0,1,1,1,0,0,0,1,
            1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,
            1,0,0,0,0,1,0,0,0,2,0,1,0,0,1,
            1,0,0,1,0,0,1,1,0,0,0,1,0,0,1,
            1,0,0,0,1,0,0,0,0,1,0,0,1,0,1,
            1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,
            1,0,0,1,0,1,0,0,0,1,1,0,1,0,1,
            1,0,0,1,0,1,0,0,0,0,0,0,1,0,1,
            1,0,0,1,0,1,0,0,1,0,1,1,1,0,1,
            1,0,0,1,0,1,0,0,1,0,0,0,0,0,1,
            1,1,0,0,0,1,0,0,0,0,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

    public void loadArrays() {
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < 225; i++){
            int tilenr = map[i];
            blockImg[i] = Tiles[tilenr];
            blocks[i] = new Rectangle(x,y,32,32);
            x+=32;
            if (x > 32*14){
                y+=32;
                x=0;
            }
        //for (int i = 0 ; i < 16 ; i++) {
            //if (map[i] == 0) {
            //    blockImg[i] = BACKGROUND;
            //} else if (map[i] == 1) {
            //    blockImg[i] = WALL;
            //} else if (map[i] == 2) {
            //    blockImg[i] = GOAL;
            //} //else {
                // 3 motsvarar spelaren så spelpjäsen ska in på den positionen
            //}
        }
        // Mera kod som tar hand om arrayen block till exempel
    }

    public void draw(Graphics g){
        for(int i = 0; i < arrayNum; i++){
            g.drawImage(blockImg[i], blocks[i].x, blocks[i].y, null);
        }
    }

}
