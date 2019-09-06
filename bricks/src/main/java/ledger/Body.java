package ledger;

import java.util.Collections;
import java.util.Set;

public class Body {

    static final Body EMPTY = new Body(null, Collections.EMPTY_SET);

    private final TransactionCounter txCouter;
    private final Set<Transaction> transactions;

    public Body(TransactionCounter txCouter, Set<Transaction> transactions) {
        this.txCouter = txCouter;
        this.transactions = transactions;
    }
}
