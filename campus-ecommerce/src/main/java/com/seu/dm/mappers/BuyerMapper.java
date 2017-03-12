package com.seu.dm.mappers;

import com.seu.dm.entities.Buyer;

import java.util.List;

public interface BuyerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Buyer record);

    int insertSelective(Buyer record);

    Buyer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Buyer record);

    int updateByPrimaryKey(Buyer record);

    List<Buyer> findBuyersByCampusId(Integer campusId);

    Buyer findBuyerByStudentNumber(Integer studentNumber);
}