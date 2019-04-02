package com.dtdhehe.ptulife.service.impl;

import com.dtdhehe.ptulife.entity.HotLabel;
import com.dtdhehe.ptulife.entity.PtuAnswer;
import com.dtdhehe.ptulife.entity.PtuNews;
import com.dtdhehe.ptulife.repository.HotLableRepository;
import com.dtdhehe.ptulife.service.LabelService;
import com.dtdhehe.ptulife.util.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public HotLabel save(Object object, Class clazz) {
        HotLabel hotLabel = new HotLabel();
        hotLabel.setLabelId(KeyUtils.getUniqueKey());
        try {
            if (PtuNews.class.equals(clazz)){
                PtuNews ptuNews = (PtuNews) object;
                hotLabel.setPostId(ptuNews.getNewsId());
                hotLabel.setLabelTitle(ptuNews.getNewsTitle());
            }else if (PtuAnswer.class.equals(clazz)){
                PtuAnswer ptuAnswer = (PtuAnswer) object;
                hotLabel.setPostId(ptuAnswer.getAnswerId());
                hotLabel.setLabelTitle(ptuAnswer.getAnswerTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        hotLabel.setLabelHot(60);
        return hotLableRepository.save(hotLabel);
    }

    @Override
    public HotLabel save(HotLabel hotLabel) {
        return hotLableRepository.save(hotLabel);
    }

    @Override
    public List<HotLabel> findAllLabel() {
        return hotLableRepository.findAll();
    }

}
