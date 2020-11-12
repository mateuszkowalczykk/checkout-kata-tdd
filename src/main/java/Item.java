public class Item {
    private final String name;
    private final int price;
    private int numbersOfItemsToSpecialOffer;
    private int priceForSpecialOfferSet;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, int price, int numbersOfItemsToSpecialOffer, int priceForSpecialOfferSet) {
        this.name = name;
        this.price = price;
        this.numbersOfItemsToSpecialOffer = numbersOfItemsToSpecialOffer;
        this.priceForSpecialOfferSet = priceForSpecialOfferSet;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getNumbersOfItemsToSpecialOffer() {
        return numbersOfItemsToSpecialOffer;
    }

    public int getPriceForSpecialOfferSet() {
        return priceForSpecialOfferSet;
    }
}
