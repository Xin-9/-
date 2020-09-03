package com.xin.admin.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xin.entity.Order;
import com.xin.order.service.OrderService;

import povos.OrderDescPovo;
import povos.OrderPovo;

@Controller
@RequestMapping("/order1")
public class AdminOrderController {

	@Autowired
	private OrderService orderService;
	

	@RequestMapping("/getOrder.action")
	public String getOrder(@PathVariable String status,Model model) {
		List<Order> orders = orderService.getOrderByStatus(status);
		model.addAttribute("orders", orders);
		return "adminjsps/admin/order/list";
	}
	
	
	
	
	
	@RequestMapping("/createOrder.action")
	@ResponseBody
	public ModelAndView createOrder(OrderPovo povo) {
		ModelAndView mav = new ModelAndView("jsps/order/ordersucc");
		// mav.setViewName("jsps/order/ordersucc");

		povo = orderService.createOrder(povo);
		mav.addObject("orderpovo", povo);
		return mav;
	}

	@RequestMapping("/changeStatus.action")
	@ResponseBody
	public ModelAndView changeStatus(Order order) {
		System.out.println(order.getStatus() + "---------------------");
		orderService.changeStatus(order);
		ModelAndView mav = new ModelAndView();
		// 视图转换器 规则 写法
		mav.setViewName("jsps/order/desc");

		List<OrderDescPovo> order_desc_povos = orderService.getOrderByOid(order.getOid());

		if (order_desc_povos != null && order_desc_povos.size() != 0) {

			order = order_desc_povos.get(0).getOrder();
			mav.addObject("order", order);
		}
		mav.addObject("orderdescpovos", order_desc_povos);

		return mav;
		// return "redirect:/order/getOrdersByUid/"+order.getUid()+".action";
	}

	@GetMapping("/getOrderByOid/{oid}.action")
	public String getOrderByOid(@PathVariable String oid, Model model) {

		List<OrderDescPovo> order_desc_povos = orderService.getOrderByOid(oid);
		model.addAttribute("orderdescpovos", order_desc_povos);
		if (order_desc_povos != null && order_desc_povos.size() != 0) {

			Order order = order_desc_povos.get(0).getOrder();
			model.addAttribute("order", order);
		}

		return "adminjsps/admin/order/list";
	}

	@RequestMapping("/getOrders.action")
	public String getOrders( Model model) {

		List<OrderPovo> orderpovos = orderService.getOrders();
		model.addAttribute("orderpovos", orderpovos);

		return "adminjsps/admin/order/list";
	}
	
	private void getUrl(Model model, HttpServletRequest request) throws Exception {
		
		String uri = request.getRequestURI();
		Map<String, String[]> map = request.getParameterMap();

		uri = uri + "?xxx=xxx";
		
		Set<String> set = map.keySet();
		List<String> keys = new ArrayList<String>(set);
		for (String param_name : keys) {
			String param_value = map.get(param_name)[0];

			System.out.println(param_value);

			// param_value = new String(param_value.getBytes("iso8859-1"),"utf-8");
			param_value = new String(param_value.getBytes("iso8859-1"), "utf-8");
			if (!param_name.equals("pageNum") && !param_name.equals("xxx")) {
				/// uri
				uri = uri + "&" + param_name + "=" + param_value;
			}
		}

		System.out.println(uri);

		model.addAttribute("url", uri);

	}

	@RequestMapping("/getOrdersByUid/{uid}.action")
	public String getOrdersByUid(@PathVariable String uid, Model model,
			@RequestParam(defaultValue = "1") Integer pageNum, HttpServletRequest request) throws Exception {
		getUrl(model, request);

		//
		PageHelper.startPage(pageNum, 2);
		List<OrderPovo> orderpovos = orderService.getOrdersByUid(uid);
		PageInfo<OrderPovo> info = new PageInfo<OrderPovo>(orderpovos);
		model.addAttribute("orderpovos", orderpovos);
		model.addAttribute("info", info);

		return "jsps/order/list";
	}


}
