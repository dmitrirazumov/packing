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

        private int id;
        private long x;
        private long y;
        private long w;
        private long h;

        Rectangle(int id, long x, long y, long w, long h) {
            this.id = id;
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

        public int getId() {
            return id;
        }
    }

    static class Result {

        private long HeightStrip;
        private Map<Integer, ArrayList<Types.Rectangle>> rectangles;
        private ArrayList<Types.Areas> emptyAreas;

        Result(long HeightStrip, Map<Integer, ArrayList<Types.Rectangle>> rectangles, ArrayList<Types.Areas> emptyAreas) {
            this.HeightStrip = HeightStrip;
            this.rectangles = rectangles;
            this.emptyAreas = emptyAreas;
        }

        public Map<Integer, ArrayList<Types.Rectangle>> getMapRectangles() {
            return rectangles;
        }

        public ArrayList<Types.Rectangle> getRectangles() {

            ArrayList<Types.Rectangle> getRectangles = new ArrayList<>();

            for (Map.Entry<Integer, ArrayList<Types.Rectangle>> item : rectangles.entrySet()){
                getRectangles.addAll(item.getValue());
            }

            return getRectangles;
        }

        public long getHeightStrip() {
            return HeightStrip;
        }

        public void setHeightStrip(long HeightStrip) {
            this.HeightStrip = HeightStrip;
        }

        public ArrayList<Types.Areas> getEmptyAreas() {
            return emptyAreas;
        }

    }

    static class sortResults implements Comparator<Result> {

        @Override
        public int compare(Result o1, Result o2) {
            return (int) (o1.HeightStrip - o2.HeightStrip);
        }
    }

    static class Section {

        int number;
        ArrayList<Types.Rectangle> rectangles;

        Section(int number, ArrayList<Types.Rectangle> rectangles) {
            this.number = number;
            this.rectangles = rectangles;
        }
    }

    static class Rectangles {

        int section;
        ArrayList<Types.Rectangle> rectangles;
        ArrayList<Types.Barrier> barriers;

        Rectangles(int section, ArrayList<Types.Rectangle> rectangles, ArrayList<Types.Barrier> barriers) {
            this.section = section;
            this.rectangles = rectangles;
            this.barriers = barriers;
        }

        public int getSection() {
            return section;
        }

        public ArrayList<Types.Rectangle> getRectangles() {
            return rectangles;
        }

        public ArrayList<Types.Barrier> getBarriers() {
            return barriers;
        }
    }

    static class Areas {

        int section;
        ArrayList<Types.Area> areas;

        Areas(int section, ArrayList<Types.Area> areas) {
            this.section = section;
            this.areas = areas;
        }

        public int getSection() {
            return section;
        }

        public ArrayList<Types.Area> getAreas() {
            return areas;
        }

        public Types.Area getAreasFromSection(int section) {
                return areas.get(section);

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
        public String toString() {
            return
                    "[" + "x = " + x + ", " +
                            "y = " + y + ", " +
                            "w = " + w + ", " +
                            "h = " + h + "]";
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

//    static class sortAreasByHeight implements Comparator<Area> {
//
//        @Override
//        public int compare(Area o1, Area o2) {
//            return (int) (o1.h - o2.h);
//        }
//    }

    static class sortAreasByWeight implements Comparator<Area> {

        @Override
        public int compare(Area o1, Area o2) {
            return (int) (o1.w - o2.w);
        }
    }

    static class Combination {

        private ArrayList<Integer> combination;

        Combination(ArrayList<Integer> combination) {
            this.combination = combination;
        }

        @Override
        public String toString() {
            return "" + combination + "";
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            ArrayList<Integer> copy = new ArrayList<>(combination);
            Combination other = (Combination) obj;

            copy.removeAll(other.combination);
            return copy.isEmpty();
        }

        public ArrayList<Integer> getCombination() {
            return combination;
        }
    }

    static class BiggestVerticalArea {

        boolean placed;
        ArrayList<BVAreas> areas;
        ArrayList<Types.Rectangle> rectangles;
        long rectanglesHeight;

        BiggestVerticalArea(boolean placed, ArrayList<BVAreas> areas, ArrayList<Types.Rectangle> rectangles, long rectanglesHeight) {
            this.placed = placed;
            this.areas = areas;
            this.rectangles = rectangles;
            this.rectanglesHeight = rectanglesHeight;
        }

        public ArrayList<BVAreas> getAreas() {
            return areas;
        }

        public ArrayList<Types.Rectangle> getRectangles() {
            return rectangles;
        }

        public int getLastNumberOfPut() {

            int lastNop = 0;
            for (Types.BVAreas area: areas) {
                if (lastNop < area.getNumberOfPut()) lastNop = area.getNumberOfPut();
            }

            return lastNop;
        }
    }

    static class BVAreas {

        long x;
        long y;
        long w;
        long h;
        int numberOfPut;
        int variation;

        BVAreas(long x, long y, long w, long h, int numberOfPut, int variation) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.numberOfPut = numberOfPut;
            this.variation = variation;
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

        public int getNumberOfPut() {
            return numberOfPut;
        }

        public int getVariation() {
            return variation;
        }
    }

    static class Barrier {

        long x1;
        long x2;
        long y;

        Barrier(long x1, long x2, long y) {
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + "(" + x1 + "..." + x2 + ")" + ", "+ y + "]";
        }

        public long getX1() {
            return x1;
        }

        public long getX2() {
            return x2;
        }

        public long getY() {
            return y;
        }

        public void setX1(long x1) {
            this.x1 = x1;
        }
        public void setX2(long x2) {
            this.x2 = x2;
        }
        public void setY(long y) {
            this.y = y;
        }
    }
}
