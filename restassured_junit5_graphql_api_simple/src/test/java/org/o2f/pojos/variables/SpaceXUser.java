package org.o2f.pojos.variables;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Builder(toBuilder = true)
@Value
@Getter
public class SpaceXUser {

    UUID id;
    String name;
    String rocket;

}
