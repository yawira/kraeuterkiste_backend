package aw.krauterkiste.camera.controller;

import aw.krauterkiste.camera.repository.PictureRepository;
import aw.krauterkiste.camera.model.PictureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/camera")
public class CameraController {

    private final RestTemplate raspiRestTemplate;
    private final PictureRepository pictureRepository;

    @Autowired
    public CameraController(PictureRepository pictureRepository,
                            RestTemplate raspiRestTemplate) {
        this.pictureRepository = pictureRepository;
        this.raspiRestTemplate = raspiRestTemplate;
    }

    @GetMapping("/photo")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public PictureDto takePhoto() {
        PictureDto pictureDto = new PictureDto();

        String encodedPhoto = raspiRestTemplate.getForObject("/camera/photo", String.class);

        pictureDto.setEncodedImage(encodedPhoto);

        return pictureDto;
    }
}

