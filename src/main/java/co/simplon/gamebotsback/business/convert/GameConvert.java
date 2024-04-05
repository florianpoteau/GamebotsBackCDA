package co.simplon.gamebotsback.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.simplon.gamebotsback.business.dto.GameDTO;
import co.simplon.gamebotsback.persistance.entity.Game;

public class GameConvert {

    private static GameConvert instance;

    public static GameConvert getInstance() {
        if (instance == null)
            instance = new GameConvert();
        return instance;
    }

    public GameDTO convertEntityToDto(final Game entity) {
        final GameDTO dto = new GameDTO();
        dto.setIdGame(entity.getIdGame());
        dto.setTitle(entity.getTitle());
        dto.setStory(entity.getStory());
        dto.setNumberPlayers(entity.getNumberPlayers());
        dto.setOnline(entity.isOnline());
        dto.setPlatform(entity.getPlatform());
        dto.setReleaseDate(entity.getReleaseDate());
        dto.setStudio(entity.getStudio());
        dto.setCreationDate(entity.getCreationDate());
        dto.setModificationDate(entity.getModificationDate());

        return dto;
    }

    public Game convertDtoToEntity(final GameDTO dto) {
        final Game entity = new Game();
        entity.setIdGame(dto.getIdGame());
        entity.setTitle(dto.getTitle());
        entity.setStory(dto.getStory());
        entity.setNumberPlayers(dto.getNumberPlayers());
        entity.setOnline(dto.isOnline());
        entity.setPlatform(dto.getPlatform());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setStudio(dto.getStudio());
        entity.setCreationDate(dto.getCreationDate());
        entity.setModificationDate(dto.getModificationDate());
        return entity;
    }

    public List<Game> convertDtoListToEntityList(final List<GameDTO> dtoList) {
        final List<Game> entityList = new ArrayList<>();
        for (GameDTO dto : dtoList) {
            entityList.add(convertDtoToEntity(dto));
        }
        return entityList;
    }

    public List<GameDTO> convertEntityListToDtoList(final List<Game> entityList) {
        final List<GameDTO> dtoList = new ArrayList<>();
        for (Game entity : entityList) {
            dtoList.add(convertEntityToDto(entity));
        }
        return dtoList;
    }

}
