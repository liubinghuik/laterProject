package com.accp.domain;

import java.util.Date;

public class Supplier {
	//编号
    private String sid;
    //全称
    private String fullname;
    //简称
    private String shortname;
    //英文全称
    private String engfullname;
    //英文简称
    private String engshortname;
    //账款归属
    private String fundsattribution;
    //类别
    private String classid;
    //地区
    private String area;
    //币别
    private String currencyid;
    //负责人
    private String chiefname;
    //联系人
    private String linkman;
    //采购人员
    private String personid;
    //税务登记号
    private String taxno;
    //资本额
    private Double capitalization;
    //行业别
    private String industrialclass;
    //邮箱
    private String email;
    //网站
    private String webaddress;
    //传真号码
    private String faxno;
    //联系电话1
    private String telephone1;
    //联系电话2
    private String telephone2;
    //联系电话3
    private String telephone3;
    //移动电话
    private String mobilephone;
    //银行账号
    private String bankaccount;
    //开户银行
    private String bank;
    //单价是否含税
    private Integer priceoftax;
    //终止交易日
    private Integer invaliddate;
    //最初采购入库日
    private Date earliesttradedate;
    //最初采购退货日
    private Date firsttradedate;
    //最近采购日
    private Date latelytradedate;
    //最近退货日
    private Date latelyreturn;
    //期初预付
    private Double startadvrecv;
    //期初应付
    private Double startreceivable;
    //账款额度
    private Double amountquota;
    //付款条件
    private Integer recvway;
    //付款天数
    private Integer distdays;
    //每月结账日
    private Integer dayofclose;
    //月结付款日
    private Integer dayofrecv;
    //信用等级
    private String creditlevel;
    //备注
    private String memao;
    //自定义1
    private String coulumn1;
    //自定义2
    private String coulumn2;
    //状态0正常1删除
    private String coulumn3;
    //查询数据
    //期末预付款
    private Double curAdvRecv;
    //期末应付款
    private Double curReceivable;
    //地址
    private Supplieraddress supplieraddress;
    //类别名称
    private String className;
    //采购人员名称
    private String personName;
    
    public Double getCurAdvRecv() {
		return curAdvRecv;
	}

	public void setCurAdvRecv(Double curAdvRecv) {
		this.curAdvRecv = curAdvRecv;
	}

	public Double getCurReceivable() {
		return curReceivable;
	}

	public void setCurReceivable(Double curReceivable) {
		this.curReceivable = curReceivable;
	}

	public Supplieraddress getSupplieraddress() {
		return supplieraddress;
	}

	public void setSupplieraddress(Supplieraddress supplieraddress) {
		this.supplieraddress = supplieraddress;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getEngfullname() {
        return engfullname;
    }

    public void setEngfullname(String engfullname) {
        this.engfullname = engfullname;
    }

    public String getEngshortname() {
        return engshortname;
    }

    public void setEngshortname(String engshortname) {
        this.engshortname = engshortname;
    }

    public String getFundsattribution() {
        return fundsattribution;
    }

    public void setFundsattribution(String fundsattribution) {
        this.fundsattribution = fundsattribution;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(String currencyid) {
        this.currencyid = currencyid;
    }

    public String getChiefname() {
        return chiefname;
    }

    public void setChiefname(String chiefname) {
        this.chiefname = chiefname;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getTaxno() {
        return taxno;
    }

    public void setTaxno(String taxno) {
        this.taxno = taxno;
    }

    public Double getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(Double capitalization) {
        this.capitalization = capitalization;
    }

    public String getIndustrialclass() {
        return industrialclass;
    }

    public void setIndustrialclass(String industrialclass) {
        this.industrialclass = industrialclass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebaddress() {
        return webaddress;
    }

    public void setWebaddress(String webaddress) {
        this.webaddress = webaddress;
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getTelephone3() {
        return telephone3;
    }

    public void setTelephone3(String telephone3) {
        this.telephone3 = telephone3;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getPriceoftax() {
        return priceoftax;
    }

    public void setPriceoftax(Integer priceoftax) {
        this.priceoftax = priceoftax;
    }

    public Integer getInvaliddate() {
        return invaliddate;
    }

    public void setInvaliddate(Integer invaliddate) {
        this.invaliddate = invaliddate;
    }

    public Date getEarliesttradedate() {
        return earliesttradedate;
    }

    public void setEarliesttradedate(Date earliesttradedate) {
        this.earliesttradedate = earliesttradedate;
    }

    public Date getFirsttradedate() {
        return firsttradedate;
    }

    public void setFirsttradedate(Date firsttradedate) {
        this.firsttradedate = firsttradedate;
    }

    public Date getLatelytradedate() {
        return latelytradedate;
    }

    public void setLatelytradedate(Date latelytradedate) {
        this.latelytradedate = latelytradedate;
    }

    public Date getLatelyreturn() {
        return latelyreturn;
    }

    public void setLatelyreturn(Date latelyreturn) {
        this.latelyreturn = latelyreturn;
    }

    public Double getStartadvrecv() {
        return startadvrecv;
    }

    public void setStartadvrecv(Double startadvrecv) {
        this.startadvrecv = startadvrecv;
    }

    public Double getStartreceivable() {
        return startreceivable;
    }

    public void setStartreceivable(Double startreceivable) {
        this.startreceivable = startreceivable;
    }

    public Double getAmountquota() {
        return amountquota;
    }

    public void setAmountquota(Double amountquota) {
        this.amountquota = amountquota;
    }

    public Integer getRecvway() {
        return recvway;
    }

    public void setRecvway(Integer recvway) {
        this.recvway = recvway;
    }

    public Integer getDistdays() {
        return distdays;
    }

    public void setDistdays(Integer distdays) {
        this.distdays = distdays;
    }

    public Integer getDayofclose() {
        return dayofclose;
    }

    public void setDayofclose(Integer dayofclose) {
        this.dayofclose = dayofclose;
    }

    public Integer getDayofrecv() {
        return dayofrecv;
    }

    public void setDayofrecv(Integer dayofrecv) {
        this.dayofrecv = dayofrecv;
    }

    public String getCreditlevel() {
        return creditlevel;
    }

    public void setCreditlevel(String creditlevel) {
        this.creditlevel = creditlevel;
    }

    public String getMemao() {
        return memao;
    }

    public void setMemao(String memao) {
        this.memao = memao;
    }

    public String getCoulumn1() {
        return coulumn1;
    }

    public void setCoulumn1(String coulumn1) {
        this.coulumn1 = coulumn1;
    }

    public String getCoulumn2() {
        return coulumn2;
    }

    public void setCoulumn2(String coulumn2) {
        this.coulumn2 = coulumn2;
    }

    public String getCoulumn3() {
        return coulumn3;
    }

    public void setCoulumn3(String coulumn3) {
        this.coulumn3 = coulumn3;
    }
}