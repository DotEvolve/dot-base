package net.dotevolve.base.data.commonObjects;

import lombok.Data;

@Data
public class Range<T extends Number> {
    private T min;
    private T max;
}
