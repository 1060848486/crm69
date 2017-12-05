package com.heima.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.heima.dao.ItemsMapper;
import com.heima.pojo.Items;

@Service
public class ItemsService {
	@Resource
	ItemsMapper itemsMapper;
	public List<Items> findAllItems(){
		List<Items> list= itemsMapper.selectByExampleWithBLOBs(null);
		
		
		return list;
		
	}
	
	
	public Items findItemsById(Integer id){
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}
	public void updateitem(Items items) {
		itemsMapper.updateByPrimaryKeySelective(items);
	}

}
