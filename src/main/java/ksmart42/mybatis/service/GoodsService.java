package ksmart42.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.mybatis.dto.Goods;
import ksmart42.mybatis.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsService {
	//DI 의존성 주입
	private GoodsMapper goodsMapper;
	
	public GoodsService(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}
	
	//상품목록조회
	public List<Goods> getGoodsList(Map<String, Object> paramMap){
		List<Goods> goodsList = goodsMapper.getGoodsList(paramMap);
		
		return goodsList;
	}
	
	//상품등록	
	public void addGoods(Goods goods) {
		goodsMapper.addGoods(goods);
	}
	
	//상품별 상품 정보
	public Goods selectGoods(String goodsCode) {
		Goods goods = goodsMapper.selectGoods(goodsCode);
		return goods;
	}
	
	//상품 수정
	public void modifyGoods(Goods goods) {
		goodsMapper.modifyGoods(goods);
	}
	
	//상품 삭제
	public void removeGoods(String goodsCode) {
		goodsMapper.removeOrderByGoodsCode(goodsCode);
		goodsMapper.removeGoods(goodsCode);
	}
}
