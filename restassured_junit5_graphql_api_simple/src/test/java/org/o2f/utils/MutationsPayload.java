package org.o2f.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.o2f.pojos.variables.DeleteSpaceXUsernameByRocketPartialName;
import org.o2f.pojos.variables.blocks.Rocket;
import org.o2f.pojos.variables.blocks.SetName;
import org.o2f.pojos.variables.blocks.Id;
import org.o2f.pojos.variables.blocks.Where;
import org.o2f.pojos.variables.UpdateSpaceXUserNameByID;

@Slf4j
public final class MutationsPayload {


    public String updateVariablesJsonCreation(String UUID, String newName){

        // this is only for demonstration purpose

        JsonObject where = new JsonObject();
        JsonObject id = new JsonObject();
        JsonObject set = new JsonObject();
        JsonObject root = new JsonObject();

        id.addProperty("_eq", UUID);
        set.addProperty("name", newName);
        where.add("id", id);
        root.add("where",where);
        root.add("set", set);

        log.debug(String.format("Created the Json: %s", root));

        return root.toString();
    }

    public UpdateSpaceXUserNameByID updateUserNameByIDVariable(String uuid, String newName){

        UpdateSpaceXUserNameByID payload = UpdateSpaceXUserNameByID
                .builder()
                .where(Where
                        .builder()
                        .id(Id
                                .builder()
                                ._eq(uuid)
                                .build())
                        .build())
                .setName(SetName
                        .builder()
                        .name(newName)
                        .build()
                ).build();

        return payload;
    }

    public JsonNode ObjectToJsonNode(Object object){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.valueToTree(object);
        log.debug(String.format("Generated the following node: %s", node.asText()));
        return node;
    }

    public DeleteSpaceXUsernameByRocketPartialName deleteSpaceXUsernameByRocketPartialNameVariable(String partialString){

        return DeleteSpaceXUsernameByRocketPartialName
                .builder()
                .where(Where
                        .builder()
                        .rocket(Rocket
                                .builder()
                                ._like(partialString)
                                .build())
                        .build())
                .build();
    }

}
