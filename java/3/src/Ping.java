import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
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
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            ArrayList<Float> f = new ArrayList<>();
            String response = "";
            String pingtime = "";
            int len = noOfTimes;
            boolean unreachable = false;
            while ((response = inputStream.readLine()) != null) {
                if (Pattern.matches(".*time=.*", response)) {
                    String ss[] = response.split(" ");
                    pingtime = ss[7].substring(5);
                    // System.out.println(pingtime+" ms");
                    f.add(Float.parseFloat(pingtime));
                    unreachable = true;
                }
            }
            Collections.sort(f);
            if (!unreachable)
                logger.info("unreachable");
            else {
                float medainTime = 0;
                if (len % 2 == 0)
                    medainTime = (f.get(len / 2) + f.get(len / 2 - 1)) / 2;
                else
                    medainTime = (float) f.get(len / 2);
                logger.info("Median of time taken to ping host:" + medainTime + " ms");
            }
        } catch (Exception e) {
            logger.info(" error while executing ping command");
            e.printStackTrace();
        }
    }

    /**
     * method to take input and invoke pingHost method.
     * input will contain url of host and no of times to hit the host.
     */
    public void tester() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the url of host to ping ");
        String urlOfHost = sc.next();
        System.out.println("Enter no of times to hit ");
        int noOfTimes = sc.nextInt();
        pingHost("ping -c " + noOfTimes + " " + urlOfHost, noOfTimes);
    }

    public static void main(String[] args) {
        Ping ping = new Ping();
        ping.tester();
    }
}
