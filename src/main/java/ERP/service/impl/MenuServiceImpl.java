package ERP.service.impl;

import ERP.mapper.MenuMapper;
import ERP.pojo.Menu;
import ERP.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuByPid(String pid) {
        return menuMapper.getMenuByPid(pid);
    }

    @Override
    public List<Menu> getMenuByUser(String id, String pid) {
        return menuMapper.getMenuByUser(id, pid);
    }

    @Override
    public List<Menu> getMenues(String pid) {
        return menuMapper.getMenues(pid);
    }

}
