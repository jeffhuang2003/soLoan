package com.psc.scLoan.api.ui;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "角色資料表")
public class DrownUI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "人員清單{\"value\":\"人員編號\",\"label\":\"名稱\"}")
	private List<HashMap<String, String>> userOption;
	@ApiModelProperty(value = "角色清單{\"value\":\"角色編號\",\"label\":\"角色名稱\"}")
	private List<HashMap<String, String>> roleOption;

	@ApiModelProperty(value = "關卡清單{\"value\":\"關卡編號\",\"label\":\"關卡名稱\"}")
	private List<HashMap<String, String>> stageOption;

	@ApiModelProperty(value = "CEMSTEP清單{\"value\":\"1\",\"label\":\"STEP\"\"}")
	private List<HashMap<String, String>> cemStepOption;

	@ApiModelProperty(value = "階段清單{\"value\":\"business\",\"label\":\"商機\"\"}")
	private List<HashMap<String, String>> flowTypeOption;

	@ApiModelProperty(value = "會議類型")
	private List<HashMap<String, String>> meetOption;


	@ApiModelProperty(value = "年份清單")
	private List<HashMap<String, String>> years;
	@ApiModelProperty(value = "月份清單")
	private List<HashMap<String, String>> months;

	@ApiModelProperty(value = "狀態選單")
	private List<HashMap<String, String>> statusOptions;






	public List<HashMap<String, String>> getStatusOptions() {
		return statusOptions;
	}

	public void setStatusOptions(List<HashMap<String, String>> statusOptions) {
		this.statusOptions = statusOptions;
	}

	public List<HashMap<String, String>> getMonths() {
		return months;
	}

	public void setMonths(List<HashMap<String, String>> months) {
		this.months = months;
	}

	public List<HashMap<String, String>> getYears() {
		return years;
	}

	public void setYears(List<HashMap<String, String>> years) {
		this.years = years;
	}



	public List<HashMap<String, String>> getMeetOption() {
		return meetOption;
	}

	public void setMeetOption(List<HashMap<String, String>> meetOption) {
		this.meetOption = meetOption;
	}

	public List<HashMap<String, String>> getFlowTypeOption() {
		return flowTypeOption;
	}

	public void setFlowTypeOption(List<HashMap<String, String>> flowTypeOption) {
		this.flowTypeOption = flowTypeOption;
	}

	public List<HashMap<String, String>> getCemStepOption() {
		return cemStepOption;
	}

	public void setCemStepOption(List<HashMap<String, String>> cemStepOption) {
		this.cemStepOption = cemStepOption;
	}

	public List<HashMap<String, String>> getUserOption() {
		return userOption;
	}

	public void setUserOption(List<HashMap<String, String>> userOption) {
		this.userOption = userOption;
	}

	public List<HashMap<String, String>> getRoleOption() {
		return roleOption;
	}

	public void setRoleOption(List<HashMap<String, String>> roleOption) {
		this.roleOption = roleOption;
	}

	public List<HashMap<String, String>> getStageOption() {
		return stageOption;
	}

	public void setStageOption(List<HashMap<String, String>> stageOption) {
		this.stageOption = stageOption;
	}

}
