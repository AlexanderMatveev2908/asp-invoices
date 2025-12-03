package server.models.images.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import server.models.RootTableSvc;
import server.models.images.Image;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public final class ImageSvc extends RootTableSvc<Image> {
  private final ImageRepo imageRepo;

  public final ImageRepo withRepo() {
    return imageRepo;
  }

}