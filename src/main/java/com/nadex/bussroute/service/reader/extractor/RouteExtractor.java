package com.nadex.bussroute.service.reader.extractor;

import com.nadex.bussroute.domain.container.RouteContainer;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

@Component
public class RouteExtractor extends AbstractContainerExtractor<RawDataExtractor, RouteContainer> {

    private final RawDataExtractor extractor;
    protected RouteExtractor(RawDataExtractor extractor) {
        super(extractor);
        this.extractor = extractor;
    }

    @Override
    public RouteContainer getContainer(StringBuilder builder) {
        return new RouteContainer(extractor.extractId(builder)
                ,convertToArrayAndFilter(extractor.extractPoints(builder)));
    }

    private int[] convertToArrayAndFilter(LinkedHashSet<String> set) {
        return  set.stream()
                .mapToInt(str -> {
                            try {
                                return Integer.parseInt(str);
                            } catch (NumberFormatException ignored) {
                            }
                            return 0;
                        }
                ).filter(num -> num >= 1).toArray();
    }
}
