package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.taskList.TaskList;
import com.kodilla.hibernate.taskList.dao.TaskListDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME ="IN PROGRESS";
    private static final String DESCRITPION ="TASK 1";


    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME,DESCRITPION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();
        List<TaskList> taskListList = taskListDao.findByListName(LISTNAME);
        Assertions.assertEquals(LISTNAME,taskListList.get(0).getListName());
        //CleanUp
        taskListDao.deleteById(id);
    }
}
