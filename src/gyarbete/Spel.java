package gyarbete;

import javax.swing.JFrame;

public class Spel extends JFrame {

    Panel gp;

    public Spel() {
        gp = new Panel();
        setTitle("Game");
        setSize(480, 480);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gp);
    }

    public static void main(String[] args){
        Spel test = new Spel();
    }
}

