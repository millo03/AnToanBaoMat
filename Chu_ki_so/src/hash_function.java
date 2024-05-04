import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;


public class hash_function {
    // Java program to calculate SHA hash value
    public byte[] getSHA(FileWriter fw) throws NoSuchAlgorithmException, IOException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        // duyệt từng dòng của file
        Scanner sc = new Scanner(Paths.get("test.txt"));
        String result="";
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split("\n");
            for (String x : s) {
                result += x;
            }
        }
        return md.digest(result.getBytes(StandardCharsets.UTF_8));
    }

    public String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    // insert file
    public void InsertFile(FileWriter fileWriter,String input) throws NoSuchAlgorithmException, IOException {
        //FileWriter fileWriter = new FileWriter("test.txt", true);
        fileWriter.write("\n");
        fileWriter.write(input);

       // System.out.println("Success");
    }

    public void displayFile(FileWriter fw) throws IOException {

        Scanner sc = new Scanner(Paths.get("test.txt"));
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split("\n");
            for (String x : s) {
                //int n = Integer.parseInt(i) chuyển chuỗi về số nguyên
                System.out.print(x + "\n ");
            }
        }
    }

//    public static void main(String[] args) {
//        String input = "Hello";
//        FileWriter fw;
//
//        try {
//            fw = new FileWriter("test.txt",true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fw);
//            PrintWriter printWriter =new PrintWriter(bufferedWriter);
//
//            InsertFile(fw,input);
//            printWriter.close();
//            bufferedWriter.close();
//            fw.close();//luôn luôn phải đóng file khi ghi xong
//            displayFile(fw);
//
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
