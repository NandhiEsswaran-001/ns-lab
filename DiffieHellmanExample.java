import javax.crypto.KeyAgreement;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.util.Base64;

public class DiffieHellmanExample {
    public static void main(String[] args) throws Exception {
        // Generate parameters for Diffie-Hellman
        AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DH");
        paramGen.init(512);
        DHParameterSpec dhSpec = (DHParameterSpec) paramGen.generateParameters().getParameterSpec(DHParameterSpec.class);

        // Alice's key pair
        KeyPairGenerator aliceKeyGen = KeyPairGenerator.getInstance("DH");
        aliceKeyGen.initialize(dhSpec);
        KeyPair aliceKeyPair = aliceKeyGen.generateKeyPair();

        // Bob's key pair
        KeyPairGenerator bobKeyGen = KeyPairGenerator.getInstance("DH");
        bobKeyGen.initialize(dhSpec);
        KeyPair bobKeyPair = bobKeyGen.generateKeyPair();

        // Generate shared secret
        KeyAgreement aliceAgree = KeyAgreement.getInstance("DH");
        aliceAgree.init(aliceKeyPair.getPrivate());
        aliceAgree.doPhase(bobKeyPair.getPublic(), true);
        byte[] aliceSharedSecret = aliceAgree.generateSecret();

        KeyAgreement bobAgree = KeyAgreement.getInstance("DH");
        bobAgree.init(bobKeyPair.getPrivate());
        bobAgree.doPhase(aliceKeyPair.getPublic(), true);
        byte[] bobSharedSecret = bobAgree.generateSecret();

        System.out.println("Shared Secret (Alice): " + Base64.getEncoder().encodeToString(aliceSharedSecret));
        System.out.println("Shared Secret (Bob): " + Base64.getEncoder().encodeToString(bobSharedSecret));
    }
}

