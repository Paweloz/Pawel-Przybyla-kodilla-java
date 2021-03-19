package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int uniqueUserIdentifier;
    private final String userName;
    private final char sex;
    private final LocalDate birthDate;
    private final int postsAmount;

    public ForumUser(final int uniqueUserIdentifier, final String userName, final char sex, final LocalDate birthDate, final int postsAmount) {
        this.uniqueUserIdentifier = uniqueUserIdentifier;
        this.userName = userName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postsAmount = postsAmount;
    }

    public int getUniqueUserIdentifier() {
        return uniqueUserIdentifier;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostsAmount() {
        return postsAmount;
    }

    @Override
    public String toString() {
        return  ", UserName: '" + userName + '\'' +
                ", Sex: " + sex +
                ", BirthDate: " + birthDate +
                ", Posts amount: " + postsAmount;
    }
}
