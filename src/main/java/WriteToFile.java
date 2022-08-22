import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 1:31 PM
 * @project firstMavenPro
 */
public class WriteToFile {
    public static void main(String[] args) {
        Account account = new Account("1", "acc1", LocalDateTime.now());
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        try {
            Writer writer = new FileWriter("account.json");
            gson.toJson(account, writer);
            // close the writer
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
