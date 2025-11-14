import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    public static void addReceipt(ArrayList<Item> list){
        try {
            File folder = new File("receipts");
            if (!folder.exists()) {
                folder.mkdir();
            }

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String file = "receipts/" + now.format(formatter) + ".txt";

            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);

            for (Item item : list) {
                buffer.write(item.toString());
                buffer.write("\n");
            }

            buffer.close();
            System.out.println("Receipt saved: " + file);

        } catch (Exception e) {
            System.out.println("Receipt did not save");
        }
    }








}
