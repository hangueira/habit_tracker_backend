package hksstudy.habittraker.repository;

import hksstudy.habittraker.repository.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {

}
