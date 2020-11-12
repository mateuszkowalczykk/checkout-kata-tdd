import org.junit.jupiter.api.Test;

public class CheckoutTest {
    Checkout checkout;
    @Test
    void canCreateCheckOut() {
        checkout = new Checkout("src/main/resources/pricing_rules.txt");
    }
}
