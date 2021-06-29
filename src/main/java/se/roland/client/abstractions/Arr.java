package se.roland.client.abstractions;

import java.util.List;

public class Arr {
    public Object Head(List elems){
        if (elems.size()>0)
            return  elems.get(0);
        return null;
    };

    public List Tail(List elems){
        if (elems.size()>1)
            return elems.subList(1,elems.size());
        return null;
    }
}
