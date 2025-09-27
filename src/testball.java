import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class testball extends JFrame {
    private ControlWindow cw = new ControlWindow();

    public Main() {
        this.add(cw);
        this.pack();
        this.setTitle("Pong");
        this.setSize(Consts.WIDTH, Consts.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
class ControlWindow extends JPanel implements ActionListener {
    private Ball ball= new Ball(Consts.WIDTH/2, Consts.HEIGHT/2, 30);
    private Timer timer = new Timer(8, this);

    @Override public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(ball.x, ball.y, ball.bk, ball.bk);
    }

    @Override public void actionPerformed(ActionEvent e) {
        ball.x += ball.speedX;
        ball.y += ball.speedY;
        if(ball.x >= Consts.WIDTH - 2 * ball.bk) {
            ball.speedX *= -1;
        }
        if(ball.y >= Consts.HEIGHT - 2 * ball.bk) {
            ball.speedY *= -1;
        }
        if(ball.x <= 0) {
            ball.speedX *= -1;
        }
        if(ball.y <= 0) {
            ball.speedY *= -1;
        }
        repaint();
    }

    public ControlWindow() {
        timer.start();
        this.setBackground(Color.BLACK);
    }
}

class Ball {
    public int x,y,bk;
    public int speedX = 5;
    public int speedY = 5;

    public Ball(int x, int y, int bk) {
        this.x = x;
        this.y = y;
        this.bk = bk;
    }
}

class Consts {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 550;
}
