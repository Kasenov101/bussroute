package com.nadex.bussroute.service.manager.finder;

import com.nadex.bussroute.domain.container.RouteContainer;

import java.util.List;

public abstract class AbstractThreadingSearch implements Runnable{
    protected int xIndex;
    protected int yIndex;
    protected final int x;
    protected final int y;
    protected boolean isPresent = false;
    protected final List<RouteContainer> original;
    protected final List<RouteContainer> sorted;

    protected AbstractThreadingSearch(int x, int y, List<RouteContainer> original,
                                      List<RouteContainer> sorted) {
        this.x = x;
        this.y = y;
        this.original = original;
        this.sorted = sorted;
    }

    protected boolean checkXBeforeY(int x, int y, int[] points) {
        boolean xIsPresent = false;
        for (int point : points) {
            if (point == x) xIsPresent = true;
            if (!xIsPresent & point == y) break;
            if (xIsPresent & point == y) {
                return true;
            }
        }
        return false;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
