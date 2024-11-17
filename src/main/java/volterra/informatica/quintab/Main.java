package volterra.informatica.quintab;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    private static final RSA es = new RSA();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String message = getInput();

        BigInteger crypted = es.encryption(message);

        log.info("Stringa criptata: {}", crypted);

        String decrypted = es.decryptionToString(crypted);

        log.info("Stringa decriptata: {}", decrypted);
    }

    public static String getInput(){
        log.info("Inserisci la stringa da criptare: ");
        String message = scanner.nextLine();
        scanner.close();
        return message;
    }
}