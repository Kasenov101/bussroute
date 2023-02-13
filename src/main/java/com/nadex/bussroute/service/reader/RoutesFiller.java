package com.nadex.bussroute.service.reader;

import com.nadex.bussroute.domain.container.RouteContainer;
import com.nadex.bussroute.service.reader.extractor.RouteExtractor;
import com.nadex.bussroute.service.reader.raw.DataReader;
import com.nadex.bussroute.service.reader.raw.RawDataReaderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class RoutesFiller implements Filler<DataReader,RouteExtractor>{
    private final DataReader reader;
    private final RouteExtractor extractor;

    public RoutesFiller(RawDataReaderImpl reader, RouteExtractor extractor) {
        this.reader = reader;
        this.extractor = extractor;
    }

    @Override
    @Bean("originalContainersList")
    public List<RouteContainer> fill() throws IOException {
        List<RouteContainer> original = new ArrayList<>();
        StringBuilder builder;
        while ((builder = reader.read()) != null) {
            original.add(extractor.getContainer(builder));
            }
        return original;
    }


}
