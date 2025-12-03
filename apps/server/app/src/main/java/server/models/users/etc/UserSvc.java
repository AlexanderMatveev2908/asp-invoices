package server.models.users.etc;

import org.springframework.stereotype.Service;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import reactor.core.publisher.Mono;
import server.models.RootTableSvc;
import server.models.users.User;

@Service
@SuppressFBWarnings({ "EI2", "EI" })
public final class UserSvc extends RootTableSvc<User, UserRepo> {
  protected final UserRepo userRepo;

  public UserSvc(UserRepo userRepo) {
    super(userRepo);
    this.userRepo = userRepo;
  }

  public final Mono<User> byUsername(String arg) {
    return userRepo.byUsername(arg);
  }
}
