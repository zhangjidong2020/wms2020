package ERP.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_post")
public class Post extends Model<Post> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 职位名称
     */
    private String name;

    /**
     * 所在部门id
     */
    @JsonProperty("dId")
    private String dId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
