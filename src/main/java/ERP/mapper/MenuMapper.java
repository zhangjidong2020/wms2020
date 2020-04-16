package ERP.mapper;

import ERP.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

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
    @Select("SELECT * FROM s_menu WHERE menu_pid=#{pid}")
    List<Menu> getMenues(@Param("pid") String pid);

}
