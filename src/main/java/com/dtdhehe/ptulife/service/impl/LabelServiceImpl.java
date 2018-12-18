package com.dtdhehe.ptulife.service.impl;

import com.dtdhehe.ptulife.entity.HotLabel;
import com.dtdhehe.ptulife.repository.HotLableRepository;
import com.dtdhehe.ptulife.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Create By Xie_东
 * on 2018/12/18 15:56
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private HotLableRepository hotLableRepository;

    @Override
    public Page<HotLabel> queryHotLable(Pageable pageable) {
        return hotLableRepository.findAll(pageable);
    }
}
