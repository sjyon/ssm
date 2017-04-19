package test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.jayon.ssm.pojo.PermissionDO;
import com.jayon.ssm.pojo.RoleDO;
import com.jayon.ssm.pojo.UserDO;
import com.jayon.ssm.realm.UserRealm;
import com.jayon.ssm.service.PermissionService;
import com.jayon.ssm.service.RoleService;
import com.jayon.ssm.service.UserService;

import java.util.Arrays;

import javax.sql.DataSource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/spring-config.xml", 
		"classpath:conf/spring-shiro.xml"})
@TransactionConfiguration(defaultRollback = true)
public class ShiroTest {

    @Autowired
    protected PermissionService permissionService;
    @Autowired
    protected RoleService roleService;
    @Autowired
    protected UserService userService;

    @Autowired
    private UserRealm userRealm;

    
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    private void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);    
    }


    protected String password = "123";

    protected PermissionDO p1;
    protected PermissionDO p2;
    protected PermissionDO p3;
    protected RoleDO r1;
    protected RoleDO r2;
    protected UserDO u1;
    protected UserDO u2;
    protected UserDO u3;
    protected UserDO u4;
    
    @Before
    public void setUp() {
    	jdbcTemplate.update("delete from sys_users_roles");
    	jdbcTemplate.update("delete from sys_roles_permissions");
        jdbcTemplate.update("delete from sys_users");
        jdbcTemplate.update("delete from sys_roles");
        jdbcTemplate.update("delete from sys_permissions");


        //1、新增权限
        p1 = new PermissionDO("user:create", "用户模块新增", Boolean.TRUE);
        p2 = new PermissionDO("user:update", "用户模块修改", Boolean.TRUE);
        p3 = new PermissionDO("menu:create", "菜单模块新增", Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2、新增角色
        r1 = new RoleDO("admin", "管理员", Boolean.TRUE);
        r2 = new RoleDO("user", "用户管理员", Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3、关联角色-权限
        roleService.correlationPermissions(r1.getId(), Arrays.asList(p1.getId()));
        roleService.correlationPermissions(r1.getId(), Arrays.asList(p2.getId()));
        roleService.correlationPermissions(r1.getId(), Arrays.asList(p3.getId()));

        roleService.correlationPermissions(r2.getId(), Arrays.asList(p1.getId()));
        roleService.correlationPermissions(r2.getId(), Arrays.asList(p2.getId()));

        //4、新增用户
        u1 = new UserDO("zhang", password);
        u2 = new UserDO("li", password);
        u3 = new UserDO("wu", password);
        u4 = new UserDO("wang", password);
        u4.setLocked(Boolean.TRUE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5、关联用户-角色
        userService.correlationRoles(u1.getId(), Arrays.asList(r1.getId()));

    }

    @Test
    public void test() {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(u1.getUserName(), password);
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());
        subject.checkRole("admin");
        subject.checkPermission("user:create");

        userService.changePassword(u1.getId(), password + "1");
        userRealm.clearCache(subject.getPrincipals());

        token = new UsernamePasswordToken(u1.getUserName(), password + "1");
        subject.login(token);
        Assert.assertTrue(subject.isAuthenticated());



    }

}
