package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        final Forum forum = new Forum();
        final LocalDate date = LocalDate.now();

        // Tworzy mapę i przypisuję do niej wyjściowy strumień obiektów klasy ForumUser
        Map<Integer, ForumUser> forumUserMap = forum.getForumUserList().stream()
                .filter(s -> s.getSex() == 'M')
                .filter(s -> Period.between(s.getBirthDate(),date).getYears() >= 20)
                .filter(s -> s.getPostsAmount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUniqueUserIdentifier, Forum->Forum));
        // Wyświetla obiekty mapy za pomocą innego strumienia
        forumUserMap.entrySet().stream()
                .map(entry -> "Unique User Identifier : " + entry.getKey() +" "+ entry.getValue())
                .forEach(System.out::println);
    }
}

