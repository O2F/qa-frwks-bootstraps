package org.o2f.pojos.variables.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class SetName {
    @JsonProperty("name")
    String name;
}
