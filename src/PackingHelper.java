import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PackingHelper {

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

    ArrayList<ArrayList<Integer>> combinationsOfAreas(ArrayList<Types.Area> areas) {

        Types.Area firstCandidate = null;
        Types.Area interCandidate;
        ArrayList<Types.Area> interCandidates;
        ArrayList<Types.Area> candidatesCopy = null;

        ArrayList<Integer> sortedAreas = new ArrayList<>();
        ArrayList<Integer> combination = new ArrayList<>();
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<Types.Area> candidates = new ArrayList<>();

        ArrayList<Types.Area> copy = new ArrayList<>(areas);
        Comparator<Types.Area> c = Collections.reverseOrder(new Types.sortAreasByHeight());
        copy.sort(c);

        for (Types.Area element : copy) {
            sortedAreas.add(areas.indexOf(element));
        }

        do {
            if (candidates.isEmpty()) {
                firstCandidate = areas.get(sortedAreas.get(0));
                sortedAreas.remove(0);
                candidates = formCandidates(firstCandidate, areas);
                candidatesCopy = new ArrayList<>(candidates);
            }

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

            combinations.add(new ArrayList<>(combination));
            combination.clear();

        } while (!sortedAreas.isEmpty());

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
}
