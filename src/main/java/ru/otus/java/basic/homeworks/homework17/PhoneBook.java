package ru.otus.java.basic.homeworks.homework17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    Map<String, HashSet<Long>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public PhoneBook(HashMap<String, HashSet<Long>> otherPhoneBook) {
        if (otherPhoneBook == null) {
            phoneBook = new HashMap<>();
            return;
        }
        phoneBook = new HashMap<>(Map.copyOf(otherPhoneBook));
    }

    public void add(String FIO, long phoneNumber) {
        if (!phoneBook.containsKey(FIO)){
            phoneBook.put(FIO, new HashSet<>(Set.of(phoneNumber)));
            return;
        }
        phoneBook.get(FIO).add(phoneNumber);
    }

    public HashSet<Long> find(String FIO) {
        return phoneBook.get(FIO);
    }

    public boolean containsPhoneNumber(long initialPhoneNumber) {
        for(Map.Entry<String, HashSet<Long>> entry : phoneBook.entrySet()) {
            for(long phoneNumber : entry.getValue()) {
                if (phoneNumber == initialPhoneNumber) {
                    return true;
                }
            }
        }
        return false;
    }
}
