package club.futurer.community.puzzle;

import club.futurer.community.common.Base58;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.web3j.crypto.*;
import org.web3j.utils.Numeric;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String  randomHex = "0x0c1e24e5917779d297e14d45f14e1a1a";
        BigInteger random = Numeric.toBigInt(randomHex);
//        SHA256Digest digest = new SHA256Digest();
//        byte[] values = digest.
//        byte mask = (byte)(255 << 8 - 128 / 32);
//        System.out.println(String.format("%02x", mask & 255));
        String words = MnemonicUtils.generateMnemonic(random.toByteArray());
        System.out.println(words);//"mnemonic"
        byte[] seeds = MnemonicUtils.generateSeed(words, "");
        System.out.println(Numeric.toHexString(seeds));

        Bip32ECKeyPair master = Bip32ECKeyPair.generateKeyPair(seeds);
        System.out.println(Numeric.toHexString(master.getPublicKeyPoint().getEncoded(false)));

//        int[] path = new int[]{0, 0};
        Bip32ECKeyPair bip32ECKeyPair = Bip32ECKeyPair.deriveKeyPair(master, new int[]{0, 0});

        System.out.println(Numeric.toHexString(bip32ECKeyPair.getPublicKeyPoint().getEncoded(true)));

        System.out.println("legnth:" + bip32ECKeyPair.getPublicKeyPoint().getEncoded(false).length);
        byte[] tmp = new byte[64];
        System.arraycopy(bip32ECKeyPair.getPublicKeyPoint().getEncoded(false), 1, tmp, 0, 64);

//        方法1
//        String hash = Hash.sha3(Numeric.toHexString(tmp));

//        方法2
        byte[] hashByte = Hash.sha3(tmp);//
        String hash = Numeric.toHexString(hashByte);

        String address =  hash.substring(hash.length() - 40);
        System.out.println(address);//08d3f5988d21d83df8d73cd6894c5ca6bef43157

        //0x00ca72b45eede592f059b7eaf3da13eb7d8d15aa472b6f79f74820bb22ff59618678d9b8dbfbde9a5e05b7bdad83401ae651ed705a788855190a8b08b5633495af
//        byte[] results = Hash.hmacSha512("Bitcoin seed".getBytes(), seeds);
//        System.out.println(Numeric.toHexString(results));
//
//        System.out.println(Base58.encode(results));
////        BigInteger privateKey = new BigInteger();
//        ECKeyPair pair = ECKeyPair.create(Arrays.copyOf(results, 32));;
//        System.out.println(Keys.getAddress(pair));
    }
}
