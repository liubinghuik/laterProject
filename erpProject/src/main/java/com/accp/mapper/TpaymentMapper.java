package com.accp.mapper;

import com.accp.domain.Tpayment;
import com.accp.domain.TpaymentExample;
import com.accp.domain.Tprepay;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpaymentMapper {
	Tpayment isOutTime(String id);
	
	List<TpaymentMapper> showPayment(@Param("startseachtime") String startseachtime,
			   @Param("endseachtime") String endseachtime,@Param("id") String id,@Param("sid") String sid);
	
    int countByExample(TpaymentExample example);

    int deleteByExample(TpaymentExample example);

    int deleteByPrimaryKey(String id);

    int insert(Tpayment record);

    int insertSelective(Tpayment record);

    List<Tpayment> selectByExample(TpaymentExample example);

    Tpayment selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Tpayment record, @Param("example") TpaymentExample example);

    int updateByExample(@Param("record") Tpayment record, @Param("example") TpaymentExample example);

    int updateByPrimaryKeySelective(Tpayment record);

    int updateByPrimaryKey(Tpayment record);
}