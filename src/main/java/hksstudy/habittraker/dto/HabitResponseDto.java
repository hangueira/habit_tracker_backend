package hksstudy.habittraker.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class HabitResponseDto {
    private Long id;
    private String name;
    private int count;


    @Builder
    public HabitResponseDto(Long id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }
}
