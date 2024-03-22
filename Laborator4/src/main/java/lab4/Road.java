package lab4;

import java.util.ArrayList;
import java.util.List;

public class Road {
    private List<String> destinations;

    public Road(List<String> destinations) {
        this.destinations =new ArrayList<>(destinations) ;
    }

    public List<String> getDestinations() {
        return destinations;
    }
}
