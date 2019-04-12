package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.Market;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Create By Xie_东
 * on 2019/4/11 15:52
 */
public interface MarketService {

    /**
     * 保存商品记录
     * @param market
     * @return
     */
    Market save(Market market);

    /**
     * 根据id查询所有商品
     * @param goodsName
     * @param pageable
     * @return
     */
    Page<Market> queryGoodsById(String goodsName, Pageable pageable);

    /**
     * 根据id查询某个商品
     * @param id
     * @return
     */
    Market getById(String id);

}
