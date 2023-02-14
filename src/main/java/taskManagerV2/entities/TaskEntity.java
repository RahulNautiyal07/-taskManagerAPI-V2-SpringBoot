package taskManagerV2.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "tasks")
@Setter
@Getter
//@Table(indexes = @Index(columnList = "title"))  //Putting index like this
public class TaskEntity extends BaseEntity{
    @Column(name = "title", nullable = false, length = 150)
    String title;
    @Column(name = "description", nullable = true,length = 500)
    String description;
    @Column(name = "completed", nullable = false, columnDefinition = "boolean default false")
    Boolean completed = false;
    @Column(name = "due_date")
    Date dueDate;
    @OneToMany(mappedBy = "task")
    List<NoteEntity> notes;

}
