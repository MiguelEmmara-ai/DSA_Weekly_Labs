package Exercise1_3;

import java.awt.*;
import java.util.Random;

/**
 * <h1>Ball</h1>
 *
 * @author Miguel Emmara - 18022146
 */
public class Ball implements Runnable {
    public final int PANEL_WIDTH = 500;
    public final int PANEL_HEIGHT = 500;
    private final Random random;
    private int x, y, xMovement, yMovement, ballSize;
    private Color colour;
    private boolean stop;

    public Ball() {
        this.random = new Random();
        setBallSize(random.nextInt(100) + 5);
        setX(random.nextInt(getPANEL_WIDTH() / 2) + getBallSize());
        setY(random.nextInt(getPANEL_HEIGHT() / 2) + getBallSize());
        setxMovement(random.nextInt(20) - 10);
        setyMovement(random.nextInt(20) - 10);
        setColour(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

    }

    public int getPANEL_WIDTH() {
        return PANEL_WIDTH;
    }

    public int getPANEL_HEIGHT() {
        return PANEL_HEIGHT;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxMovement() {
        return xMovement;
    }

    public void setxMovement(int xMovement) {
        this.xMovement = xMovement;
    }

    public int getyMovement() {
        return yMovement;
    }

    public void setyMovement(int yMovement) {
        this.yMovement = yMovement;
    }

    public int getBallSize() {
        return ballSize;
    }

    public void setBallSize(int ballSize) {
        this.ballSize = ballSize;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public void draw(Graphics g) {
        g.setColor(this.getColour());
        g.fillOval(this.getX(), this.getY(), this.getBallSize(), this.getBallSize());
    }

    @Override
    public void run() {
        while (!stop) {
            move();

            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        // Move x and y coordinate to next position.
        this.setX(this.getX() + this.getxMovement());
        this.setY(this.getY() + this.getyMovement());

        // Check x and y if they are not outside world bounds, if so....
        if (this.getX() <= 0 || (this.getX() + (this.getBallSize())) >= (this.PANEL_WIDTH - 2)) {
            this.setxMovement(this.getxMovement() * -1);    // Invert movement.
        }

        if (this.getY() <= 0 || (this.getY() + (this.getBallSize())) >= (this.PANEL_HEIGHT - 2)) {
            this.setyMovement(this.getyMovement() * -1);    // Invert movement.
        }
    }
}

