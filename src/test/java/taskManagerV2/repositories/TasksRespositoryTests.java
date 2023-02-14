package taskManagerV2.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import taskManagerV2.entities.TaskEntity;
import taskManagerV2.repositries.TasksRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TasksRespositoryTests {
    @Autowired
    TasksRepository tasksRepository;

    @Test
    public void testCreateTask() {
        TaskEntity task = new TaskEntity();
        task.setTitle("Test Task");
        task.setDescription("Test Description");
        task.setCompleted(false);
//        task.setCreatedAT(new Data());
//        task.setUpdatedAt(new Date());
        var savedtask = tasksRepository.save(task);
        assertNotNull(savedtask);

    }

    @Test
    public void readTaskWorks(){
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task");
        task1.setDescription("Test Description");
        task1.setCompleted(false);

        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task 2");
        task2.setDescription("Test Description 2");
        task2.setCompleted(false);
        tasksRepository.save(task1);
        tasksRepository.save(task2);
        var tasks = tasksRepository.findAll();
        assertNotNull(tasks);
        assertEquals(2, tasks.size());
    }

    @Test
    public void findByCompletedWorks() {
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task");
        task1.setDescription("Test Description");
        task1.setCompleted(false);

        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task 2");
        task2.setDescription("Test Description 2");
        task2.setCompleted(true);
        tasksRepository.save(task1);
        tasksRepository.save(task2);
        var completedTasks = tasksRepository.findAllByCompleted(true);
        var inCompletedTasks = tasksRepository.findAllByCompleted(false);

        assertEquals(1, completedTasks.size());
        assertEquals(1, inCompletedTasks.size());
    }
}
