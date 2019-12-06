package utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import plain_Old_Java_Objects.Authentication_JO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonReader {

    public static JsonObject getJsonObjectFromFile(String srcFile, String property) {
        try {
            Gson gson = new Gson();
            File jsonFile = Paths.get(srcFile).toFile();
            return gson.fromJson(new FileReader(jsonFile), JsonObject.class).getAsJsonObject(property);
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
