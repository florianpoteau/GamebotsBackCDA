package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.TypeImageConvert;
import co.simplon.gamebotsback.business.dto.TypeImageDTO;
import co.simplon.gamebotsback.persistance.entity.TypeImage;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Unit test for the ImageConvert class.
 */
class TypeImageConvertTest {

    private static final TypeImageConvert typeImageConvert = TypeImageConvert.getInstance();

    /**
     * Tests the conversion of a TypeImage entity to a TypeImageDTO.
     */
    @Test
    void testConvertTypeImageToTypeImageDTO() {
        TypeImage typeImage = new TypeImage();
        typeImage.setIdTypeImage(1);
        typeImage.setName("Avatar");
        Date creationDate = new Date();
        typeImage.setCreationDate(creationDate);
        typeImage.setModificationDate(null);

        TypeImageDTO typeImageDTO = typeImageConvert.convertEntityToDto(typeImage);

        assertSame(1, typeImageDTO.getIdTypeImage());
        assertSame("Avatar", typeImageDTO.getName());
        assertSame(creationDate, typeImageDTO.getCreationDate());
        assertNull(typeImageDTO.getModificationDate());
    }

    /**
     * Tests the conversion of a TypeImageDTO to a TypeImage entity.
     */
    @Test
    void testConvertTypeImageDTOToTypeImage() {
        TypeImageDTO typeImageDTO = new TypeImageDTO();
        typeImageDTO.setIdTypeImage(1);
        typeImageDTO.setName("Avatar");
        Date creationDate = new Date();
        typeImageDTO.setCreationDate(creationDate);
        typeImageDTO.setModificationDate(null);

        TypeImage typeImage = typeImageConvert.convertDtoToEntity(typeImageDTO);

        assertSame(1, typeImage.getIdTypeImage());
        assertSame("Avatar", typeImage.getName());
        assertSame(creationDate, typeImage.getCreationDate());
        assertNull(typeImage.getModificationDate());
    }

    /**
     * Tests the conversion of a List TypeImage entity to a List TypeImageDTO.
     */
    @Test
    void testConvertListTypeImageToListTypeImageDTO() {
        TypeImage typeImage = new TypeImage();
        typeImage.setIdTypeImage(1);
        typeImage.setName("Avatar");
        Date creationDate = new Date();
        typeImage.setCreationDate(creationDate);
        typeImage.setModificationDate(null);

        TypeImage typeImage2 = new TypeImage();
        typeImage2.setIdTypeImage(2);
        typeImage2.setName("Logo");
        Date creationDate2 = new Date();
        typeImage2.setCreationDate(creationDate2);
        typeImage2.setModificationDate(null);

        List<TypeImage> typeImageList = List.of(typeImage, typeImage2);

        List<TypeImageDTO> typeImageDTOList = typeImageConvert.convertListEntityToListDto(typeImageList);

        assertSame(1, typeImageDTOList.get(0).getIdTypeImage());
        assertSame(2, typeImageDTOList.get(1).getIdTypeImage());
        assertSame("Avatar", typeImageDTOList.get(0).getName());
        assertSame("Logo", typeImageDTOList.get(1).getName());
        assertSame(creationDate, typeImageDTOList.get(0).getCreationDate());
        assertSame(creationDate2, typeImageDTOList.get(1).getCreationDate());
        assertNull(typeImageDTOList.get(0).getModificationDate());
        assertNull(typeImageDTOList.get(1).getModificationDate());
    }

    /**
     * Tests the conversion of a List TypeImageDTO to a List TypeImage entity.
     */
    @Test
    void testConvertListTypeImageDTOToListTypeImage() {
        TypeImageDTO typeImageDTO = new TypeImageDTO();
        typeImageDTO.setIdTypeImage(1);
        typeImageDTO.setName("Avatar");
        Date creationDate = new Date();
        typeImageDTO.setCreationDate(creationDate);
        typeImageDTO.setModificationDate(null);

        TypeImageDTO typeImageDTO2 = new TypeImageDTO();
        typeImageDTO2.setIdTypeImage(2);
        typeImageDTO2.setName("Logo");
        Date creationDate2 = new Date();
        typeImageDTO2.setCreationDate(creationDate2);
        typeImageDTO2.setModificationDate(null);

        List<TypeImageDTO> typeImageDTOList = List.of(typeImageDTO, typeImageDTO2);

        List<TypeImage> typeImageList = typeImageConvert.convertListDtoToListEntity(typeImageDTOList);

        assertSame(1, typeImageList.get(0).getIdTypeImage());
        assertSame(2, typeImageList.get(1).getIdTypeImage());
        assertSame("Avatar", typeImageList.get(0).getName());
        assertSame("Logo", typeImageList.get(1).getName());
        assertSame(creationDate, typeImageList.get(0).getCreationDate());
        assertSame(creationDate2, typeImageList.get(1).getCreationDate());
        assertNull(typeImageList.get(0).getModificationDate());
        assertNull(typeImageList.get(1).getModificationDate());
    }
}
