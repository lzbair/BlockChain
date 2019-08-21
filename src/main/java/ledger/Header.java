package ledger;


public class Header {
    // Indicates which set of block validation rules to follow
    Version version;

    // The merkle hash value of all transactions in the block.
    Hash merkleRootHash;

    // Current time as seconds in universal timesince January 1, 1970
    Timestamp timestamp;

    // Target threshold of a valid block hash (difficulty)
    Threshold nBits;


    // 4-byte field, changed for every hash calculation
    Nonce nonce;

    // 256-bit hash value of the previous block
    Hash parentHash;


}
