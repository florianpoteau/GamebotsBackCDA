package co.simplon.gamebotsback.business.convert;

import co.simplon.gamebotsback.business.dto.TypeImageDTO;
import co.simplon.gamebotsback.persistance.entity.TypeImage;

import java.util.ArrayList;
import java.util.List;

public class TypeImageConvert {

    private static TypeImageConvert instance;

    private TypeImageConvert() {

    }

    public static TypeImageConvert getInstance() {
        if (instance == null)
            instance = new TypeImageConvert();
        return instance;
    }

    public TypeImageDTO convertEntityToDto(final TypeImage entity) {
        final TypeImageDTO dto = new TypeImageDTO();
        dto.setIdTypeImage(entity.getIdTypeImage());
        dto.setName(entity.getName());
        dto.setCreationDate(entity.getCreationDate());
        dto.setModificationDate(entity.getModificationDate());

        return dto;
    }

    public TypeImage convertDtoToEntity(final TypeImageDTO dto) {
        final TypeImage entity = new TypeImage();
        entity.setIdTypeImage(dto.getIdTypeImage());
        entity.setName(dto.getName());
        entity.setCreationDate(dto.getCreationDate());
        entity.setModificationDate(dto.getModificationDate());
        return entity;
    }

    public List<TypeImage> convertListDtotoListEntity(final List<TypeImageDTO> dtoList) {
        final List<TypeImage> entityList = new ArrayList<>();
        for (TypeImageDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }
        return entityList;
    }

    public List<TypeImageDTO> convertListEntitytoListDto(final List<TypeImage> entityList) {
        final List<TypeImageDTO> dtoList = new ArrayList<>();
        for (TypeImage entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }
        return dtoList;
    }
}
