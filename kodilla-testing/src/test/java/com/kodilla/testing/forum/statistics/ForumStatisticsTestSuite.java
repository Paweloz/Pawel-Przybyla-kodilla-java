package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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

    @BeforeAll
    static void init(){
        for(int i=0;i<100;i++){
            users100.add("name"+i);
        }
    }

    @Mock
    private Statistics statisticsMock;

    @Nested
    public class TestingPosts {
        @DisplayName("when no posts" +
                "then calculateAdvStatistics() should write 0 in postsTotal variable")
        @Test
        void calculateAdvStatisticsZeroPosts() {
            //Given
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
            when(statisticsMock.postsCount()).thenReturn(0);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postAmount = statisticsCalculations.getPostsTotal();
            //Then
            assertEquals(0, postAmount);
        }
        @DisplayName("when 1000 posts " +
                "then calculateAdvStatistics() should write 1000 in postsTotal variable")
        @Test
        void calculateAdvStatistics1000Posts() {
            //Given
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
            when(statisticsMock.postsCount()).thenReturn(1000);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postsTotal = statisticsCalculations.getPostsTotal();
            //Then
            assertEquals(1000, postsTotal);
        }
    }
    @Nested
    public class TestingComments {
        @DisplayName("when 0 comments " +
                "then calculateAdvStatistics() should write 0 in commentsTotal variable")
        @Test
        void calculateAdvStatisticsZeroComments() {
            //Given
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
            when(statisticsMock.commentsCount()).thenReturn(0);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int comentsTotal = statisticsCalculations.getCommentsTotal();
            //Then
            assertEquals(0, comentsTotal);
        }
        @DisplayName("when less comments than posts " +
                "then calculateAdvStatistics() should write higher value in postsTotal than commentsTotal")
        @Test
        void calculateAdvStatisticsLessCommentsThanPosts() {
            //Given
            boolean result = false;
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
            when(statisticsMock.postsCount()).thenReturn(100);
            when(statisticsMock.commentsCount()).thenReturn(99);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postsTotal = statisticsCalculations.getPostsTotal();
            int comentsTotal = statisticsCalculations.getCommentsTotal();
            if (comentsTotal < postsTotal) {
                result = true;
            }
            //Then
            assertTrue(result);
        }
        @DisplayName("when more comments than posts " +
                "then calculateAdvStatistics() should write higher value in commentsTotal than postsTotal")
        @Test
        void calculateAdvStatisticsMoreCommentsThanPosts() {
            //Given
            boolean result = false;
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
            when(statisticsMock.postsCount()).thenReturn(99);
            when(statisticsMock.commentsCount()).thenReturn(100);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int postsTotal = statisticsCalculations.getPostsTotal();
            int comentsTotal = statisticsCalculations.getCommentsTotal();
            if (comentsTotal > postsTotal) {
                result = true;
            }
            //Then
            assertTrue(result);
        }
    }

    @Nested
    public class TestingUsers {
        @DisplayName("when zero users " +
                "then calculateAdvStatistics() should write 0  in usersTotal")
        @Test
        void calculateAdvStatisticsZeroUsers() {
            //Given
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
            when(statisticsMock.usersNames()).thenReturn(new ArrayList<>());
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int usersTotal = statisticsCalculations.getUsersTotal();
            //Then
            assertEquals(0, usersTotal);

        }
        @DisplayName("when 100 zero users " +
                "then calculateAdvStatistics() should write 100 in usersTotal")
        @Test
        void calculateAdvStatistics100Users() {
            //Given
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
            when(statisticsMock.usersNames()).thenReturn(users100);
            //When
            statisticsCalculations.calculateAdvStatistics(statisticsMock);
            int usersTotal = statisticsCalculations.getUsersTotal();
            //Then
            assertEquals(100, usersTotal);
        }
    }
    @Nested
    public class TestingShowStatistic {
        @DisplayName("when create statisticsCalculations with given parameters " +
                "then showStatistics() should show exactly the same parameters ")
        @Test
        void testShowStatistic() {
            //Given
            StatisticsCalculations statisticsCalculations = new StatisticsCalculations();
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
