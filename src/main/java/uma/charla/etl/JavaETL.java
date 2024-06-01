package uma.charla.etl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaETL {

    public static List<String> extract() {
        List<String> data = new ArrayList<>();
        data.add("1,foo");
        data.add("2,boo");
        data.add("3,bar");
        data.add("Java is better than Scala (wtf you're kiddin me right?)");
        return data;
    }

    public static List<JData> transform(List<String> data) {
        return data.stream()
                .map(line -> {
                    String[] parts = line.split(",");
                    if(parts.length == 2 && parts[0].matches("\\d+")) {
                        return new JData(Integer.parseInt(parts[0]), parts[1]);
                    } else {
                        return new JData(187, parts[0]);
                    }
        }).collect(Collectors.toList());
    }

    public static void load(List<JData> data){
        data.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<String> rawData = extract();
        List<JData> transformedData = transform(rawData);
        load(transformedData);
    }

}
