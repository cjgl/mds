package cn.fy.mds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.fy.mds.model.User;
import cn.fy.mds.service.UserService1;
import cn.fy.mds.service.UserService2;

@Controller
@RequestMapping("user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserService1 userService1;
	
	@Autowired
    private UserService2 userService2;

	
	@RequestMapping("/queryUserList1")
	@ResponseBody
	public Map<String, Object> queryUserList(User user, HttpServletRequest request, HttpServletResponse response) {
		PageHelper.startPage(0, 20);
		user.setDelflag("0");
		List<User> userList = this.userService1.queryUserList(user);
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", userList);
		map.put("total", pageInfo.getTotal());

		return map;
	}
	
	@RequestMapping("/queryUserList2")
	@ResponseBody
	public Map<String, Object> queryUserList2(User user, HttpServletRequest request, HttpServletResponse response) {
		PageHelper.startPage(0, 20);
		user.setDelflag("0");
		List<User> userList = this.userService2.queryUserList(user);
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", userList);
		map.put("total", pageInfo.getTotal());

		return map;
	}
	
	
}
