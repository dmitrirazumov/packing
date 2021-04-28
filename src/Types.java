import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class Types {

    static class CoupleWH implements Cloneable {

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

        private long x;
        private long y;
        private long w;
        private long h;

        Rectangle(long x, long y, long w, long h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }


        public long getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public long getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public long getH() {
            return h;
        }

        public void setH(int h) {
            this.h = h;
        }
    }

    static class Result {

        private long HeightStrip;
        private Map<Integer, Rectangle> rectangles;

        Result(long HeightStrip, Map<Integer, Types.Rectangle> rectangles) {
            this.HeightStrip = HeightStrip;
            this.rectangles = rectangles;
        }

        public long getHeightStrip() {
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
