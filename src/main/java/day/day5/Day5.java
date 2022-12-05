package day.day5;

import day.AdventHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Day5 {
    public static void main(String[] args) {
        Map<Integer, Stack<String>> crateMap = buildCrateStacks();
        Map<Integer, Stack<String>> crateMap2 = buildCrateStacks();

        List<String> crates = AdventHelper.readFile("src/main/resources/crates.txt");
        part1(crates, crateMap);
        System.out.println("----------");
        part2(crates, crateMap2);
    }

    private static void part1(List<String> crates, Map<Integer, Stack<String>> crateMap) {
        for (String direction : crates) {
            String[] cleanDirectionSplit = getCrateInformation(direction);
            int amountOfBoxesToMove = Integer.parseInt(cleanDirectionSplit[0]);
            int initialBox = Integer.parseInt(cleanDirectionSplit[1]);
            int finalBox = Integer.parseInt(cleanDirectionSplit[2]);

            for (int i = 0; i < amountOfBoxesToMove; i++) {
                String poppedBox = crateMap.get(initialBox).pop();
                crateMap.get(finalBox).add(poppedBox);
            }

        }
        System.out.println(crateMap);
    }

    private static void part2(List<String> crates, Map<Integer, Stack<String>> crateMap) {
        for (String direction : crates) {
            String[] cleanDirectionSplit = getCrateInformation(direction);
            int amountOfBoxesToMove = Integer.parseInt(cleanDirectionSplit[0]);
            int initialBox = Integer.parseInt(cleanDirectionSplit[1]);
            int finalBox = Integer.parseInt(cleanDirectionSplit[2]);

            Stack<String> tempStack = new Stack<>();
            for (int i = 0; i < amountOfBoxesToMove; i++) {
                String poppedBox = crateMap.get(initialBox).pop();
                tempStack.add(poppedBox);
            }

            for (int i = 0; i < amountOfBoxesToMove; i++) {
                String poppedBox = tempStack.pop();
                crateMap.get(finalBox).add(poppedBox);
            }

        }
        System.out.println(crateMap);

    }

    private static String[] getCrateInformation(String direction) {
        String cleanDirections = direction.replaceAll("\\D+", " ").trim();
        return cleanDirections.split(" ");
    }

    private static Map<Integer, Stack<String>> buildCrateStacks() {
        Stack<String> row1 = new Stack<>();
        row1.add("D");
        row1.add("B");
        row1.add("J");
        row1.add("V");
        Stack<String> row2 = new Stack<>();
        row2.add("P");
        row2.add("V");
        row2.add("B");
        row2.add("W");
        row2.add("R");
        row2.add("D");
        row2.add("F");
        Stack<String> row3 = new Stack<>();
        row3.add("R");
        row3.add("G");
        row3.add("F");
        row3.add("L");
        row3.add("D");
        row3.add("C");
        row3.add("W");
        row3.add("Q");
        Stack<String> row4 = new Stack<>();
        row4.add("W");
        row4.add("J");
        row4.add("P");
        row4.add("M");
        row4.add("L");
        row4.add("N");
        row4.add("D");
        row4.add("B");
        Stack<String> row5 = new Stack<>();
        row5.add("H");
        row5.add("N");
        row5.add("B");
        row5.add("P");
        row5.add("C");
        row5.add("S");
        row5.add("Q");
        Stack<String> row6 = new Stack<>();
        row6.add("R");
        row6.add("D");
        row6.add("B");
        row6.add("S");
        row6.add("N");
        row6.add("G");
        Stack<String> row7 = new Stack<>();
        row7.add("Z");
        row7.add("B");
        row7.add("P");
        row7.add("M");
        row7.add("Q");
        row7.add("F");
        row7.add("S");
        row7.add("H");
        Stack<String> row8 = new Stack<>();
        row8.add("W");
        row8.add("L");
        row8.add("F");
        Stack<String> row9 = new Stack<>();
        row9.add("S");
        row9.add("V");
        row9.add("F");
        row9.add("M");
        row9.add("R");
        Map<Integer, Stack<String>> crateMap = new HashMap<>();
        crateMap.put(1, row1);
        crateMap.put(2, row2);
        crateMap.put(3, row3);
        crateMap.put(4, row4);
        crateMap.put(5, row5);
        crateMap.put(6, row6);
        crateMap.put(7, row7);
        crateMap.put(8, row8);
        crateMap.put(9, row9);
        return crateMap;
    }
}
