import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
        Map<Long, Account> accountMap = new HashMap<>();
        accountMap.put(1L, new Account("1", "acc1", LocalDateTime.now()));
        accountMap.put(2L, new Account("2", "acc2", LocalDateTime.now()));
        accountMap.put(3L, new Account("3", "acc3", LocalDateTime.now()));
        accountMap.put(4L, new Account("4", "acc4", LocalDateTime.now()));
        instance.writeToFile(accountMap, filePath);
        Object o = instance.readFile(Map.class, filePath);
        System.out.println(o);

    }
}
