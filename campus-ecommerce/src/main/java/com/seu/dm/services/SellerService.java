package com.seu.dm.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seu.dm.entities.*;
/**
 * Created by 张老师 on 2017/3/3.
 */

public interface SellerService {
    int addSeller(Seller seller);

    int deleteSeller(Integer id);

    int updateSeller(Seller seller);

    Seller findSeller(Integer id);

    Seller findSellerByName(String name);

    int deleteSellerByName(String name);

    int selectCountOfSellers();
}
