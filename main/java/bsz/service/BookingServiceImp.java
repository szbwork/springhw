package bsz.service;

import bsz.domain.Auditorium;
import bsz.domain.Event;
import bsz.domain.Ticket;
import bsz.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yuriy_Tkach
 */
public class BookingServiceImp implements BookingService {

    private DiscountService discountService;
    private UserService userService;
    private Double vipSeatRateMultiplier = Double.valueOf(2);

    public BookingServiceImp(DiscountService discountService, UserService userService) {
        this.discountService = discountService;
        this.userService = userService;
    }

    /**
     * Getting price when buying all supplied seats for particular event
     *
     * @param event    Event to get base ticket price, vip seats and other
     *                 information
     * @param dateTime Date and time of event air
     * @param user     User that buys ticket could be needed to calculate discount.
     *                 Can be <code>null</code>
     * @param seats    Set of seat numbers that user wants to buy
     * @return total price
     */
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user,
                                  @Nonnull Set<Long> seats) {
        Double price;
        byte discountPercent = discountService.getDiscount(user, event, dateTime, seats.size());

        Double basePrice = event.getBasePrice();
        Set<Long> normalSeats = this.getNormalSeats(event, dateTime, seats);
        Set<Long> vipSeats = this.getVipSeats(event, dateTime, seats);

        price = ((normalSeats.size() * basePrice * getEventRateMultiplier(event))
                + (vipSeats.size() * basePrice * vipSeatRateMultiplier * getEventRateMultiplier(event))) * (100 - discountPercent) / 100;

        return price;
    }


    private Double getEventRateMultiplier(Event event) {
        Double result = 1.0;
        switch (event.getRating()) {
            case LOW:
                result = 1.0;
                break;
            case MID:
                result = 1.1;
                break;
            case HIGH:
                result = 1.3;
                break;
        }
        return result;
    }

    private Set<Long> getNormalSeats(Event event, LocalDateTime dateTime, Set<Long> seats) {
        Set<Long> normalSeats = new TreeSet<>();
        Auditorium auditorium = event.getAuditoriums().get(dateTime);

        if (null != auditorium) {
            normalSeats = auditorium.getAvailableNormalSeats();
            normalSeats.retainAll(seats);
        }
        return normalSeats;
    }

    private Set<Long> getVipSeats(Event event, LocalDateTime dateTime, Set<Long> seats) {
        Set<Long> vipSeats = new TreeSet<>();
        Auditorium auditorium = event.getAuditoriums().get(dateTime);

        if (null != auditorium) {
            vipSeats = auditorium.getAvailableVipSeats();
            vipSeats.retainAll(seats);
        }
        return vipSeats;
    }

    /**
     * Books tickets in internal system. If user is not
     * <code>null</code> in a ticket then booked tickets are saved with it
     *
     * @param tickets Set of tickets
     */
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        Iterator<Ticket> iterator = tickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getUser() != null) {
                ticket.getUser().getTickets().add(ticket);
            }
        }
    }

    /**
     * Getting all purchased tickets for event on specific air date and time
     *
     * @param event    Event to get tickets for
     * @param dateTime Date and time of airing of event
     * @return set of all purchased tickets
     */
    public @Nonnull
    Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        List<User> users = new ArrayList<>(userService.getAll());
        Set<Ticket> purchasedTickets = new TreeSet<>();

        for (User user : users) {
            purchasedTickets.addAll(user.getTickets().stream().filter(ticket -> ticket.getEvent().equals(event) && ticket.getDateTime().equals(dateTime)).collect(Collectors.toSet()));
        }
        return purchasedTickets;
    }
}
