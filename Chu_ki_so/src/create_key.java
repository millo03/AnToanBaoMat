import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;

public class create_key {
    private BigInteger public_key_n;
    private  BigInteger public_key_e;
    private  BigInteger private_key_d;
    public  void key () throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();
        // Lấy khóa bí mật
        RSAPrivateCrtKey privateKey = (RSAPrivateCrtKey) kp.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) kp.getPublic();

        // Lấy thông tin n (modulus)

        public_key_n = (BigInteger) publicKey.getModulus();
        public_key_e = (BigInteger) publicKey.getPublicExponent();
    }

    public BigInteger getPublic_key_n() {
        return public_key_n;
    }

    public BigInteger getPublic_key_e() {
        return public_key_e;
    }

    public BigInteger getPrivate_key_d() {
        return private_key_d;
    }
}

