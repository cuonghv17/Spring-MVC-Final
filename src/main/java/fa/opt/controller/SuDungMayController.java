package fa.opt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.opt.entities.KhachHang;
import fa.opt.entities.May;
import fa.opt.entities.SuDungMay;
import fa.opt.page.PageAble;
import fa.opt.service.KhachHangService;
import fa.opt.service.MayService;
import fa.opt.service.SuDungMayService;


@Controller
@RequestMapping("/sudungmay")
public class SuDungMayController {
	@Autowired
	private SuDungMayService suDungMayServiceImpl;

	@Autowired
	private KhachHangService khachHangServiceImpl;

	@Autowired
	private MayService mayServiceImpl;


	
	
	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<SuDungMay> suDungMayS = suDungMayServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("suDungMayS", suDungMayS);
		model.addAttribute("totalPages", suDungMayServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/sudungmay/list";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("sudungmayForm", new SuDungMay());
		return "/sudungmay/new";
	}

	@PostMapping("/save")
	public String addNewSuDungMay(@ModelAttribute(name = "sudungmayForm") @Valid SuDungMay suDungMay,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/sudungmay/new";
		}
		suDungMayServiceImpl.saveOrUpdate(suDungMay);
		return "redirect:/sudungmay/list";
	}
	@ModelAttribute("khachHangs")
	public List<KhachHang> initKhachHangs() {
		return khachHangServiceImpl.findAll();
	}
	
	@ModelAttribute("mays")
	public List<May> initMays() {
		return mayServiceImpl.findAll();
	}


	
	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<SuDungMay> suDungMays = suDungMayServiceImpl.search(searchKey);
		model.addAttribute("suDungMays", suDungMays);
		model.addAttribute("searchKey", searchKey);

		return "/sudungdichvu/list";
	}

	


	
	
}
