package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.HotLabel;
import com.dtdhehe.ptulife.service.LabelService;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By Xie_东
 * on 2018/12/18 16:01
 * @author admin
 */
@RestController
@RequestMapping("/label/labelController")
public class LabelController {

    private final Logger logger = LoggerFactory.getLogger(LabelController.class);

    @Autowired
    private LabelService labelService;

    @RequestMapping("/queryHotLabel")
    public ResultVO queryHotLabel(@RequestParam("page")Integer page, @RequestParam("size")Integer size){
        logger.info("查询热门标签");
        ResultVO resultVO = new ResultVO();
        List<HotLabel> list;
        try {
            Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC,"labelHot");
            //分页查询热门标签
            Page<HotLabel> hotLabels = labelService.queryHotLable(pageable);
            list = hotLabels.getContent();
            resultVO.setStatus("0");
            resultVO.setObject(list);
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            //热门标签  7627
            resultVO.setError_code("7627");
            resultVO.setError_msg(e.getMessage());
        }
        return resultVO;
    }
}
