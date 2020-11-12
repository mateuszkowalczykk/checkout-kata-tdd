import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutTest {
    Checkout checkout;

    public void multiScan(String string){
        for(String itemName : string.split("")){
            checkout.scan(itemName);
        }
    }

    @BeforeEach
    void setUp() {
        checkout = new Checkout("src/main/resources/pricing_rules.txt");
    }

    @Test
    void canCreateCheckOut() {
        checkout = new Checkout("src/main/resources/pricing_rules.txt");
    }

    @Test
    void canScanItem() {
        checkout.scan("A");
    }
    @Test
    void canGetTotalPrice() {
        checkout.getTotalPrice();
    }
    @Test
    void canScanAndGetPriceWithoutSpecialOffers() {
        multiScan("ABA");
        assertThat(checkout.getTotalPrice()).isEqualTo(130);
    }
    @Test
    void handleSpecialOffers() {
        multiScan("ABADCBA");
        assertThat(checkout.getTotalPrice()).isEqualTo(210);
    }


}
