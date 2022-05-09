package hksstudy.habittraker.repository;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Habit {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int count;

    @Builder
    public Habit(String name, int count) {
        this.name = name;
        this.count = count;
    }

    // 카운트 변경
    public void changeCount(int count) {
        this.count = count;
    }
}
