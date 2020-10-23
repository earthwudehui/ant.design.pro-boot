package com.sdm.auth.servlet;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

@WebServlet(urlPatterns = "/druid/*",
initParams={
//        @WebInitParam(name="allow",value="192.168.16.110,127.0.0.1"),// IP白名单 (没有配置或者为空，则允许所有访问)
//        @WebInitParam(name="deny",value="192.168.16.111"),// IP黑名单 (存在共同时，deny优先于allow)
        @WebInitParam(name="loginUsername",value="admin"),// 用户名
        @WebInitParam(name="loginPassword",value="admin"),// 密码
        @WebInitParam(name="resetEnable",value="true"),// 允许清空统计数据
        @WebInitParam(name="profileEnable",value="true")//配置profileEnable能够监控单个url调用的sql列表
})
public class DruidServlet extends StatViewServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 361916399123863635L;

}
