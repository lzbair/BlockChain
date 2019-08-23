package ledger;

public class Hash {
    public static final Hash NO_HASH = new Hash("");

    private final String value;

    public Hash(String value) {
        this.value = value;
    }
}
