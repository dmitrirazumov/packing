import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class Visualisation extends JPanel {

    static void createFrame(int WidthStrip, int HeightStrip, ArrayList<Types.Rectangle> rectangles) {

        Random rand = new Random();

        JFrame frame = new JFrame("Draw Rectangles");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        while (RecursPacking.Height < 1200) {
            for (Types.Rectangle element : rectangles) {
                frame.add(new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));

                        double x = element.getX();
                        double y = element.getY();
                        double width = element.getW();
                        double height = element.getH();

                        g2.fill(new Rectangle2D.Double(x, y, width, height));

//                        if (rectangles.indexOf(element) == 3) g2.fill(new Rectangle2D.Double(250, 420, 50, 20));
//                        if (rectangles.indexOf(element) == 4) g2.fill(new Rectangle2D.Double(340, 340, 10, 80));
//                        if (rectangles.indexOf(element) == 5) g2.fill(new Rectangle2D.Double(300, 420, 50, 20));

                        Font font = new Font("Arial", Font.BOLD, 12);
                        g2.setFont(font);
                        g2.setColor(Color.BLACK);
                        g2.drawString(Integer.toString(element.getId()), element.getX() + element.getW() / 2, element.getY() + element.getH() / 2);
                    }
                });

                frame.pack();
                frame.setSize(new Dimension(WidthStrip, HeightStrip));
                frame.setVisible(true);
            }
        }
//    }
}

