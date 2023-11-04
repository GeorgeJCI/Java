import javax.swing.*;

public class GameFrame  extends JFrame {
    // This class makes and sets options for the
    // window in which the game will run

    // GameFrame Constructor
    GameFrame(){

        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

}
