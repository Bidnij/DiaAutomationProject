package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DeviceCapabilities;



public class Hooks {

    @Before
    public void setUp() throws Exception {
        DeviceCapabilities deviceCapabilities = new DeviceCapabilities();
        deviceCapabilities.runTestWithConfig();
    }

    @After
    public void tearDown() {
        DeviceCapabilities.destroyDriver();
        System.out.println("Run ended");
    }
}
