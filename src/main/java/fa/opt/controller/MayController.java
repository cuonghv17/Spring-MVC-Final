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

import fa.opt.entities.May;
import fa.opt.page.PageAble;
import fa.opt.service.MayService;


@Controller
@RequestMapping("/may")
public class MayController {
	@Autowired
	private MayService mayServiceImpl;

	@GetMapping("/list")
	public String getAllCategoryWithPageAble(Model model, @RequestParam(defaultValue = "1") Integer page) {
		PageAble pageAble = new PageAble(page);
		List<May> mays = mayServiceImpl.findWithPageAble(pageAble);
		model.addAttribute("mays", mays);
		model.addAttribute("totalPages", mayServiceImpl.totalPages(pageAble));
		model.addAttribute("currentPage", page);

		return "/may/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("mayForm", new May());
		return "/may/new";
	}

	@PostMapping("/save")
	public String addNewMay(@ModelAttribute(name = "mayForm") @Valid May may,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/may/new";
		}
		mayServiceImpl.saveOrUpdate(may);
		return "redirect:/may/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam(name = "maMay") String maMay) {
		mayServiceImpl.delete(maMay);
		return "redirect:/may/list";
	}

	@RequestMapping("/update/{maMay}")
	public String update(@PathVariable(name = "maMay") String maMay, Model model) {
		May may = mayServiceImpl.findById(maMay);
		model.addAttribute("mayForm", may);
		return "/may/edit";
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam(name = "searchKey") String searchKey, Model model) {
		System.out.println("Search method " + searchKey);
		List<May> mays = mayServiceImpl.search(searchKey);
		model.addAttribute("mays", mays);
		model.addAttribute("searchKey", searchKey);

		return "/may/list";
	}
}
