package day.day1;

import day.AdventHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1 {

    public static void main(String[] args) {
        List<String> list = AdventHelper.readFile("src/main/resources/calories.txt");
        Map<Integer, Integer> mapOfElfTotals = generateMapOfElfCalories(list);
        part1(mapOfElfTotals);
        System.out.println("------------");
        part2(mapOfElfTotals);
    }

    private static Map<Integer, Integer> generateMapOfElfCalories(List<String> list) {
        Map<Integer, Integer> mapOfElfTotals = new HashMap<>();
        int elf = 1;
        int total = 0;
        for (String line : list) {
            if (StringUtils.isNotBlank(line)) {
                total += Integer.parseInt(line);
            } else {
                mapOfElfTotals.put(elf, total);
                total = 0;
                elf++;
            }
        }
        return mapOfElfTotals;
    }

    public static void part1(Map<Integer, Integer> mapOfElfTotals) {
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : mapOfElfTotals.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println(maxEntry);
    }

    public static void part2(Map<Integer, Integer> mapOfElfTotals) {
        Map<Integer, Integer> top3 = AdventHelper.getLargestMapValue(mapOfElfTotals, 3);
        System.out.println("Part 2: " + top3CaloriesTotal(top3));
    }

    private static int top3CaloriesTotal(Map<Integer, Integer> top3) {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : top3.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }
}
