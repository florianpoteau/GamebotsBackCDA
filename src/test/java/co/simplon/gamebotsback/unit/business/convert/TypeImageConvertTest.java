package co.simplon.gamebotsback.unit.business.convert;

import co.simplon.gamebotsback.business.convert.TypeImageConvert;
import co.simplon.gamebotsback.business.dto.TypeImageDTO;
import co.simplon.gamebotsback.persistance.entity.TypeImage;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class TypeImageConvertTest {

    private static final TypeImageConvert typeImageConvert = TypeImageConvert.getInstance();
    private static final String name = "Avatar";

    private TypeImage createSampleTypeImage() {
        TypeImage typeImage = new TypeImage();
        typeImage.setIdTypeImage(1);
        typeImage.setName(name);
        typeImage.setCreationDate(new Date());
        typeImage.setModificationDate(new Date());
        return typeImage;
    }

    private TypeImage createSampleTypeImageWithNull() {
        TypeImage typeImage = new TypeImage();
        typeImage.setIdTypeImage(1);
        typeImage.setName(null);
        typeImage.setCreationDate(null);
        typeImage.setModificationDate(null);
        return typeImage;
    }

    private TypeImageDTO createSampleTypeImageDTO() {
        TypeImageDTO typeImageDTO = new TypeImageDTO();
        typeImageDTO.setIdTypeImage(1);
        typeImageDTO.setName(name);
        typeImageDTO.setCreationDate(new Date());
        typeImageDTO.setModificationDate(new Date());
        return typeImageDTO;
    }

    private TypeImageDTO createSampleTypeImageDTOWithNull() {
        TypeImageDTO typeImageDTO = new TypeImageDTO();
        typeImageDTO.setIdTypeImage(1);
        typeImageDTO.setName(null);
        typeImageDTO.setCreationDate(null);
        typeImageDTO.setModificationDate(null);
        return typeImageDTO;
    }

    @Test
    void testConvertTypeImageToTypeImageDTO() {

        TypeImage typeImage = createSampleTypeImage();
        TypeImageDTO typeImageDTO = typeImageConvert.convertEntityToDto(typeImage);

        assertSame(1, typeImageDTO.getIdTypeImage());
        assertSame(name, typeImageDTO.getName());
        assertSame(typeImage.getCreationDate(), typeImageDTO.getCreationDate());
        assertSame(typeImage.getModificationDate(), typeImageDTO.getModificationDate());
    }

    @Test
    void testConvertTypeImageToTypeImageDTOWithNull() {

        TypeImage typeImage = createSampleTypeImageWithNull();
        TypeImageDTO typeImageDTO = typeImageConvert.convertEntityToDto(typeImage);

        assertSame(1, typeImageDTO.getIdTypeImage());
        assertNull(typeImageDTO.getName());
        assertNull(typeImageDTO.getCreationDate());
        assertNull(typeImageDTO.getModificationDate());
    }

    @Test
    void testConvertTypeImageDTOToTypeImage() {

        TypeImageDTO typeImageDTO = createSampleTypeImageDTO();
        TypeImage typeImage = typeImageConvert.convertDtoToEntity(typeImageDTO);

        assertSame(1, typeImage.getIdTypeImage());
        assertSame(name, typeImage.getName());
        assertSame(typeImageDTO.getCreationDate(), typeImage.getCreationDate());
        assertSame(typeImageDTO.getModificationDate(), typeImage.getModificationDate());
    }

    @Test
    void testConvertTypeImageDTOToTypeImageWithNull() {

        TypeImageDTO typeImageDTO = createSampleTypeImageDTOWithNull();
        TypeImage typeImage = typeImageConvert.convertDtoToEntity(typeImageDTO);

        assertSame(1, typeImage.getIdTypeImage());
        assertNull(typeImage.getName());
        assertNull(typeImage.getCreationDate());
        assertNull(typeImage.getModificationDate());
    }

    @Test
    void testConvertListTypeImageToListTypeImageDTO() {

        List<TypeImage> typeImageList = List.of(createSampleTypeImage(), createSampleTypeImage());
        List<TypeImageDTO> typeImageDTOList = typeImageConvert.convertListEntityToListDto(typeImageList);

        assertSame(1, typeImageDTOList.get(0).getIdTypeImage());
        assertSame(1, typeImageDTOList.get(1).getIdTypeImage());
        assertSame(name, typeImageDTOList.get(0).getName());
        assertSame(name, typeImageDTOList.get(1).getName());
        assertSame(typeImageList.get(0).getCreationDate(), typeImageDTOList.get(0).getCreationDate());
        assertSame(typeImageList.get(1).getCreationDate(), typeImageDTOList.get(1).getCreationDate());
        assertSame(typeImageList.get(0).getModificationDate(), typeImageDTOList.get(0).getModificationDate());
        assertSame(typeImageList.get(1).getModificationDate(), typeImageDTOList.get(1).getModificationDate());
    }

    @Test
    void testConvertListTypeImageToListTypeImageDTOWithNull() {

        List<TypeImage> typeImageList = List.of(createSampleTypeImageWithNull(), createSampleTypeImageWithNull());
        List<TypeImageDTO> typeImageDTOList = typeImageConvert.convertListEntityToListDto(typeImageList);

        assertSame(1, typeImageDTOList.get(0).getIdTypeImage());
        assertSame(1, typeImageDTOList.get(1).getIdTypeImage());
        assertNull(typeImageDTOList.get(0).getName());
        assertNull(typeImageDTOList.get(1).getName());
        assertNull(typeImageDTOList.get(0).getCreationDate());
        assertNull(typeImageDTOList.get(1).getCreationDate());
        assertNull(typeImageDTOList.get(0).getModificationDate());
        assertNull(typeImageDTOList.get(1).getModificationDate());
    }

    @Test
    void testConvertListTypeImageDTOToListTypeImage() {

        List<TypeImageDTO> typeImageDTOList = List.of(createSampleTypeImageDTO(), createSampleTypeImageDTO());
        List<TypeImage> typeImageList = typeImageConvert.convertListDtoToListEntity(typeImageDTOList);

        assertSame(1, typeImageList.get(0).getIdTypeImage());
        assertSame(1, typeImageList.get(1).getIdTypeImage());
        assertSame(name, typeImageList.get(0).getName());
        assertSame(name, typeImageList.get(1).getName());
        assertSame(typeImageDTOList.get(0).getCreationDate(), typeImageList.get(0).getCreationDate());
        assertSame(typeImageDTOList.get(1).getCreationDate(), typeImageList.get(1).getCreationDate());
        assertSame(typeImageDTOList.get(0).getModificationDate(), typeImageList.get(0).getModificationDate());
        assertSame(typeImageDTOList.get(1).getModificationDate(), typeImageList.get(1).getModificationDate());
    }

    @Test
    void testConvertListTypeImageDTOToListTypeImageWithNull() {

        List<TypeImageDTO> typeImageDTOList = List.of(createSampleTypeImageDTOWithNull(), createSampleTypeImageDTOWithNull());
        List<TypeImage> typeImageList = typeImageConvert.convertListDtoToListEntity(typeImageDTOList);

        assertSame(1, typeImageList.get(0).getIdTypeImage());
        assertSame(1, typeImageList.get(1).getIdTypeImage());
        assertNull(typeImageList.get(0).getName());
        assertNull(typeImageList.get(1).getName());
        assertNull(typeImageList.get(0).getCreationDate());
        assertNull(typeImageList.get(1).getCreationDate());
        assertNull(typeImageList.get(0).getModificationDate());
        assertNull(typeImageList.get(1).getModificationDate());
    }
}
