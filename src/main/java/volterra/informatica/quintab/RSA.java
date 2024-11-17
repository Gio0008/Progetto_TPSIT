package volterra.informatica.quintab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigInteger;
import java.security.SecureRandom;

import static volterra.informatica.quintab.Main.log;

public class RSA {
    private static final Logger logger = LogManager.getLogger(RSA.class);

    private static BigInteger  p, n, e, q, d, phi;

    private final int bitLenght = 1024;

    public RSA {

        //generazione di due numeri primi grandi
        SecureRandom rand = new SecureRandom();
        p = BigInteger.probablePrime(bitLenght/2, rand);
        log.info("Generated prime number p: " + p);
        q = BigInteger.probablePrime(bitLenght/2, rand);
        log.info("Generated prime number q: " + q);

        //prodotto p*q
        n = p.multiply(q);
        log.info("Generated n: " + n);

        //(p-1)(q-1)
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        log.info("Generated phi: " + phi);

        //esponente pubblico
        e = new BigInteger(phi.bitLength(), rand);
        while(e.compareTo(BigInteger.ONE) <= 0 || e.compareTo(phi) >= 0 || !e.gcd(phi).equals(BigInteger.ONE));
        log.info("Generated e: " + e);

        //esponente privato
        d = e.modInverse(phi);
        log.info("Generated d: " +d);
    }

    public static BigInteger encryption(String message){
        return message.modPow(e, n);
    }

    public static BigIntegetr decryption(String message){
        return message.modPow(d, n);
    }


}
