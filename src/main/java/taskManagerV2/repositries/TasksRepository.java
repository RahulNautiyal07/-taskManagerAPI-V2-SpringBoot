package taskManagerV2.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import taskManagerV2.entities.TaskEntity;
import java.util.List;
import java.util.Date;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity, Integer> {

    List<TaskEntity> findAllByCompleted(boolean completed);

    //Ideally this is business terminology(i.e. overdue)
    @Query("SELECT t FROM TASKS t WHERE t.completed =  false AND t.dueDate < CURRENT_DATE")
    List<TaskEntity> findAllOverdue();
   // TaskEntity findAllOverdue();// If query returning single tasks

    List<TaskEntity> findAllByCompletedAndDueDateBefore(boolean completed, Date dueDate);// Same like a above query this is a better approach

    @Query("SELECT t FROM tasks t WHERE t.title LIKE %?1 ?2 ?3%")// Arguments hanlde like this
    List<TaskEntity> findAllByTitle(String title,String title2, String title3);

    List<TaskEntity> findAllByTitleIsContainingIgnoreCase(String titleFragement);// above query you can run like this also
}
