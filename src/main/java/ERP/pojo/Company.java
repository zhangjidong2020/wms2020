package ERP.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("s_company")
public class Company extends Model<Company> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */

    private String id;


    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 法人
     */
    private String legal;

    /**
     * 固定电话
     */
    private String fixedTel;

    /**
     * 省份
     */
    private String companyProvince;

    /**
     * 市
     */
    private String companyCity;

    /**
     * 区
     */
    private String companyArea;

    /**
     * 详细地址
     */
    private String companyAddress;

    /**
     * 公司邮箱
     */
    private String companyEmail;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 公司品牌
     */
    private String companyBrand;

    /**
     * 公司类型
     */
    private String companyType;

    /**
     * 公司规模
     */
    private String companyScale;

    /**
     * 经纬度
     */
    private String longitudeLatitude;

    /**
     * QQ
     */
    private String companyQq;

    /**
     * 微信
     */
    private String companyWechat;

    /**
     * 法人手机号
     */
    private String legalTel;

    /**
     * 注册时间
     */
    private String creatTime;

    /**
     * 公司状态
     */
    private String companyStatus;

    /**
     * 企业简介
     */
    private String companyIntroduction;

    /**
     * 企业图标
     */
    private String companyImage;

    @TableField(exist = false)
    private User user;

    @TableField(exist = false)
    private Staff staff;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
