import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 1:26 PM
 * @project firstMavenPro
 */
public class ReadFromFile {
    public static void main(String[] args) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        FileReader fileReader;
        {
            try {
                fileReader = new FileReader("account.json");
                Account account = gson.fromJson(fileReader, Account.class);
                System.out.println(account);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
