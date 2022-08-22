import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 1:58 PM
 * @project firstMavenPro
 */
public class MyGson {
    private static MyGson myInstance = null;
    private final Gson gson;

    private MyGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        gson = builder.setPrettyPrinting().create();
    }

    public static MyGson getInstance() {
        if (myInstance == null)
            myInstance = new MyGson();
        return myInstance;
    }

    public Object readFile(Class<?> objectClass, String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            return gson.fromJson(fileReader, objectClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToFile(Object o, String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(o, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
