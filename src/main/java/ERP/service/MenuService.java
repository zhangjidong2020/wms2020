package ERP.service;

import ERP.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService extends IService<Menu> {


    /**
     * 根据父级id查询子级
     * 菜单
     *
     * @param pid
     * @return
     */
    List<Menu> getMenuByPid(String pid);

    /**
     * 用户-角色-菜单关联查询左侧菜单权限
     *
     * @param id
     * @return
     */
    List<Menu> getMenuByUser(String id, String pid);

    /**
     * 根据pid查询
     *
     * @param pid
     * @return
     */
    List<Menu> getMenues(@Param("pid") String pid);

}
