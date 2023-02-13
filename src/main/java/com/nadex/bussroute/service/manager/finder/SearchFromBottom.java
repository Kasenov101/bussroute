package com.nadex.bussroute.service.manager.finder;

import com.nadex.bussroute.domain.container.RouteContainer;

import java.util.Arrays;
import java.util.List;

public class SearchFromBottom extends AbstractThreadingSearch {
    public SearchFromBottom(int x, int y, List<RouteContainer> original, List<RouteContainer> sorted) {
        super(x, y, original, sorted);
    }

    @Override
    public void run() {
        for (int i = sorted.size() - 1; i >= sorted.size() / 2; i--) {
            xIndex = Arrays.binarySearch(sorted.get(i).getPoints(),x);
            if (xIndex != -1) {
                yIndex = Arrays.binarySearch(sorted.get(i).getPoints(),y);
                if(yIndex != -1) {
                    if (checkXBeforeY(x,y, original.get(i).getPoints())) {
                        isPresent = true;
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
