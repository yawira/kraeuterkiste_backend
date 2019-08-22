package aw.krauterkiste.kraeuterkisteserver;

import aw.krauterkiste.kraeuterkisteserver.repositories.PicturesRepository;
import aw.krauterkiste.kraeuterkisteserver.responsebodies.PicturesResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameraController {

    @Autowired
    private final PicturesRepository picturesRepository;

    public CameraController(PicturesRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }

    // object returned by the method should be marshalled directly to the HTTP response body

    @PostMapping(value = "/showPhoto")
    @ResponseBody
    public PicturesResponseBody showPicture() {

        PicturesResponseBody picturesResponseBody = new PicturesResponseBody();

        picturesResponseBody.setPicturesList(picturesRepository.findAll());

        return picturesResponseBody;
    }


}
