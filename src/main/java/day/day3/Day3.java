package day.day3;

import day.AdventHelper;
import org.apache.commons.collections4.ListUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day3 {

    public static void main(String[] args) {
        List<String> listOfRunSacks = AdventHelper.readFile("src/main/resources/runsack.txt");

        Map<Character, Integer> mapOfLetters = new HashMap<>();
        mapOfLetters.put('a', 1);
        mapOfLetters.put('b', 2);
        mapOfLetters.put('c', 3);
        mapOfLetters.put('d', 4);
        mapOfLetters.put('e', 5);
        mapOfLetters.put('f', 6);
        mapOfLetters.put('g', 7);
        mapOfLetters.put('h', 8);
        mapOfLetters.put('i', 9);
        mapOfLetters.put('j', 10);
        mapOfLetters.put('k', 11);
        mapOfLetters.put('l', 12);
        mapOfLetters.put('m', 13);
        mapOfLetters.put('n', 14);
        mapOfLetters.put('o', 15);
        mapOfLetters.put('p', 16);
        mapOfLetters.put('q', 17);
        mapOfLetters.put('r', 18);
        mapOfLetters.put('s', 19);
        mapOfLetters.put('t', 20);
        mapOfLetters.put('u', 21);
        mapOfLetters.put('v', 22);
        mapOfLetters.put('w', 23);
        mapOfLetters.put('x', 24);
        mapOfLetters.put('y', 25);
        mapOfLetters.put('z', 26);

        mapOfLetters.put('A', 27);
        mapOfLetters.put('B', 28);
        mapOfLetters.put('C', 29);
        mapOfLetters.put('D', 30);
        mapOfLetters.put('E', 31);
        mapOfLetters.put('F', 32);
        mapOfLetters.put('G', 33);
        mapOfLetters.put('H', 34);
        mapOfLetters.put('I', 35);
        mapOfLetters.put('J', 36);
        mapOfLetters.put('K', 37);
        mapOfLetters.put('L', 38);
        mapOfLetters.put('M', 39);
        mapOfLetters.put('N', 40);
        mapOfLetters.put('O', 41);
        mapOfLetters.put('P', 42);
        mapOfLetters.put('Q', 43);
        mapOfLetters.put('R', 44);
        mapOfLetters.put('S', 45);
        mapOfLetters.put('T', 46);
        mapOfLetters.put('U', 47);
        mapOfLetters.put('V', 48);
        mapOfLetters.put('W', 49);
        mapOfLetters.put('X', 50);
        mapOfLetters.put('Y', 51);
        mapOfLetters.put('Z', 52);
        mapOfLetters.put(' ', 0);

        System.out.println("Part 1: " + part1(listOfRunSacks, mapOfLetters));
        System.out.println("--------------");
        System.out.println("Part 2: " + part2(listOfRunSacks, mapOfLetters));
    }

    public static int part1(List<String> listOfRunSacks, Map<Character, Integer> mapOfLetters) {
        int total = 0;
        for (String runSack : listOfRunSacks) {
            String firstHalfOfRunSack = runSack.substring(0, runSack.length() / 2);
            String secondHalfOfRunSack = runSack.substring(runSack.length() / 2);

            List<Character> firstHalfCharList = AdventHelper.convertStringToCharList(firstHalfOfRunSack);
            List<Character> secondHalfCharList = AdventHelper.convertStringToCharList(secondHalfOfRunSack);

            List<Character> tempLetters = getMatchedLetter(firstHalfCharList, secondHalfCharList);
            char matchedLetter = getPriorityCharacter(mapOfLetters, tempLetters);
            int letterValue = mapOfLetters.get(matchedLetter);
            total += letterValue;
        }
        return total;
    }

    public static int part2(List<String> listOfRunSacks, Map<Character, Integer> mapOfLetters) {
        int total = 0;
        List<List<String>> chunkedRunSacks = ListUtils.partition(listOfRunSacks, 3);

        for (List<String> listOfChunked : chunkedRunSacks) {
            List<Character> firstList = AdventHelper.convertStringToCharList(listOfChunked.get(0));
            List<Character> secondList = AdventHelper.convertStringToCharList(listOfChunked.get(1));
            List<Character> thirdList = AdventHelper.convertStringToCharList(listOfChunked.get(2));

            List<Character> tempLetters = findMatchedLetters(firstList, secondList, thirdList);
            char matchedLetter = getPriorityCharacter(mapOfLetters, tempLetters);
            int letterValue = mapOfLetters.get(matchedLetter);
            total += letterValue;
        }
        return total;
    }

    private static char getPriorityCharacter(Map<Character, Integer> mapOfLetters, List<Character> tempLetters) {
        char matchedLetter = ' ';
        for (char storedLetter : tempLetters) {
            int tempLetterValue = mapOfLetters.get(storedLetter);
            int letterValue = mapOfLetters.get(matchedLetter);
            if (tempLetterValue > letterValue) {
                matchedLetter = storedLetter;
            }
        }
        return matchedLetter;
    }

    private static List<Character> getMatchedLetter(List<Character> firstHalfCharList, List<Character> secondHalfCharList) {
        List<Character> tempLetters = new ArrayList<>();
        for (char letter : firstHalfCharList) {
            for (char otherLetter : secondHalfCharList) {
                if (letter == otherLetter) {
                    tempLetters.add(letter);
                }
            }
        }
        return tempLetters;
    }

    private static List<Character> findMatchedLetters(List<Character> firstList, List<Character> secondList, List<Character> thirdList) {
        List<Character> tempLetters = new ArrayList<>();
        for (char letter : firstList) {
            for (char secondLetter : secondList) {
                if (secondLetter == letter) {
                    for (char thirdLetter : thirdList) {
                        if (letter == thirdLetter) {
                            tempLetters.add(letter);
                        }
                    }
                }
            }
        }
        return tempLetters;
    }
}
