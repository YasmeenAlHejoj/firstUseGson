import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 1:58 PM
 * @project firstMavenPro
 */
public class MyGson {
    private static MyGson myInstance = null;
    private static Gson gson;

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

    private Gson getGson() {
        return gson;
    }

    public void readFile(Class<?> objectClass){
        try {
            FileReader fileReader = new FileReader("account.json");
            Object o = gson.fromJson(fileReader, objectClass);
            System.out.println(o);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void writeToFile(Object  o,String filePath){
        try {
            Writer writer = new FileWriter(filePath);
            gson.toJson(o, writer);
            // close the writer
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
