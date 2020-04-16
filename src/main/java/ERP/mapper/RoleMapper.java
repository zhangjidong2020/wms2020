package ERP.mapper;

import ERP.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id判断角色状态
     *
     * @param id
     * @return
     */
    List<Role> getRoleStatusByUserId(String id);

    /**
     * 获取角色用户选中状态
     *
     * @return
     */
    @Select("SELECT user_id FROM s_user_role WHERE role_id=#{roleId}")
    List<String> getOpt(Integer roleId);

}
