package org.o2f.pojos.variables.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Rocket {

    @JsonProperty("_like")
    String _like;
}
