package Exercise1_3;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <h1>Bouncing Balls</h1>
 *
 * @author  Miguel Emmara - 18022146
 */
public class BouncingBalls extends JPanel {
    public final int PANEL_WIDTH = 500;
    public final int PANEL_HEIGHT = 500;
    private DrawingPanel drawPanel;
    private Timer timer;
    private ArrayList<Ball> balls;
    private ArrayList<Thread> threads;

    public int counter;
    public JButton addBtn, add10Btn, add100Btn, rmvBtn, rmv10Btn, rmvAllBtn;
    public JButton pause1Btn, resumeBtn;
    public JPanel ballButtonsPanel;
    private ExecutorService threadExecutor;

    public BouncingBalls() {
        super(new BorderLayout());
        balls = new ArrayList<>();
        threads = new ArrayList<>();
        threadExecutor = Executors.newCachedThreadPool();
        counter = 0;

        this.drawPanel = new DrawingPanel();
        this.add(drawPanel, BorderLayout.CENTER);

        ballButtonsPanel = new JPanel(new GridLayout(3,3));
        this.add(ballButtonsPanel, BorderLayout.SOUTH);

        addBtn = new JButton("Add a Ball");
        addBtn.addActionListener(action -> {
            this.addBall();
        });
        ballButtonsPanel.add(addBtn);

        add10Btn = new JButton("Add 10 Balls");
        add10Btn.addActionListener(action -> {
            this.addMultipleBalls(10);
        });
        ballButtonsPanel.add(add10Btn);

        add100Btn = new JButton("Add 100 Balls");
        add100Btn.addActionListener(action -> {
            this.addMultipleBalls(100);
        });
        ballButtonsPanel.add(add100Btn);

        rmvBtn = new JButton("Remove a Ball");
        rmvBtn.addActionListener(action -> {
            this.removeBall();
        });
        ballButtonsPanel.add(rmvBtn);

        rmv10Btn = new JButton("Remove 10 Balls");
        rmv10Btn.addActionListener(action -> {
            this.removeMultipleBalls(10);
        });
        ballButtonsPanel.add(rmv10Btn);

        rmvAllBtn = new JButton("Remove All Balls");
        rmvAllBtn.addActionListener(action -> {
            this.removeAllBalls();
        });
        ballButtonsPanel.add(rmvAllBtn);

        pause1Btn = new JButton("Freeze");
        pause1Btn.addActionListener(action -> {
            this.timer.stop();
        }); // Freezes current movements.
        ballButtonsPanel.add(pause1Btn);

        resumeBtn = new JButton("Play");
        resumeBtn.addActionListener(action -> {
            this.timer.start();
        }); // Resumes frozen movements.
        ballButtonsPanel.add(resumeBtn);

        resumeBtn = new JButton("Exit");
        resumeBtn.addActionListener(action -> {
            this.exitApp();
        }); // Resumes frozen movements.
        ballButtonsPanel.add(resumeBtn);

        timer = new Timer(10, execute -> {
            balls.forEach((ball) -> ball.move());
            this.drawPanel.repaint();
        });
        timer.start();

    }

    private void exitApp() {
        System.exit(0);
    }

    private void removeBall() {
        if (balls.size() == 0) {
            JOptionPane.showMessageDialog(null, "There is no ball to be removed!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            if (counter == balls.size()) {
                counter--;
            }

            threads.remove(counter);
            balls.remove(counter--);
            drawPanel.repaint();
        }
    }

    private void removeAllBalls() {
        if (balls.size() == 0) {
            JOptionPane.showMessageDialog(null, "There is no ball to be removed!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }

        threads.removeAll(this.threads);
        balls.removeAll(this.balls);
        this.counter = 0;
        this.drawPanel.repaint();
    }

    private void removeMultipleBalls(int i) {
        if (balls.size() == 0) {
            JOptionPane.showMessageDialog(null, "There is no ball to be removed!",
                    "Error!", JOptionPane.ERROR_MESSAGE);
        }

        if (i > balls.size()) {
            threads.removeAll(threads);
            balls.removeAll(balls);
            counter = 0;
        } else  {
            if (counter == balls.size()) {
                counter--;
            }

            for (int j = 0; j < i; j++) {
                threads.remove(counter);
                balls.remove(counter--);
            }

            if(counter < 0)
                counter = 0;
        }

        drawPanel.repaint();
    }

    private void addMultipleBalls(int i) {
        for (int j = 0; j < i; j++) {
            balls.add(new Ball());
            threadExecutor.execute( balls.get(balls.size() - 1) );
            threads.add(new Thread(balls.get(counter)));
            drawPanel.repaint();
            counter++;
        }

        System.out.println(Thread.activeCount());
    }

    private void addBall() {
        balls.add(new Ball());
        threads.add(new Thread(balls.get(counter)));
        drawPanel.repaint();
        counter++;
    }

    //separate inner class for graphics
    private class DrawingPanel extends JPanel {
        public DrawingPanel() {
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            setBackground(Color.BLUE);
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for (Ball ball : balls) {
                ball.draw(g);
            }
        }
    }

    public static void main(String[] args) {
        BouncingBalls myPanel = new BouncingBalls();
        JFrame frame = new JFrame("Exercise 1.3 (Bouncing Balls)");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(myPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

