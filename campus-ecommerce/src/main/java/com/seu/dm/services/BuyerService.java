package com.seu.dm.services;

import com.seu.dm.entities.Buyer;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface BuyerService {
    int addBuyer(Buyer buyer);

    int deleteBuyer(Integer id);//根据商品刪除

    int updateBuyer(Buyer buyer);

    Buyer findBuyer(Integer id);


}
