package ksmart42.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ksmart42.mybatis.dto.Goods;
import ksmart42.mybatis.dto.Member;
import ksmart42.mybatis.mapper.GoodsMapper;
import ksmart42.mybatis.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);

	
	private GoodsService goodsService;
	
	public GoodsController(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	
	/**
	 * 상품삭제
	 */
	@PostMapping("/removeGoods")
	public String removeGoods(@RequestParam(name="goodsCode", required = false) String goodsCode
							,@RequestParam(name="memberPw", required = false, defaultValue = "") String memberPw
							, RedirectAttributes reAttr
							,Goods goods) {
		
		
		log.info("여기{}",goods);

		if(goods != null && goods.getMember().getMemberPw() != null && memberPw.equals(goods.getMember().getMemberPw())) {
			goodsService.removeGoods(goodsCode);
			return "redirect:/goods/goodsList";
		}
		
		reAttr.addAttribute("goodsCode", goodsCode);
		reAttr.addAttribute("result", "상품을 삭제할 수 없습니다.");
			
		return "redirect:/goods/removeGoods";		
		
	}
	
	@GetMapping("/removeGoods")
	public String removeGoods(Model model
								,@RequestParam(name="goodsCode", required = false) String goodsCode
								,@RequestParam(name="result", required = false) String result) {
		
		model.addAttribute("title", "상품삭제");
		model.addAttribute("goodsCode", goodsCode);
		if(result!=null)model.addAttribute("result", result);
		
		return "merchandise/removeGoods";
	}
	
	
	/**
	 * 상품수정
	 */
	@GetMapping("/modifyGoods")
	public String modifyGoods(Model model
								,@RequestParam(name="goodsCode", required = false) String goodsCode) {
		
		Goods goods = goodsService.selectGoods(goodsCode);
		
		model.addAttribute("title", "상품수정");
		model.addAttribute("goods", goods);
		
		return "merchandise/modifyGoods";
	}
	
	@PostMapping("/modifyGoods")
	public String modifyGoods(Goods goods) {
		goodsService.modifyGoods(goods);
		log.info("상품 수정 : {}", goods);
		return "redirect:/goods/goodsList";
	}
	
	/**
	 * 상품등록
	 */
	@PostMapping("/addGoods")
	public String addGoods(Goods goods) {
		
		//goods.setGoodsSellerId("id002");
		goodsService.addGoods(goods);
		
		log.info("상품등록 addGoods: {}", goods);
		
		return "redirect:/goods/goodsList";
	}
	
	@GetMapping("/addGoods")
	public String addGoods(Model model) {
		
		model.addAttribute("title", "상품등록");
		
		return "merchandise/addGoods";
	}
	
	/**
	 * 상품조회
	 */
	@GetMapping("/goodsList")
	public String getGoodsList(Model model, HttpSession session) {
		
		String sessionId = (String) session.getAttribute("SID");
		String sessionLevel = (String) session.getAttribute("SLEVEL");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(sessionId != null && sessionLevel.equals("2")) {			
			paramMap.put("memberId", sessionId);
		}
		
		List<Goods> goodsList = goodsService.getGoodsList(paramMap);
		paramMap = null;
		
		log.info("상품목록조회 goodsList: {}", goodsList);
		
		model.addAttribute("title", "상품목록조회");
		model.addAttribute("goodsList", goodsList);
		
		return "merchandise/goodsList";
	}
}
