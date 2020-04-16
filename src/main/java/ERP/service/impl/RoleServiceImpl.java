package ERP.service.impl;

import ERP.mapper.RoleMapper;
import ERP.pojo.Role;
import ERP.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;


    @Override
    public List<Role> getRoleStatusByUserId(String id) {
        return roleMapper.getRoleStatusByUserId(id);
    }

    @Override
    public List<String> getOpt(Integer roleId) {
        return roleMapper.getOpt(roleId);
    }

}
