package cl.gdgandroidstgo.simple_dagger_application.commons.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseMapper<I, O> {
    public abstract O map(I input);
    public List<O> mapAll(Collection<I> inputs) {
        List<O> list = new ArrayList<>(inputs.size());
        for (I input : inputs) {
            list.add(map(input));
        }
        return list;
    }
}
