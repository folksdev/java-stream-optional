package com.javastream.optional;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class PhoneBookCrawler {

    private PhoneBook phoneBook;

    public PhoneBookCrawler(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public static void main(String[] args) {
        PhoneBookCrawler p = new PhoneBookCrawler(new PhoneBook());
        System.out.println(p.findPhoneNumberByNameOrNameByPhoneNumber("Raf de Giraf", "016/161619"));
    }

    public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
        return phoneBook.findPhoneNumberByName(name)
                .orElseThrow(() -> new IllegalArgumentException("No phone number found"));
    }

    public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
        final StringBuilder result = new StringBuilder();
        phoneBook.findPhoneNumberByName(name)
                .ifPresentOrElse(result::append, //Java11
                () -> System.out.println(phoneBook.getPhoneBookEntries()));

        return result.toString();
    }

    public String findPhoneNumberByNameOrNameByPhoneNumber(String name, String phoneNumber) {
        Optional<String> phoneNumberOptional = phoneBook.findPhoneNumberByName(name);
        Optional<String> nameOptional = phoneBook.findNameByPhoneNumber(phoneNumber);

        if(phoneNumberOptional.isPresent()) {
            return phoneNumberOptional.get();
        } else if(nameOptional.isPresent()) {
            return nameOptional.get();
        }
        //return new ArrayList<>(phoneBook.getPhoneBookEntries().values()).get(0);

        return phoneBook.findPhoneNumberByName(name)
                .orElse(phoneBook.findNameByPhoneNumber(phoneNumber)
                        .orElse(phoneBook.findPhoneNumberByName("Jos de Vos")
                                .orElse(null)
                        )
                );

    }

    public PhoneBook getPhoneBook(){
        return phoneBook;
    }

}
