import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 1:58 PM
 * @project firstMavenPro
 */
public class MyGson {
    private static MyGson myInstance = null;
    public static Gson gson;

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

    public Gson getGson() {
        return gson;
    }
}
