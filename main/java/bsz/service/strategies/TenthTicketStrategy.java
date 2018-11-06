package bsz.service.strategies;

import bsz.domain.Event;
import bsz.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

public class TenthTicketStrategy implements DiscountStrategy {

    @Override
    public byte calculatePossibleDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        double fullPrice = event.getBasePrice()*numberOfTickets;
        double discount = event.getBasePrice()*(int)(numberOfTickets/10)*0.05;
        double totalPrice = fullPrice-discount;
        return ((Double)((1-(totalPrice/fullPrice))*100)).byteValue();
    }

}
