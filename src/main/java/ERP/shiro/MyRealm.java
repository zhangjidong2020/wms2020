package ERP.shiro;

import ERP.pojo.User;
import ERP.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始授权认证...");


        User user = (User) principalCollection.getPrimaryPrincipal();

        //得到用户角色
        Set<String> role = userService.getRoleByUserName(user.getUserName());
        Set<String> menus = null;
        if (user.getId().equals("1")) {
            menus = userService.getAllMenusToManage();
            menus.add("corporateaccount");
        } else {
            menus = userService.getMenusByUserName(user.getUserName());
        }
        System.out.println(menus);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(role);
        info.setStringPermissions(menus);
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始登录认证...");

        //从登录的token中获取用户名
        String userName = (String) authenticationToken.getPrincipal();

        User user = userService.getUserByUsername(userName);

        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }

        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassWord(), credentialsSalt, getName());
        return simpleAuthenticationInfo;
    }

}
