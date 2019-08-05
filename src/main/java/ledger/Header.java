package ledger;

public class Header {
    // Indicates which set of block validation rules to follow
    Version version;

    // The hash value of all the transactions in the block.
    Hash merkleHash;

    // Current time as seconds in universal timesince January 1, 1970
    Timestamp timestamp;

    // Target threshold of a valid block hash
    Threshold nBits;
}
