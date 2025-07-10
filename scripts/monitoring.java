import java.io.*;

public class monitoring {
    public static void main(String[] args) {
        String host = "google.com"; // Change to your host
        System.out.println("Pinging " + host + "...");

        try {
            Process process = Runtime.getRuntime().exec("ping -c 1 " + host); // For Linux/Mac
            // For Windows, use: ping -n 1
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean reachable = false;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("1 packets transmitted") || line.contains("TTL=")) {
                    reachable = true;
                }
            }

            int exitCode = process.waitFor();
            if (reachable && exitCode == 0) {
                System.out.println(host + " is reachable ✅");
            } else {
                System.out.println(host + " is NOT reachable ❌");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

