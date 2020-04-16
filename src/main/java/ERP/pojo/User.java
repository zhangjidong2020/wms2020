package ERP.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Data
//它默认仅使用该类中定义的属性且不调用父类的方法
@EqualsAndHashCode(callSuper = false)
//1. fluent 一个布尔值。如果为真，pepper的getter就是 pepper()，setter方法就是pepper(T newValue)。并且，除非特别说明，chain默认为真。
//2. chain 一个布尔值。如果为真，产生的setter返回的this而不是void。默认是假。如果fluent=true，那么chain默认为真。
@Accessors(chain = true)
@TableName("s_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;


    /**
     * 用户名 登录帐号
     */
    private String userName;


    /**
     * 用户密码
     */
    private String passWord;

    /**
     * 混淆数
     */
    private String salt;

    /**
     * 头像
     */
    private String userImage;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日年份
     */
    private String birYear;

    /**
     * 生日月份
     */
    private String birMonth;

    /**
     * 生日日期
     */
    private String birDay;

    /**
     * 个人邮箱
     */
    private String userEmail;

    /**
     * 联系方式
     */
    private String userTel;

    /**
     * 个人状态
     */
    private String userStatus;

    /**
     * 公司id 企业id
     */
    @JsonProperty("companyId")
    private String companyId;

    /**
     * 查询次数
     */
    private Integer queryTimes;


    /**
     * 员工编号
     */
    private String no;
    /**
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;


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

    @TableField(exist = false)
    private Company company;
    @TableField(exist = false)
    private Department department;
    @TableField(exist = false)
    private Post post;
    @TableField(exist = false)
    private Boolean userOpt;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
