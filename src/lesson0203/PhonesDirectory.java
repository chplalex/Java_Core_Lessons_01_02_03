package lesson0203;

import java.util.*;

public class PhonesDirectory {
    private Map<String, Set<String>> phonesMap;

    public PhonesDirectory(String[][] phonesArr) {
        phonesMap = new HashMap<>();
        for (String[] entry: phonesArr) {
            add(entry[0], entry[1]);
        }
    }

    public String get(String name) {
        if (phonesMap.containsKey(name)) {
            return String.format("Имя: \"%s\", телефоны: %s.", name, phonesMap.get(name));
        } else {
            return String.format("Имя \"%s\" не найдено в справочнике.", name);
        }
    }

    public void add (String name, String phone) {
        Set<String> phonesSet = phonesMap.getOrDefault(name, new HashSet<String>());
        phonesSet.add(phone);
        phonesMap.put(name, phonesSet);
    }

}
