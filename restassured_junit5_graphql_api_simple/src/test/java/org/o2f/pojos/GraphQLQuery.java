package org.o2f.pojos;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class GraphQLQuery {

    @NonNull String query;
    Object variables;

}
