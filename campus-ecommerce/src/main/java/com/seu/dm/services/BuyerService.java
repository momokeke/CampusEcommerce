package com.seu.dm.services;

import com.seu.dm.entities.Buyer;

import java.util.List;

/**
 * Created by 张老师 on 2017/3/3.
 */
public interface BuyerService {
    int addBuyer(Buyer buyer);

    int deleteBuyer(Integer id);

    int updateBuyer(Buyer buyer);

    Buyer findBuyer(Integer id);

    List<Buyer> findBuyersByCampusId(Integer campusId);

    int banBuyer(Integer id);

    int unBanBuyer(Integer id);

    Buyer findBuyerByStudentNumber(Integer studentNumber);
}
