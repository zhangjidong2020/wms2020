package ERP.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_staff")
public class Staff extends Model<Staff> {

    private static final long serialVersionUID = 1L;

    /**
     * 员工id
     */
    private String id;

    /**
     * 登录帐号
     */
    private String loginAccount;

    /**
     * 初始密码
     */
    private String password;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工编号
     */
    private String no;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 入职时间
     */

    private LocalDateTime entryTime;

    /**
     * 账号状态
     */
    private String accountStatus;

    /**
     * 员工成绩
     */
    private String grade;

    /**
     * 员工状态
     */
    private String status;

    /**
     * 职位id
     */
    @JsonProperty("pId")
    private String pId;

    /**
     * 企业id
     */
    @JsonProperty("cId")
    private String cId;

    /**
     * 所属部门id
     */
    @JsonProperty("dId")
    private String dId;

    /**
     * 公司员工数量
     */
    @TableField(exist = false)
    private int staffNumber;
    /**
     * 员工启用数
     */
    @TableField(exist = false)
    private int startNumber;

    private Company company;
    private Department department;
    private Post post;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}

