//package com.sdm.auth.api.pcmanger;
//
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RestController
//@RequestMapping("/hello")
//public class HelloControllerDao {
//
//	@Resource
//	private DeErrorLogDao deErrorLogDao;
//
//	@RequestMapping("/dao")
//    public String helloworld(){
//    	DeErrorLog DeErrorLog =deErrorLogDao.findDeErrorLogByLoan("86481", "CYPL02");
//        System.err.println(DeErrorLog.getDeErrSeq());
//    	return "dao";
//    }
//
//    @RequestMapping(value = "/daoPage/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
//    public String daoPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
//	    System.err.println("pageNum:"+pageNum);//第几页
//	    System.err.println("pageSize:"+pageSize);//每页几条
//        PageHelper.startPage(pageNum, pageSize);//1,10 获取第1页，10条内容，默认查询总数count
//        List<DeErrorLog> list =deErrorLogDao.findAllDeErrorLogByLoan("CYPL02");
//        PageInfo<DeErrorLog> page = new PageInfo<DeErrorLog>(list);//PageInfo 包含分页信息
//        System.err.println(page);
//    	return "dao";
//    }
//}
//
