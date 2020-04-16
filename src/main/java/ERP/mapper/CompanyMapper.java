package ERP.mapper;

import ERP.pojo.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

public interface CompanyMapper extends BaseMapper<Company> {

    //根据公司名查询公司是否已存在
    @Select("SELECT * FROM s_company WHERE company_name = #{companyName} ")
    Company getCompanyByCompanyName(String companyName);

}
