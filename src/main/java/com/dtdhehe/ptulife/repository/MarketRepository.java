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
     * 根据id查询所有商品
     * @param goodsName
     * @param pageable
     * @return
     */
    @Query(value = "select t from Market t where t.goodsName like %?1%")
    Page<Market> queryGoodsById(String goodsName, Pageable pageable);
}
