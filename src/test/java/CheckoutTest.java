import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckoutTest {
    Checkout checkout;
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
}
