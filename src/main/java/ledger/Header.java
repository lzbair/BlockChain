package ledger;


public class Header {
    // Indicates which set of block validation rules to follow
    private final Version version;

    // The merkle hash value of all transactions in the block.
    private final Hash merkleRootHash;

    // Current time as seconds in universal timesince January 1, 1970
    private final Timestamp timestamp;

    // Target threshold of a valid block hash (difficulty)
    private final long nBits;


    // 4-byte field, changed for every hash calculation
    private final int nonce;

    // 256-bit hash value of the previous block
    private final Hash parentHash;

    public Header(Version version, Hash merkleRootHash, Timestamp timestamp, long nBits, int nonce, Hash parentHash) {
        this.version = version;
        this.merkleRootHash = merkleRootHash;
        this.timestamp = timestamp;
        this.nBits = nBits;
        this.nonce = nonce;
        this.parentHash = parentHash;
    }

    public static Header genesis() {
        return new Header(
                new Version("0"),
                Hash.NO_HASH,
                Timestamp.now(),
                0,
                0,
                Hash.NO_HASH
        );
    }
}
