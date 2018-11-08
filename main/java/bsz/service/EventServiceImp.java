package bsz.service;

import bsz.dao.EventDao;
import bsz.domain.Auditorium;
import bsz.domain.Event;
import bsz.domain.EventRating;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

public class EventServiceImp implements EventService{

    EventDao eventDao;

    public EventServiceImp(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    /**
     * Finding event by name
     *
     * @param name Name of the event
     * @return found event or <code>null</code>
     */
    @Nullable
    @Override
    public Event getByName(@Nonnull String name) {

        return eventDao.getByName(name);
    }

    /**
     * Saving new object to storage or updating existing one
     *
     * @param object Object to save
     * @return saved object with assigned id
     */
    @Override
    public Event save(@Nonnull Event object) {
        return eventDao.save(object);
    }

    /**
     * Removing object from storage
     *
     * @param object Object to remove
     */
    @Override
    public void remove(@Nonnull Event object) {
        eventDao.remove(object);
    }

    /**
     * Getting object by id from storage
     *
     * @param id id of the object
     * @return Found object or <code>null</code>
     */
    @Override
    public Event getById(@Nonnull Long id) {
        return eventDao.getById(id);
    }

    /**
     * Getting all objects from storage
     *
     * @return collection of objects
     */
    @Nonnull
    @Override
    public Collection<Event> getAll() {
        return eventDao.getAll();
    }

    public @Nullable
    Event createEvent(String eventName, double basePrice, EventRating eventRating, String dateString, String auditoriumName) {
        return eventDao.createEvent(eventName, basePrice, eventRating, dateString, auditoriumName);
    }

    public @Nullable
    Event createEvent(String eventName, double basePrice, EventRating eventRating) {
        return eventDao.createEvent(eventName, basePrice, eventRating);
    }


}
