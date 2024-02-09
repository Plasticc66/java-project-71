package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Differ {

    public static String generate(File path1, File path2) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mapJson1 = (Map) mapper.readValue(path1, Object.class);
        Map<String, Object> mapJson2 = (Map) mapper.readValue(path2, Object.class);

        Set<String> twoMapsKeySet = new HashSet<>();
        twoMapsKeySet.addAll(mapJson1.keySet());
        twoMapsKeySet.addAll(mapJson2.keySet());
        List<String> keysList = twoMapsKeySet.stream()
                .sorted()
                .toList();

        StringBuilder result = new StringBuilder();
        result.append("\n{\n");

        for (String key : keysList) {
            if (mapJson1.containsKey(key) && mapJson2.containsKey(key)) {
                if (mapJson1.get(key).equals(mapJson2.get(key))) {
                    result.append("  " + key + ": " + mapJson1.get(key) + "\n");
                } else {
                    result.append("- " + key + ": " + mapJson1.get(key) + "\n"
                            + "+ " + key + ": " + mapJson2.get(key) + "\n");
                }
            } else {
                if (mapJson1.containsKey(key)) {
                    result.append("- " + key + ": " + mapJson1.get(key) + "\n");
                } else {
                    result.append("+ " + key + ": " + mapJson2.get(key) + "\n");
                }
            }
        }

        result.append("}");

        return result.toString();
    }
}
