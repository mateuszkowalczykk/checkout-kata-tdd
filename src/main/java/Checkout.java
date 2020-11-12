import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Checkout {
    List<String> scannedItems = new ArrayList<>();
    Map<String,Integer> pricingRules = new HashMap<>();

    public Checkout(String path) {
        try {
            loadPricingRules(path);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void scan(String itemName){
        if(pricingRules.containsKey(itemName)){
            scannedItems.add(itemName);
        }else{
            System.out.println("Sorry. Not found item in database");
        }
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for(String itemName : scannedItems){
            totalPrice += pricingRules.get(itemName);
        }
        return totalPrice;
    }

    private void loadPricingRules(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner loadedFile = new Scanner(file);
        while (loadedFile.hasNextLine()) {
            String[] itemData = loadedFile.nextLine().split(";");
            String itemName = itemData[0];
            int price = Integer.parseInt(itemData[1]);
            pricingRules.put(itemName,price);
        }
    }
}
