package server.models.items.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.RequiredArgsConstructor;
import server.models.RootTableSvc;
import server.models.items.Item;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
@RequiredArgsConstructor
public final class ItemSvc extends RootTableSvc<Item> {
  private final ItemRepo itemRepo;

  public final ItemRepo withRepo() {
    return itemRepo;
  }

}