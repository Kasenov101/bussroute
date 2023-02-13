package com.nadex.bussroute.service.manager.finder;

import com.nadex.bussroute.domain.container.RouteContainer;
import com.nadex.bussroute.repository.RoutesRepository;
import org.springframework.stereotype.Component;

@Component
public class RouteFinderImpl implements RouteFinder<RouteContainer> {
    private final RoutesRepository repository;
    public RouteFinderImpl(RoutesRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean find(int x, int y) {
        AbstractThreadingSearch top = new SearchFromTop
                (x,y,repository.getOriginal(), repository.getSorted());

        AbstractThreadingSearch bottom = new SearchFromBottom
                (x,y,repository.getOriginal(),repository.getSorted());

        Thread thread1 = new Thread(top);
        Thread thread2 = new Thread(bottom);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            if (top.isPresent()) return true;
            thread2.join();
            return top.isPresent() ^ bottom.isPresent();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
