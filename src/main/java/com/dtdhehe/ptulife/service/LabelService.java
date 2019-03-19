package com.dtdhehe.ptulife.service;

import com.dtdhehe.ptulife.entity.HotLabel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Create By Xie_东
 * on 2018/12/18 15:53
 */
public interface LabelService<T> {

    /**
     * 查询热门标签
     * @param pageable
     * @return
     */
    Page<HotLabel> queryHotLable(Pageable pageable);

    /**
     * 根据业务id保存热度
     * @param object
     * @return
     */
    HotLabel save(T object,Class<T> clazz);

}
