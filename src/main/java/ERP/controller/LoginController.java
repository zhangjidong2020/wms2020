package ERP.controller;

import ERP.mapper.UserMapper;
import ERP.pojo.Company;
import ERP.pojo.Menu;
import ERP.pojo.Role;
import ERP.pojo.User;
import ERP.service.CompanyService;
import ERP.service.MenuService;
import ERP.service.RoleService;
import ERP.utils.IpUtil;
import ERP.utils.ShiroUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {

//    @Resource
//    private IWareService wareService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private MenuService menuService;

//    @Autowired
//    private ICargoService cargoService;

    @Autowired
    private RoleService roleService;

//    @Resource
//    private IProductService productService;
//
//    @Resource
//    private IOrderService orderService;

    @Resource
    private CompanyService companyService;


    private Logger log = LoggerFactory.getLogger(LoginController.class);

    //从前端表单提交，在此接受用户名密码
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password, String code, Model model, HttpSession session, HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //比较表单提交的验证码和session里的验证码
            if (!code.equalsIgnoreCase((String) session.getAttribute("code"))) {
                model.addAttribute("msg", "验证码错误");
                return "system/login";
            }
            User user = userMapper.getUserByUsername(username);
            subject.login(token);


//            //是否登录
//            if (subject.isAuthenticated()) {
//                String ip = new IpUtil().getIpAddr(request);
//                session.setAttribute("ip", ip);
//                //获取home页面所需要显示的值
//                //1.获取仓库数
//                int wareCount = wareService.count(new QueryWrapper<Ware>().eq("company_id", user.getCompanyId()));
//                //2.获取本公司货位上的商品总数
//                int productAllCount = cargoService.count(new QueryWrapper<Cargo>().eq("company_id", user.getCompanyId()).eq("status", "有货"));
//                //3.获取本公司的商品数
//                int productCount = productService.count(new QueryWrapper<Product>().eq("company_id", user.getCompanyId()));
//                //4.获取本公司以下架商品
//                int subProCount = productService.count(new QueryWrapper<Product>().eq("p_status", "-1").eq("company_id", user.getCompanyId()));
//                //5.获取订单总数
//                int orderCount = orderService.count(new QueryWrapper<Order>().eq("supplier_id", user.getCompanyId()));
//                //6.获取为发货的数量
//                int unShippedCount = orderService.count(new QueryWrapper<Order>().eq("supplier_id", user.getCompanyId()).eq("order_status", "2"));
//                //7.获取已发货的数量
//                int ShippedCount = orderService.count(new QueryWrapper<Order>().eq("supplier_id", user.getCompanyId()).eq("order_status", "3"));
//                int[] arr = {wareCount, productAllCount, productCount, subProCount, orderCount, unShippedCount, ShippedCount};
//                session.setAttribute("home", arr);
//
//                return "redirect:/gogo";
//            }
        } catch (UnknownAccountException uae) {
            log.info(token.getPrincipal() + uae.getMessage());
            model.addAttribute("msg", uae.getMessage());
            return "system/login";
        } catch (IncorrectCredentialsException ice) {
            log.info(token.getPrincipal() + "密码不正确");
            model.addAttribute("msg", "密码不正确");
            return "system/login";
        } catch (LockedAccountException lae) {
            log.info(token.getPrincipal() + "用户被锁定了 ");
            model.addAttribute("msg", token.getPrincipal() + "用户被锁定了");
            return "system/login";
        } catch (AuthenticationException ae) {
            log.info(ae.getMessage());
            model.addAttribute("msg", token.getPrincipal() + "登录失败");
            return "system/login";
        }
        return "";
    }

    @RequestMapping("gogo")
    public String gogo(Model model) {
        User user = ShiroUtils.getUser();
        Subject subject = SecurityUtils.getSubject();
        //状态判断
        Company company = companyService.getOne(new QueryWrapper<Company>().eq("id", user.getCompanyId()));
        List<Role> roleStatusByUserId = roleService.getRoleStatusByUserId(user.getId());
        String status1 = "";
        for (Role role : roleStatusByUserId) {
            if (role != null) {
                status1 = role.getRoleStatus();
            }
        }
        if (user.getId().equals("1")) {

            List<Menu> menu = null;
            //获取一级菜单
            List<Menu> menuees = menuService.getMenues("0");
            for (Menu menu1 : menuees) {
                //获取二级、三级菜单
                List<Menu> menus = menuService.getMenuByPid(menu1.getMenuPid());

                //增加超级管理员仅有的菜单
                //第一个子菜单
                Menu menu3 = new Menu();
                List<Menu> list1 = new ArrayList<>();
                menu3.setId("kknkk");
                menu3.setMenuPid("3434ere");
                menu3.setMenuName("专属一");
                menu3.setMenuUrl("/account/wt_qiyeyonghu.html");
                menu3.setMenuPermission("corporateaccount");
                list1.add(menu3);
                //父级菜单
                Menu menu2 = new Menu();
                menu2.setId("3434ere");
                menu2.setMenuPid("0");
                menu2.setMenuName("平台管理");
                menu2.setMenuUrl("");
                menu2.setMenuPermission("");
                menu2.setList(list1);

                menus.add(menu2);
                menu = menus;
            }
            model.addAttribute("menus", menu);
            model.addAttribute("user", user);
            return "e_index";
        } else if ((subject.hasRole("管理员")) && (company.getCompanyStatus().equals("on")) && (user.getUserStatus().equals("1")) && ("1".equals(status1))) {
            List<Menu> menu = null;
            //获取一级菜单
            List<Menu> menuees = menuService.getMenues("0");
            for (Menu menu1 : menuees) {
                //获取二级、三级菜单
                List<Menu> menus = menuService.getMenuByUser(user.getId(), menu1.getMenuPid());
                menu = menus;
            }
            model.addAttribute("menus", menu);
            model.addAttribute("user", user);
            return "e_index";
        } else if ((company.getCompanyStatus().equals("on")) && (user.getUserStatus().equals("1")) && ("1".equals(status1))) {
            System.out.println(company.getCompanyStatus());
            System.out.println(user.getUserStatus());
            System.out.println(status1);
            List<Menu> menu = null;
            //获取一级菜单
            List<Menu> menuees = menuService.getMenues("0");
            for (Menu menu1 : menuees) {
                //获取二级、三级菜单
                List<Menu> menus = menuService.getMenuByUser(user.getId(), menu1.getMenuPid());
                menu = menus;
            }
            model.addAttribute("menus", menu);
            model.addAttribute("user", user);
            return "e_index";

        } else if ((company.getCompanyStatus().equals("on")) && (user.getUserStatus().equals("1")) && ("".equals(status1))) {
            List<Menu> menu = null;
            model.addAttribute("menus", menu);
            model.addAttribute("user", user);
            return "e_index";
        } else {
            if (!company.getCompanyStatus().equals("on")) {
                model.addAttribute("msg", "公司已禁用！");
                return "system/login";
            } else if (!user.getUserStatus().equals("1")) {
                model.addAttribute("msg", "用户已禁用！");
                return "system/login";
            } else if ("0".equals(status1)) {
                model.addAttribute("msg", "角色已禁用！");
                return "system/login";
            }
        }
        model.addAttribute("msg", "出了点小差，请重试！");
        return "system/login";
    }


    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "system/login";
    }

}
