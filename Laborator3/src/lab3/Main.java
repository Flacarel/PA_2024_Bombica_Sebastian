package lab3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<LocalDate, TimeInterval> timetable = new HashMap<>();
        timetable.put(LocalDate.of(2021, 6, 1), new TimeInterval(LocalTime.of(19, 0), LocalTime.of(21, 0)));
        Concert concert = new Concert("Concert", "Concert description", "Concert image",timetable,100);
        Church church = new Church("Church", "Church description", "Church image",timetable);
        Statue statue = new Statue("Statue", "Statue description", "Statue image",timetable);
        System.out.println(concert);
        System.out.println(church);
        System.out.println(statue);
        System.out.println();
        ArrayList<Attraction> attractions = new ArrayList<>();
        Trip trip = new Trip("Bucharest", LocalDate.of(2021, 6, 1), LocalDate.of(2021, 6, 2));
        attractions.add(concert);
        attractions.add(church);
        attractions.add(statue);
        trip.setAttractions(attractions);
        System.out.println(trip);
        System.out.println();

        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addAttraction(concert, LocalDate.of(2021, 6, 1));
        travelPlan.addAttraction(church, LocalDate.of(2021, 6, 2));
        travelPlan.addAttraction(statue, LocalDate.of(2021, 6, 3));

        System.out.println(travelPlan);
    }


}