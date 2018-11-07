package bsz.ui.actions;

import bsz.service.AuditoriumServiceImp;
import bsz.service.EventServiceImp;


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
        listEvents(eventService);
    }
}

