package com.accp.mapper;

import com.accp.domain.Purchaserequisitionsdetails;
import com.accp.domain.PurchaserequisitionsdetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaserequisitionsdetailsMapper {
    int countByExample(PurchaserequisitionsdetailsExample example);

    int deleteByExample(PurchaserequisitionsdetailsExample example);

    int deleteByPrimaryKey(Integer serno);

    int insert(Purchaserequisitionsdetails record);

    int insertSelective(Purchaserequisitionsdetails record);

    List<Purchaserequisitionsdetails> selectByExample(PurchaserequisitionsdetailsExample example);

    Purchaserequisitionsdetails selectByPrimaryKey(Integer serno);

    int updateByExampleSelective(@Param("record") Purchaserequisitionsdetails record, @Param("example") PurchaserequisitionsdetailsExample example);

    int updateByExample(@Param("record") Purchaserequisitionsdetails record, @Param("example") PurchaserequisitionsdetailsExample example);

    int updateByPrimaryKeySelective(Purchaserequisitionsdetails record);

    int updateByPrimaryKey(Purchaserequisitionsdetails record);
}