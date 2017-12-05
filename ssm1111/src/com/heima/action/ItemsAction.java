package com.heima.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.heima.pojo.Items;
import com.heima.pojo.QueryVo;
import com.heima.service.ItemsService;

@Controller
@RequestMapping("/item")
public class ItemsAction {
	@Resource
	ItemsService itemsService;
	
	@RequestMapping("/list")
	public String list( HttpServletRequest requestm,Model model,QueryVo queryVo,Integer id,Items items){
		List<Items> list = itemsService.findAllItems();
//		request.setAttribute("itemList", list);
		model.addAttribute("itemList", list);
		System.out.println(requestm.getParameter("id"));
		return "itemList";
		
	}
	
	@RequestMapping("/itemEdit")
	public ModelAndView to_edit(Integer id){
		Items items = itemsService.findItemsById(id);
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.addObject("item",items);
		modelAndView.setViewName("editItem");
		return modelAndView;
		
	}
	@RequestMapping("/updateitem")
	public String updateitem(Items items) {
		itemsService.updateitem(items);
		return "redirect:www.baidu.com";
	}
	//git
	
}
