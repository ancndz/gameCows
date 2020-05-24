package sample.game;

import java.util.*;
import java.util.stream.Collectors;

public class Verifier {
    public Verifier() {
    }

    public List<Integer> stringToList(String s) {
        final List emptyList = Collections.EMPTY_LIST;
        if (!s.isEmpty()) {
            try {
                Integer.parseInt(s);
                return Arrays.stream(s.split("\\B"))
                        .map(Integer::valueOf).collect(Collectors.toList());
            } catch (Exception e) {
                return emptyList;
            }
        } else {
            return emptyList;
        }
    }

    public List<Integer> getRandomList(int size) {
        List<Integer> machineList = new ArrayList<>();
        List<Integer> existingDigits = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < size; i++) {
            int randomInt = random.nextInt(9);
            if (!existingDigits.contains(randomInt)) {
                machineList.add(randomInt);
                existingDigits.add(i);
            }
        }
        return machineList;
    }

    public boolean isListUnique(List<Integer> list) {
        List<Integer> existingDigits = new ArrayList<>();
        for (Integer integer : list) {
            if (!existingDigits.contains(integer)) {
                existingDigits.add(integer);
            } else {
                return false;
            }
        }
        return true;
    }

}
