package server.models.items.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import server.models.RootTableSvc;
import server.models.items.Item;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
public final class ItemSvc extends RootTableSvc<Item, ItemRepo> {

  protected final ItemRepo itemRepo;

  public ItemSvc(ItemRepo itemRepo) {
    super(itemRepo);
    this.itemRepo = itemRepo;
  }
}