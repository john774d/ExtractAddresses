import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class ExtractAddresses {

    public static void main(String[] args) 
        throws InterruptedException {

        try {
            Scanner input = new Scanner(new File("raw_dat.txt"));

        	ArrayList<String> out = new ArrayList<String>();

        	int count = 0;

        	while (input.hasNext()) {
        		String N;
       		 	N = input.next();
        		if (N.startsWith("0x") && N.length() >= 30) { // for people who put spaces before their address
        			count++;
                    out.add(N.substring(0,41));
        		} else if (N.contains("0x") && N.length() >= 30) { // for those who didn't put spaces before their address
                    int begin = N.indexOf("0x");
                    count++;
                    out.add(N.substring(begin,(begin + 41)));
                }
        	}

            // remove duplicate addresses (if people posted their address twice)

            ArrayList<String> delete = new ArrayList<String>();

            for (int i = 0; i < out.size(); i++) {
                String check = out.get(i);
                for (int j = i + 1; j < out.size(); j++) {
                    if (out.get(j).equals(check)) {
                        delete.add(out.get(i));
                    }
                }
            }
            for (int i = 0; i < delete.size(); i++) {
                out.remove(delete.get(i));
            }

            // begin output
            System.out.println("\n==================================================");
            System.out.println("====CryptoCurrency Network Ethereum Give-Away!====");
            System.out.println("==================================================\n");
            System.out.println();

            Thread.sleep(1000);

            System.out.println("Number of ethereum addresses detected: " + out.size());
            System.out.println("Thanks for supporting the channel!\n");

        	String winlist = "";

            Thread.sleep(4000);

            System.out.println("Winning ethereum addresses:\n");
            Thread.sleep(2000);

        	for (int i = 0; i < 10; i++) {
        		int rand_winner = (int) (Math.random() * out.size());
                System.out.println(out.get(rand_winner) + "\n");
                out.remove(rand_winner); // don't let the same address win twice
                Thread.sleep(2000); // adjust this value to increase or decrease time (in milliseconds) between winners
        	}

        } catch (FileNotFoundException e) {
            System.out.println("Could not open file");
            System.exit(1);
        }
    }
}