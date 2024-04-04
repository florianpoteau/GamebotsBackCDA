package co.simplon.gamebotsback.persistance.repository.image;

import co.simplon.gamebotsback.persistance.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Integer> {
}
