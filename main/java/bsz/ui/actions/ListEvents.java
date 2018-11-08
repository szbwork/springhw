package bsz.ui.actions;

import bsz.domain.Auditorium;
import bsz.service.AuditoriumServiceImp;
import bsz.service.EventServiceImp;

import java.util.Set;


public class ListEvents extends EventAction implements MenuAction {

    private EventServiceImp eventService;
    private AuditoriumServiceImp auditoriumService;

    public void setEventService(EventServiceImp eventService) {
        this.eventService = eventService;
    }

    public void setAuditoriumService(AuditoriumServiceImp auditoriumService) {
        this.auditoriumService = auditoriumService;
    }

    @Override
    public void doAction() {
//        Set<Auditorium> auditoriums = auditoriumService.getAll();
//        System.out.println("Valid auditorium names:");
//        auditoriums.forEach(auditorium -> System.out.print(auditorium.getName() + ", "));
//        System.out.println("numberOfSeats:");
//        auditoriums.forEach(auditorium -> System.out.print(auditorium.getNumberOfSeats() + ", "));

        listEvents(eventService);
    }
}

