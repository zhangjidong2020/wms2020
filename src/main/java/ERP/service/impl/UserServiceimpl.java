package ERP.service.impl;

import ERP.mapper.UserMapper;
import ERP.pojo.User;
import ERP.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceimpl extends ServiceImpl<UserMapper,User> implements UserService{

    @Resource
    private UserMapper userMapper;


    @Override
    public User getUserByUsername(String userName) {
        return userMapper.getUserByUsername(userName);
    }

    @Override
    public void update(String id) {
        userMapper.update(id);
    }

    @Override
    public Set<String> getRoleByUserName(String userName) {
        return userMapper.getRoleByUserName(userName);
    }


    @Override
    public Set<String> getMenusByUserName(String userName) {
        return userMapper.getMenusByUserName(userName);
    }

    @Override
    public Set<String> getAllMenusToManage() {
        return userMapper.getAllMenusToManage();
    }
}
