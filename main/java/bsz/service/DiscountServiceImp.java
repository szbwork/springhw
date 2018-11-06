package bsz.service;

import bsz.domain.Event;
import bsz.domain.User;
import bsz.service.strategies.DiscountStrategy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

public class DiscountServiceImp implements DiscountService {
    private List<DiscountStrategy> strategies;

    public DiscountServiceImp(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        byte discount = 0;

        for (DiscountStrategy strategy : strategies) {
            byte possibleDiscount = strategy.calculatePossibleDiscount(user, event, airDateTime, numberOfTickets);

            if (possibleDiscount > discount) {
                discount = possibleDiscount;
            }
        }

        return discount;
    }
}
