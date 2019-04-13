package com.dtdhehe.ptulife.repository;

import com.dtdhehe.ptulife.entity.Market;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Create By Xie_东
 * on 2019/4/11 15:51
 */
public interface MarketRepository extends JpaRepository<Market,String> {

    /**
     * 根据名称查询所有商品
     * @param goodsName
     * @param pageable
     * @return
     */
    @Query(value = "select t from Market t where t.goodsName like %?1%")
    Page<Market> queryGoodsByGoodsName(String goodsName, Pageable pageable);

    /**
     * 根据id和商品名查询商品
     * @param id
     * @param goodsName
     * @param pageable
     * @return
     */
    @Query(value = "select t from Market t where t.userId= ?1 and t.goodsName like %?2%")
    Page<Market> queryGoodsById(String id,String goodsName, Pageable pageable);
}
