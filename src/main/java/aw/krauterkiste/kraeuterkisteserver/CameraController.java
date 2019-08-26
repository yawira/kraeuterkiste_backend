package aw.krauterkiste.kraeuterkisteserver;

import aw.krauterkiste.kraeuterkisteserver.repositories.PicturesRepository;
import aw.krauterkiste.kraeuterkisteserver.responsebodies.PicturesResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;


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


   /* // this method takes the file that was given as a payload by the Client and stores it at a chosen place
    @CrossOrigin(origins = "http://localhost:2020", allowCredentials = "true")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file") String file) throws IOException {
        // path where the picture should be saved
        File convertFile = new File("C:\\Users\\kozyr\\Desktop");
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File is uploaded succressfully aufm Desktop", HttpStatus.OK);
    }
*/

        /*@GetMapping
        public String getImageFromRaspi () throws IOException {

        RestTemplate restTemplate = new RestTemplate();


        String fileResponse = restTemplate.getForObject("http://localhost:2020/upload",String.class);
        System.out.println(fileResponse);
        return fileResponse;
    }*/

        @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
        @GetMapping(value = "/readImage")
        @ResponseBody()
        public PicturesResponseBody readImage() throws IOException {

            PicturesResponseBody picturesResponseBody = new PicturesResponseBody();

            RestTemplate restTemplate = new RestTemplate();
            String fileResponse = restTemplate.getForObject("http://localhost:2020/upload",String.class);
            System.out.println(fileResponse);


            picturesResponseBody.setEncodedImage(fileResponse);
            System.out.println("Foto" + fileResponse);

            return picturesResponseBody;

    }
}

