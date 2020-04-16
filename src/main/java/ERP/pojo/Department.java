package ERP.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_department")
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 父级菜单
     */
    private String pid;

    /**
     * 部门编号
     */
    private String no;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门经理
     */
    private String manager;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 固定电话
     */
    private String tel;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 部门简介
     */
    private String intro;

    /**
     * 企业id
     */
    @JsonProperty("cId")
    private String cId;

    /**
     * 分部
     */
    @TableField(exist = false)
    private List<Department> departments;

    /**
     * 职位
     */
    @TableField(exist = false)
    private List<Post> posts;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
