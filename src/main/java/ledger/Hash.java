package ledger;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class Hash {
    public static final Hash NO_HASH = new Hash("");

    private final String value;

    public Hash(String value) {
        this.value = value;
    }

    public static Hash hash(Object... values) {
        String value = Arrays.stream(values).map(Object::toString).reduce("", String::concat);
        return new Hash(DigestUtils.sha256Hex(value));
    }

    @Override
    public String toString() {
        return value;
    }
}
