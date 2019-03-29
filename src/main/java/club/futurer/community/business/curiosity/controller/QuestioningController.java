package club.futurer.community.business.curiosity.controller;

import org.bouncycastle.math.ec.rfc7748.X25519;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.Hash;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class QuestioningController {

    public static void main(String[] args) {
//        String data = "0xa9059cbb" + Numeric.toHexStringNoPrefixZeroPadded(Numeric.toBigInt("0x4f1df06d79672f41b549a7708a5ac644850d9296"), 64)
//                + Numeric.toHexStringNoPrefixZeroPadded(BigInteger.valueOf(10000), 64);
//        System.out.println("data:" + data);

//        Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:8545"));
//        Web3ClientVersion web3ClientVersion = null;
//        try {
//            web3ClientVersion = web3.web3ClientVersion().send();
//            System.out.println(web3ClientVersion.getWeb3ClientVersion());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Hash.sha3();
//        System.out.println(Numeric.toHexString());

//        //solidity encode
//        byte[] pre = Numeric.toBytesPadded(BigInteger.valueOf(233L),32);
//        byte[] next = Numeric.toBytesPadded(BigInteger.valueOf(0L), 32);
//        byte[] message = new byte[64];
//        System.arraycopy(pre, 0, message, 0, 32);
//        System.arraycopy(next, 0, message, 32, 32);
//        System.out.println(Numeric.toHexString(message));
//        System.out.println(Numeric.toHexString(Hash.sha3(message)));

        //X25519
    }

}