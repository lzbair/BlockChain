package ledger;

public class BlockAcceptance {
    public static final BlockAcceptance OK = new BlockAcceptance();

    public static BlockAcceptance error(BlockErrors errors) {
        return null;
    }
}
