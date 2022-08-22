import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author YasmeenHj
 * created on 8/22/2022 at 12:41 PM
 * @project firstMavenPro
 */
public class Account {
    private String id;
    private String name;

    private LocalDateTime createDateTime;

    public Account(String id, String name, LocalDateTime createDateTime) {
        this.id = id;
        this.name = name;
        this.createDateTime = createDateTime;
    }


    @Override
    public String toString() {
        return "Account{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", createDateTime=" + createDateTime +
            '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}





