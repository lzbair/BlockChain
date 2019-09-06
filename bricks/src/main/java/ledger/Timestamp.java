package ledger;

import java.time.ZonedDateTime;

public class Timestamp {
    private final ZonedDateTime value;

    public Timestamp(ZonedDateTime value) {
        this.value = value;
    }

    public static Timestamp now() {
        return new Timestamp(ZonedDateTime.now());
    }
}
