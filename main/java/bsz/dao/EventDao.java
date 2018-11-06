package bsz.dao;

import bsz.domain.Auditorium;
import bsz.domain.Event;
import bsz.domain.EventRating;
import bsz.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by szb on 10/23/18.
 */
public class EventDao {

    private Map<Long, Event> events = new HashMap<>();

    public EventDao() {
        Event event1 = createEvent("event1", 10.0, EventRating.HIGH);
        Event event2 = createEvent("event2", 5.0, EventRating.LOW);
        events.put(event1.getId(), event1);
        events.put(event2.getId(), event2);
    }

    public @Nullable
    Event getById(Long id){
     return events.get(id);
    }

    public @Nullable
    Event getByName(@Nonnull String name) {
        final Event[] retval = {null};
                events.forEach((id, event) -> {
            if (event.getName().equals(name)) {
                retval[0] = event;
            }
        });
        return retval[0];
    }

    public @Nullable
    List<Event> getAll() {
        List eventList = new ArrayList();
        events.forEach((id, event) -> {
            eventList.add(event);
        });
        return eventList;
    }

    public @Nullable
    Event save(Event event) {
        long id = event.getId();
        events.put(id, event);
        return event;
    }

    public void remove(Event event) {
        events.remove(event.getId());
    }

    public @Nullable
    Event createEvent(String eventName, double basePrice, EventRating eventRating) {
        TreeSet<LocalDateTime> airDates = new TreeSet();
        TreeMap<LocalDateTime, Auditorium> auditoriums = new TreeMap<>();
        Event event = new Event();
        event.setAirDates(airDates);
        event.setName(eventName);
        event.setBasePrice(10);
        event.setRating(EventRating.MID);
        event.setAuditoriums(auditoriums);
        event.setId((long)event.hashCode());
        return event;
    }

    public User createNewUser() {
        return new User();
    }
}