package hksstudy.habittraker.service;

import hksstudy.habittraker.repository.Habit;
import hksstudy.habittraker.repository.HabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabitService {

    private final HabitRepository habitRepository;

    // 취미 저장
    public Habit insertHabit(Habit habit) {
        Habit saveHabit = habitRepository.save(habit);
        return saveHabit;
    }

    // 취미 전체 조회
    public List<Habit> getHabits() {
        return habitRepository.findAll();
    }

    // 취미 카운트 변경
    public Habit updateHabit(Long id, int count) {
        Habit findHabit = habitRepository.getById(id);
        findHabit.changeCount(count);
        Habit changeHabit = habitRepository.save(findHabit);
        return changeHabit;
    }

    // 취미 삭제
    public Long deleteHabit(Long id) {
        habitRepository.deleteById(id);
        return id;
    }

}
