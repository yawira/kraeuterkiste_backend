package aw.krauterkiste.LED;

import org.springframework.stereotype.Service;

@Service
public class LEDService {
    public void toggle() {
        System.out.println("toggling Light");
    }
}
