package club.futurer.community.business.curiosity.controller;

import club.futurer.community.business.uidgenerator.UidGenerator;
import club.futurer.community.common.BaseAction;
import club.futurer.community.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.RawTransaction;
import org.web3j.tx.Contract;
import org.web3j.tx.Transfer;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

@RestController
public class HelloworldController extends BaseAction {
    private static final Logger logger = LoggerFactory.getLogger(HelloworldController.class.getName());

    @Autowired
    private UidGenerator uidGenerator;

    @Autowired
    private StringRedisTemplate hll;

    @RequestMapping(value = "/helloworld", method = {RequestMethod.GET})
    public Result<String> helloworld() {
        Result<String> result = new Result<>();
        result.setCode("0");
        result.setMsg("");
        result.setData("helloworld!");
        hll.opsForHyperLogLog().add("helloworld!");
        return  result;
    }

    @RequestMapping(value = "/uids", method = {RequestMethod.GET})
    public Result<List<Long>> uid() {
        Result<List<Long>> result = new Result<>();
        result.setCode("0");
        result.setMsg("");
        List<Long> ids = new ArrayList<>(128);
        for(int i = 0; i < 128; i++) {
            ids.add(uidGenerator.getUID());
        }
        result.setData(ids);
        return  result;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        //bip39
        try
        {
            String password = "pink wave steak torch admit casual album aware addict normal shop boy";
            int iterationCount = 2048;

            int  keyLength = 64*8;

            char[] charPwd = password.toCharArray();

            byte[] salt = "mnemonic".getBytes();
//            for (byte b : salt)
//            {
//                System.out.print(b);
//            }
//            System.out.println();
//            System.out.println("------------------------");

            PBEKeySpec keySpec = new PBEKeySpec(charPwd, salt, iterationCount, keyLength);

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] pbePwd = keyFactory.generateSecret(keySpec).getEncoded();
//            System.out.println(Base58.encode(pbePwd));
            System.out.println(byte2Hex(pbePwd));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
