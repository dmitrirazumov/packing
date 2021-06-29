import java.util.ArrayList;
import java.util.Map;

public class Main {

    static long HeightStrip;

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();
        ArrayList<Types.Rectangle> rectangles;
        ArrayList<Types.Areas> emptyAreas;
        long WidthStrip = 340;
        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();
        double efficiency;

//        for (int i = 0; i < 5000; i++) {
//            boxes.add(new Types.CoupleWH(400, 400));
//        }
//
//        for (int i = 0; i < 6000; i++) {
//            boxes.add(new Types.CoupleWH(200, 100));
//        }
//
//        for (int i = 0; i < 5000; i++) {
//            boxes.add(new Types.CoupleWH(200, 200));
//        }
//
//        for (int i = 0; i < 6000; i++) {
//            boxes.add(new Types.CoupleWH(100, 100));
//        }
//
//        for (int i = 0; i < 13000; i++) {
//            boxes.add(new Types.CoupleWH(50, 50));
//        }
//
//        for (int i = 0; i < 30000; i++) {
//            boxes.add(new Types.CoupleWH(100, 50));
//        }
//
//        for (int i = 0; i < 5000; i++) {
//            boxes.add(new Types.CoupleWH(200, 300));
//        }
//
//        for (int i = 0; i < 20000; i++) {
//            boxes.add(new Types.CoupleWH(300, 250));
//        }
//
//        for (int i = 0; i < 5000; i++) {
//            boxes.add(new Types.CoupleWH(20, 40));
//        }
//
//        for (int i = 0; i < 5000; i++) {
//            boxes.add(new Types.CoupleWH(100, 200));
//        }

//        for (int i = 0; i < 50000; i++) {
//            boxes.add(new Types.CoupleWH(100, 200));
//        }
//        for (int i = 0; i < 50000; i++) {
//            boxes.add(new Types.CoupleWH(80, 200));
//        }

//        boxes.add(new Types.CoupleWH(250, 100));
//        boxes.add(new Types.CoupleWH(230, 100));
//        boxes.add(new Types.CoupleWH(60, 80));
//        boxes.add(new Types.CoupleWH(100, 50));
//        boxes.add(new Types.CoupleWH(20, 50));
//
//        boxes.add(new Types.CoupleWH(250, 50));
//        boxes.add(new Types.CoupleWH(250, 50));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));

//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(80, 200));
//        boxes.add(new Types.CoupleWH(80, 200));
//        boxes.add(new Types.CoupleWH(80, 200));
//        boxes.add(new Types.CoupleWH(80, 200));
//        boxes.add(new Types.CoupleWH(80, 200));
//        boxes.add(new Types.CoupleWH(80, 200));

//        boxes.add(new Types.CoupleWH(50, 30));
//        boxes.add(new Types.CoupleWH(50, 30));
//        boxes.add(new Types.CoupleWH(20, 40));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(100, 50));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));

//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(50, 20));
//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(100, 50));

//        //2 прямоуг в первой секции CHECK
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(50, 20));
//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(100, 50));
//        boxes.add(new Types.CoupleWH(150, 50));
//        boxes.add(new Types.CoupleWH(150, 50));

//        boxes.add(new Types.CoupleWH(50, 30));
//        boxes.add(new Types.CoupleWH(230, 80));
//        boxes.add(new Types.CoupleWH(230, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(80, 40));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));

//        boxes.add(new Types.CoupleWH(50, 30));
//        boxes.add(new Types.CoupleWH(50, 30));
//        boxes.add(new Types.CoupleWH(20, 40));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(100, 50));
//        boxes.add(new Types.CoupleWH(60, 40));
//        boxes.add(new Types.CoupleWH(10, 100));
//        boxes.add(new Types.CoupleWH(60, 40));
//        boxes.add(new Types.CoupleWH(10, 100));
//        boxes.add(new Types.CoupleWH(80, 40));
//        boxes.add(new Types.CoupleWH(60, 60));
//        boxes.add(new Types.CoupleWH(200, 140));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 100));

//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(100, 50));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(50, 30));
//        boxes.add(new Types.CoupleWH(50, 30));
//        boxes.add(new Types.CoupleWH(20, 40));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(100, 50));
//        boxes.add(new Types.CoupleWH(60, 40));
//        boxes.add(new Types.CoupleWH(10, 100));
//        boxes.add(new Types.CoupleWH(60, 40));
//        boxes.add(new Types.CoupleWH(10, 100));
//        boxes.add(new Types.CoupleWH(80, 40));
//        boxes.add(new Types.CoupleWH(60, 60));
//        boxes.add(new Types.CoupleWH(200, 140));
//        boxes.add(new Types.CoupleWH(50, 50));
//        boxes.add(new Types.CoupleWH(100, 200));

        boxes.add(new Types.CoupleWH(50, 150));
        boxes.add(new Types.CoupleWH(50, 150));
        boxes.add(new Types.CoupleWH(50, 140));
        boxes.add(new Types.CoupleWH(60, 130));
        boxes.add(new Types.CoupleWH(50, 150));
        boxes.add(new Types.CoupleWH(140, 120));
        boxes.add(new Types.CoupleWH(40, 100));
        boxes.add(new Types.CoupleWH(80, 120));
        boxes.add(new Types.CoupleWH(60, 130));
        boxes.add(new Types.CoupleWH(50, 140));
        boxes.add(new Types.CoupleWH(60, 130));
        boxes.add(new Types.CoupleWH(60, 130));
        boxes.add(new Types.CoupleWH(50, 140));
        boxes.add(new Types.CoupleWH(60, 130));



        Types.Result result = new RecursPacking().spprg(WidthStrip, boxes, true);
        HeightStrip = result.getHeightStrip();
        rectangles = result.getRectangles();
        emptyAreas = result.getEmptyAreas();
        ArrayList<Types.Area> areas = new ArrayList<>();

        for (Types.Areas areas1: emptyAreas) {
            areas.addAll(areas1.getAreas());
        }

        System.out.println("Количество всех областей = " + areas.size());

        final long endTime = System.currentTimeMillis();

        System.out.println("");
        System.out.println("Высота ленты = " + HeightStrip);
        System.out.println("Площадь ленты = " + WidthStrip * HeightStrip);

        efficiency = new RecursPacking().efficiencyRatio(WidthStrip, HeightStrip, rectangles);
        String eff = String.format("%.10f", efficiency);
        System.out.println("Отходы = " + eff + "%");

        System.out.println("");
        System.out.println("Время сортировки прямоугольников: " + (double) (RecursPacking.endSortingTime2 - startTime) + " сек");
        System.out.println("Время выполнения программы: " + (double) (endTime - startTime) / 1000 + " сек");
//
        Visualisation.createFrame((int) WidthStrip + 50, (int) HeightStrip + 50, rectangles);
    }

}