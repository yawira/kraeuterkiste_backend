package aw.krauterkiste.camera.controller;

import aw.krauterkiste.camera.repository.PicturesRepository;
import aw.krauterkiste.camera.model.PicturesResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;


@RestController
public class CameraController {

    @Value("${raspi.url}")
    private String raspiUrl;

    private final PicturesRepository picturesRepository;

    @Autowired
    public CameraController(PicturesRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping(value = "/readImage")
    @ResponseBody()
    public PicturesResponseBody readImage() throws IOException {

        PicturesResponseBody picturesResponseBody = new PicturesResponseBody();

        RestTemplate restTemplate = new RestTemplate();
        String fileResponse = restTemplate.getForObject(raspiUrl + "/upload", String.class);

        picturesResponseBody.setEncodedImage(fileResponse);

        return picturesResponseBody;
    }
}

