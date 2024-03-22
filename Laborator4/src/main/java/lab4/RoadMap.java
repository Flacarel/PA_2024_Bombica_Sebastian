package lab4;

import java.util.ArrayList;
import java.util.List;

public class RoadMap {
    private List<Road> roads;

    public RoadMap(List<Road> roads) {
        this.roads = new ArrayList<>(roads);
    }

    public List<Road> getRoads() {
        return roads;
    }
}
