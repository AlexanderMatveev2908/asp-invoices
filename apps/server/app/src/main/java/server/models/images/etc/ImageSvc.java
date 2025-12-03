package server.models.images.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import server.models.RootTableSvc;
import server.models.images.Image;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
public final class ImageSvc extends RootTableSvc<Image, ImageRepo> {
  protected final ImageRepo imageRepo;

  public ImageSvc(ImageRepo imageRepo) {
    super(imageRepo);
    this.imageRepo = imageRepo;
  }
}