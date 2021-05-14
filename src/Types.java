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

        public void setX(long x) {
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public void setY(long y) {
            this.y = y;
        }

        public long getW() {
            return w;
        }

        public void setW(long w) {
            this.w = w;
        }

        public long getH() {
            return h;
        }

        public void setH(long h) {
            this.h = h;
        }
    }

    static class Result {

        private long HeightStrip;
        private Map<Integer, Rectangle> rectangles;
        private ArrayList<Types.Area> emptyAreas;

        Result(long HeightStrip, Map<Integer, Types.Rectangle> rectangles, ArrayList<Types.Area> emptyAreas) {
            this.HeightStrip = HeightStrip;
            this.rectangles = rectangles;
            this.emptyAreas = emptyAreas;
        }

        public long getHeightStrip() {
            return HeightStrip;
        }

        public ArrayList<Types.Area> getEmptyAreas() {
            return emptyAreas;
        }

        public Map<Integer, Types.Rectangle> getRectangles() {
            return rectangles;
        }

        public ArrayList<Rectangle> getRectanglesWithoutId() {
            ArrayList<Rectangle> rects = new ArrayList<>();

            for (int i = 0; i < rectangles.size(); i++) {
                rects.add(rectangles.get(i));
            }

            return rects;
        }
    }

    static class Area implements Cloneable {

        private long x;
        private long y;
        private long w;
        private long h;

        Area(long x, long y, long w, long h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        @Override
        public int hashCode() {

            final int prime = 31;
            long result = 1;

            result = prime * result + x;
            result = prime * result + y;
            result = prime * result + w;
            result = prime * result + h;

            return (int) result;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            Area other = (Area) obj;

            if (x != other.x) return false;
            if (y != other.y) return false;
            if (w != other.w) return false;
            if (h != other.h) return false;

            return true;
        }

        public long getX() {
            return x;
        }

        public void setX(long x) {
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public void setY(long y) {
            this.y = y;
        }

        public long getW() {
            return w;
        }

        public void setW(long w) {
            this.w = w;
        }

        public long getH() {
            return h;
        }

        public void setH(long h) {
            this.h = h;
        }
    }

    static class sortAreasByHeight implements Comparator<Area> {

        @Override
        public int compare(Area o1, Area o2) {
            return (int) (o1.h - o2.h);
        }
    }
}
