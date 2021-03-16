package com.kodilla.testing.forum.statistics;

import java.util.Objects;

public class StatisticsCalculations {
    private int usersTotal;
    private int postsTotal;
    private int commentsTotal;
    private double averagePostPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;


    public void calculateAdvStatistics(Statistics statistics){
        this.postsTotal = statistics.postsCount();
        this.usersTotal = statistics.usersNames().size();
        this.commentsTotal = statistics.commentsCount();
        this.averagePostPerUser = (double) statistics.postsCount()/statistics.usersNames().size();
        this.averageCommentsPerPost = (double) statistics.commentsCount()/statistics.postsCount();
        this.averageCommentsPerUser = (double) statistics.commentsCount()/statistics.usersNames().size();
    }

    public String showStatistics(){
        return "Total amount of users : " + usersTotal +"\n"+
                "Total amount of comments : " + commentsTotal +"\n"+
                "Total amount of posts : " + postsTotal +"\n"+
                "Average posts per user : " + averagePostPerUser +"\n"+
                "Average comments per user : " + averageCommentsPerUser +"\n"+
                "Average comments per post : " + averageCommentsPerPost;
    }

    //Constructor,Getters,Setters,Equal & Hashcode


    public int getUsersTotal() {
        return usersTotal;
    }

    public int getPostsTotal() {
        return this.postsTotal;
    }

    public int getCommentsTotal() {
        return commentsTotal;
    }

    public double getAveragePostPerUser() {
        return averagePostPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    public void setUsersTotal(int usersTotal) {
        this.usersTotal = usersTotal;
    }

    public void setPostsTotal(int postsTotal) {
        this.postsTotal = postsTotal;
    }

    public void setCommentsTotal(int commentsTotal) {
        this.commentsTotal = commentsTotal;
    }

    public void setAveragePostPerUser(double averagePostPerUser) {
        this.averagePostPerUser = averagePostPerUser;
    }

    public void setAverageCommentsPerUser(double averageCommentsPerUser) {
        this.averageCommentsPerUser = averageCommentsPerUser;
    }

    public void setAverageCommentsPerPost(double averageCommentsPerPost) {
        this.averageCommentsPerPost = averageCommentsPerPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticsCalculations that = (StatisticsCalculations) o;
        return usersTotal == that.usersTotal && postsTotal == that.postsTotal && commentsTotal == that.commentsTotal && Double.compare(that.averagePostPerUser, averagePostPerUser) == 0 && Double.compare(that.averageCommentsPerUser, averageCommentsPerUser) == 0 && Double.compare(that.averageCommentsPerPost, averageCommentsPerPost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(usersTotal, postsTotal, commentsTotal, averagePostPerUser, averageCommentsPerUser, averageCommentsPerPost);
    }
}
