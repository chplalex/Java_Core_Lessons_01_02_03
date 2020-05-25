package lesson0203;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PhonesDirectory extends HashMap <String, ArrayList<String>>{

    public PhonesDirectory(String[][] phonesArr) {
        for (String[] entry: phonesArr) {
            ArrayList<String> phonesList = get(entry[0]);
            if (phonesList == null) {
                phonesList = new ArrayList<String>();
                put(entry[0], phonesList);
            }
            phonesList.add(entry[1]);
        }
    }

    public String getNameInfo(String name) {
        if (containsKey(name)) {
            return String.format("Имя: \"%s\", телефоны: %s.", name, get(name));
        } else {
            return String.format("Имя \"%s\" не найдено в справочнике.", name);
        }
    }

    public void add (String name, String phone) {
        ArrayList<String> phonesList;
        if (containsKey(name)) {
            phonesList = get(name);
            for (String p: phonesList) {
                if (p.equals(phone)) {
                    return;
                }
            }
            phonesList.add(phone);
            return;
        }
        phonesList = new ArrayList<>();
        phonesList.add(phone);
        put(name, phonesList);
    }



}
