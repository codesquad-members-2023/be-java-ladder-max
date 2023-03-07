package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListTest {

    @Test
    public void arrayList() throws Exception {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");

        Assertions.assertThat(values.add("third")).isTrue();
        Assertions.assertThat(values.size()).isEqualTo(3);
        Assertions.assertThat(values.get(0)).isEqualTo("first");
        Assertions.assertThat(values.contains("first")).isTrue();
        Assertions.assertThat(values.remove(0)).isEqualTo("first");
        Assertions.assertThat(values.size()).isEqualTo(2);

        for(String val : values){
            System.out.println(val);
        }
    }

    @Test
    public void LikedList() throws Exception {
        LinkedList<String> values = new LinkedList<>();
        values.add("first");
        values.add("second");

        Assertions.assertThat(values.add("third")).isTrue();
        Assertions.assertThat(values.size()).isEqualTo(3);
        Assertions.assertThat(values.get(0)).isEqualTo("first");
        Assertions.assertThat(values.contains("first")).isTrue();
        Assertions.assertThat(values.remove(0)).isEqualTo("first");
        Assertions.assertThat(values.size()).isEqualTo(2);

        for(String val : values){
            System.out.println(val);
        }
    }
}
