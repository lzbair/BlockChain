package ledger;

import java.util.List;

import static java.util.Arrays.asList;

public class BlockChain {
    private final List<Block> blocks;
    private final BlockPolicy policy;

    private BlockChain(List<Block> blocks, BlockPolicy policy) {
        this.blocks = blocks;
        this.policy = policy;
    }

    public static BlockChain start() {
        return new BlockChain(asList(Block.GENESIS), BlockPolicy.POW);
    }

    public BlockAcceptance accept(Block newBlock) {
        BlockErrors errors = policy.validate(newBlock);
        if (errors.isEmpty()) {
            blocks.add(newBlock);
            return BlockAcceptance.OK;
        }
        return BlockAcceptance.error(errors);
    }


}
