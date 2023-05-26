package com.projet_integre.taskflow.services;


import com.projet_integre.taskflow.entities.ImageData;
import com.projet_integre.taskflow.entities.Tache;
import com.projet_integre.taskflow.entities.Utilisateur;
import com.projet_integre.taskflow.repositories.ImageDataRepository;
import com.projet_integre.taskflow.utils.ImageUtil;
import jakarta.transaction.Transactional;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {

    @Autowired
    private ImageDataRepository imageDataRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Transactional
    public String uploadImage(MultipartFile file, Utilisateur user) throws IOException {

          Optional<ImageData> image= imageDataRepository.findByUtilisateur(user);
          if (image.isPresent()){
              imageDataRepository.delete(image.get());
          }



        ImageData imageData = new ImageData();
          Integer id= sequenceGeneratorService.generateSequence(Tache.SEQUENCE_NAME);
          imageData.setId(id);
        imageData.setUtilisateur(user);
        imageData.setImageData( new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        imageData.setName(file.getOriginalFilename());
        imageData.setType(file.getContentType());

        imageDataRepository.insert(imageData);



        return ("Image uploaded successfully: " );

    }

    @Transactional
    public ImageData getInfoByImageByUser(Utilisateur user) {
        Optional<ImageData> dbImage = imageDataRepository.findByUtilisateur(user);
        if (!dbImage.isPresent()){
            return null;
        }

        return ImageData.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(dbImage.get().getImageData()).build();

    }


    @Transactional
    public Binary getImage(Utilisateur user) {
        Optional<ImageData> dbImage = imageDataRepository.findByUtilisateur(user);
        Binary image = dbImage.get().getImageData();
        return image;
    }


}