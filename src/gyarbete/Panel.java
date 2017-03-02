package gyarbete;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{
    //Double buffering
    private Image dbImage;
    private Graphics dbg;
    //Jpanel variables
    static final int GWIDTH = 480, GHEIGHT = 480;
    static final Dimension gameDim = new Dimension(GWIDTH, GHEIGHT);
    //Game variables
    private Thread game;
    private volatile boolean running = false;

    //Game objects
    World world;

    public Panel(){
        world =  new World();
        setPreferredSize(gameDim);
        setBackground(Color.WHITE);
        setFocusable(true);
        requestFocus();
        //handle all key inputs from user
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_A){

                }
                if (e.getKeyCode() == KeyEvent.VK_D){

                }

            }
            @Override
            public void keyReleased(KeyEvent e){

            }
            @Override
            public void keyTyped(KeyEvent e){

            }
        });
    }

    public void run(){
        while(running){

            gameUpdate();
            gameRender();
            paintScreen();

        }
    }

    private void gameUpdate(){
        if(running && game != null){
            //update gamestate
        }
    }

    private void gameRender(){
        if(dbImage == null){ //Create the buffer
            dbImage = createImage(GWIDTH, GHEIGHT);
            if(dbImage == null){
                System.out.println("dbImage is still null!");
                return;
            }else{
                dbg = dbImage.getGraphics();
            }
        }
        //Clear the screen
        dbg.setColor(Color.WHITE);
        dbg.fillRect(0, 0, GWIDTH, GHEIGHT);
        //Draw game elements
        draw(dbg);
    }

    /* Draw all game content in this method */
    public void draw(Graphics g){
        world.draw(g);
    }

    private void paintScreen(){
        Graphics g;
        try{
            g = this.getGraphics();
            if(dbImage != null && g != null){
                g.drawImage(dbImage, 0, 0, null);
            }
            Toolkit.getDefaultToolkit().sync(); //For some operating systems
            g.dispose();
        }catch (Exception e){
            System.err.println(e);
        }
    }

    public void addNotify(){
        super.addNotify();
        startGame();
    }

    private void startGame(){
        if(game == null || !running){
            game = new Thread(this);
            game.start();
            running = true;
        }
    }

    public void stopGame(){
        if(running){
            running = false;
        }
    }

    private void log(String s){
        System.out.println(s);
    }
}
