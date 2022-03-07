package ksmart42.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.mybatis.dto.Goods;

@Mapper
public interface GoodsMapper {
	
	//상품목록 조회
	public List<Goods> getGoodsList(Map<String, Object> paramMap);
	
	//상품등록
	public void addGoods(Goods goods);
	
	//상품별 상품 정보
	public Goods selectGoods(String goodsCode);
	
	//상품 수정 처리
	public void modifyGoods(Goods goods);
	
	//상품코드에 따른 구매 삭제
	public void removeOrderByGoodsCode(String goodsCode);
	
	//상품 삭제
	public void removeGoods(String goodsCode);
}
