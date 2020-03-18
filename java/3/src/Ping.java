import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

class Ping {
    private static Logger logger = Logger.getLogger(Ping.class.getName());

    /**
     * Pings the host to test the host reachability.
     * calculates  the median time taken to ping host and prints the same.
     *
     * @param command   ping command to ping the host.
     * @param noOfTimes mentions number of times to hit the host.
     */
    public void pingHost(String command, int noOfTimes) {

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            ArrayList<Float> time = new ArrayList<>();
            String response = "";
            String pingTime = "";
            int len = noOfTimes;
            boolean unreachable = false;
            while ((response = inputStream.readLine()) != null) {
                if (Pattern.matches(".*time=.*", response)) {
                    String responseLine[] = response.split(" ");
                    logger.info(response);
                    pingTime = responseLine[7].substring(5);
                    time.add(Float.parseFloat(pingTime));
                    unreachable = true;
                }
            }
            Collections.sort(time);
            if (!unreachable)
                logger.info("unreachable");
            else {
                float medainTime = 0;
                if (len % 2 == 0)
                    medainTime = (time.get(len / 2) + time.get(len / 2 - 1)) / 2;
                else
                    medainTime = (float) time.get(len / 2);
                logger.info("Median of time taken to ping host:" + medainTime + " ms");
            }
        } catch (IOException e) {
            logger.log(Level.WARNING," error while executing ping command");
            e.printStackTrace();
        }
    }

    /**
     * method to take input and invoke pingHost method.
     * input will contain url of host and no of times to hit the host.
     */
    public void isUrlReachable() {
        Scanner sc = new Scanner(System.in);
        logger.info("Enter the url of host to ping ");
        String urlOfHost = sc.next();
        logger.info("Enter no of times to hit ");
        int noOfTimes = sc.nextInt();
        pingHost("ping -c " + noOfTimes + " " + urlOfHost, noOfTimes);
    }

    public static void main(String[] args) {
        Ping ping = new Ping();
        ping.isUrlReachable();
    }
}
