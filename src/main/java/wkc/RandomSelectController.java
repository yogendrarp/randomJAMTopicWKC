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

    @Get("/next")
    public HttpResponse<TeamTopic> getNext() throws IOException {
        return HttpResponse.ok(userSession.getTeamTopic());
    }

}
