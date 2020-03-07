package com.accp.mapper;

import com.accp.domain.Supplier;
import com.accp.domain.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
	List<Supplier> showSupplier(@Param("sid") String sid,@Param("fullName") String fullName,
			@Param("classId") String classId);
	/**
	 * 查询供应商期末预付款
	 * @param sid
	 * @return
	 */
	Double getcurAdvRecvBySid(String sid);
	/**
	 * 查询供应商期末应付款
	 * @param sid
	 * @return
	 */
	Double getcurReceivableBySid(String sid);
	
    int countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}