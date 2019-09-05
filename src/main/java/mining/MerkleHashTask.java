package mining;


import ledger.Hash;
import ledger.Transaction;

import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

import static java.util.Arrays.copyOfRange;

public class MerkleHashTask extends RecursiveTask<Hash> {

    private static Logger logger = Logger.getAnonymousLogger();
    private final Transaction[] transactions;

    public MerkleHashTask(Transaction... transactions) {
        this.transactions = transactions;
    }

    @Override
    protected Hash compute() {
        if (transactions.length > 1) {
            return ForkJoinTask
                    .invokeAll(createSubtasks())
                    .stream()
                    .map(ForkJoinTask::join)
                    .reduce(Hash.NO_HASH, Hash::hash);
        } else {
            return process(transactions[0]);
        }
    }

    public Hash digest() {
        if (transactions.length > 1) {
            return createSubtasks()
                    .stream()
                    .map(MerkleHashTask::digest).reduce(Hash.NO_HASH, Hash::hash);
        } else {
            return process(transactions[0]);
        }
    }

    private Hash process(Transaction tx) {
        logger.info("The transaction - (" + tx + ") - was processed by " + Thread.currentThread().getName());
        return Hash.hash(tx);
    }

    private List<MerkleHashTask> createSubtasks() {
        final int length = transactions.length;
        return List.of(
                new MerkleHashTask(copyOfRange(transactions, 0, length / 2)),
                new MerkleHashTask(copyOfRange(transactions, length / 2, length)));
    }
}
