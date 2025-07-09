import java.io.IOException;
import java.net.InetAddress;

public class monitoring {
    public static void main(String[] args) {
        String host = "google.com"; // change to any IP or hostname

        System.out.println("Pinging " + host + "...");

        try {
            InetAddress inet = InetAddress.getByName(host);
            if (inet.isReachable(2000)) { // 2-second timeout
                System.out.println(host + " is reachable ✅");
            } else {
                System.out.println(host + " is NOT reachable ❌");
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
