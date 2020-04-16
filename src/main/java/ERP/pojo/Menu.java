package ERP.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Qujiahao
 * @since 2019-11-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    private String id;

    /**
     * 层级
     */
    private String menuPid;

    /**
     * 菜单名字
     */
    private String menuName;

    /**
     * 地址
     */
    private String menuUrl;

    /**
     * 权限
     */
    private String menuPermission;

    /**
     * 选中状态
     */
    @TableField(exist = false)
    private Boolean menuOpt;

    private List<Menu> list;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
