package aw.krauterkiste.kraeuterkisteserver;

import aw.krauterkiste.kraeuterkisteserver.repositories.PicturesRepository;
import aw.krauterkiste.kraeuterkisteserver.responsebodies.PicturesResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class CameraController {

    @Autowired
    private final PicturesRepository picturesRepository;

    public CameraController(PicturesRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }

    // object returned by the method should be marshalled directly to the HTTP response body

//    @PostMapping(value = "/upload")
//    @ResponseBody
//    public PicturesResponseBody showPicture() {
//
//        PicturesResponseBody picturesResponseBody = new PicturesResponseBody();
//
//        picturesResponseBody.setPicturesList(picturesRepository.findAll());
//
//        return picturesResponseBody;
//    }


    // this method takes the file that was given as a payload by the Client and stores it at a chosen place
    @CrossOrigin(origins = "http://localhost:5555", allowCredentials = "true")
    @PostMapping(value="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        //                                            path where the picture should be saved
        File convertFile = new File("C:\\Users\\kozyr\\Desktop\\pictureR\\"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File is uploaded succressfully aufm Desktop", HttpStatus.OK);
    }
}



