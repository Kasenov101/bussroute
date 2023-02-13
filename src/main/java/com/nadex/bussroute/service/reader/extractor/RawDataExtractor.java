package com.nadex.bussroute.service.reader.extractor;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashSet;

@Component
public class RawDataExtractor implements Extractor{

    @Override
    public int extractId(StringBuilder builder) {
        int index = builder.indexOf(" ");
        return Integer.parseInt(builder.substring(0,index));
    }

    @Override
    public LinkedHashSet<String> extractPoints(StringBuilder builder) {
        int indexAfterFirstNum = builder.indexOf(" ") + 1;
        return new LinkedHashSet<>(Arrays.asList(builder
                .substring(indexAfterFirstNum)
                .split("\\s")));
    }
}
