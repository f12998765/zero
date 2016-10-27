import com.alibaba.fastjson.JSON;
import com.x.model.Bug;
import com.x.model.Task;
import com.x.model.User;
import com.x.service.BugService;
import com.x.service.LinkService;
import com.x.service.ProjectService;
import com.x.service.TaskService;
import com.x.util.Page;
import org.apache.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
    //  private ApplicationContext ac = null;

    //private TaskService taskService =null;
    //@Resource
    //private ProjectService projectService = null;
    //private BugService bugService =null;
    @Resource
    private LinkService linkService=null;
//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
        //Task t = taskService.getTaskById(4);
        //List<Project> projects = projectService.get();
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        //logger.info(JSON.toJSONString(t));
       /* List<User> users=linkService.getUserByJoinPro(1);
        for(User u : users){
            System.out.println(u.getUsername());
        }*/
/*       if(linkService.delLinkPro(1,1))
           System.out.println("ok");*/


    }
}
