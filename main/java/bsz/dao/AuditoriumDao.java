package bsz.dao;

import bsz.domain.Auditorium;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;

public class AuditoriumDao {

    private Auditorium auditorium1;

    private Auditorium auditorium2;



    public Set<Auditorium> auditoriums = new TreeSet<>();

    public AuditoriumDao(Auditorium auditorium1, Auditorium auditorium2) {
        this.auditorium1 = auditorium1;
        this.auditorium2 = auditorium2;
        auditoriums.add(auditorium1);
        auditoriums.add(auditorium2);
    }

    public @Nullable
    Auditorium save(Auditorium auditorium) {
        auditoriums.add(auditorium);
        return auditorium;
    }

    public @Nullable
    Auditorium getByName(@Nonnull String name) {
        var ref = new Object() {
            Auditorium retval = null;
        };
        auditoriums.forEach(auditorium -> {
            if (auditorium.getName().equals(name)) {
                ref.retval = auditorium;
            }
        });
        return ref.retval;
    }


    public Set<Auditorium> getAll() {
        return auditoriums;
    }

    public Set<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }


}
