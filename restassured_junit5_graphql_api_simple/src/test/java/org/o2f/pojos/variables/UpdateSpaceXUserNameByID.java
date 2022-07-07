package org.o2f.pojos.variables;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;
import org.o2f.pojos.variables.blocks.SetName;
import org.o2f.pojos.variables.blocks.Where;

@Builder
@ToString
public final class UpdateSpaceXUserNameByID {
    @JsonProperty("where")
    Where where;
    @JsonProperty("set")
    SetName setName;
}
