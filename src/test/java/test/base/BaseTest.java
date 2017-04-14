package test.base;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring-mvc.xml",
	"classpath:conf/spring-context.xml","classpath:conf/spring-shiro-web.xml"})
public abstract class BaseTest <T>{
	
	public abstract void add();
	
	public abstract void delete();
	
	public abstract void update();
	
	public abstract void query();
	
}
