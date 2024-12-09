import java.security.*;
import java.util.Base64;

public class DSAExample {
    public static void main(String[] args) throws Exception {
        // Generate DSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(1024);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // Message to sign
        String message = "This is a secure message.";

        // Sign the message
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        byte[] signature = sign.sign();
        String encodedSignature = Base64.getEncoder().encodeToString(signature);

        // Verify the signature
        Signature verify = Signature.getInstance("SHA256withDSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());
        boolean isVerified = verify.verify(Base64.getDecoder().decode(encodedSignature));

        System.out.println("Signature: " + encodedSignature);
        System.out.println("Verified: " + isVerified);
    }
}

