package bsz.service;

import bsz.dao.AuditoriumDao;
import bsz.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

/**
 * @author Yuriy_Tkach
 */
public class AuditoriumServiceImp {

    AuditoriumDao auditoriumDao;

    public AuditoriumServiceImp(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    /**
     * Getting all auditoriums from the system
     * 
     * @return set of all auditoriums
     */
    public @Nonnull Set<Auditorium> getAll() {
        return auditoriumDao.getAll();
    }

    /**
     * Finding auditorium by name
     * 
     * @param name
     *            Name of the auditorium
     * @return found auditorium or <code>null</code>
     */
    public @Nullable Auditorium getByName(@Nonnull String name) {
        Auditorium returnValue = null;

        Set<Auditorium> auditoriums = getAll();

        for (Auditorium auditorium : auditoriums) {
            if (name.equals(auditorium.getName())) {
                returnValue = auditorium;
            }
        }
        return returnValue;
    }

}
