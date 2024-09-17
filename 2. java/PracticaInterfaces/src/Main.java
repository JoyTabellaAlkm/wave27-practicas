import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> listaCadenas = new ArrayList<>();

        listaCadenas.add("Argentina");
        listaCadenas.add("Brasil");
        listaCadenas.add("Chile");
        listaCadenas.add("Uruguay");
        listaCadenas.add("Paraguay");

        listaCadenas.stream().map(pais -> pais + ".").forEach(System.out::println);



    }
}
