package bsz.service.strategies;

import bsz.domain.Event;
import bsz.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class BirthdayStrategy implements DiscountStrategy{
    private static final Integer BIRTHDAY_DISCOUNT_DURATION = 5;
    private static final byte BIRTHDAY_DISCOUNT_RATE = 5;

    @Override
    public byte calculatePossibleDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        if (null != user) {
            if (DAYS.between(airDateTime.toLocalDate(), user.getBirthDay()) <= BIRTHDAY_DISCOUNT_DURATION) {
                return BIRTHDAY_DISCOUNT_RATE;
            }
        }

        return 0;
    }

}
