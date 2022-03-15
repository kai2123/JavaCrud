package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.demo.entity.InquiryForm;
import com.example.demo.entity.ItemEntity;
import com.example.demo.itemform.Itemform;
//import com.example.demo.models.ItemInquiryForm;
import com.example.demo.repositries.ItemRepository;


@Service
public class ItemService {
  
    @Autowired
    private ItemRepository itemRepository;
    
    
    public List<Itemform> searchAll(){
    	List<ItemEntity>itemlist = itemRepository.findAll();
    	List<Itemform> list = new ArrayList<Itemform>();
    	
    	
    	//拡張for文
//    	for (取り出す要素の変数宣言 : 配列あるいはjava.lang.Iterableのインスタンス) {
//    	繰り返し処理;}
    	 for(ItemEntity itemEntity : itemlist) {
    		 Itemform itemform = new Itemform();
    		 itemform.setId(itemEntity.getId());
    		 itemform.setName(itemEntity.getName());
    		 itemform.setPrice(itemEntity.getPrice());
    		 itemform.setContent(itemEntity.getContent());
    		 list.add(itemform);
    	  }
    	 
    	 return list;
    }

    
    public void create(Itemform itemform) {
       ItemEntity itemEntity = new ItemEntity();
       itemEntity.setName(itemform.getName());
       itemEntity.setPrice(itemform.getPrice());
       itemEntity.setContent(itemform.getContent());
       itemRepository.saveAndFlush(itemEntity);
    } 
    
    public void update(Itemform itemform,Long id) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity= itemRepository.findById(id).get();
        itemEntity.setName(itemform.getName());
        itemEntity.setPrice(itemform.getPrice());
        itemEntity.setContent(itemform.getContent());
        itemRepository.saveAndFlush(itemEntity);
     } 
    
    
    public Itemform inforead(Itemform itemform,Long id) {
    	ItemEntity itemEntity = new ItemEntity();
        itemEntity= itemRepository.findById(id).get();
		itemform.setName(itemEntity.getName());
		itemform.setPrice(itemEntity.getPrice());
		itemform.setContent(itemEntity.getContent());
		return itemform;
	}
    

   public void delete(Long id) {
	   itemRepository.deleteById(id);
   	}
   
}
