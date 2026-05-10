import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESencrypt {
    private static final String FIXED_KEY = "cinemax2026key!"; // 16 caratteri per AES-128

    // Prende in input una password e restituisce la password codificata
    public static String encrypt(String password) throws Exception {
        SecretKeySpec chiaveSegreta = new SecretKeySpec(
                FIXED_KEY.getBytes(), 0, 16, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chiaveSegreta);
        byte[] encryptedpass = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedpass);
    }

    // Prende in input una password codificata e restituisce la password originale
    public static String decrypt(String passwordCodificata) throws Exception {
        SecretKeySpec chiaveSegreta = new SecretKeySpec(
                FIXED_KEY.getBytes(), 0, 16, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chiaveSegreta);
        byte[] decodedPassword = Base64.getDecoder().decode(passwordCodificata);
        byte[] decryptedPassword = cipher.doFinal(decodedPassword);
        return new String(decryptedPassword);
    }
}