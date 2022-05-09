package hksstudy.habittraker.service;

import hksstudy.habittraker.repository.Habit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class HabitServiceTest {

    @Autowired
    HabitService habitService;

    @Test
    void 전체_취미_조회() {
        // given
        Habit habit1 = Habit.builder()
                .name("coding")
                .count(0)
                .build();
        Habit habit2 = Habit.builder()
                .name("running")
                .count(0)
                .build();

        habitService.insertHabit(habit1);
        habitService.insertHabit(habit2);

        // when
        List<Habit> habits = habitService.getHabits();

        // then
        assertThat(habits.size()).isEqualTo(2);
        assertThat(habits).contains(habit1, habit2);
    }

    @Test
    void 취미_저장() {
        // given
        Habit habit1 = Habit.builder()
                .name("coding")
                .count(0)
                .build();

        // when
        Habit habit = habitService.insertHabit(habit1);

        // then
        assertThat(habit).isEqualTo(habit);
    }

    @Test
    void 취미_카운트_변경() {
        // given
        Habit habit1 = Habit.builder()
                .name("coding")
                .count(0)
                .build();

        Habit habit = habitService.insertHabit(habit1);

        // when
        habit.changeCount(1);
        Habit changeHabit = habitService.insertHabit(habit);

        // then
        assertThat(changeHabit.getCount()).isEqualTo(1);
        assertThat(changeHabit.getName()).isEqualTo("coding");

    }

    @Test
    void 취미_삭제() {
        // given
        Habit habit1 = Habit.builder()
                .name("coding")
                .count(0)
                .build();

        Habit habit2 = Habit.builder()
                .name("running")
                .count(0)
                .build();

        habitService.insertHabit(habit1);
        habitService.insertHabit(habit2);

        // when
        habitService.deleteHabit(habit1.getId());
        List<Habit> habits = habitService.getHabits();

        // then
        assertThat(habits.size()).isEqualTo(1);

    }
}