package Railway;

import org.testng.annotations.Test;

public class Dev extends TestBase {
    @Test
    public void TC01() {
        step("Step 1: Do something");
        step("Step 2: Do something else", () -> {
            // Do something else
        });
    }
}
