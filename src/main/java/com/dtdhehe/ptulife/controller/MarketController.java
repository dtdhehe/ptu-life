package com.dtdhehe.ptulife.controller;

import com.dtdhehe.ptulife.entity.Market;
import com.dtdhehe.ptulife.service.MarketService;
import com.dtdhehe.ptulife.util.RedisUtils;
import com.dtdhehe.ptulife.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Create By Xie_东
 * on 2019/4/11 15:53
 * @author admin
 */
@Controller
@RequestMapping("/market/marketController")
public class MarketController {

    private final Logger logger = LoggerFactory.getLogger(MarketController.class);

    @Autowired
    private MarketService marketService;
    @Resource
    private RedisUtils redisUtils;

    @RequestMapping("/getMarketInfo")
    public String getMarketInfo(){
        return "market/marketInfo";
    }

    @RequestMapping("/saveGoods")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResultVO saveGoods(Market market){
        ResultVO resultVO = new ResultVO();
        try {
            logger.info("保存商品记录");
            market = marketService.save(market);
            logger.info("商品记录保存成功,market = "+market);
            resultVO.setStatus("0");
            resultVO.setError_msg("上架成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            resultVO.setError_msg("上架失败");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return resultVO;
    }

    @RequestMapping("/queryGoods")
    @ResponseBody
    public ResultVO queryGoods(@RequestParam("goodsName")String goodsName,@RequestParam("rows") Integer rows,
                               @RequestParam("page") Integer page){
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isEmpty(goodsName)){
            goodsName = "";
        }
        try {
            Pageable pageable = PageRequest.of(page,rows,Sort.Direction.DESC,"createTime");
            String key = goodsName + "_" + String.valueOf(pageable.getPageNumber());
            List<Market> marketList;
            long total;
            marketList = (List<Market>) redisUtils.get(key);
            if (marketList == null){
                System.out.println("缓存中没有查询到数据,进入数据库查询");
                Page<Market> marketPage = marketService.queryGoodsById(goodsName,pageable);
                marketList = marketPage.getContent();
                redisUtils.set(key,marketList);
                total = marketPage.getTotalElements();
                redisUtils.set(key+"_total",total);
            }else {
                total = (Integer) redisUtils.get(key+"_total");
            }
            resultVO.setStatus("0");
            resultVO.setError_msg(String.valueOf(total));
            resultVO.setObject(marketList);
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            resultVO.setError_msg("查询失败");
        }
        return resultVO;
    }

    @RequestMapping("/checkGoods")
    @ResponseBody
    public ResultVO checkGoods(@RequestParam("id")String id){
        ResultVO resultVO = new ResultVO();
        try {
            Market market = marketService.getById(id);
            resultVO.setStatus("0");
            resultVO.setObject(market);
        }catch (Exception e){
            logger.error(e.getMessage());
            resultVO.setStatus("1");
            resultVO.setError_msg("查询失败");
        }
        return resultVO;
    }

}
