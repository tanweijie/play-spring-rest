package org.weijie.playspringrest.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data
public class Time
{
    private String local;
    private String abroad;
    private String zone;
}
