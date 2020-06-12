import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private final SILab2 lab2;

    public SILab2Test(){
        lab2 = new SILab2();
    }
    private List<String> createList(String... s) {
        return new ArrayList<>(Arrays.asList(s));
    }

    @Test
    void everyBranch() {
        IllegalArgumentException exception;
        exception = assertThrows(IllegalArgumentException.class, () -> this.lab2.function(Collections.emptyList()));
        assertTrue(exception.getMessage().contains("List length should be greater than 0"));

        assertEquals(new ArrayList<>(createList("#", "2", "#")), lab2.function(createList("#", "0", "#")));

        assertEquals(new ArrayList<>(createList("0")), lab2.function(createList("0")));
    }

    @Test
    void multipleCondition() {
        //(i - 1 >= 0 && list.get(i - 1).equals("#")), (i + 1 < list.size() && list.get(i + 1).equals("#"))
        assertEquals(new ArrayList<>(createList("0")), lab2.function(createList("0")));

        assertEquals(new ArrayList<>(createList("#", "2", "#")), lab2.function(createList("#", "0", "#")));

        assertEquals(new ArrayList<>(createList("0", "0")), lab2.function(createList("0", "0")));
    }
}