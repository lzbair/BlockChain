package network;

import ledger.BlockChain;

import java.util.List;

public class TransportLayer {

    List<Peer> peers;


    public void listen() {

    }

    // refresh peers in the Network
    public void refresh() {

    }

    public List<BlockChain> fetchBlocks(BlockChain localCopy) {
        return null;

    }
}
