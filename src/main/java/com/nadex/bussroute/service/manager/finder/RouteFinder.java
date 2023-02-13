package com.nadex.bussroute.service.manager.finder;

import com.nadex.bussroute.domain.container.AbstractContainer;

public interface RouteFinder<T extends AbstractContainer> {
    boolean find(int x, int y);
}
