import dev.corbett.Models.Requests;
import dev.corbett.Repos.RequestsDAO;
import dev.corbett.Services.RequestsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RequestsServiceTests {
    @InjectMocks
    private static RequestsService mockRs;

    @Mock
    private static RequestsDAO mockRd;

    @Test
    public void should_createRequest(){
        //given
        Requests mock = new Requests(1, 1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1, 1, "none");
        //when
        when(mockRd.createRequest(1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1)).thenReturn(mock);
        //then
        assertEquals(mock, mockRs.createRequest(1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1));
    }

    @Test
    public void should_getAllRequests(){
        //given
        List<Requests> mock = new ArrayList<>();
        mock.add(new Requests(1, 1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1, 1, "none"));
        mock.add(new Requests(2, 2, "Yasha", "Nydoorin", "6/27/2022", "3:52 PM", 1, "Stormlord Self Confidence Class", 250, "Stormlord called me", 1, 1, "none"));
        //when
        when(mockRd.getAllRequests()).thenReturn(mock);
        //then
        assertEquals(mock, mockRs.getAllRequests());
    }

    @Test
    public void should_getAllRequestsByUserId(){
        //given
        List<Requests> mock = new ArrayList<>();
        mock.add(new Requests(1, 1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1, 1, "none"));
        mock.add(new Requests(2, 1, "Beauregard", "Lionett", "6/27/2022", "3:30 PM", 1,
                "Cobalt Soul Ghost-Punching Class 2", 300, "I need to punch ghosts, duh",
                1, 1, "none"));
        //when
        when(mockRd.getRequestsByUserId(1)).thenReturn(mock);
        //then
        assertEquals(mock, mockRd.getRequestsByUserId(1));
    }

    @Test
    public void should_getRequestById(){
        //given
        List<Requests> mock = new ArrayList<>();
        mock.add(new Requests(1, 1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1, 1, "none"));
        mock.add(new Requests(2, 1, "Beauregard", "Lionett", "6/27/2022", "3:30 PM", 1,
                "Cobalt Soul Ghost-Punching Class 2", 300, "I need to punch ghosts, duh",
                1, 1, "none"));
        //when
        when(mockRd.getRequestById(1, 1)).thenReturn(mock.get(0));
        //then
        assertEquals(mock.get(0), mockRs.getRequestById(1, 1));
    }

    @Test
    public void should_updateRequestGrade(){
        //given
        Requests mock = new Requests(1, 1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1, 1, "75");
        //when
        when(mockRd.updateRequestGrade(1, 1, "75")).thenReturn(mock);
        //then
        assertEquals(mock, mockRs.updateRequestGrade(1, 1, "75"));
    }

    @Test
    public void should_updateRequestStatus(){
        //given
        Requests mock = new Requests(1, 1, "Beauregard", "Lionett", "6/27/2022", "3:14 PM", 1,
                "Cobalt Soul Ghost-Punching Class", 300, "I need to punch ghosts, duh",
                1, 5, "75");
        //when
        when(mockRd.updateRequestStatus(1, 1, 5)).thenReturn(mock);
        //then
        assertEquals(mock, mockRs.updateRequestStatus(1, 1, 5));
    }
}
