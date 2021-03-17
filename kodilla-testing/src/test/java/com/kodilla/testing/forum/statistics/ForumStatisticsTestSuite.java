package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    private static final List<String> users100 = new ArrayList<>();
    private final StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
    @Mock
    private Statistics statisticsMock;

    @BeforeAll
    static void init(){

        for(int i=0;i<100;i++){
            users100.add("name"+i);
        }
    }

    @Nested
    public class TestingPosts {
        @DisplayName("when no posts" +
                "then calculateAdvStatistics() should write 0 in postsTotal variable")
        @Test
        void calculateAdvStatisticsZeroPosts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postAmount = statisticsCalculations.getPostsTotal();
            double averagePostPerUser = statisticsCalculations.getAveragePostPerUser();
            double averageCommentsPerPost = statisticsCalculations.getAverageCommentsPerPost();
            double averageCommentsPerUser = statisticsCalculations.getAverageCommentsPerUser();
            //Then
            assertEquals(0, postAmount);
            assertEquals(0,averagePostPerUser);
            assertEquals(0,averageCommentsPerPost);
            assertEquals(0,averageCommentsPerUser);
        }
        @DisplayName("when 1000 posts " +
                "then calculateAdvStatistics() should write 1000 in postsTotal variable")
        @Test
        void calculateAdvStatistics1000Posts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(10);
            when(statisticsMock.usersNames()).thenReturn(users100);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postsTotal = statisticsCalculations.getPostsTotal();
            double averagePostPerUser = statisticsCalculations.getAveragePostPerUser();
            double averageCommentsPerPost = statisticsCalculations.getAverageCommentsPerPost();
            double averageCommentsPerUser = statisticsCalculations.getAverageCommentsPerUser();
            //Then
            assertEquals(1000, postsTotal);
            assertEquals(10,averagePostPerUser);
            assertEquals(0.01,averageCommentsPerPost);
            assertEquals(0.1,averageCommentsPerUser);
        }
    }
    @Nested
    public class TestingComments {
        @DisplayName("when 0 comments " +
                "then calculateAdvStatistics() should write 0 in commentsTotal variable")
        @Test
        void calculateAdvStatisticsZeroComments() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(10);
            when(statisticsMock.commentsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(users100);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int comentsTotal = statisticsCalculations.getCommentsTotal();
            double averagePostPerUser = statisticsCalculations.getAveragePostPerUser();
            double averageCommentsPerPost = statisticsCalculations.getAverageCommentsPerPost();
            double averageCommentsPerUser = statisticsCalculations.getAverageCommentsPerUser();
            //Then
            assertEquals(0, comentsTotal);
            assertEquals(0.1,averagePostPerUser);
            assertEquals(0,averageCommentsPerPost);
            assertEquals(0,averageCommentsPerUser);
        }
        @DisplayName("when less comments than posts " +
                "then calculateAdvStatistics() should write higher value in postsTotal than commentsTotal")
        @Test
        void calculateAdvStatisticsLessCommentsThanPosts() {
            //Given
            boolean result = false;
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.commentsCount()).thenReturn(99);
            when(statisticsMock.usersNames()).thenReturn(users100);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postsTotal = statisticsCalculations.getPostsTotal();
            int comentsTotal = statisticsCalculations.getCommentsTotal();
            if (comentsTotal < postsTotal) {
                result = true;
            }
            double averagePostPerUser = statisticsCalculations.getAveragePostPerUser();
            double averageCommentsPerPost = statisticsCalculations.getAverageCommentsPerPost();
            double averageCommentsPerUser = statisticsCalculations.getAverageCommentsPerUser();
            //Then
            assertTrue(result);
            assertEquals(1,averagePostPerUser);
            assertEquals(0.99,averageCommentsPerPost);
            assertEquals(0.99,averageCommentsPerUser);
        }
        @DisplayName("when more comments than posts " +
                "then calculateAdvStatistics() should write higher value in commentsTotal than postsTotal")
        @Test
        void calculateAdvStatisticsMoreCommentsThanPosts() {
            //Given
            boolean result = false;
            List<String> oneUser = new ArrayList<>();
            oneUser.add("Stasiek");
            when(statisticsMock.postsCount()).thenReturn(80);
            when(statisticsMock.commentsCount()).thenReturn(100);
            when(statisticsMock.usersNames()).thenReturn(oneUser);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postsTotal = statisticsCalculations.getPostsTotal();
            int comentsTotal = statisticsCalculations.getCommentsTotal();
            if (comentsTotal > postsTotal) {
                result = true;
            }
            double averagePostPerUser = statisticsCalculations.getAveragePostPerUser();
            double averageCommentsPerPost = statisticsCalculations.getAverageCommentsPerPost();
            double averageCommentsPerUser = statisticsCalculations.getAverageCommentsPerUser();
            //Then
            assertTrue(result);
            assertEquals(80,averagePostPerUser);
            assertEquals(1.25,averageCommentsPerPost);
            assertEquals(100,averageCommentsPerUser);
        }
    }

    @Nested
    public class TestingUsers {
        @DisplayName("when zero users " +
                "then calculateAdvStatistics() should write 0  in usersTotal")
        @Test
        void calculateAdvStatisticsZeroUsers() {
            //Given
            when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
            when(statisticsMock.postsCount()).thenReturn(80);
            when(statisticsMock.commentsCount()).thenReturn(100);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int usersTotal = statisticsCalculations.getUsersTotal();
            double averagePostPerUser = statisticsCalculations.getAveragePostPerUser();
            double averageCommentsPerPost = statisticsCalculations.getAverageCommentsPerPost();
            double averageCommentsPerUser = statisticsCalculations.getAverageCommentsPerUser();

            //Then
            assertEquals(0, usersTotal);
            assertEquals(0,averagePostPerUser);
            assertEquals(1.25,averageCommentsPerPost);
            assertEquals(0,averageCommentsPerUser);

        }
        @DisplayName("when 100 zero users " +
                "then calculateAdvStatistics() should write 100 in usersTotal")
        @Test
        void calculateAdvStatistics100Users() {
            //Given
            when(statisticsMock.usersNames()).thenReturn(users100);
            when(statisticsMock.postsCount()).thenReturn(37);
            when(statisticsMock.commentsCount()).thenReturn(359);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int usersTotal = statisticsCalculations.getUsersTotal();
            double averagePostPerUser = statisticsCalculations.getAveragePostPerUser();
            double averageCommentsPerPost = statisticsCalculations.getAverageCommentsPerPost();
            double averageCommentsPerUser = statisticsCalculations.getAverageCommentsPerUser();
            //Then
            assertEquals(100, usersTotal);
            assertEquals(0.37,averagePostPerUser);
            assertEquals(9.702702702702703,averageCommentsPerPost);
            assertEquals(3.59,averageCommentsPerUser);
        }
    }
    @Nested
    public class TestingShowStatistic {
        @DisplayName("when create statisticsCalculations with given parameters " +
                "then showStatistics() should show exactly the same parameters ")
        @Test
        void testShowStatistic() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.commentsCount()).thenReturn(1100);
            when(statisticsMock.usersNames()).thenReturn(users100);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            String result = statisticsCalculations.showStatistics();
            String compare = "Total amount of users : " + 100 + "\n" +
                    "Total amount of comments : " + 1100 + "\n" +
                    "Total amount of posts : " + 1000 + "\n" +
                    "Average posts per user : " + 10.0 + "\n" +
                    "Average comments per user : " + 11.0 + "\n" +
                    "Average comments per post : " + 1.1;
            //Then
            assertEquals(compare, result);
        }
    }
}
