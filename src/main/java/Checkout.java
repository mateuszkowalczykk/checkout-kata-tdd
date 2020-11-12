import java.io.File;
import java.util.*;

public class Checkout {
    List<String> scannedItems = new ArrayList<>();
    Map<String,Integer> pricingRules = new HashMap<>();

    public Checkout(String path) {
        try {
            File file = new File(path);
            Scanner loadedFile = new Scanner(file);
            while (loadedFile.hasNextLine()) {
                String[] itemData = loadedFile.nextLine().split(";");
                String itemName = itemData[0];
                int price = Integer.parseInt(itemData[1]);
                pricingRules.put(itemName,price);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void scan(String itemName){
        scannedItems.add(itemName);
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for(String itemName : scannedItems){
            totalPrice += pricingRules.get(itemName);
        }
        return totalPrice;
    }


}
