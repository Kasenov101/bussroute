package com.nadex.bussroute.service.manager.copier;

import com.nadex.bussroute.domain.container.AbstractContainer;

import java.util.List;

public interface RouteCopier<T extends AbstractContainer> {

    List<T> copy(List<T> container);
}
