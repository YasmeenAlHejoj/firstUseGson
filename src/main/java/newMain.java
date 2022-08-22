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
        Account account = new Account("2", "acc2", LocalDateTime.now());
        String filePath = "account.json";
        instance.writeToFile(account, filePath);
        System.out.println(instance.readFile(Account.class, filePath));
    }
}
