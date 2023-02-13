package com.nadex.bussroute.dto.projection;

public record RouteProjectionResponse(int from, int to, boolean direct) {
    public RouteProjectionResponse(int from, int to, boolean direct) {
        this.from = from;
        this.to = to;
        this.direct = direct;
    }
}