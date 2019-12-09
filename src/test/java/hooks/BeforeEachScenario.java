package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeEachScenario {
    @Before
    public void init() {
        System.out.println("-----------Before Each-----------");
    }

    @After
    public void tearDown() {
        System.out.println("-----------After Each-----------");
    }
}
