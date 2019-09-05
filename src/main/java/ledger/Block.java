package ledger;

import java.util.Set;

public class Block {

    public static final Block GENESIS = new Block(Header.genesis(), Body.EMPTY);
    private final Header header;
    private final Body body;

    public Block(Header header, Body body) {
        this.header = header;
        this.body = body;
    }

    public Set<Transaction> availableTransaction() {
        return null;
    }
}
