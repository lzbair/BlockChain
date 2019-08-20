import ledger.Block;
import ledger.BlockChain;
import mining.Miner;
import mining.TransactionPool;

public class App {

    public static void main(String... args){
        BlockChain blockChain = new BlockChain();
        TransactionPool pool = new TransactionPool();

        while (true) {
            Block newBlock = new Miner().nextBlock(pool);
            blockChain.append(newBlock);
        }

    }

    private static boolean newMiner(String[] args) {
        return false;
    }
}
