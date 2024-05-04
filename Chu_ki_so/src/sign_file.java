import java.io.FileWriter;

public class sign_file {
    public static void main(String[] args) {
        // Dísplay private key
        create_key ckey = new create_key();
        hash_function hf = new hash_function();
        Encode en = new Encode();
        String string = "test2.txt";
        try {
            FileWriter fw = new FileWriter(string, true);
            ckey.key();
            // đổi file chuyền vào thành hàm băm
            String hexString = hf.toHexString(hf.getSHA(fw));
            // mã hóa hàm băm bằng privakey
            String s = en.encode(hf.getSHA(fw), string);
            // đưa hàm mã hóa vào cuối file
            hf.InsertFile(fw, s);
            // đóng file
            fw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //System.out.println(ckey.getPrivate_key());
        // Cryptography hash function
        hash_function hash = new hash_function();
    }
}
