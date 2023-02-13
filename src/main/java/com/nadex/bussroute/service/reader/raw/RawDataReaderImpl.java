package com.nadex.bussroute.service.reader.raw;

import com.nadex.bussroute.service.validator.RouteValidator;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;

@Component
public class RawDataReaderImpl implements DataReader {
    private final BufferedReader reader;
    private final RouteValidator validator;
    private StringBuilder builder = new StringBuilder();

    public RawDataReaderImpl(BufferedReader reader, RouteValidator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    @Override
    public StringBuilder read() throws IOException {
        while (reader.ready()){
            builder.setLength(0);
            if (validator.isValid(builder.append(reader.readLine()))) {
                return builder;
            }
        }
        return builder = null;
    }
}
