package com.seu.dm.serviceimpls;

import com.seu.dm.entities.Seller;
import com.seu.dm.mappers.SellerMapper;
import com.seu.dm.services.SellerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by 张老师 on 2017/3/3.
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public int addSeller(Seller seller) {
        return sellerMapper.insert(seller);
    }

    @Override
    public int deleteSeller(Integer id) {
        return sellerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateSeller(Seller seller) {
        return sellerMapper.updateByPrimaryKey(seller);
    }

    @Override
    public Seller findSeller(Integer id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    public Seller findSellerByName(String name) {
        return sellerMapper.selectByName(name);
    }

    @Override
    public int deleteSellerByName(String name) {
        return sellerMapper.deleteByName(name);
    }

    @Override
    public int selectCountOfSellers() {
        return sellerMapper.selectCountOfAll();
    }
}
