import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 12:45 PM
 * @project firstMavenPro
 */
public class Main {
    public static void main(String[] args) {
        Account account = new Account("1","acc1", LocalDateTime.now());
       // Gson json = new Gson();
       // String s = json.toJson(account);
       // System.out.println(s);
        /*to make Gson Deal With DataTime*/
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        String toJson = gson.toJson(account);
        System.out.println(toJson);

        Account account1 = gson.fromJson(toJson, Account.class);
        System.out.println(account1);





    }
}
