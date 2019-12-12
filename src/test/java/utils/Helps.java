package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class Helps {
    private Logger logger;

    public Helps() {
        this.logger = BaseVars.logger;
    }


    public JsonObject getJsonObjectFromFile(String srcFile, String property) {
        try {
            Gson gson = new Gson();
            File jsonFile = Paths.get(srcFile).toFile();
            return gson.fromJson(new FileReader(jsonFile), JsonObject.class).getAsJsonObject(property);
        }catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Map<String, String> convertObjectToMap(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return (Map<String, String>) mapper.convertValue(object, Map.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * Compare 2 objects.
     * return true when matching
     * @param objectA
     * @param objectB
     * @return
     */
    public boolean compareObjects(Object objectA, Object objectB) {
        DiffNode diffNode = ObjectDifferBuilder.buildDefault().compare(objectA, objectB);
        return !diffNode.hasChanges();
    }
}
