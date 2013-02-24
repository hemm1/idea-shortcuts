package bekk;

import snake.Snake;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<String>();

        OtherClass.sortList(strings);

        Snake snake = new Snake();
        snake.startMovement();
    }
}
