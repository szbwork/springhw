package bsz.ui.actions;

import bsz.domain.Auditorium;
import bsz.domain.Event;
import bsz.domain.EventRating;
import bsz.domain.User;
import bsz.service.AuditoriumServiceImp;
import bsz.service.EventServiceImp;
import bsz.ui.GetInput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveEvent extends EventAction implements MenuAction {

    private EventServiceImp eventService;

    @Override
    public void doAction() {
        eventService.remove(eventService.getByName(getEventname()));
        listEvents(eventService);
    }

    private String getEventname() {
        return GetInput.read("Event name ? ", false);
    }

    public void setEventService(EventServiceImp eventService) {
        this.eventService = eventService;
    }
}


