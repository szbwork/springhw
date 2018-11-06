package bsz.dao;

import bsz.domain.Auditorium;
import javax.annotation.Nullable;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class AuditoriumDao {

    private Auditorium auditorium;
    private NavigableSet<Auditorium> auditoriums = new TreeSet<>();

    public AuditoriumDao(Auditorium auditorium) {
        save(auditorium);
    }

    public @Nullable
    Auditorium save(Auditorium auditorium) {
        auditoriums.add(auditorium);
        return auditorium;
    }

    public Set<Auditorium> getAll() {
        return auditoriums;
    }

}
