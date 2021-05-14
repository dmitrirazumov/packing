import java.util.ArrayList;
import java.util.Map;

public class Main {

    static long HeightStrip;

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();
        ArrayList<Types.Rectangle> rectangles;
        ArrayList<Types.Area> emptyAreas = new ArrayList<>();
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

//        boxes.add(new Types.CoupleWH(250, 50));
//        boxes.add(new Types.CoupleWH(250, 50));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(100, 200));
//
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
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(200, 100));
//
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(100, 200));
//        boxes.add(new Types.CoupleWH(50, 20));
//        boxes.add(new Types.CoupleWH(100, 100));
//        boxes.add(new Types.CoupleWH(100, 50));
//        boxes.add(new Types.CoupleWH(250, 80));
//        boxes.add(new Types.CoupleWH(250, 80));

        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(80, 40));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));


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


        Types.Result result = new RecursPacking().spprg(WidthStrip, boxes, "width");
        HeightStrip = result.getHeightStrip();
        rectangles = result.getRectanglesWithoutId();
        emptyAreas = result.getEmptyAreas();
        emptyAreas = new PackingHelper().mergingAreas(emptyAreas);

        ArrayList<Types.Combination> combinations = new PackingHelper().combinationsOfAreas(emptyAreas);

        for (int i = 0; i < combinations.size(); i++) {
            System.out.println("Комбинация " + i + ": " + combinations.get(i));
            }
        System.out.println("");



//        ArrayList<Types.Area> sortedAreas = new PackingHelper().combinationsOfAreas(emptyAreas);
//
//        for (int i = 0; i < rectangles.size(); i++) {
//            System.out.println("Отсортированная пустая область " + i + " : " +
//                    "w = " + sortedAreas.get(i).getW() + ", " +
//                    "h = " + sortedAreas.get(i).getH() + ", " +
//                    "x = " + sortedAreas.get(i).getX() + ", " +
//                    "y = " + sortedAreas.get(i).getY());
//        }
//
//        System.out.println();

//        long inter;

//        rectangles.get(3).setX(250);
//        rectangles.get(3).setY(320);
//        inter = rectangles.get(3).getW();
//        rectangles.get(3).setW(rectangles.get(3).getH());
//        rectangles.get(3).setH(inter);

//        rectangles.get(3).setX(250);
//        rectangles.get(3).setY(320);
//        inter = rectangles.get(3).getW();
//        rectangles.get(3).setW(rectangles.get(3).getH());
//        rectangles.get(3).setH(inter);
//
//        rectangles.get(4).setX(0);
//        rectangles.get(4).setY(570);

        for (int i = 0; i < rectangles.size(); i++) {
            System.out.println("Координаты для " + i + " прямоугольника: " + rectangles.get(i).getX() + ", " + rectangles.get(i).getY());
        }

        System.out.println("");

        for (int i = 0; i < emptyAreas.size(); i++) {
            System.out.println("Пустая область " + i + " : " +
                    "w = " + emptyAreas.get(i).getW() + ", " +
                    "h = " + emptyAreas.get(i).getH() + ", " +
                    "x = " + emptyAreas.get(i).getX() + ", " +
                    "y = " + emptyAreas.get(i).getY());
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
//
        Visualisation.createFrame((int) WidthStrip + 50, (int) HeightStrip + 50, rectangles, emptyAreas);
    }

}