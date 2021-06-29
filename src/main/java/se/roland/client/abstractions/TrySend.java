package se.roland.client.abstractions;

import java.io.IOException;

public interface TrySend {
    boolean send(Object o) throws IOException;

}
