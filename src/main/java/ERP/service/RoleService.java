package ERP.service;

import ERP.pojo.Role;
import ERP.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface RoleService extends IService<Role> {

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
    List<String> getOpt(Integer roleId);



}
