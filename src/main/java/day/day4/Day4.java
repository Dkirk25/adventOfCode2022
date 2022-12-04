package day.day4;

import day.AdventHelper;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day4 {

    public static void main(String[] args) {
        List<String> assignments = AdventHelper.readFile("src/main/resources/assignments.txt");

        //483
        System.out.println("Part 1: " + part1(assignments));
        System.out.println("-------------------");
        System.out.println("Part 2: " + part2(assignments));
    }

    private static int part2(List<String> assignments) {
        int count = 0;
        for (String assignment : assignments) {
            String[] splitAssignments = assignment.split(",");
            //2-4,6-8
            String assignment1 = splitAssignments[0].trim();
            String assignment2 = splitAssignments[1].trim();

            List<Integer> fullAssignment2 = getMissingNumbers(assignment2);
            List<Integer> fullAssignment1 = getMissingNumbers(assignment1);

            if (fullAssignment1.size() > fullAssignment2.size()) {
                if (CollectionUtils.containsAll(fullAssignment1, fullAssignment2)) {
                    count++;
                }
            } else {
                if (CollectionUtils.containsAll(fullAssignment2, fullAssignment1)) {
                    count++;
                }
            }

        }
        return count;
    }

    private static int part1(List<String> assignments) {
        int count = 0;
        for (String assignment : assignments) {
            String[] splitAssignments = assignment.split(",");
            //2-4,6-8
            String assignment1 = splitAssignments[0].trim();
            String assignment2 = splitAssignments[1].trim();

            if(check2(assignment1,assignment2)){
                count++;
            }
        }
        return count;
    }

    private static List<Integer> getMissingNumbers(String assignment) {
        int min = Integer.parseInt(assignment.substring(0, 1));
        int max = Integer.parseInt(assignment.substring(assignment.length() - 1));
        List<Integer> listOfNumbers = new ArrayList<>();

        IntStream.rangeClosed(min, max).forEach(listOfNumbers::add);
        return listOfNumbers;
    }

    private static boolean check2(String x, String y) {
        String[] xSplit = x.split("-");
        String[] ySplit = y.split("-");
        int elfOneLow = Integer.parseInt(xSplit[0]);
        int elfOneHigh = Integer.parseInt(xSplit[1]);
        int elfTwoLow = Integer.parseInt(ySplit[0]);
        int elfTwoHigh = Integer.parseInt(ySplit[1]);

        return ((elfTwoLow <= elfOneLow) && (elfOneHigh <= elfTwoHigh)) || ((elfOneLow <= elfTwoLow) && (elfTwoHigh <= elfOneHigh));
    }
}
