/**
 * This class provides methods to convert between ImageDTO objects and Image entities.
 */
package co.simplon.gamebotsback.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.gamebotsback.business.dto.ImageDTO;
import co.simplon.gamebotsback.persistance.entity.Image;

public class ImageConvert {

    private static ImageConvert instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     */
    private ImageConvert() {
    }

    /**
     * Returns the singleton instance of ImageConvert.
     *
     * @return the singleton instance of ImageConvert
     */
    public static ImageConvert getInstance() {
        if (instance == null)
            instance = new ImageConvert();
        return instance;
    }

    /**
     * Converts an Image entity to an ImageDTO.
     *
     * @param entity the Image entity to convert
     * @return the converted ImageDTO
     */
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

    /**
     * Converts an ImageDTO to an Image entity.
     *
     * @param dto the ImageDTO to convert
     * @return the converted Image entity
     */
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

    /**
     * Converts a list of ImageDTO objects to a list of Image entities.
     *
     * @param dtoList the list of ImageDTO objects to convert
     * @return the list of converted Image entities
     */
    public List<Image> convertListDtoToListEntity(final List<ImageDTO> dtoList) {
        final List<Image> entityList = new ArrayList<>();
        for (ImageDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }

        return entityList;
    }

    /**
     * Converts a list of Image entities to a list of ImageDTO objects.
     *
     * @param entityList the list of Image entities to convert
     * @return the list of converted ImageDTO objects
     */
    public List<ImageDTO> convertListEntityToListDto(final List<Image> entityList) {
        final List<ImageDTO> dtoList = new ArrayList<>();
        for (Image entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }

        return dtoList;
    }

}