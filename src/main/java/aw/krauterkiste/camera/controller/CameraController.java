package aw.krauterkiste.camera.controller;

import aw.krauterkiste.camera.repository.PictureRepository;
import aw.krauterkiste.camera.model.PictureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;


@RestController
public class CameraController {

    @Value("${raspi.url}")
    private String raspiUrl;

    private final PictureRepository pictureRepository;

    @Autowired
    public CameraController(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping(value = "/readImage")
    @ResponseBody()
    public PictureDto readImage() throws IOException {

        PictureDto pictureDto = new PictureDto();

        RestTemplate restTemplate = new RestTemplate();
        String fileResponse = restTemplate.getForObject(raspiUrl + "/upload", String.class);

        pictureDto.setEncodedImage(fileResponse);

        return pictureDto;
    }
}

