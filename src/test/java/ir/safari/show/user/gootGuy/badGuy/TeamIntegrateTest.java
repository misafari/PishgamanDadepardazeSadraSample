package ir.safari.show.user.gootGuy.badGuy;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.safari.show.entity.Team;
import ir.safari.show.entity.dto.TeamRequest;
import ir.safari.show.repository.TeamRepository;
import ir.safari.show.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static ir.safari.show.controller.TeamController.ROOT_PATH;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamIntegrateTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TeamService teamService;

    @Test
    public void testPersist_goodGuy() throws Exception {
        TeamRequest team = new TeamRequest("team1", Arrays.asList(1L, 2L), 1L);

        mockMvc.perform(post(ROOT_PATH).content(objectMapper.writeValueAsString(team))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

        verify(teamService, times(1)).save(any(TeamRequest.class));
    }
}
