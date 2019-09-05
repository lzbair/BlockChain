package ledger;

import java.util.UUID;

public class Transaction {
    private String id;

    public Transaction(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaction{" + id + "}";
    }
}
