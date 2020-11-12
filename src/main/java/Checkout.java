import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Checkout {
    Map<Item,Integer> scannedItems = new HashMap();
    Set<Item> pricingRules = new HashSet<>();

    public Checkout(String path) {
        try {
            loadPricingRules(path);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public void scan(String itemName){
        Item item = pricingRules.stream()
                .filter(item1 -> item1.getName().equalsIgnoreCase(itemName))
                .findFirst()
                .get();
        if(scannedItems.containsKey(item)){
            scannedItems.put(item,scannedItems.get(item)+1);
        }else{
            scannedItems.put(item,1);
        }
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for(Item item : scannedItems.keySet()){
            if(item.getNumbersOfItemsToSpecialOffer() ==0){
                totalPrice += item.getPrice() * scannedItems.get(item);
            }else{
                totalPrice += scannedItems.get(item) / item.getNumbersOfItemsToSpecialOffer() * item.getPriceForSpecialOfferSet();
                totalPrice += scannedItems.get(item) % item.getNumbersOfItemsToSpecialOffer() * item.getPrice();
            }
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
            if(itemData.length >2){
                int numbersOfItemsToSpecialOffer = Integer.parseInt(itemData[2]);
                int priceForSpecialOfferSet = Integer.parseInt(itemData[3]);
                pricingRules.add(new Item(itemName,price,numbersOfItemsToSpecialOffer,priceForSpecialOfferSet));
            }else{
                pricingRules.add(new Item(itemName,price));
            }
        }
    }
}
