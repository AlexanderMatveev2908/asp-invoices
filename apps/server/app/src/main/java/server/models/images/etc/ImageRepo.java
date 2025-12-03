package server.models.images.etc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;
import server.models.RootTableRepo;
import server.models.images.Image;

@Repository
public interface ImageRepo extends RootTableRepo<Image> {
  @Query("""
      INSERT INTO images (public_id, url, user_id)
      VALUES (:#{#image.publicId}, :#{#image.url}, :#{#image.userId})
      RETURNING *
      """)
  public Mono<Image> insert(Image image);
}
