package com.nadex.bussroute.repository;

import com.nadex.bussroute.domain.container.RouteContainer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class RoutesRepository {
    private final List<RouteContainer> original;
    private final List<RouteContainer> sorted;

    public RoutesRepository(@Qualifier("originalContainersList") List<RouteContainer> original,
                            @Qualifier("sortedContainersList") List<RouteContainer> sorted) {
        this.original = original;
        this.sorted = sorted;
    }
}
