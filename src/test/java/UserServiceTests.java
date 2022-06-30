import dev.corbett.Models.User;
import dev.corbett.Repos.UserDAO;
import dev.corbett.Services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @InjectMocks
    private static UserService mockUs;

    @Mock
    private static UserDAO mockUd;


    @Test
    public void should_loginUser(){
        //given
        User mock = new User(1, "beaulionettem9", "thaddeus", 1);
        //when
        when(mockUd.getUserByUsername("beaulionettem9")).thenReturn(mock);
        //then
        assertEquals(mock, mockUs.loginUser("beaulionettem9", "thaddeus"));
    }
    @Test
    public void should_notLoginUserBadUsername(){
        //given
        User mock = new User(1, "beaulionettem9", "thaddeus", 1);
        //when
        when(mockUd.getUserByUsername("yashanydoorinm9")).thenReturn(mock);
        //then
        assertNotEquals(mock, mockUs.loginUser("yashanydoorinm9", "stormlord"));
    }

    @Test
    public void should_notLoginUserBadPword(){
        //given
        User mock = new User(1, "beaulionettem9", "thaddeus", 1);
        //when
        when(mockUd.getUserByUsername("beaulionettem9")).thenReturn(mock);
        //then
        assertNotEquals(mock, mockUs.loginUser("beaulionettem9", "thad"));
    }
}
