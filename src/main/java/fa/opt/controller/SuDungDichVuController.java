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

import fa.opt.entities.DichVu;
import fa.opt.entities.KhachHang;
import fa.opt.entities.SuDungDichVu;
import fa.opt.page.PageAble;
import fa.opt.service.DichVuService;
import fa.opt.service.KhachHangService;
import fa.opt.service.SuDungDichVuService;


@Controller
@RequestMapping("/sudungdichvu")
public class SuDungDichVuController {
	@Autowired
	private SuDungDichVuService suDungdichVuServiceImpl;
	
	@Autowired
	private KhachHangService khachHangServiceImpl;
	
	@Autowired
	private DichVuService dichVuServiceImpl;


	
	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<SuDungDichVu> suDungDichVus = suDungdichVuServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("suDungDichVus", suDungDichVus);
		model.addAttribute("totalPages", suDungdichVuServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/sudungdichvu/list";
	}
	
	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("sudungdichvuForm", new SuDungDichVu());
		return "/sudungdichvu/new";
	}

	@PostMapping("/save")
	public String addNewDichVu(@ModelAttribute(name = "sudungdichvuForm") @Valid SuDungDichVu suDungDichVu,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/sudungdichvu/new";
		}
		suDungdichVuServiceImpl.saveOrUpdate(suDungDichVu);
		return "redirect:/sudungdichvu/list";
	}
	
	@ModelAttribute("khachHangs")
	public List<KhachHang> initKhachHangs() {
		return khachHangServiceImpl.findAll();
	}
	
	@ModelAttribute("dichVus")
	public List<DichVu> initDichVus() {
		return dichVuServiceImpl.findAll();
	}

	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<SuDungDichVu> suDungDichVus = suDungdichVuServiceImpl.search(searchKey);
		model.addAttribute("suDungDichVus", suDungDichVus);
		
		model.addAttribute("searchKey", searchKey);

		return "/sudungdichvu/list";
	}


	


	
	
}
