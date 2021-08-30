/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Homework 02 - PlanetQuest Class
 */

public class PlanetQuest {

    private ArrayList planets;
    private Planet current;
    private double MAX_DISTANCE = 1000;

    public PlanetQuest(Planet current) {
        planets = new ArrayList();
        this.current = current;
    }

    public PlanetQuest() {
        this(new Planet());
    }

    // TODO: only add a new destination if distance from current planet to the given one is <= MAX_DISTANCE
    public void addPlanet(Planet planet) {
        if (current.distance(planet) <= MAX_DISTANCE) {
            planets.add(planet);
        }
    }

    // TODO: return the closest planet from current
    public Planet closest() {
        if (planets.isEmpty()) {
            return null;
        }
        int indexOfClosest = 0;
        for (int i = 1; i < planets.size() ; i++) {
            if (planets.get(i).distance(current) < planets.get(indexOfClosest).distance(current)) {
                indexOfClosest = i;
            }
        }
        return planets.get(indexOfClosest);
    }

    // TODO: return the farthest planet from current
    public Planet farthest() {
        if (planets.isEmpty()) {
            return null;
        }
        int indexOfFarthest = 0;
        for (int i = 1; i < planets.size() ; i++) {
            if (planets.get(i).distance(current) > planets.get(indexOfFarthest).distance(current)) {
                indexOfFarthest = i;
            }
        }
        return planets.get(indexOfFarthest);
    }

    @Override
    public String toString() {
        String str = planets.toString();
        str += "\nClosest: " + closest();
        str += "\nFarthest: " + farthest();
        return str;
    }
}
