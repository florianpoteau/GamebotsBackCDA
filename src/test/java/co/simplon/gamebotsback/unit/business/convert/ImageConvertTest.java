package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.ImageConvert;
import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.persistance.entity.Image;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit test for the ImageConvert class.
 */
class ImageConvertTest {

    private static final ImageConvert imageConvert = ImageConvert.getInstance();

    /**
     * Tests the conversion of an Image entity to an ImageDTO.
     */
    @Test
    void testConvertImageToImageDTO() {
        Image image = new Image();
        image.setIdImage(1);
        image.setName("Avatar-Apex-Pathfinder");
        image.setSource("./src/images");
        Date creationDate = new Date();
        image.setCreationDate(creationDate);
        image.setModificationDate(null);
        image.setGame(null);
        image.setTypeImage(null);

        ImageDTO imageDTO = imageConvert.convertEntityToDto(image);

        assertSame(1, imageDTO.getIdImage());
        assertSame("Avatar-Apex-Pathfinder", imageDTO.getName());
        assertSame("./src/images", imageDTO.getSource());
        assertSame(creationDate, imageDTO.getCreationDate());
        assertNull(imageDTO.getModificationDate());
        assertNull(imageDTO.getGame());
        assertNull(imageDTO.getTypeImage());
    }

    /**
     * Tests the conversion of an ImageDTO to an Image entity.
     */
    @Test
    void testConvertImageDTOToImage() {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setIdImage(1);
        imageDTO.setName("Avatar-Apex-Pathfinder");
        imageDTO.setSource("./src/images");
        Date creationDate = new Date();
        imageDTO.setCreationDate(creationDate);
        imageDTO.setModificationDate(null);
        imageDTO.setGame(null);
        imageDTO.setTypeImage(null);

        Image image = imageConvert.convertDtoToEntity(imageDTO);

        assertSame(1, image.getIdImage());
        assertSame("Avatar-Apex-Pathfinder", image.getName());
        assertSame("./src/images", image.getSource());
        assertSame(creationDate, image.getCreationDate());
        assertNull(image.getModificationDate());
        assertNull(image.getGame());
        assertNull(image.getTypeImage());
    }

    /**
     * Tests the conversion of a List Image entity to a List ImageDTO.
     */
    @Test
    void testConvertListImageToListImageDTO() {
        Image image = new Image();
        image.setIdImage(1);
        image.setName("Avatar-Apex-Pathfinder");
        image.setSource("./src/images/Avatar-Apex-Pathfinder");
        Date creationDate = new Date();
        image.setCreationDate(creationDate);
        image.setModificationDate(null);
        image.setGame(null);
        image.setTypeImage(null);

        Image image2 = new Image();
        image2.setIdImage(2);
        image2.setName("Avatar-Apex-Lifeline");
        image2.setSource("./src/images/Avatar-Apex-Lifeline");
        Date creationDate2 = new Date();
        image2.setCreationDate(creationDate2);
        image2.setModificationDate(null);
        image2.setGame(null);
        image2.setTypeImage(null);

        List<Image> imageList = List.of(image, image2);

        List<ImageDTO> imageDTOList = imageConvert.convertListEntityToListDto(imageList);

        assertSame(1, imageDTOList.get(0).getIdImage());
        assertSame(2, imageDTOList.get(1).getIdImage());
        assertSame("Avatar-Apex-Pathfinder", imageDTOList.get(0).getName());
        assertSame("Avatar-Apex-Lifeline", imageDTOList.get(1).getName());
        assertSame("./src/images/Avatar-Apex-Pathfinder", imageDTOList.get(0).getSource());
        assertSame("./src/images/Avatar-Apex-Lifeline", imageDTOList.get(1).getSource());
        assertSame(creationDate, imageDTOList.get(0).getCreationDate());
        assertSame(creationDate2, imageDTOList.get(1).getCreationDate());
        assertNull(imageDTOList.get(0).getModificationDate());
        assertNull(imageDTOList.get(1).getModificationDate());
        assertNull(imageDTOList.get(0).getGame());
        assertNull(imageDTOList.get(1).getGame());
        assertNull(imageDTOList.get(0).getTypeImage());
        assertNull(imageDTOList.get(1).getTypeImage());
    }

    /**
     * Tests the conversion of a List ImageDTO to a List Image entity.
     */
    @Test
    void testConvertListImageDTOToListImage() {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setIdImage(1);
        imageDTO.setName("Avatar-Apex-Pathfinder");
        imageDTO.setSource("./src/images/Avatar-Apex-Pathfinder");
        Date creationDate = new Date();
        imageDTO.setCreationDate(creationDate);
        imageDTO.setModificationDate(null);
        imageDTO.setGame(null);
        imageDTO.setTypeImage(null);

        ImageDTO imageDTO2 = new ImageDTO();
        imageDTO2.setIdImage(2);
        imageDTO2.setName("Avatar-Apex-Lifeline");
        imageDTO2.setSource("./src/images/Avatar-Apex-Lifeline");
        Date creationDate2 = new Date();
        imageDTO2.setCreationDate(creationDate2);
        imageDTO2.setModificationDate(null);
        imageDTO2.setGame(null);
        imageDTO2.setTypeImage(null);

        List<ImageDTO> imageDTOList = List.of(imageDTO, imageDTO2);

        List<Image> imageList = imageConvert.convertListDtoToListEntity(imageDTOList);

        assertSame(1, imageList.get(0).getIdImage());
        assertSame(2, imageList.get(1).getIdImage());
        assertSame("Avatar-Apex-Pathfinder", imageList.get(0).getName());
        assertSame("Avatar-Apex-Lifeline", imageList.get(1).getName());
        assertSame("./src/images/Avatar-Apex-Pathfinder", imageList.get(0).getSource());
        assertSame("./src/images/Avatar-Apex-Lifeline", imageList.get(1).getSource());
        assertSame(creationDate, imageList.get(0).getCreationDate());
        assertSame(creationDate2, imageList.get(1).getCreationDate());
        assertNull(imageList.get(0).getModificationDate());
        assertNull(imageList.get(1).getModificationDate());
        assertNull(imageList.get(0).getGame());
        assertNull(imageList.get(1).getGame());
        assertNull(imageList.get(0).getTypeImage());
        assertNull(imageList.get(1).getTypeImage());
    }
}
