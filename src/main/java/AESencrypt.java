import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public  class AESencrypt {
    private String Password; //getPassword();

    public AESencrypt(String Password) {
        this.Password = Password;
    }

    public String encryptPassword() throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator Chiave = KeyGenerator.getInstance("AES");
        Chiave.init(256);
        //Chiave segreta
        SecretKey chiaveSegreta = Chiave.generateKey();
        //AES Cipher instance
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chiaveSegreta);
        //Inizio encryption
        byte[] encryptedpass = cipher.doFinal(Password.getBytes());
        //encode in base64
        String passb64 = Base64.getEncoder().encodeToString(encryptedpass);
        return passb64;
    }

}


