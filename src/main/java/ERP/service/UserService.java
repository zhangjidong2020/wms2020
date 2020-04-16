package ERP.service;

import ERP.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

public interface UserService extends IService<User> {

    User getUserByUsername(String username);

    //根据用户名查询角色
    Set<String> getRoleByUserName(String userName);
    void update(String id);


    //根据用户名查询所有权限
    Set<String> getMenusByUserName(String userName);

    //根据用户名查询所有权限
    Set<String> getAllMenusToManage();


}
