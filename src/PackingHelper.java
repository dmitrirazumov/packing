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

        Types.Rectangles lastSection = sections.get(sections.size() - 1);
        ArrayList<Types.Result> results = new ArrayList<>();

        results.add(result);

        for (Types.Combination combination : combinations) {

            putBiggest(results.get(0), lastSection, verticalAreas, combination);
        }

        return result;
    }

    void putBiggest(Types.Result result, Types.Rectangles lastSection, ArrayList<Types.Area> verticalAreas, Types.Combination combination) {

        for (int i = 0; i < combination.getCombination().size(); i++) {
            if (lastSection.getRectangles().get(0).getW() <= verticalAreas.get(i).getW() &&
                    lastSection.getRectangles().get(0).getH() <= verticalAreas.get(i).getH()) {

            } else if (lastSection.getRectangles().get(0).getH() <= verticalAreas.get(i).getW() &&
                    lastSection.getRectangles().get(0).getW() <= verticalAreas.get(i).getH()) {

            }
        }
    }
}
