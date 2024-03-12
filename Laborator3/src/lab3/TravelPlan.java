package lab3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Map<Attraction, LocalDate> plan;

    public TravelPlan() {
        this.plan = new HashMap<>();
    }

    public void addAttraction(Attraction attraction, LocalDate date) {
        this.plan.put(attraction, date);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Attraction, LocalDate> entry : plan.entrySet()) {
            sb.append("Attraction: ").append(entry.getKey().getName())
                    .append(", Date: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}