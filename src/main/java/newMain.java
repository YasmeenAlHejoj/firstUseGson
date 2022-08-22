import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 2:07 PM
 * @project firstMavenPro
 */
public class newMain {
    public static void main(String[] args) {
        MyGson instance = MyGson.getInstance();
        Gson gson = instance.getGson();

        writeToFile(gson);
        readFile(gson);
    }

    public static void readFile(Gson gson) {
        try {
            FileReader fileReader = new FileReader("account.json");
            Account account = gson.fromJson(fileReader, Account.class);
            System.out.println(account);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void writeToFile(Gson gson) {
        Account account = new Account("1", "acc1", LocalDateTime.now());
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
