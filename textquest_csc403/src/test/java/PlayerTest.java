import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import com.textquest.Characters.*;

public class PlayerTest {

    @Test
    public void testPlayerConstructor() {

        assertThrows(NullPointerException.class, () -> new Player("test", "test", null));

    }

}
