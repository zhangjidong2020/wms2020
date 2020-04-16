package ERP.mapper;

import ERP.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Set;

public interface UserMapper extends BaseMapper<User> {

    //通过用户名查询用户
    @Select("SELECT * FROM s_user WHERE BINARY user_name = #{username}")
    User getUserByUsername(String userName);


    @Update("UPDATE s_user SET query_times = query_times + 1 WHERE id = #{id}")
    void update(String id);

    //根据用户名查询角色
    @Select("SELECT role_name FROM s_role r LEFT JOIN s_user_role ur ON r.id = ur.role_id LEFT JOIN s_user u ON u.id = ur.user_id WHERE u.user_name = #{userName}")
    Set<String> getRoleByUserName(String userName);

    //根据用户名查询所有权限
    @Select("SELECT m.menu_permission FROM s_user u LEFT JOIN s_user_role ur ON u.id=ur.user_id LEFT JOIN s_role r ON ur.role_id=r.id LEFT JOIN s_role_menu rm ON r.id=rm.role_id LEFT JOIN s_menu m ON rm.menu_id=m.id WHERE u.user_name=#{userName} AND m.menu_permission IS NOT NULL")
    Set<String> getMenusByUserName(String userName);

    //根据用户名查询所有权限
    @Select("SELECT menu_permission FROM s_menu WHERE menu_permission IS NOT NULL")
    Set<String> getAllMenusToManage();

}
