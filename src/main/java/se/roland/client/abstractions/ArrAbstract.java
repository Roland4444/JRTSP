package se.roland.client.abstractions;

import java.io.IOException;
import java.util.List;

public abstract  class ArrAbstract {
    public abstract Object Head() throws IOException;
    public abstract List Tail() throws IOException;

}
