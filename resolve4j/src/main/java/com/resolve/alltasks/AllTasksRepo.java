package com.resolve.alltasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllTasksRepo extends JpaRepository<AllTasks, Long> {
}
