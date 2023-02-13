package com.nadex.bussroute.service.manager.copier;

import com.nadex.bussroute.domain.container.RouteContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RouteCopierImpl implements RouteCopier<RouteContainer> {

    @Override
    @Bean("sortedContainersList")
    public List<RouteContainer> copy(@Qualifier("originalContainersList")
                                                   List<RouteContainer> container) {
        List<RouteContainer> sortedClone = new ArrayList<>(container.size());
        for (RouteContainer con:container) {
            sortedClone.add(new RouteContainer(con.getRoute(),
                    Arrays.stream(con.getPoints()).sorted().toArray()));
        }
        return sortedClone;
    }
}
