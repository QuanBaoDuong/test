import javax.swing.*;
import java.awt.*;

public class Jframe {
    private JFrame frame;
    private JButton button;
    private JLabel background;
    private ImageIcon image;
    private ImageIcon icon;

    Jframe() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame("Arkanoid");
        frame.setSize(1500,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        image = new ImageIcon("gamemenu.jpg");
        background = new JLabel(image);
        frame.setContentPane(background);

        background.setLayout(null);

        addButton("NEW GAME",250,200);
        addButton("LOAD GAME",250,260);
        addButton("HISCORES",250,320);
        addButton("INSTRUCTION",250,380);
        addButton("    OPTION",250,440);
        addButton("      QUIT",250,500);


        frame.setVisible(true);

    }
    private void addButton (String text , int x , int y) {
        icon = new ImageIcon("buttongame.png");
        Image scaleding = icon.getImage().getScaledInstance(120,60, Image.SCALE_SMOOTH);
        ImageIcon scaled = new ImageIcon(scaleding);
        button = new JButton(scaled);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setBounds(x,y,scaled.getIconWidth(),scaled.getIconHeight());

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial",Font.BOLD,15));
        label.setForeground(Color.CYAN);
        label.setBounds(button.getX()+15,button.getY()+25,button.getWidth(), 30);

        frame.add(button);
        frame.getLayeredPane().add(label,JLayeredPane.PALETTE_LAYER);


    }

    public static void main(String[] args) {

        new Jframe();

    }
}
