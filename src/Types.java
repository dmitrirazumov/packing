import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Types {

    static class CoupleWH {

        private int w;
        private int h;

        CoupleWH(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public int getWidthOrHeight(int mathExprForWH) {
            if (mathExprForWH == 0) return w;
            else return h;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }

    static class SortByWidth implements Comparator<CoupleWH> {

        @Override
        public int compare(CoupleWH o1, CoupleWH o2) {
            return o1.w - o2.w;
        }
    }

    static class Rectangle {

        private int x;
        private int y;
        private int w;
        private int h;

        Rectangle(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
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

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }

    static class Result {

        private int HeightStrip;
        private Map<Integer, Rectangle> rectangles;

        Result(int HeightStrip, Map<Integer, Types.Rectangle> rectangles) {
            this.HeightStrip = HeightStrip;
            this.rectangles = rectangles;
        }

        public int getHeightStrip() {
            return HeightStrip;
        }

        public ArrayList<Rectangle> getRectangles() {

            ArrayList<Rectangle> rects = new ArrayList<>();

            for (int i = 0; i < rectangles.size(); i++) {
                rects.add(rectangles.get(i));
            }

            return rects;
        }
    }
}
