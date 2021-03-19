package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final  class Forum {
    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        forumUserList.add(new ForumUser(1,"Stanisław", 'M', LocalDate.of(1998, 5,23), 320));
        forumUserList.add(new ForumUser(2,"Madzia", 'F', LocalDate.of(2008, 9,30), 10));
        forumUserList.add(new ForumUser(3,"Krystyna", 'F', LocalDate.of(2000, 10,1), 0));
        forumUserList.add(new ForumUser(4,"Maciek", 'M', LocalDate.of(2015, 11,18), 231));
        forumUserList.add(new ForumUser(5,"Małgosia", 'F', LocalDate.of(1991, 3,26), 1));
        forumUserList.add(new ForumUser(6,"Piotr", 'M', LocalDate.of(1999, 5,10), 1));
        forumUserList.add(new ForumUser(7,"Weronika", 'F', LocalDate.of(2001, 8,23), 78));
        forumUserList.add(new ForumUser(8,"Rafał", 'M', LocalDate.of(1989, 1,4), 0));
        forumUserList.add(new ForumUser(9,"Mateusz", 'M', LocalDate.of(2000, 4,9), 65));
        forumUserList.add(new ForumUser(10,"Robert", 'M', LocalDate.of(1995, 12,15), 10));
        forumUserList.add(new ForumUser(11,"Hania", 'F', LocalDate.of(2009, 9,29), 369));
    }

    public List<ForumUser> getForumUserList() {
        return new ArrayList<>(forumUserList);
    }
}
