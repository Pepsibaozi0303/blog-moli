import com.blog.BlogApplication;
import com.blog.dao.UserDao;
import com.blog.pojo.User;
import com.blog.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:baozi
 * @Date:2020-12-16 21:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class BlogTest {
    @Autowired
    UserDao userDao;

    @Test
    public void test(){
        User user = userDao.login("admin", "123456");
        System.out.println(user);
    }
}
