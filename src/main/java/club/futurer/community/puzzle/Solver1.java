package club.futurer.community.puzzle;

import org.web3j.crypto.Bip32ECKeyPair;
import org.web3j.crypto.Hash;
import org.web3j.crypto.MnemonicUtils;
import org.web3j.utils.Numeric;

//0xd64fdefa8dbc540c2582a6fc44b8f88ffb6657ce
public class Solver1 implements ISolver {
    @Override
    public void solve() {
        Figure figure = Figure.constructor();
        byte[] result = new byte[16];
        for(int i = 0; i < 16; i++) {
            byte[] ringi = figure.rings[i].evaluate();
            //^ b5e5b6739edbe48e58ba944ad776d18ead262604
            //& afa84baff81f2efb572dddd0e44463f8c51d2ca3
            result[i] = (byte)(ringi[0] ^ ringi[1]);
        }
        String words = MnemonicUtils.generateMnemonic(result);
        byte[] seeds = MnemonicUtils.generateSeed(words, "");
        Bip32ECKeyPair master = Bip32ECKeyPair.generateKeyPair(seeds);

        byte[] tmp = new byte[64];
        System.arraycopy(master.getPublicKeyPoint().getEncoded(false), 1, tmp, 0, 64);
        byte[] hashByte = Hash.sha3(tmp);
        String hash = Numeric.toHexString(hashByte);
        String address =  hash.substring(hash.length() - 40);
        System.out.println("address:" + address);
    }

    public static void main(String[] args) {
        ISolver instance = new Solver1();
        instance.solve();
    }
}
