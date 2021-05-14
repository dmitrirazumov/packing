import java.util.*;

class RecursPacking {

    static long Height;
    public static long endSortingTime1;
    public static long endSortingTime2;

    Types.Result spprg(long WidthStrip, ArrayList<Types.CoupleWH> rectanglesWH, String sorting) {

        int wh = 0;
        int intermediateW;

        Map<Integer, Types.Rectangle> rectangles = new HashMap<>();
        ArrayList<Types.CoupleWH> remaining = new ArrayList<>();
        ArrayList<Integer> sorted_indexes = new ArrayList<>();
        ArrayList<Types.Area> areas = new ArrayList<>();

        if (sorting.equals("width"))
            wh = 0;
        else if (sorting.equals("height"))
            wh = 1;

        for (int i = 0; i < rectanglesWH.size(); i++) {
            rectangles.put(i, null);
        }

        for (Types.CoupleWH element: rectanglesWH) {
            remaining.add(new Types.CoupleWH(element.getW(), element.getH()));
        }

        for (Types.CoupleWH element : remaining) {     //для каждого элемента поменять местами ширину и высоту
            if (element.getW() > element.getH()) {
                intermediateW = element.getW();
                element.setW(element.getH());
                element.setH(intermediateW);
            }
        }

        ArrayList<Types.CoupleWH> copy = new ArrayList<>(remaining);

        if (wh == 0) {
            Comparator<Types.CoupleWH> c = Collections.reverseOrder(new Types.SortByWidth());  // сортировка прямоугольников по ширине
            endSortingTime1 = System.currentTimeMillis();
            copy.sort(c);
            endSortingTime2 = System.currentTimeMillis();
        }

        for (Types.CoupleWH element : copy) {        //получить список индексов прямоугольников с шириной по убыванию   TODO для невозрастающей высоты
            sorted_indexes.add(remaining.indexOf(element));
        }

        long x, y, w, h, H;
        x = 0;
        y = 0;
        H = 0;

        while (!sorted_indexes.isEmpty()) {

            int idx;
            idx = sorted_indexes.get(0);
            sorted_indexes.remove(0);
            Types.CoupleWH r = remaining.get(idx);

            if (r.getH() > WidthStrip) {
                rectangles.put(idx, new Types.Rectangle(x, y, r.getW(), r.getH()));
                x = r.getW();
                y = H;
                w = WidthStrip - r.getW();
                h = r.getH();
                H = H + r.getH();
            } else {
                rectangles.put(idx, new Types.Rectangle(x, y, r.getH(), r.getW()));
                x = r.getH();
                y = H;
                w = WidthStrip - r.getH();
                h = r.getW();
                H = H + r.getW();
            }

            areas.add(new Types.Area(x, y, w ,h));
            recursive_packing(x, y, w, h, 1, remaining, sorted_indexes, rectangles, areas);
            x = 0;
            y = H;
            Height = H;
        }

        return new Types.Result(y, rectangles, areas);
    }

    private void recursive_packing(long x, long y, long w, long h, int wh,
                                   ArrayList<Types.CoupleWH> remaining, ArrayList<Integer> indexes, Map<Integer, Types.Rectangle> result, ArrayList<Types.Area> areas) {

        int lastArea = areas.size() - 1;

        int priority = 6;
        int orientation = 0;
        int best = 0;
        int psi, d;
        long min_w, min_h;

        for (int id : indexes) {
            for (int j = 0; j < wh + 1; j++) {
                if ((priority > 1) &&
                        (remaining.get(id).getWidthOrHeight(j % 2) == w) &&
                        (remaining.get(id).getWidthOrHeight((1 + j) % 2) == h)) {
                    priority = 1;
                    orientation = j;
                    best = id;
                    break;
                } else if ((priority > 2) &&
                        (remaining.get(id).getWidthOrHeight(j % 2) == w) &&
                        (remaining.get(id).getWidthOrHeight((1 + j) % 2) < h)) {
                    priority = 2;
                    orientation = j;
                    best = id;
                } else if ((priority > 3) &&
                        (remaining.get(id).getWidthOrHeight(j % 2) < w) &&
                        (remaining.get(id).getWidthOrHeight((1 + j) % 2) == h)) {
                    priority = 3;
                    orientation = j;
                    best = id;
                } else if ((priority > 4) &&
                        (remaining.get(id).getWidthOrHeight(j % 2) < w) &&
                        (remaining.get(id).getWidthOrHeight((1 + j) % 2) < h)) {
                    priority = 4;
                    orientation = j;
                    best = id;
                } else if (priority > 5) {
                    priority = 5;
                    orientation = j;
                    best = id;
                }
            }
        }

        if (priority < 5) {

            areas.remove(lastArea);

            if (orientation == 0) {
                psi = remaining.get(best).getW();
                d = remaining.get(best).getH();
            } else {
                psi = remaining.get(best).getH();
                d = remaining.get(best).getW();
            }

            result.put(best, new Types.Rectangle(x, y, psi, d));
            indexes.remove(new Integer(best));

            if (priority == 2) {
                areas.add(new Types.Area(x, y + d, w, h - d));
                recursive_packing(x, y + d, w, h - d, wh, remaining, indexes, result, areas);
            }
            else if (priority == 3) {
                areas.add(new Types.Area(x + psi, y, w - psi, h));
                recursive_packing(x + psi, y, w - psi, h, wh, remaining, indexes, result, areas);
            }
            else if (priority == 4) {

                min_w = Long.MAX_VALUE;
                min_h = Long.MAX_VALUE;

                for (Integer id : indexes) {
                    min_w = Math.min(min_w, remaining.get(id).getW());
                    min_h = Math.min(min_h, remaining.get(id).getH());
                }

                min_w = Math.min(min_h, min_w);
                min_h = min_w;

                if ((w - psi) < min_w) {
                    areas.add(new Types.Area(x + psi, y, w - psi, d));
                    areas.add(new Types.Area(x, y + d, w, h - d));
                    recursive_packing(x, y + d, w, h - d, wh, remaining, indexes, result, areas);
                }
                else if ((h - d) < min_h) {
                    areas.add(new Types.Area(x, y + d, psi, h - d));
                    areas.add(new Types.Area(x + psi, y, w - psi, h));
                    recursive_packing(x + psi, y, w - psi, h, wh, remaining, indexes, result, areas);
                }
                else if (psi < min_w) {
                    areas.add(new Types.Area(x + psi, y, w - psi, d));
                    recursive_packing(x + psi, y, w - psi, d, wh, remaining, indexes, result, areas);
                    areas.add(new Types.Area(x, y + d, w, h - d));
                    recursive_packing(x, y + d, w, h - d, wh, remaining, indexes, result, areas);
                } else {
                    areas.add(new Types.Area(x, y + d, psi, h - d));
                    recursive_packing(x, y + d, psi, h - d, wh, remaining, indexes, result, areas);
                    areas.add(new Types.Area(x + psi, y, w - psi, h));
                    recursive_packing(x + psi, y, w - psi, h, wh, remaining, indexes, result, areas);
                }
            }

        }
    }

    double efficiencyRatio(long width, long height, ArrayList<Types.Rectangle> rectangles) {

        double tapeArea;
        double wasteArea;
        double rectanglesAreas = 0;

        for (Types.Rectangle rectangle : rectangles) {
            rectanglesAreas = rectanglesAreas + (rectangle.getW() * rectangle.getH());
        }

        tapeArea = (double) width * height;
        wasteArea = tapeArea - rectanglesAreas;

        System.out.println("Площадь отходов = " + wasteArea);
        return ((wasteArea * 100) / tapeArea);
    }
}