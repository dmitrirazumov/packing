import javafx.util.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {

        int HeightStrip;
        ArrayList<Types.Rectangle> rectangles;

        int WidthStrip = 500;

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            boxes.add(new Types.CoupleWH(300, 300));
        }

        for (int i = 0; i < 8; i++) {
            boxes.add(new Types.CoupleWH(100, 80));
        }

        for (int i = 0; i < 6; i++) {
            boxes.add(new Types.CoupleWH(200, 100));
        }



        Types.Result result = new RecursPacking().spprg(WidthStrip, boxes, "width");
        HeightStrip = result.getHeightStrip();
        rectangles = result.getRectangles();

        System.out.println(HeightStrip);

        Visualisation.createFrame(WidthStrip, HeightStrip, rectangles);
    }
}
