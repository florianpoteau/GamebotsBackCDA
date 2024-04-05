package co.simplon.gamebotsback.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.persistance.entity.Image;

public class ImageConvert {

    private static ImageConvert instance;

    private ImageConvert() {

    }

    public static ImageConvert getInstance() {
        if (instance == null)
            instance = new ImageConvert();
        return instance;
    }

    public ImageDTO convertEntityToDto(final Image entity) {
        final ImageDTO dto = new ImageDTO();
        dto.setIdImage(entity.getIdImage());
        dto.setName(entity.getName());
        dto.setSource(entity.getSource());
        dto.setTypeImage(entity.getTypeImage());
        dto.setGame(entity.getGame());
        dto.setCreationDate(entity.getCreationDate());
        dto.setModificationDate(entity.getModificationDate());

        return dto;
    }

    public Image convertDtoToEntity(final ImageDTO dto) {
        final Image entity = new Image();
        entity.setIdImage(dto.getIdImage());
        entity.setName(dto.getName());
        entity.setSource(dto.getSource());
        entity.setTypeImage(dto.getTypeImage());
        entity.setGame(dto.getGame());
        entity.setCreationDate(dto.getCreationDate());
        entity.setModificationDate(dto.getModificationDate());
        return entity;
    }

    public List<Image> convertListDtotoListEntity(final List<ImageDTO> dtoList) {
        final List<Image> entityList = new ArrayList<>();
        for (ImageDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }
        return entityList;
    }

    public List<ImageDTO> convertListEntitytoListDto(final List<Image> entityList) {
        final List<ImageDTO> dtoList = new ArrayList<>();
        for (Image entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }
        return dtoList;
    }

}
