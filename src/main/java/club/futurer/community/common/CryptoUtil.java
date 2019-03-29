package club.futurer.community.common;

import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.crypto.ec.CustomNamedCurves;
import org.bouncycastle.jcajce.provider.digest.Keccak;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPrivateKeySpec;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.util.encoders.Hex;
import org.web3j.crypto.Keys;
import org.web3j.utils.Numeric;

import javax.crypto.KeyAgreement;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

public class CryptoUtil {
    public static KeyPair generateCurve25519() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        //找到曲线
        X9ECParameters ecP = CustomNamedCurves.getByName("curve25519");//secp256k1
        //配置相应曲线参数
        org.bouncycastle.jce.spec.ECParameterSpec ecSpec = new org.bouncycastle.jce.spec.ECParameterSpec(ecP.getCurve(), ecP.getG(), ecP.getN(), ecP.getH(), ecP.getSeed());
        //生成器
//        KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDH", "BC");
        Provider bcProvider = new BouncyCastleProvider();
        //TODO KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDSA", bcProvider); ECDSA这是数字签名，ECDH是dh协议
        KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDH", bcProvider);
        //生成器初始化
        generator.initialize(ecSpec, new SecureRandom());
        return generator.generateKeyPair();
//        KeyPair keyPair = generator.generateKeyPair();
////        ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
////        ecPublicKey.getEncoded()
//        byte[] pk = keyPair.getPublic().getEncoded();
//        System.out.println("pKey:" + pk.length);
//        byte[] sk = keyPair.getPrivate().getEncoded();
//        System.out.println("sKey:" + sk.length);
    }

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, InvalidKeySpecException {
//        testEthAddress();

//        034b4209962c75ea5c8ea99e7028443fdb3228e91cfc6a1a977099ebf3fc41d73b ?b1ca7e3b68c4db65593d578a9102cffb63ab8562e8a5afaa4e082d6e03a3c932
//        044b4209962c75ea5c8ea99e7028443fdb3228e91cfc6a1a977099ebf3fc41d73b5c7ede26b16c2cdafa11ed59dade70e088749af716d7ac69c439c207fade87cf
//        02370b537a17f9e916c32c942258f679803e9e8022be3b57da1e4bb2f6d3d1f2
//        testCurve25519();

//        byte[] sKeyBytes = Hex.decode("0168720ced553cb0da8a74f38ad3b889a1ba40377fd645e18497200a8ce91089");
//        byte[] publicKeyBytes = generateCurve25519PKey(sKeyBytes);

//        testECDH2("0168720ced553cb0da8a74f38ad3b889a1ba40377fd645e18497200a8ce91089", "b24fc5ccb1903cd04d1d6e865e8cd03e9d2183989c1fc8bf142b573c4d15e312");

//        testECDH();

        generateCurve25519PKey(Hex.decode("180b6a7274b2797688d7d7d6e982ad13c49923ba6d52f8ecd93a9a1b2ba60a76" ), true);

//        testX25519("180b6a7274b2797688d7d7d6e982ad13c49923ba6d52f8ecd93a9a1b2ba60a76");
        //publicKey:f43ae3b47138a406ac72ce599cb5f25e1714922a966861d97775843956dfcd26
        //sessionKey:070b550b2a95e63b08dd83f7a924f58e6da2ed3e84f0c6306b02b47e1a962568

    }

    //0447ecca013dd8a118912fdb4efebf9732e79618932ad0d0d2b91dd1885601499329bca95cc7a951184e5092f5ff43ac05fb90fde24f23350e6c0ded3f5a56290d
    //0f1f00726b857b3bb26a8239701930ef46bd0f39c2cea4f6e34cdca41f2bb233

    //04061e0cf52fd83aea698fe16c6b79d3477c3e93c652d5e0df26a96ca0767c7cf95a313537e488f0645f0209a4ab13a66f0015f4a56a39d0a3f19e3a40462bf9c4
    //0cc89f2eb81fd116e5b3c71e9b9d8d430065a2fcfe48acecb96ca0e105fac1ce

    //sKey:0168720ced553cb0da8a74f38ad3b889a1ba40377fd645e18497200a8ce91089
    //pKey:0332d1b94dcda240eb86dfda2f70e7dcd09d8de9e6781e2c2b0ffd1aa8e1ac77c3
    private static void testCurve25519() throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPair keyPair = generateCurve25519();
        ECPublicKey publicKey = (ECPublicKey) keyPair.getPublic();
        ECPoint ecPoint = publicKey.getQ();
//        int length = ecPoint.getEncoded(true).length;
//        System.out.println("length:" + length);
        byte[] publicBytes = ecPoint.getEncoded(true);
        System.out.println(byte2Hex(publicBytes));
        System.out.println(byte2Hex(ecPoint.getEncoded(false)));
//        System.out.println(byte2Hex(publicBytes));
//        System.out.println("publicKeyFormat:" + publicKey.getFormat());

        ECPrivateKey privateKey = (ECPrivateKey) keyPair.getPrivate();
//        String privateKeyStr = byte2Hex(privateKey.getEncoded());
//        System.out.println("format:" + privateKey.getFormat());
//        System.out.println("algorithm:" + privateKey.getAlgorithm());
        System.out.println(Numeric.toHexStringNoPrefixZeroPadded(privateKey.getD(), 64));
//        System.out.println(byte2Hex(privateKey.getD().toByteArray()));
    }

//    skey:b483add06cdf7bfdbeab9bb7b0c867478a32e3c70e932078b5331c3c6beef2c7
//    length:65
//            [B@387c703b
//    pkey:04bd49fb10b9421b2f58f10ce6cba5bc7f08bb935d4e530ae1000ad80a5389ab0cacd3d12e9e380a3a5f8fba0a6490fcae5d69ddd3d2f71ceabbe187b7a6a5407d
//    publicKeyBytes's length:65
//    address:d263bf7212c7da62a84a09514f8e385aeb45d25f
//    web3j address:d263bf7212c7da62a84a09514f8e385aeb45d25f
    private static  final void testEthAddress() throws NoSuchAlgorithmException {
        byte[] privateKeyBytes = generateRandomSeed(32);
        System.out.println("skey:" + byte2Hex(privateKeyBytes));
        byte[] publicKeyBytes = generateEthPublicKey(privateKeyBytes, false);
//        byte[] publicKeyBytes = generateEthPublicKey(privateKeyBytes, true);
        System.out.println("pkey:" + byte2Hex(publicKeyBytes));
        String address = generateEthAddress(publicKeyBytes);
        System.out.println("address:" + address);

        System.out.println("web3j address:" + byte2Hex(Keys.getAddress(publicKeyBytes)));
    }

    public static byte[] generateRandomSeed(int seedLength) {
        SecureRandom random = new SecureRandom();
        byte[] seed = new byte[seedLength];
        random.nextBytes(seed);
//        String seedHexStr = byte2Hex(seed);
//        System.out.println(seedHexStr);
//        return seedHexStr;
        return seed;
    }

    public static String byte2Hex(byte[] bytes) {
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

    public static byte[] generateEthPublicKey(byte[] privateKey, boolean compressed) {
        ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
        ECPoint pointQ = spec.getG().multiply(new BigInteger(1, privateKey));
        byte[] publicKeyBytes = pointQ.getEncoded(compressed);
        System.out.println("length:" + publicKeyBytes.length);
        String publicKeyHexStr = byte2Hex(publicKeyBytes);
        System.out.println(publicKeyBytes);
        return publicKeyBytes;
    }

    //
    public static String generateBitcoinAddress(byte[] publicKeyBytes) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] pubKeySha256 = digest.digest(publicKeyBytes);
        digest = MessageDigest.getInstance("RIPEMD160");
        byte[] bytesAddr = digest.digest(pubKeySha256);
        return byte2Hex(bytesAddr);
    }

    public static String generateEthAddress(byte[] publicKeyBytes) throws NoSuchAlgorithmException {
//        SHA3.DigestSHA3 digest256 = new SHA3.DigestSHA3(256);
//        byte[] pubKeyHash = digest256.digest(publicKeyBytes);
//        String address = byte2Hex(pubKeyHash);
//        return address.substring(24);

        Keccak.DigestKeccak kecc = new Keccak.Digest256();
        System.out.println("publicKeyBytes's length:" + publicKeyBytes.length);
        kecc.update(publicKeyBytes, 0, publicKeyBytes.length);
        byte[] pubKeyHash = kecc.digest();
        String address = byte2Hex(pubKeyHash);
        return address.substring(24);
    }

    /**
     * 生成会话密钥
     * @return
     */
    public static String ecdh(KeyPair alice, KeyPair bob) throws NoSuchAlgorithmException, InvalidKeyException {
        Provider bcProvider = new BouncyCastleProvider();
        KeyAgreement agreement = KeyAgreement.getInstance("ECDH", bcProvider);
        agreement.init(alice.getPrivate());
        agreement.doPhase(bob.getPublic(), true);
        byte[] secrets =  agreement.generateSecret();
        System.out.println("alice:" + byte2Hex(secrets));

        KeyAgreement agreementBob = KeyAgreement.getInstance("ECDH", bcProvider);
        agreementBob.init(bob.getPrivate());
        agreementBob.doPhase(alice.getPublic(), true);
        byte[] bobSecrets = agreementBob.generateSecret();
        System.out.println("bob:" + byte2Hex(bobSecrets));
        return byte2Hex(secrets);
    }

    public static String testECDH2(String serverSKeyStr, String clientPKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        Provider bcProvider = new BouncyCastleProvider();
        KeyAgreement agreement = KeyAgreement.getInstance("ECDH", bcProvider);
        agreement.init(restoreCurve25519SKey(serverSKeyStr));
        agreement.doPhase(restoreCurve25519PKey(clientPKeyStr), true);
        byte[] secret = agreement.generateSecret();
        System.out.println("secret:" + byte2Hex(secret));
        return byte2Hex(secret);
    }

    private static final void testECDH() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        KeyPair alice = generateCurve25519();
        KeyPair bob = generateCurve25519();
        ecdh(alice, bob);
    }

//    public static ECPublicKey restoreCurve25519PKey(String publicKey) {
//        ECParameterSpec spec = ECNamedCurveTable.getParameterSpec("Curve25519");
//        ECPrivateKey
//    }
//
    public static PrivateKey restoreCurve25519SKey(String secretKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] secreKeyBytes = Hex.decode(secretKey);
        X9ECParameters ecP = CustomNamedCurves.getByName("curve25519");
        ECParameterSpec spec = new org.bouncycastle.jce.spec.ECParameterSpec(ecP.getCurve(), ecP.getG(), ecP.getN(), ecP.getH(), ecP.getSeed());
        ECPrivateKeySpec privateKeySpec = new ECPrivateKeySpec(new BigInteger(secreKeyBytes), spec);
        Provider bcProvider = new BouncyCastleProvider();
        KeyFactory kf = KeyFactory.getInstance("ECDH", bcProvider);
        PrivateKey key = kf.generatePrivate(privateKeySpec);
        System.out.println(key.getFormat());
        System.out.println(key.getAlgorithm());
        System.out.println("length:" + key.getEncoded().length);
        System.out.println("skey:" + byte2Hex(key.getEncoded()));
        return key;
    }

    public static PublicKey restoreCurve25519PKey(String clientPKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] clientPKeyBytes = Hex.decode(clientPKey);
        X9ECParameters ecP = CustomNamedCurves.getByName("curve25519");
        org.bouncycastle.jce.spec.ECParameterSpec spec = new org.bouncycastle.jce.spec.ECParameterSpec(ecP.getCurve(), ecP.getG(), ecP.getN(), ecP.getH(), ecP.getSeed());
        org.bouncycastle.jce.spec.ECPublicKeySpec publicKeySpec = new org.bouncycastle.jce.spec.ECPublicKeySpec(spec.getCurve().decodePoint(clientPKeyBytes), spec);
//        ECPublicKeySpec publicKeySpec = new ECPublicKeySpec(spec.getCurve().decodePoint(clientPKeyBytes), spec);
        Provider bcProvider = new BouncyCastleProvider();
        KeyFactory kf = KeyFactory.getInstance("ECDH", bcProvider);
        PublicKey pKey = kf.generatePublic(publicKeySpec);
        System.out.println(pKey.getFormat());
        System.out.println(pKey.getAlgorithm());
        System.out.println(byte2Hex(pKey.getEncoded()));
        return pKey;
    }

    public static byte[] generateCurve25519PKey(byte[] sKeyBytes, boolean compression) {
        ECParameterSpec spec = ECNamedCurveTable.getParameterSpec("curve25519");
        ECPoint pointQ = spec.getG().multiply(new BigInteger(1, sKeyBytes));
        byte[] publicKeyBytes = pointQ.getEncoded(compression);
        System.out.println("length:" + publicKeyBytes.length);
        String publicKeyHexStr = byte2Hex(publicKeyBytes);
        System.out.println(publicKeyHexStr);
        return publicKeyBytes;
    }

    private static void testX25519(String secretKey) {
        byte[] secretKeyBytes = Hex.decode(secretKey);
        byte[] pKeyBytes = new byte[32];
        X25519.scalarMultBase(secretKeyBytes, 0, pKeyBytes, 0);
        System.out.println(byte2Hex(pKeyBytes));
        byte[] otherPKeyBytes = Hex.decode("fdf8760e31362b501497513b5202b62353433ac653409f530411b6a7ba244a66");
        byte[] otherSKeyBytes = Hex.decode("028d178666a1625b873d2372d28a438dc6478d8387a20fa9bd43d39c259917be");
        byte[] sessionBytes = new byte[32];
        X25519.scalarMult(secretKeyBytes, 0, otherPKeyBytes, 0, sessionBytes, 0);
        byte[] sessionBytes2 = new byte[32];
        X25519.scalarMult(otherSKeyBytes, 0, pKeyBytes, 0, sessionBytes2, 0);
        System.out.println("session key1:" + byte2Hex(sessionBytes));
        System.out.println("session key2:" + byte2Hex(sessionBytes2));
    }
}
