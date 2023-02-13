package com.nadex.bussroute.service.reader.raw;

import java.io.IOException;


public interface DataReader{
    StringBuilder read() throws IOException;
}
