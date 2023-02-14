package taskManagerV2.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskManagerV2.entities.NoteEntity;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity, Integer> {
}
