package aw.krauterkiste.kraeuterkisteserver;

import java.util.Base64;
import aw.krauterkiste.kraeuterkisteserver.repositories.PicturesRepository;
import aw.krauterkiste.kraeuterkisteserver.responsebodies.PicturesResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;

@RestController
public class CameraController {

    @Autowired
    private final PicturesRepository picturesRepository;

    public CameraController(PicturesRepository picturesRepository) {
        this.picturesRepository = picturesRepository;
    }


    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping(value = "/readImage")
    @ResponseBody
    public String readImage() throws IOException {


        BufferedImage image = ImageIO.read(new File("C:\\Users\\kozyr\\Desktop\\pictureR\\cool.jpg"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        byte[] encodedImageBytes = Base64.getEncoder().encode(outputStream.toByteArray());
        String encodedImage = new String(encodedImageBytes);


        return encodedImage;

    }


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



