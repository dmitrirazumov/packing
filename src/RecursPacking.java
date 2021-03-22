import java.util.*;

class RecursPacking {

    Types.Result spprg(int WidthStrip, ArrayList<Types.CoupleWH> rectanglesWH, String sorting) {

        int D;
        int intermediateW;
        ArrayList<Types.CoupleWH> remaining;
        Map<Integer, Types.Rectangle> rectangles;

        if (sorting.equals("width"))
            D = 0;
        else if (sorting.equals("height"))
            D = 1;

        rectangles = new HashMap<>();
        for (int i = 0; i < rectanglesWH.size(); i++) {
            rectangles.put(i, null);
        }

        remaining = new ArrayList<>(rectanglesWH);

        for (Types.CoupleWH element : remaining) {     //для каждого элемента поменять местами ширину и высоту
            if (element.getW() > element.getH()) {
                intermediateW = element.getW();
                element.setW(element.getH());
                element.setH(intermediateW);
            }
        }

        ArrayList<Types.CoupleWH> copy = new ArrayList<>(remaining);
        ArrayList<Integer> sorted_indexes = new ArrayList<>();

        Comparator<Types.CoupleWH> c = Collections.reverseOrder(new Types.SortByWidth());
        copy.sort(c);    // получили отсортированные прямоугольники

        for (Types.CoupleWH element : copy) {        //получить список индексов прямоугольников с шириной по убыванию   TODO для невозрастающей высоты
            sorted_indexes.add(remaining.indexOf(element));
        }

        int x, y, w, h, H;
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

            recursive_packing(x, y, w, h, 0, remaining, sorted_indexes, rectangles);
            x = 0;
            y = H;
        }

        return new Types.Result(y, rectangles);
    }

    private void recursive_packing(int x, int y, int w, int h, int D,
                                   ArrayList<Types.CoupleWH> remaining, ArrayList<Integer> indexes, Map<Integer, Types.Rectangle> result) {

        int priority = 6;
        int orientation = 0;
        int best = 0;
        int psi, d;
        long min_w, min_h;

        for (int id : indexes) {
            for (int j = 0; j < D + 1; j++) {
                if ((priority > 1) &&
                        (remaining.get(id).getWidthOrHeight((0 + j) % 2) == w) &&
                        (remaining.get(id).getWidthOrHeight((1 + j) % 2) == h)) {
                    priority = 1;
                    orientation = j;
                    best = id;
                    break;
                } else if ((priority > 2) &&
                        (remaining.get(id).getWidthOrHeight((0 + j) % 2) == w) &&
                        (remaining.get(id).getWidthOrHeight((1 + j) % 2) < h)) {
                    priority = 2;
                    orientation = j;
                    best = id;
                } else if ((priority > 3) &&
                        (remaining.get(id).getWidthOrHeight((0 + j) % 2) < w) &&
                        (remaining.get(id).getWidthOrHeight((1 + j) % 2) == h)) {
                    priority = 3;
                    orientation = j;
                    best = id;
                } else if ((priority > 4) &&
                        (remaining.get(id).getWidthOrHeight((0 + j) % 2) < w) &&
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

            if (orientation == 0) {
                psi = remaining.get(best).getW();
                d = remaining.get(best).getH();
            } else {
                psi = remaining.get(best).getH();
                d = remaining.get(best).getW();
            }

            result.put(best, new Types.Rectangle(x, y, psi, d));
            indexes.remove(new Integer(best));

            if (priority == 2)
                recursive_packing(x, y + d, w, h - d, D, remaining, indexes, result);
            else if (priority == 3)
                recursive_packing(x + psi, y, w - psi, h, D, remaining, indexes, result);
            else if (priority == 4) {

                min_w = Long.MAX_VALUE;
                min_h = Long.MAX_VALUE;

                for (Integer id : indexes) {
                    min_w = Math.min(min_w, remaining.get(id).getW());
                    min_h = Math.min(min_h, remaining.get(id).getH());
                }

                min_w = Math.min(min_h, min_w);
                min_h = min_w;

                if ((w - psi) < min_w)
                    recursive_packing(x, y + d, w, h - d, D, remaining, indexes, result);
                else if ((h - d) < min_h)
                    recursive_packing(x + psi, y, w - psi, h, D, remaining, indexes, result);
                else if (psi < min_w) {
                    recursive_packing(x + psi, y, w - psi, d, D, remaining, indexes, result);
                    recursive_packing(x, y + d, w, h - d, D, remaining, indexes, result);
                } else {
                    recursive_packing(x, y + d, psi, h - d, D, remaining, indexes, result);
                    recursive_packing(x + psi, y, w - psi, h, D, remaining, indexes, result);
                }
            }

        }
    }
}
