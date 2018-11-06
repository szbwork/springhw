package bsz.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author Yuriy_Tkach
 */
public class Auditorium implements Comparable< Auditorium >{

    private String name;

    private long numberOfSeats;

    private Set<Long> vipSeats = Collections.emptySet();

    private Set<Long> availableSeats = Collections.emptySet();
    private Set<Long> availableVipSeats = Collections.emptySet();

    private String numberOfSeatsString;

    private String vipSeatsString;

    public Auditorium() {
        setAvailableSeats(getAllSeats());
    }

    /**
     * Counts how many vip seats are there in supplied <code>seats</code>
     * 
     * @param seats
     *            Seats to process
     * @return number of vip seats in request
     */
    public long countVipSeats(Collection<Long> seats) {
        return seats.stream().filter(seat -> vipSeats.contains(seat)).count();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public long getNumberOfSeats() {
        return Long.parseLong(numberOfSeatsString);
    }

    public void setNumberOfSeatsString(String numberOfSeatsString) {
        this.numberOfSeatsString = numberOfSeatsString;
    }
    
    public Set<Long> getAllSeats() {
        return LongStream.range(1, numberOfSeats+1).boxed().collect(Collectors.toSet());
    }

    public Set<Long> getVipSeats() {
        HashSet<Long> vipSeatsSet = new HashSet(100);
        StringTokenizer st = new StringTokenizer(vipSeatsString, ",");
        while(st.hasMoreTokens())
            vipSeatsSet.add(Long.parseLong(st.nextToken()));
        return vipSeatsSet;
    }

    public void setVipSeatsString(String vipSeatsString) {
        this.vipSeatsString = vipSeatsString;
    }

    public Set<Long> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Set<Long> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void updateAvailableSeats(Set<Long> bookedSeats) {
        availableSeats.removeAll(bookedSeats);
        availableVipSeats.removeAll(bookedSeats);
    }

    public Set<Long> getAvailableNormalSeats() {
        Set<Long> resultSet = getAvailableSeats();
        resultSet.removeAll(availableVipSeats);
        return resultSet;
    }


    public Set<Long> getAvailableVipSeats() {
        return availableVipSeats;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Auditorium other = (Auditorium) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Auditorium a) {
        return name.compareTo(a.name);
    }
}
