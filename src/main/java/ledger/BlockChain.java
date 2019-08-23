package ledger;

import java.util.Arrays;
import java.util.List;

public class BlockChain {
    private final List<Block> blocks;

    private BlockChain(List<Block> blocks) {
        this.blocks = blocks;
    }

    public static BlockChain start() {
        return new BlockChain(Arrays.asList(Block.GENESIS));
    }

    public void append(Block newBlock) {
        //
    }
}
