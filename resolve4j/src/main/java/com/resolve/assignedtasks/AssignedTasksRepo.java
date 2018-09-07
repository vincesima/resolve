package com.resolve.assignedtasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignedTasksRepo extends JpaRepository<AssignedTasks, Long> {
    Optional<AssignedTasks> findById(Long id);
}
