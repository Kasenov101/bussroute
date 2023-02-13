package com.nadex.bussroute.сontroller;

import com.nadex.bussroute.dto.projection.RouteProjectionRequest;
import com.nadex.bussroute.dto.projection.RouteProjectionResponse;
import com.nadex.bussroute.exception.RouteRange;
import com.nadex.bussroute.service.manager.finder.RouteFinderImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/direct")
@Validated
public class RouteController {
    private final RouteFinderImpl finder;
    public RouteController(RouteFinderImpl finder) {
        this.finder = finder;
    }

    @PostMapping
    public ResponseEntity<RouteProjectionResponse> getDirectRoute(@Valid @RouteRange RouteProjectionRequest projection) {
        int from = (int) projection.from();
        int to = (int) projection.to();
        boolean isPresent = finder.find(from,to);
        return new ResponseEntity<>(new RouteProjectionResponse(from,to, isPresent), HttpStatus.OK);
    }

}
