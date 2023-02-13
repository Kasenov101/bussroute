package com.nadex.bussroute.service.reader.extractor;

import java.util.LinkedHashSet;

public interface Extractor {

    int extractId(StringBuilder builder);

    LinkedHashSet<String> extractPoints(StringBuilder builder);
}
