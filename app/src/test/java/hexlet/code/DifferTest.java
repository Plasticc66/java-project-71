package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    public void testGenerateAdd() throws IOException {
        File path1 =
                new File("./src/test/resources/testAdd1.json");
        File path2 = new File("./src/test/resources/testAdd2.json");

        String expected = "\n{\n+ param: 1\n}";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateChange() throws IOException {
        File path1 =
                new File("./src/test/resources/testChange1.json");
        File path2 = new File("./src/test/resources/testChange2.json");

        String expected = "\n{\n- param: 4\n+ param: 44\n}";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateDelete() throws IOException {
        File path1 =
                new File("./src/test/resources/testDelete1.json");
        File path2 = new File("./src/test/resources/testDelete2.json");

        String expected = "\n{\n- param: true\n}";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateNoDiff() throws IOException {
        File path1 =
                new File("./src/test/resources/testNoDiff1.json");
        File path2 = new File("./src/test/resources/testNoDiff2.json");

        String expected = "\n{\n  param: param\n}";
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }

}
