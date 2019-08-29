package aw.krauterkiste.exposure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExposureDto {
    private LocalDateTime dateTime;
    private boolean active;
}