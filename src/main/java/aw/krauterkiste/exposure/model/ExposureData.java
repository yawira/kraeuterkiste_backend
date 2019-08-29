package aw.krauterkiste.exposure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExposureData {
    private LocalDateTime start;
    private LocalDateTime stop;
}
