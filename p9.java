import java.io.*;
import java.math.BigInteger;
import java.util.Random;

public class RSA {
    BigInteger p, q, N, phi, e, d;
    
    RSA() {
        Random r = new Random();
        p = BigInteger.probablePrime(512, r);
        q = BigInteger.probablePrime(512, r);
        N = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(65537);
        
        while (!phi.gcd(e).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.TWO);
        }
        d = e.modInverse(phi);
    }
    
    byte[] encrypt(byte[] m) {
        return new BigInteger(1, m).modPow(e, N).toByteArray();
    }
    
    byte[] decrypt(byte[] m) {
        return new BigInteger(1, m).modPow(d, N).toByteArray();
    }
    
    static String bytesToString(byte[] b) {
        String s = "";
        for (byte x : b) {
            s += x + " ";
        }
        return s;
    }
    
    public static void main(String[] args) throws IOException {
        RSA rsa = new RSA();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter the plain text: ");
        String text = in.readLine();
        
        System.out.println("Encrypting String: " + text);
        System.out.println("String in Bytes: " + bytesToString(text.getBytes()));
        
        byte[] encrypted = rsa.encrypt(text.getBytes());
        System.out.println("Encrypted Bytes: " + bytesToString(encrypted));
        
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypting Bytes: " + bytesToString(decrypted));
        System.out.println("Decrypted String: " + new String(decrypted));
    }
}
