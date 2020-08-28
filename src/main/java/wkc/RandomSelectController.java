package wkc;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;
import java.io.IOException;

@Controller
public class RandomSelectController {

    @Inject
    UserSession userSession;

    @Get("/team")
    public HttpResponse<Team> getTeam() throws IOException {
        return HttpResponse.ok(userSession.getTeam());
    }

    @Get("/topic")
    public HttpResponse<Topic> getTopic() throws IOException {
        return HttpResponse.ok(userSession.getTopic());
    }

}
