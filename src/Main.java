import java.util.ArrayList;

public class Main {

    static long HeightStrip;

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();
        ArrayList<Types.Rectangle> rectangles;
        long WidthStrip = 350;
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

        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(20, 40));
        boxes.add(new Types.CoupleWH(300, 80));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 100));
        boxes.add(new Types.CoupleWH(100, 50));
        boxes.add(new Types.CoupleWH(60, 40));
        boxes.add(new Types.CoupleWH(10, 100));
        boxes.add(new Types.CoupleWH(80, 40));
        boxes.add(new Types.CoupleWH(60, 60));
        boxes.add(new Types.CoupleWH(200, 140));
        boxes.add(new Types.CoupleWH(300, 80));


        Types.Result result = new RecursPacking().spprg(WidthStrip, boxes, "width");
        HeightStrip = result.getHeightStrip();
        rectangles = result.getRectangles();


        for (int i = 0; i < rectangles.size(); i++) {
            System.out.println("Координаты для " + i + " прямоугольника: " + rectangles.get(i).getX() + ", " + rectangles.get(i).getY());
        }

        final long endTime = System.currentTimeMillis();

        System.out.println("");
        System.out.println("Высота ленты = " + HeightStrip);
        System.out.println("Площадь ленты = " + WidthStrip * HeightStrip);

        efficiency = new RecursPacking().efficiencyRatio(WidthStrip, HeightStrip, rectangles);
        String eff = String.format("%.10f", efficiency);
        System.out.println("Отходы = " + eff + "%");

        System.out.println("");
        System.out.println("Время сортировки прямоугольников: " + (double) (RecursPacking.endSortingTime1 - startTime) + " сек");
        System.out.println("Время сортировки прямоугольников: " + (double) (RecursPacking.endSortingTime2 - startTime) + " сек");
        System.out.println("Время выполнения программы: " + (double) (endTime - startTime) / 1000 + " сек");

        Visualisation.createFrame((int) WidthStrip + 50, (int) HeightStrip + 50, rectangles);
    }

}