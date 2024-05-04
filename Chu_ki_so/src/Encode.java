import java.io.FileWriter;
import java.math.BigInteger;

public class Encode {
    create_key ckey = new create_key();
    hash_function hf = new hash_function();
    public  BigInteger powerMod(byte base, BigInteger exponent, BigInteger modulus) {
        BigInteger result = BigInteger.ONE;

        BigInteger baseBigInt = BigInteger.valueOf(base);

        while (exponent.compareTo(BigInteger.ZERO) > 0) {
            if (exponent.testBit(0)) {
                result = (result.multiply(baseBigInt)).mod(modulus);
            }
            exponent = exponent.shiftRight(1);
            baseBigInt = (baseBigInt.multiply(baseBigInt)).mod(modulus);
        }

        return result;
    }

// truyền vào tên file
    public String encode(byte[] hash,String File_name) throws Exception {
        FileWriter fw =new FileWriter(File_name, true);
        ckey.key();
        // đổi file chuyền vào thành hàm băm
        String hexString = hf.toHexString(hf.getSHA(fw));
        // mã hóa hàm băm bằng privakey

        //lấy ra mảng byte khi tóm lược file
        // ma hoa từng phần tử byte bằng thuật toán a mũ k mod n và gán lại vào mảng byte
        // đổi mảng byte thành string và cách nhau bởi dấu "space"
        String s ="";
        for(byte x: hash){
            x =  powerMod(x,ckey.getPublic_key_e(),ckey.getPublic_key_n()).byteValue();
            s += String.valueOf(x)+" ";

        }
        return s;
    }
}
