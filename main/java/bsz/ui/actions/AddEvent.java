package bsz.ui.actions;

import bsz.domain.Auditorium;
import bsz.domain.Event;
import bsz.domain.EventRating;
import bsz.domain.User;
import bsz.service.AuditoriumServiceImp;
import bsz.service.EventServiceImp;
import bsz.service.UserServiceImp;
import bsz.ui.GetInput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class AddEvent extends EventAction implements MenuAction {


    private EventServiceImp eventService;
    private AuditoriumServiceImp auditoriumService;

    @Override
    public void doAction() {
        Event event = getEventData();
        eventService.save(event);
        listEvents(eventService);
    }

    private Event getEventData() {
        Event event;

        String eventName = GetInput.read("Event name ? ", false);
        String basePrice = GetInput.read("Base price ? ", false);
        String eventRating = GetInput.read("Event rating ? ", false);
//        String auditoriumName = GetInput.read("Auditorium name ? ", false);
        event = eventService.createEvent(eventName,  Double.parseDouble(basePrice), EventRating.valueOf(eventRating));
        event.addAirDateTime(createAirDate(), createAuditorium());
        return event;
    }

    private LocalDateTime createAirDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime airDate = null;
        boolean airDateIsBad =true;

        while (airDateIsBad) {
            try {
//                String date = GetInput.read("Event date (yyyy-MM-dd HH:mm) ? ", false);
                String date = "2018-01-01 00:00";
                airDate = LocalDateTime.parse(date, formatter);
                airDateIsBad =false;
            }
            catch (DateTimeParseException e) {
                System.out.println(" DateTimeParseException, try again !");
            }
        }
        return airDate;
    }

    private Auditorium createAuditorium() {
        Auditorium auditorium =null;
        boolean auditoriumIsNotFound =true;
        Set<Auditorium> auditoriums = auditoriumService.getAll();
        System.out.println("Valid auditorium names:");
        auditoriums.forEach((auditorium2) -> System.out.print(auditorium2.getName() + ", "));
        while (auditoriumIsNotFound) {
            String auditoriumName = GetInput.read("Auditorium name ? ", false);
            auditorium = auditoriumService.getByName(auditoriumName);
                if (auditorium != null) {
                    auditoriumIsNotFound = false;
                }
                else {
                    System.out.println(" Auditorium was not found, try again !");
                }
        }
        return auditorium;
    }


    private NavigableSet<LocalDateTime> createAirDates(String...dates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        NavigableSet<LocalDateTime> airDates = new TreeSet<>();
        for (String date: dates) {
            airDates.add(LocalDateTime.parse(date, formatter));
        }
        return airDates;
    }

    public void setEventService(EventServiceImp eventService) {
        this.eventService = eventService;
    }

    public void setAuditoriumService(AuditoriumServiceImp auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

}

