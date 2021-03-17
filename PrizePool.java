import java.io.*;
import java.util.*;

public class PrizePool {

    private static final Set<Prize> prizePool;

    static {
        prizePool = new HashSet<>();

        try (FileInputStream fileStream = new FileInputStream("prizePool.txt");
            InputStreamReader inputStream = new InputStreamReader(fileStream, "UTF-8");
            BufferedReader bf = new BufferedReader(inputStream)) {

            String str;
            while((str = bf.readLine()) != null) {
                String[] data = str.split(" ");
                Prize newPrize = new Prize(Integer.parseInt(data[0]),data[1]);
                prizePool.add(newPrize);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PrizePool() {}

    public Set<Prize> getPrizePool() {
        return new HashSet<>(prizePool);
    }

}
