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

import fa.opt.entities.KhachHang;
import fa.opt.page.PageAble;
import fa.opt.service.KhachHangService;


@Controller
@RequestMapping("/khachhang")
public class KhachHangController {
	@Autowired
	private KhachHangService khachHangServiceImpl;

	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<KhachHang> khachHangs = khachHangServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("khachHangs", khachHangs);
		model.addAttribute("totalPages", khachHangServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/khachhang/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("khachhangForm", new KhachHang());
		return "/khachhang/new";
	}

	@PostMapping("/save")
	public String addNewKhachHang(@ModelAttribute(name = "khachhangForm") @Valid KhachHang khachHang,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/khachhang/new";
		}
		khachHangServiceImpl.saveOrUpdate(khachHang);
		return "redirect:/khachhang/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "maKH") String maKH) {
		khachHangServiceImpl.delete(maKH);
		return "redirect:/khachhang/list";
	}

	@RequestMapping("/update/{maKH}")
	public String update(@PathVariable(name = "maKH") String maKH, Model model) {
		KhachHang khachHang = khachHangServiceImpl.findById(maKH);
		model.addAttribute("khachhangForm", khachHang);
		return "/khachhang/edit";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<KhachHang> khachHangs = khachHangServiceImpl.search(searchKey);
		model.addAttribute("khachHangs", khachHangs);
		model.addAttribute("searchKey", searchKey);

		return "/khachhang/list";
	}
}
