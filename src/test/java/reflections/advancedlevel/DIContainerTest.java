package reflections.advancedlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.advancedlevel.dependencyinjection.Client;
import reflections.advancedlevel.dependencyinjection.DIContainer;
import reflections.advancedlevel.dependencyinjection.ServiceImpl;

class DIContainerTest {
    @Test
    void testDependencyInjection() throws Exception {
        DIContainer container = new DIContainer();
        container.register(ServiceImpl.class);

        Client client = new Client();
        container.injectDependencies(client);

        assertNotNull(client.service);
    }
}
