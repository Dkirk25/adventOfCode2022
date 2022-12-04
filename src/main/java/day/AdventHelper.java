package day;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdventHelper {
    public static List<String> readFile(String fileLocation) {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileLocation))) {
            //br returns as stream and convert it into a List
            list = br.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Map<Integer, Integer> getLargestMapValue(Map<Integer, Integer> mapOfElfTotals, int mapSize) {
        return mapOfElfTotals.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(mapSize)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static List<Character> convertStringToCharList(String str) {
        // return the List
        return str
                .chars()
                // Convert IntStream to Stream<Character>
                .mapToObj(e -> (char) e).toList();
    }
}
