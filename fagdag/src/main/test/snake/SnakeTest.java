package snake;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;

public class SnakeTest {

    private Snake snake;

    @Before
    public void setUp() throws Exception {
        snake = new Snake();

    }

    @Test
    public void enEllerAnnenTest() {
        SnakePanel snakePanel = new SnakePanel();
        assertFalse(snakePanel.isApple());
    }

}
