package fa.opt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.opt.entities.DichVu;
import fa.opt.page.PageAble;
import fa.opt.service.DichVuService;


@Controller
@RequestMapping("/dichvu")
public class DichVuController {
	@Autowired
	private DichVuService dichVuServiceImpl;

	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<DichVu> dichVus = dichVuServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("dichVus", dichVus);
		model.addAttribute("totalPages", dichVuServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/dichvu/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("dichVuForm", new DichVu());
		return "/dichvu/new";
	}

	@PostMapping("/save")
	public String addNewDichVu(@ModelAttribute(name = "dichVuForm") @Valid DichVu dichVu,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/dichvu/new";
		}
		dichVuServiceImpl.saveOrUpdate(dichVu);
		return "redirect:/dichvu/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "maDV") String maDV) {
		dichVuServiceImpl.delete(maDV);
		return "redirect:/dichvu/list";
	}

	@RequestMapping("/update/{maDV}")
	public String update(@PathVariable(name = "maDV") String maDV, Model model) {
		DichVu dichVu = dichVuServiceImpl.findById(maDV);
		model.addAttribute("dichVuForm", dichVu);
		return "/dichvu/edit";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<DichVu> dichVus = dichVuServiceImpl.search(searchKey);
		model.addAttribute("dichVus", dichVus);
		model.addAttribute("searchKey", searchKey);

		return "/dichvu/list";
	}
}
