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
        System.out.println("Event name: " + event.getName() + "Rating: " + event.getRating().toString() + "Base price: " + String.valueOf(event.getBasePrice()));
        event.getAuditoriums().forEach((localDateTime, auditorium) -> printDateTimeAndAuditorium(localDateTime, auditorium));
    }

    private void printDateTimeAndAuditorium(LocalDateTime localDateTime, Auditorium auditorium) {
        System.out.println("    Date & time: " + localDateTime.toString() + " Auditorium: " + auditorium.getName());
    }

}

