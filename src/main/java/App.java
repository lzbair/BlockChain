import ledger.BlockChain;
import ledger.Transaction;
import mining.MerkleHashTask;
import mining.TransactionPool;

import java.util.function.Supplier;

public class App {

    public static void main(String... args) {
        BlockChain blockChain = BlockChain.start();
        TransactionPool pool = new TransactionPool();

        /**
         while (true) {
         Block newBlock = new Miner().nextBlock(pool);
         blockChain.accept(newBlock);
         }
         **/
        Transaction[] txs = new Transaction[10000000];
        for (int i = 0; i < 10000000; i++) {
            txs[i] = new Transaction(String.valueOf(i));
        }

        MerkleHashTask task = new MerkleHashTask(txs);

        // timedMain("Fork/Join", () -> task.invoke());
        timedMain("Sequential", () -> task.digest());
    }

    static <T> T timedMain(String taskName, Supplier<T> task) {
        long startTime = System.currentTimeMillis();
        T value = task.get();
        long stopTime = System.currentTimeMillis();
        System.out.println(taskName + ": " + ((stopTime - startTime) / 1000) + " seconds");
        return value;
    }

    private static boolean newMiner(String[] args) {
        return false;
    }
}
