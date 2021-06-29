import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class RecursPackingTest {

    private Random random = new Random();

    Types.Result optimizedResult;
    Types.Result nonOptimizedResult;

    long startTime;
    long endTime;

    @Test
    public void test1() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

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

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 1:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void test2() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(80, 200));
        boxes.add(new Types.CoupleWH(80, 200));
        boxes.add(new Types.CoupleWH(80, 200));
        boxes.add(new Types.CoupleWH(80, 200));
        boxes.add(new Types.CoupleWH(80, 200));
        boxes.add(new Types.CoupleWH(80, 200));

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 2:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void test3() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        boxes.add(new Types.CoupleWH(50, 150));
        boxes.add(new Types.CoupleWH(40, 100));
        boxes.add(new Types.CoupleWH(40, 110));
        boxes.add(new Types.CoupleWH(100, 120));
        boxes.add(new Types.CoupleWH(70, 130));
        boxes.add(new Types.CoupleWH(50, 140));
        boxes.add(new Types.CoupleWH(60, 140));
        boxes.add(new Types.CoupleWH(70, 130));
        boxes.add(new Types.CoupleWH(80, 110));
        boxes.add(new Types.CoupleWH(110, 110));
        boxes.add(new Types.CoupleWH(30, 70));
        boxes.add(new Types.CoupleWH(40, 130));
        boxes.add(new Types.CoupleWH(50, 110));

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 3:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void test4() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(230, 80));
        boxes.add(new Types.CoupleWH(230, 80));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(80, 40));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 4:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void test5() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        boxes.add(new Types.CoupleWH(100, 120));
        boxes.add(new Types.CoupleWH(80, 120));
        boxes.add(new Types.CoupleWH(40, 130));
        boxes.add(new Types.CoupleWH(30, 80));
        boxes.add(new Types.CoupleWH(110, 70));
        boxes.add(new Types.CoupleWH(70, 130));
        boxes.add(new Types.CoupleWH(50, 140));
        boxes.add(new Types.CoupleWH(110, 110));
        boxes.add(new Types.CoupleWH(110, 110));
        boxes.add(new Types.CoupleWH(30, 70));
        boxes.add(new Types.CoupleWH(40, 130));
        boxes.add(new Types.CoupleWH(50, 110));

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 5:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void test6() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(20, 40));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 100));
        boxes.add(new Types.CoupleWH(100, 50));
        boxes.add(new Types.CoupleWH(60, 40));
        boxes.add(new Types.CoupleWH(10, 100));
        boxes.add(new Types.CoupleWH(60, 40));
        boxes.add(new Types.CoupleWH(10, 100));
        boxes.add(new Types.CoupleWH(80, 40));
        boxes.add(new Types.CoupleWH(60, 60));
        boxes.add(new Types.CoupleWH(200, 140));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 100));

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 6:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void test7() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        boxes.add(new Types.CoupleWH(100, 100));
        boxes.add(new Types.CoupleWH(100, 50));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(20, 40));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 100));
        boxes.add(new Types.CoupleWH(100, 50));
        boxes.add(new Types.CoupleWH(60, 40));
        boxes.add(new Types.CoupleWH(10, 100));
        boxes.add(new Types.CoupleWH(60, 40));
        boxes.add(new Types.CoupleWH(10, 100));
        boxes.add(new Types.CoupleWH(80, 40));
        boxes.add(new Types.CoupleWH(60, 60));
        boxes.add(new Types.CoupleWH(200, 140));

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 7:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void test8() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(50, 30));
        boxes.add(new Types.CoupleWH(20, 40));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(250, 80));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(100, 50));
        boxes.add(new Types.CoupleWH(60, 40));
        boxes.add(new Types.CoupleWH(50, 100));
        boxes.add(new Types.CoupleWH(60, 40));
        boxes.add(new Types.CoupleWH(50, 100));
        boxes.add(new Types.CoupleWH(80, 40));
        boxes.add(new Types.CoupleWH(60, 60));
        boxes.add(new Types.CoupleWH(200, 140));
        boxes.add(new Types.CoupleWH(100, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 200));
        boxes.add(new Types.CoupleWH(200, 100));
        boxes.add(new Types.CoupleWH(50, 50));
        boxes.add(new Types.CoupleWH(100, 80));
        boxes.add(new Types.CoupleWH(150, 40));

        nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
        optimizedResult = new RecursPacking().spprg(340, boxes, true);

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());

        System.out.println("Случай 8:");
        System.out.println("Отходы до использования оптимизационного алгоритма: " + nonOptimizedResult.getEfficiency() + "%");
        System.out.println("Отходы после использования оптимизационного алгоритма: " + optimizedResult.getEfficiency() + "%");
    }

    @Test
    public void smallScaleRandomTest() {

        ArrayList<Double> better = new ArrayList<>();

        int randomCouple;
        int optimized = 0;
        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        int minNumberOfElements = 5;
        int maxNumberOfElements = 10;

        int diff = maxNumberOfElements - minNumberOfElements;
        int numberOfElements = random.nextInt(diff + 1);

        ArrayList<Types.CoupleWH> couples = new ArrayList<>();
        couples.add(new Types.CoupleWH(50, 50));
        couples.add(new Types.CoupleWH(100, 100));
        couples.add(new Types.CoupleWH(50, 30));
        couples.add(new Types.CoupleWH(60, 40));
        couples.add(new Types.CoupleWH(80, 40));
        couples.add(new Types.CoupleWH(100, 200));
        couples.add(new Types.CoupleWH(250, 80));
        couples.add(new Types.CoupleWH(110, 70));
        couples.add(new Types.CoupleWH(40, 130));
        couples.add(new Types.CoupleWH(100, 120));
        couples.add(new Types.CoupleWH(80, 200));
        couples.add(new Types.CoupleWH(50, 110));
        couples.add(new Types.CoupleWH(50, 150));
        couples.add(new Types.CoupleWH(40, 110));
        couples.add(new Types.CoupleWH(60, 130));
        couples.add(new Types.CoupleWH(140, 120));
        couples.add(new Types.CoupleWH(200, 140));
        couples.add(new Types.CoupleWH(20, 40));
        couples.add(new Types.CoupleWH(30, 70));
        couples.add(new Types.CoupleWH(80, 110));
        couples.add(new Types.CoupleWH(110, 110));

        for (int times = 0; times < 100; times++) {

            for (int i = 0; i < 5; i++) {

                randomCouple = random.nextInt(19);

                for (int j = 0; j < numberOfElements; j++) {
                    boxes.add(couples.get(randomCouple));
                }
            }

            nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
            optimizedResult = new RecursPacking().spprg(340, boxes, true);

            if (nonOptimizedResult.getHeightStrip() != optimizedResult.getHeightStrip()) {
                assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
                assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());
                optimized++;
            }

            boxes.clear();
        }

        System.out.println("Оптимизировано из 100 случаев: " + optimized);
    }

    @Test
    public void bigScaleTest() {

        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        for (int i = 0; i < 50000; i++) {
            boxes.add(new Types.CoupleWH(100, 200));
        }
        for (int i = 0; i < 50000; i++) {
            boxes.add(new Types.CoupleWH(80, 200));
        }

        startTime = System.nanoTime();
        nonOptimizedResult = new RecursPacking().spprg(360, boxes, false);
        endTime = startTime = System.nanoTime() - startTime;
        System.out.println("Время работы алгоритма без оптимизации: " + (double) endTime / 1000000000 + " сек");
        System.out.println("Отходы = " + nonOptimizedResult.getEfficiency());

        startTime = 0;
        endTime = 0;

        startTime = System.nanoTime();
        optimizedResult = new RecursPacking().spprg(360, boxes, true);
        endTime = System.nanoTime() - startTime;
        System.out.println("Время работы алгоритма с оптимизацией: " + (double) endTime / 1000000000 + " сек");
        System.out.println("Отходы = " + optimizedResult.getEfficiency());

        assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
        assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());
    }

    @Test
    public void bigScaleRandomTest() {

        ArrayList<Double> better = new ArrayList<>();

        int randomCouple;
        int optimized = 0;
        ArrayList<Types.CoupleWH> boxes = new ArrayList<>();

        int minNumberOfElements = 3000;
        int maxNumberOfElements = 10000;

        int diff = maxNumberOfElements - minNumberOfElements;
        int numberOfElements = random.nextInt(diff + 1);

        ArrayList<Types.CoupleWH> couples = new ArrayList<>();
        couples.add(new Types.CoupleWH(100, 200));
        couples.add(new Types.CoupleWH(80, 200));
        couples.add(new Types.CoupleWH(60, 130));
        couples.add(new Types.CoupleWH(50, 150));
        couples.add(new Types.CoupleWH(140, 120));
        couples.add(new Types.CoupleWH(140, 120));
        couples.add(new Types.CoupleWH(200, 140));

        for (int times = 0; times < 10; times++) {

            if (times == 0)
            System.out.println("-------------------------------------");

            startTime = 0;
            endTime = 0;

            for (int i = 0; i < 10; i++) {

                randomCouple = random.nextInt(2);

                for (int j = 0; j < 10000; j++) {
                    boxes.add(couples.get(randomCouple));
                }
            }

            startTime = System.nanoTime();
            nonOptimizedResult = new RecursPacking().spprg(340, boxes, false);
            endTime = startTime = System.nanoTime() - startTime;
            System.out.println("Время работы алгоритма для " + times + " случая без оптимизации: " + (double) endTime / 1000000000 + " сек");
            System.out.println("Отходы = " + nonOptimizedResult.getEfficiency());

            startTime = 0;
            endTime = 0;

            startTime = System.nanoTime();
            optimizedResult = new RecursPacking().spprg(340, boxes, true);
            endTime = startTime = System.nanoTime() - startTime;


            if (nonOptimizedResult.getHeightStrip() != optimizedResult.getHeightStrip()) {
                assertTrue(optimizedResult.getHeightStrip() < nonOptimizedResult.getHeightStrip());
                assertTrue(optimizedResult.getEfficiency() < nonOptimizedResult.getEfficiency());
                optimized++;

                better.add(nonOptimizedResult.getEfficiency() - optimizedResult.getEfficiency());

                System.out.println("Время работы алгоритма для " + times + " случая с оптимизацией: " + (double) endTime / 1000000000 + " сек");
                System.out.println("Отходы = " + optimizedResult.getEfficiency());
                System.out.println(" ");
            } else {
                System.out.println("Случай не оптимизирован");
                System.out.println(" ");
            }

            System.out.println("Количество элементов для " + times + " случая: " + nonOptimizedResult.getRectangles().size());
            System.out.println("-------------------------------------");

            boxes.clear();
        }

        System.out.println(" ");

        System.out.println("Оптимизировано из 10 случаев: " + optimized);
        System.out.println(" ");
        System.out.println(better);
    }
}