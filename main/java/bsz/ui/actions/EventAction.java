package bsz.ui.actions;

import bsz.domain.Auditorium;
import bsz.domain.Event;
import bsz.service.EventServiceImp;

import java.time.LocalDateTime;

public class EventAction {

    protected void listEvents(EventServiceImp eventService) {
        System.out.println();
        System.out.println("____ List of events ________");
        eventService.getAll().forEach(event -> printEventData(event));
        System.out.println("___________________________\n");
    }

    private void printEventData(Event event) {
        System.out.println("Event name: " + event.getName() + " Event rating: " + event.getRating().toString() + " Event base price: " + String.valueOf(event.getBasePrice()));
        event.getAuditoriums().forEach((localDateTime, auditorium) -> printDateTimeAndAuditorium(localDateTime, auditorium));
    }

    private void printDateTimeAndAuditorium(LocalDateTime localDateTime, Auditorium auditorium) {
        System.out.println("Event date & time: " + localDateTime.toString() + " Event auditorium: " + auditorium.getName());
    }

}

