package com.ssg.potato.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.ssg.potato.domain.AuctionThumb;
import com.ssg.potato.domain.GroupThumb;
import com.ssg.potato.domain.ItemThumb;
import com.ssg.potato.service.SearchService;

@Controller
@SessionAttributes({"category", "productList"})
public class SearchController {

	private SearchService service;

	@Autowired
	public void setSearchService(SearchService service) {
		this.service = service;
	}
	
	@RequestMapping("/search")
	public String handleRequest(
			@RequestParam("search") String title,
			@RequestParam("type") String type,
			ModelMap model
			) throws Exception {
		
		String go = null;
		
		if (type.equals("item")) { //직거래일 때

			PagedListHolder<ItemThumb> productList = new PagedListHolder<>(this.service.searchItemList(title));
			productList.setPageSize(3);
			model.put("category", "직거래");
			model.put("productList", productList);
			
			go = "searchItem";
		}
		else if (type.equals("group")) { //공동구매일 때
			PagedListHolder<GroupThumb> productList = new PagedListHolder<>(this.service.searchGroupList(title));
			productList.setPageSize(3);
			model.put("category", "공동 구매");
			model.put("productList", productList);
			
			go = "searchGroup";
		}
		else if (type.equals("auction")) { //경매일 때
			PagedListHolder<AuctionThumb> productList = new PagedListHolder<>(this.service.searchAuctionList(title));
			productList.setPageSize(3);
			model.put("category", "경매");
			model.put("productList", productList);
			
			go = "searchAuction";
		}
		
		return go;

		
		
	}
}
