package com.nadex.bussroute.service.reader.extractor;

import com.nadex.bussroute.domain.container.AbstractContainer;

public abstract class AbstractContainerExtractor<T extends Extractor, O extends AbstractContainer>{
    private final T extractor;

    protected AbstractContainerExtractor(T extractor) {
        this.extractor = extractor;
    }

     public abstract O getContainer(StringBuilder builder);
}
