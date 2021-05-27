import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PackingHelper {

    private static int STEPS = 0;

    ArrayList<Types.Area> mergingAreas(ArrayList<Types.Area> areas) {

        for (int i = 0; i < areas.size(); i++) {
            for (int j = 1; j < areas.size(); j++) {

                //Horizontal 1
                if ((areas.get(i).getX() < areas.get(j).getX()) &&
                        (areas.get(i).getY() >= areas.get(j).getY()) &&
                        ((areas.get(i).getW() + areas.get(i).getX()) == areas.get(j).getX())) {

                    Types.Area newArea = new Types.Area(
                            areas.get(i).getX(),
                            areas.get(i).getY(),
                            areas.get(i).getW() + areas.get(j).getW(),
                            areas.get(i).getH()
                    );

                    if (!areas.contains(newArea)) areas.add(newArea);
                }

                //Horizontal 2
                if ((areas.get(i).getX() < areas.get(j).getX()) &&
                        (areas.get(i).getY() < areas.get(j).getY()) &&
                        ((areas.get(i).getW() + areas.get(i).getX()) == areas.get(j).getX())) {

                    Types.Area newArea = new Types.Area(
                            areas.get(i).getX(),
                            areas.get(j).getY(),
                            areas.get(i).getW() + areas.get(j).getW(),
                            areas.get(j).getH()
                    );

                    if (!areas.contains(newArea)) areas.add(newArea);
                }

                //Horizontal 3
                if ((areas.get(i).getX() > areas.get(j).getX()) &&
                        (areas.get(i).getY() >= areas.get(j).getY()) &&
                        ((areas.get(j).getX() + areas.get(j).getW()) == areas.get(i).getX())) {

                    Types.Area newArea = new Types.Area(
                            areas.get(j).getX(),
                            areas.get(i).getY(),
                            areas.get(i).getW() + areas.get(j).getW(),
                            areas.get(i).getH()
                    );

                    if (!areas.contains(newArea)) areas.add(newArea);
                }

                //Horizontal 4
                if ((areas.get(i).getX() > areas.get(j).getX()) &&
                        (areas.get(i).getY() < areas.get(j).getY()) &&
                        ((areas.get(j).getX() + areas.get(j).getW()) == areas.get(i).getX())) {

                    Types.Area newArea = new Types.Area(
                            areas.get(j).getX(),
                            areas.get(j).getY(),
                            areas.get(i).getW() + areas.get(j).getW(),
                            areas.get(j).getH()
                    );

                    if (!areas.contains(newArea)) areas.add(newArea);
                }

                //Vertical 1
                if ((areas.get(i).getX() <= areas.get(j).getX()) &&
                        ((areas.get(i).getX() + areas.get(i).getW()) >= (areas.get(j).getX() + areas.get(j).getW())) &&
                        (areas.get(j).getY() == (areas.get(i).getY() + areas.get(i).getH()))) {

                    Types.Area newArea = new Types.Area(
                            areas.get(j).getX(),
                            areas.get(i).getY(),
                            areas.get(j).getW(),
                            areas.get(i).getH() + areas.get(j).getH()
                    );

                    if (!areas.contains(newArea)) areas.add(newArea);
                }

                //Vertical 2
                if ((areas.get(i).getX() >= areas.get(j).getX()) &&
                        ((areas.get(i).getX() + areas.get(i).getW()) <= (areas.get(j).getX() + areas.get(j).getW())) &&
                        (areas.get(j).getY() == (areas.get(i).getY() + areas.get(i).getH()))) {

                    Types.Area newArea = new Types.Area(
                            areas.get(i).getX(),
                            areas.get(i).getY(),
                            areas.get(i).getW(),
                            areas.get(i).getH() + areas.get(j).getH()
                    );

                    if (!areas.contains(newArea)) areas.add(newArea);
                }
            }
        }

        return areas;
    }

    ArrayList<Types.Combination> combinationsOfAreas(ArrayList<Types.Area> areas) {

        Types.Area firstCandidate = null;
        Types.Area interCandidate;
        ArrayList<Types.Area> interCandidates;
        ArrayList<Types.Area> candidatesCopy = null;

        ArrayList<Integer> sortedAreas = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        ArrayList<Types.Combination> combinations = new ArrayList<>();
        ArrayList<Types.Area> candidates = new ArrayList<>();

        ArrayList<Types.Area> copy = new ArrayList<>(areas);
        Comparator<Types.Area> c = Collections.reverseOrder(new Types.sortAreasByWeight());
        copy.sort(c);

        for (Types.Area element : copy) {
            sortedAreas.add(areas.indexOf(element));
        }


        do {
            if (candidates.isEmpty()) {
                STEPS++;
                firstCandidate = areas.get(sortedAreas.get(0));
                sortedAreas.remove(0);
                candidates = formCandidates(firstCandidate, areas);
                candidatesCopy = new ArrayList<>(candidates);
            }

            if (!candidates.isEmpty()) {

                interCandidate = candidates.get(0);
                candidates.remove(0);
                combination.add(areas.indexOf(firstCandidate));
                combination.add(areas.indexOf(interCandidate));
                interCandidates = formCandidates(interCandidate, candidatesCopy);

                while (!interCandidates.isEmpty()) {
                    if (interCandidates.size() == 1) {
                        combination.add(areas.indexOf(interCandidates.get(0)));
                        interCandidates.remove(0);
                    }
                    if (interCandidates.size() > 1) {
                        interCandidate = interCandidates.get(0);
                        combination.add(areas.indexOf(interCandidate));
                        interCandidates.remove(0);
                        interCandidates = formCandidates(interCandidate, interCandidates);
                    }
//                if (interCandidates.size() == 0) candidates.remove(0);
                }

                if (!combinations.contains(new Types.Combination(combination)))
                    combinations.add(new Types.Combination(new ArrayList<>(combination)));
                combination.clear();
            }

        } while (!sortedAreas.isEmpty() && STEPS < 50);

        return combinations;

    }

    ArrayList<Types.Area> formCandidates(Types.Area candidate, ArrayList<Types.Area> areas) {

        ArrayList<Types.Area> candidates = new ArrayList<>();

        for (Types.Area area : areas) {
            if (((area.getX() + area.getW()) <= candidate.getX()) ||
                    (area.getX() >= (candidate.getX() + candidate.getW())) ||
                    (area.getY() >= (candidate.getY() + candidate.getH())) ||
                    ((area.getY() + area.getH()) <= candidate.getY())) {
                candidates.add(area);
            }
        }

        return candidates;
    }

    Types.Result updatingTape(Types.Result result, ArrayList<Types.Rectangles> sections, ArrayList<Types.Area> verticalAreas, ArrayList<Types.Combination> combinations) {

        long newHeight;
        Types.BiggestVerticalArea biggestVerticalArea;

        int lastSection = sections.size() - 1;
        long heightStrip = result.getHeightStrip();
        Types.Rectangle lastRectangle = sections.get(lastSection).getRectangles().get(0);

        ArrayList<Types.Result> results = new ArrayList<>();
        results.add(result);

        for (Types.Combination combination : combinations) {

            biggestVerticalArea = findBiggest(combination, lastRectangle, verticalAreas);
            if (biggestVerticalArea != null) {

                results.add(new Types.Result(result.getHeightStrip(), result.getMapRectangles(), result.getEmptyAreas()));
                newHeight = calculateNewHeight(heightStrip, biggestVerticalArea, lastRectangle);

                do {
                    biggestVerticalArea = fillBiggestArea(biggestVerticalArea, lastRectangle);
                    if (!biggestVerticalArea.placed) break;
                    newHeight = calculateNewHeight(heightStrip, biggestVerticalArea, lastRectangle);
                    sections.remove(lastSection);
                    lastSection = sections.size() - 1;
                    lastRectangle = sections.get(lastSection).getRectangles().get(0);

                } while (biggestVerticalArea.placed);

            }

        }

        return result;
    }

    Types.BiggestVerticalArea fillBiggestArea(Types.BiggestVerticalArea biggestVerticalArea, Types.Rectangle rectangle) {

        int lastNop = biggestVerticalArea.getLastNumberOfPut();
        ArrayList<Types.BVAreas> newBVAreas = new ArrayList<>();

        for (int i = 0; i < biggestVerticalArea.getAreas().size(); i++) {

            if ((rectangle.getW() <= biggestVerticalArea.getAreas().get(i).getW() && rectangle.getH() <= biggestVerticalArea.getAreas().get(i).getH()) ||
                    (rectangle.getH() <= biggestVerticalArea.getAreas().get(i).getW() && rectangle.getW() <= biggestVerticalArea.getAreas().get(i).getH())) {

                //TODO изменение в результате
                putRectangleInNewPosition(biggestVerticalArea.getAreas().get(i), rectangle);
                biggestVerticalArea.placed = true;

                biggestVerticalArea.getRectangles().add(rectangle);

                //Init Variation 0
                if (biggestVerticalArea.getAreas().get(i).getVariation() == 0) {

                    newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                            biggestVerticalArea.getAreas().get(0).getW() - rectangle.getW(), rectangle.getH(), 1, 1));
                    newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                            biggestVerticalArea.getAreas().get(0).getW() - rectangle.getW(), biggestVerticalArea.getAreas().get(0).getH(), 1, 2));
                    newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                            rectangle.getW(), biggestVerticalArea.getAreas().get(0).getH() - rectangle.getH(), 1, 3));
                    newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                            biggestVerticalArea.getAreas().get(0).getW(), biggestVerticalArea.getAreas().get(0).getH() - rectangle.getH(), 1, 4));

                    biggestVerticalArea.getAreas().remove(0);
                    biggestVerticalArea.getAreas().addAll(newBVAreas);
                    newBVAreas.clear();

                    return biggestVerticalArea;
                }

                //Variation 1
                else if (biggestVerticalArea.getAreas().get(i).getVariation() == 1) {

                    final int NOP = biggestVerticalArea.getAreas().get(i).getNumberOfPut();
                    biggestVerticalArea.getAreas().removeIf(bvArea -> bvArea.getNumberOfPut() == NOP && bvArea.getVariation() == 2);

                    if (rectangle.getW() == biggestVerticalArea.getAreas().get(i).getW()) {
                        biggestVerticalArea.getAreas().add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 3));
                        checkAreas(false, biggestVerticalArea.getRectangles(), biggestVerticalArea.getAreas());

                        return biggestVerticalArea;
                    } else if (rectangle.getH() == biggestVerticalArea.getAreas().get(i).getH()) {
                        biggestVerticalArea.getAreas().get(i).setX(biggestVerticalArea.getAreas().get(i).getX() + rectangle.getW());
                        biggestVerticalArea.getAreas().get(i).setW(biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW());

                        return biggestVerticalArea;
                    } else {
                        biggestVerticalArea.getAreas().removeIf(bvArea -> bvArea.getNumberOfPut() == NOP && bvArea.getVariation() == 1);

                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), rectangle.getH(), lastNop + 1, 1));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH(), lastNop + 1, 2));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 3));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                biggestVerticalArea.getAreas().get(i).getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 4));

                        biggestVerticalArea.getAreas().addAll(newBVAreas);
                        newBVAreas.clear();

                        return biggestVerticalArea;
                    }
                }

                //Variation 2
                else if (biggestVerticalArea.getAreas().get(i).getVariation() == 2) {

                    final int NOP = biggestVerticalArea.getAreas().get(i).getNumberOfPut();
                    biggestVerticalArea.getAreas().removeIf(bvArea -> bvArea.getNumberOfPut() == NOP &&
                            (bvArea.getVariation() == 1 || bvArea.getVariation() == 2 || bvArea.getVariation() == 4));

                    if (rectangle.getW() == biggestVerticalArea.getAreas().get(i).getW()) {
                        biggestVerticalArea.getAreas().add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 3));

                    } else {
                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), rectangle.getH(), lastNop + 1, 1));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH(), lastNop + 1, 2));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 3));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                biggestVerticalArea.getAreas().get(i).getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 4));

                        biggestVerticalArea.getAreas().addAll(newBVAreas);
                        newBVAreas.clear();

                    }
                    checkAreas(true, biggestVerticalArea.getRectangles(), biggestVerticalArea.getAreas());
                    if (rectangle.getY() + rectangle.getH() > biggestVerticalArea.rectanglesHeight)
                        biggestVerticalArea.rectanglesHeight = rectangle.getY() + rectangle.getH();
                    return biggestVerticalArea;
                }

                //Variation 3
                else if (biggestVerticalArea.getAreas().get(i).getVariation() == 3) {

                    final int NOP = biggestVerticalArea.getAreas().get(i).getNumberOfPut();
                    biggestVerticalArea.getAreas().removeIf(bvArea -> bvArea.getNumberOfPut() == NOP &&
                            (bvArea.getVariation() == 3 || bvArea.getVariation() == 4));

                    if (rectangle.getW() == biggestVerticalArea.getAreas().get(i).getW()) {
                        biggestVerticalArea.getAreas().get(i).setY(biggestVerticalArea.getAreas().get(i).getY() + rectangle.getH());
                        biggestVerticalArea.getAreas().get(i).setH(biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH());

                    } else {
                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), rectangle.getH(), lastNop + 1, 1));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH(), lastNop + 1, 2));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 3));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                biggestVerticalArea.getAreas().get(i).getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 4));

                        biggestVerticalArea.getAreas().addAll(newBVAreas);
                        newBVAreas.clear();

                    }
                    checkAreas(false, biggestVerticalArea.getRectangles(), biggestVerticalArea.getAreas());
                    if (rectangle.getY() + rectangle.getH() > biggestVerticalArea.rectanglesHeight)
                        biggestVerticalArea.rectanglesHeight = rectangle.getY() + rectangle.getH();
                    return biggestVerticalArea;
                }

                //Variation 4
                else if (biggestVerticalArea.getAreas().get(i).getVariation() == 4) {

                    final int NOP = biggestVerticalArea.getAreas().get(i).getNumberOfPut();
                    biggestVerticalArea.getAreas().removeIf(bvArea -> bvArea.getNumberOfPut() == NOP &&
                            (bvArea.getVariation() == 2 || bvArea.getVariation() == 3 || bvArea.getVariation() == 4));

                    if (rectangle.getW() == biggestVerticalArea.getAreas().get(i).getW()) {
                        biggestVerticalArea.getAreas().add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 3));

                    } else {
                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), rectangle.getH(), lastNop + 1, 1));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX() + rectangle.getW(), rectangle.getY(),
                                biggestVerticalArea.getAreas().get(i).getW() - rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH(), lastNop + 1, 2));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                rectangle.getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 3));
                        newBVAreas.add(new Types.BVAreas(rectangle.getX(), rectangle.getY() + rectangle.getH(),
                                biggestVerticalArea.getAreas().get(i).getW(), biggestVerticalArea.getAreas().get(i).getH() - rectangle.getH(), lastNop + 1, 4));

                        biggestVerticalArea.getAreas().addAll(newBVAreas);
                        newBVAreas.clear();

                    }
                    checkAreas(false, biggestVerticalArea.getRectangles(), biggestVerticalArea.getAreas());
                    if (rectangle.getY() + rectangle.getH() > biggestVerticalArea.rectanglesHeight)
                        biggestVerticalArea.rectanglesHeight = rectangle.getY() + rectangle.getH();
                    return biggestVerticalArea;

                }

            } else biggestVerticalArea.placed = false;
        }

        return biggestVerticalArea;
    }

    void checkAreas(boolean merging, ArrayList<Types.Rectangle> rectangles, ArrayList<Types.BVAreas> areas) {

        if (merging) {
            for (int i = 0; i < areas.size(); i++) {
                for (int j = 1; j < areas.size(); j++) {
                    if (areas.get(i).getX() + areas.get(i).getW() == areas.get(j).getX() &&
                            areas.get(i).getVariation() == 3 && areas.get(j).getVariation() == 3) {
                        areas.add(new Types.BVAreas(areas.get(i).getX(), areas.get(j).getY(), areas.get(i).getW() + areas.get(j).getW(), areas.get(j).getH(), 0, 0));
                    }
                    if (areas.get(i).getX() + areas.get(i).getW() == areas.get(j).getX() &&
                            areas.get(i).getVariation() == 3 && areas.get(j).getVariation() == 4) {
                        areas.add(new Types.BVAreas(areas.get(i).getX(), areas.get(j).getY(), areas.get(i).getW() + areas.get(j).getW(), areas.get(j).getH(), 0, 0));
                    }
                }
            }
        }

        for (Types.BVAreas area : areas) {
            for (Types.Rectangle rectangle : rectangles) {
                if (area.getX() < rectangle.getX() + rectangle.getW() &&
                        area.getY() + area.getH() > rectangle.getY()) {
                    area.setH(rectangle.getY() - (area.getY() + area.getH()));
                }
            }
        }
    }

    long calculateNewHeight(long heightStrip, Types.BiggestVerticalArea biggestVerticalArea, Types.Rectangle rectangle) {

        long newHeight = heightStrip - rectangle.getH();
        long check = biggestVerticalArea.rectanglesHeight;

        if (newHeight < check) newHeight = check;

        return newHeight;
    }

    void putRectangleInNewPosition(Types.BVAreas area, Types.Rectangle rectangle) {

        long intermediateW;

        rectangle.setX(area.getX());
        rectangle.setY(area.getY());

        if (rectangle.getW() > area.getW()) {
            intermediateW = rectangle.getW();
            rectangle.setW(rectangle.getH());
            rectangle.setH(intermediateW);
        }
    }

    Types.BiggestVerticalArea findBiggest(Types.Combination combination, Types.Rectangle rectangle, ArrayList<Types.Area> verticalAreas) {

        Types.BiggestVerticalArea biggestVerticalArea;
        ArrayList<Types.BVAreas> bvAreas = new ArrayList<>();
        ArrayList<Types.Rectangle> rectangles = new ArrayList<>();

        for (int i = 0; i < combination.getCombination().size(); i++) {
            if (rectangle.getW() <= verticalAreas.get(combination.getCombination().get(i)).getW() &&
                    rectangle.getH() <= verticalAreas.get(combination.getCombination().get(i)).getH()) {

                rectangles.add(rectangle);
                bvAreas.add(new Types.BVAreas(verticalAreas.get(combination.getCombination().get(i)).getX(), verticalAreas.get(combination.getCombination().get(i)).getY(),
                        verticalAreas.get(combination.getCombination().get(i)).getW(), verticalAreas.get(combination.getCombination().get(i)).getH(), 0, 0));

                biggestVerticalArea = new Types.BiggestVerticalArea(true, bvAreas, rectangles, verticalAreas.get(combination.getCombination().get(i)).getY() + rectangle.getH());
                rectangles.clear();
                bvAreas.clear();

                return biggestVerticalArea;

            } else if (rectangle.getH() <= verticalAreas.get(combination.getCombination().get(i)).getW() &&
                    rectangle.getW() <= verticalAreas.get(combination.getCombination().get(i)).getH()) {

                rectangles.add(rectangle);
                bvAreas.add(new Types.BVAreas(verticalAreas.get(combination.getCombination().get(i)).getX(), verticalAreas.get(combination.getCombination().get(i)).getY(),
                        verticalAreas.get(combination.getCombination().get(i)).getW(), verticalAreas.get(combination.getCombination().get(i)).getH(), 0, 0));

                biggestVerticalArea = new Types.BiggestVerticalArea(true, bvAreas, rectangles, verticalAreas.get(combination.getCombination().get(i)).getY() + rectangle.getW());
                rectangles.clear();
                bvAreas.clear();

                return biggestVerticalArea;

            }
        }

        return null;
    }
}
