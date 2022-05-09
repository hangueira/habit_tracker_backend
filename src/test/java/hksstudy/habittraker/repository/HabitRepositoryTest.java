package hksstudy.habittraker.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class HabitRepositoryTest {

    @Autowired
    HabitRepository habitRepository;

    @Test
    public void 취미리스트_전체조회() {
        Habit habit = Habit.builder()
                .name("reading")
                .count(0)
                .build();

        Habit habit2 = Habit.builder()
                .name("coding")
                .count(1)
                .build();

        habitRepository.save(habit);
        habitRepository.save(habit2);

        List<Habit> habits = habitRepository.findAll();
        assertThat(habits.size()).isEqualTo(2);
    }
}