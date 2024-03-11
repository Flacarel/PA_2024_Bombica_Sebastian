package lab3;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable{
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Concert(String name, String description, String image, Map<LocalDate, TimeInterval> timetable, double ticketPrice) {
        super(name, description, image);
        this.timetable = timetable;
        this.ticketPrice = ticketPrice;
    }

    public Concert(Map<LocalDate, TimeInterval> timetable, double ticketPrice) {
        this.timetable = timetable;
        this.ticketPrice = ticketPrice;
    }
}
