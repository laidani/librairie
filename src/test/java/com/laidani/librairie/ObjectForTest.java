package com.laidani.librairie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectForTest {
    private Long id;
    private String name;
    private LocalDate birthDay;
}
