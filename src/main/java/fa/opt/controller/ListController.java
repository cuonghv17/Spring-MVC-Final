package fa.opt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.opt.page.PageAble;
import fa.opt.service.ListService;


@Controller
@RequestMapping("/dangkysudung")
public class ListController {
	@Autowired
	private ListService listServiceImpl;

	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<Object[]> lists = listServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("lists", lists);
		
		model.addAttribute("totalPages", listServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);
		return "/dangkysudung/list";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<Object[]> results = listServiceImpl.search(searchKey);
		model.addAttribute("lists", results);
		model.addAttribute("searchKey", searchKey);

		return "/dangkysudung/list";
	}
	
}
