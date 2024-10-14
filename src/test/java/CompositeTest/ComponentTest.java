package CompositeTest;

import main.Composite.Component;
import main.Composite.Composite;
import main.Composite.Leaf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ComponentTest {

    @Test
    @DisplayName("Test Leaf operation")
    void testLeafOperation() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Component leaf = new Leaf("Leaf 1");
        leaf.operation();

        String expectedOutput = "Leaf: Leaf 1\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test Composite operation")
    void testCompositeOperation() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Composite composite = new Composite("Composite 1");
        Composite composite2 = new Composite("Composite 2");
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");

        composite.add(leaf1);
        composite2.add(leaf2);
        composite2.add(composite);

        composite2.operation();

        String expectedOutput =
                "Composite: Composite 2\n" +
                        "Leaf: Leaf 2\n" +
                        "Composite: Composite 1\n" +
                        "Leaf: Leaf 1\n";

        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test Composite add operation")
    void testCompositeAdd() {
        Composite composite = new Composite("Composite 1");
        Leaf leaf = new Leaf("Leaf 1");
        composite.add(leaf);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            composite.remove(new Leaf("Leaf 2"));
        });
    }

    @Test
    @DisplayName("Test Composite remove operation with existing leaf")
    void testCompositeRemoveExistingLeaf() {
        Composite composite = new Composite("Composite 1");
        Leaf leaf = new Leaf("Leaf 1");
        composite.add(leaf);

        assertDoesNotThrow(() -> composite.remove(leaf));
    }

    @Test
    @DisplayName("Test Composite remove operation with non-existing leaf")
    void testCompositeRemoveNonExistingLeaf() {
        Composite composite = new Composite("Composite 1");
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        composite.add(leaf1);

        assertDoesNotThrow(() -> composite.remove(leaf2));
    }
}
