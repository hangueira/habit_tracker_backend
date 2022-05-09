package hksstudy.habittraker.controller;

import hksstudy.habittraker.dto.HabitRequestDto;
import hksstudy.habittraker.dto.HabitResponseDto;
import hksstudy.habittraker.dto.HabitUpdateRequestDto;
import hksstudy.habittraker.repository.Habit;
import hksstudy.habittraker.service.HabitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/habit")
@RequiredArgsConstructor
public class HabitController {

    private final HabitService habitService;

    @GetMapping()
    public List<Habit> getHabits() {
        List<Habit> habits = habitService.getHabits();
        return habits;
    }

    @PostMapping()
    public HabitResponseDto saveHabit(@RequestBody HabitRequestDto habitRequestDto) {
        Habit habit = Habit.builder()
                .name(habitRequestDto.getName())
                .count(habitRequestDto.getCount())
                .build();

        Habit saveHabit = habitService.insertHabit(habit);
        HabitResponseDto habitResponseDto = HabitResponseDto.builder()
                .id(saveHabit.getId())
                .name(saveHabit.getName())
                .count(saveHabit.getCount())
                .build();

        return habitResponseDto;
    }

    @PutMapping("/{id}")
    public HabitResponseDto updateHabit(@PathVariable("id") Long id, @RequestBody HabitUpdateRequestDto habitUpdateRequestDto){
        log.info(String.valueOf(id));

        Habit habit = habitService.updateHabit(id, habitUpdateRequestDto.getCount());
        HabitResponseDto habitResponseDto = HabitResponseDto.builder()
                .id(habit.getId())
                .name(habit.getName())
                .count(habit.getCount())
                .build();

        return habitResponseDto;
    }

    @DeleteMapping("/{id}")
    public Long deleteHabit(@PathVariable("id") Long id) {
        return habitService.deleteHabit(id);
    }
}
