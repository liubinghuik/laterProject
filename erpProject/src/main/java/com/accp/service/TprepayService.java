package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Tprepay;
import com.accp.domain.Tprepaydetail;
import com.accp.domain.TprepaydetailExample;
import com.accp.mapper.TprepayMapper;
import com.accp.mapper.TprepaydetailMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TprepayService {
	@Autowired
	private TprepayMapper tprepayMapper;
	@Autowired
	private TprepaydetailMapper tprepaydetailMapper;
	/**
	 * 分页查询
	 * @param pageNum 页码
	 * @param pageSize 数量
	 * @param startseachtime 开始时间
	 * @param endseachtime 结束时间
	 * @param id 单据编号
	 * @param sid 供应商编号
	 * @return
	 */
	public PageInfo<Tprepay> showPrepays(Integer pageNum,Integer pageSize,String startseachtime,
			String endseachtime,String id,String sid) {
		if (pageNum==null) {
			pageNum=1;
		}
		if (pageSize==null) {
			pageSize=10;
		}
		Page<Tprepay> page=PageHelper.startPage(pageNum, pageSize);
		tprepayMapper.showPrepay(startseachtime, endseachtime, id, sid);
		return page.toPageInfo();
	}
	/**
	 * 按单号查询
	 * @param id
	 * @return
	 */
	public Tprepay showPrepayById(String id) {
		Tprepay tprepay=tprepayMapper.selectByPrimaryKey(id);
		TprepaydetailExample tprepaydetailExample=new TprepaydetailExample();
		tprepaydetailExample.createCriteria().andPidEqualTo(id);
		List<Tprepaydetail> tprepaydetails=tprepaydetailMapper.selectByExample(tprepaydetailExample);
		tprepay.setPrepaydetails(tprepaydetails);
		return tprepay;
	}
	
	
}
