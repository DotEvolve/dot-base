package net.dotevolve.base.data.commonObjects;

import lombok.Data;

@Data
public class RangeValuePair<R extends Number, V> {
    private Range<R> range;
    private V value;

}
