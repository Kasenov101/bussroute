package com.nadex.bussroute.service.reader;

import com.nadex.bussroute.domain.container.RouteContainer;
import com.nadex.bussroute.service.reader.extractor.AbstractContainerExtractor;
import com.nadex.bussroute.service.reader.extractor.RawDataExtractor;
import com.nadex.bussroute.service.reader.raw.DataReader;

import java.io.IOException;
import java.util.List;

public interface Filler<R extends DataReader,
        E extends AbstractContainerExtractor<RawDataExtractor,RouteContainer>> {
    List<RouteContainer> fill() throws IOException;
}
