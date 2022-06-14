package com.psc.scLoan.api.form;

import com.psc.scLoan.model.LendDetail;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


/**
 * 建立日期：2022/6/13 上午 12:15
 * 程式摘要：com.psc.scLoan.api.form
 * 類別名稱：LendForm.java
 * 程式內容說明：借款申請request form
 * @author kunlung
 * @version 1.0
 * @since 1.0
 */
public class LendForm extends BasicForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "客戶帳號",notes = "")
    private String cust_id;


    @ApiModelProperty(value = "借款金額",notes = "")
    private int amount;

    @ApiModelProperty(value = "借款目的",notes = "")
    private List<LendDetail> apply_reason ;

    @ApiModelProperty(value = "其他目的說明",notes = "1:投資上市櫃有價證券、2:期貨市場交易、3:不動產交易、4:其他理財、5:消費性支出、6:資金週轉、7:其他目的")
    private List<LendDetail> apply_reason_other ;

    @ApiModelProperty(value = "擔保品明細",notes = "")
    private List<LendDetail> detailList ;





	
}
