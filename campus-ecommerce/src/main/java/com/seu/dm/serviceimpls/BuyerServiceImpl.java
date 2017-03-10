package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Buyer;
import com.seu.dm.mappers.BuyerMapper;
import com.seu.dm.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public int addBuyer(Buyer buyer) {
        int i = buyerMapper.insert(buyer);
        return i;
    }

    @Override
    public Buyer findBuyer(Integer id) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(id);
//        if(buyer == null) return 0;
//        return 1;
        return buyer;
    }

    @Override
    public int deleteBuyer(Integer id) {
        int i = buyerMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateBuyer(Buyer buyer) {
        int i = buyerMapper.updateByPrimaryKey(buyer);
        return i;
    }

    @Override
    public List<Buyer> findBuyersByCampusId(Integer campusId) {
        List<Buyer> buyers = buyerMapper.findBuyersByCampusId(campusId);
        return buyers;
    }

    @Override
    public int banBuyer(Integer id) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(id);
        buyer.setBanned(true);
        return 1;
    }

    @Override
    public int unBanBuyer(Integer id) {
        Buyer buyer = buyerMapper.selectByPrimaryKey(id);
        buyer.setBanned(false);
        return 1;
    }
}
