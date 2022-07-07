package org.o2f.pojos.variables;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;
import org.o2f.pojos.variables.blocks.Where;

@Builder
@ToString
public final class DeleteSpaceXUsernameByRocketPartialName {

    @JsonProperty("where")
    Where where;
}
