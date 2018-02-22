package com.darwinbox.test.hrms.uiautomation.Settings.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.darwinbox.test.hrms.uiautomation.helper.Action.ActionHelper;
import com.darwinbox.test.hrms.uiautomation.helper.Alert.AlertHelper;
import com.darwinbox.test.hrms.uiautomation.helper.Dropdown.DropDownHelper;
import com.darwinbox.test.hrms.uiautomation.helper.Javascript.JavaScriptHelper;
import com.darwinbox.test.hrms.uiautomation.helper.TestBase.TestBase;
import com.darwinbox.test.hrms.uiautomation.helper.Wait.WaitHelper;
import com.darwinbox.test.hrms.uiautomation.helper.genericHelper.GenericHelper;

/**
 * @author shikhar
 * @Creation_Date: 20 Feb 2017
 * @ClassName : CreateAndManageLeavePolicies
 * @LastModified_Date: 20 Feb 2018
 */

public class CreateAndManageLeavePoliciesPage extends TestBase {

	WaitHelper objWait;
	GenericHelper objGenHelper;
	DropDownHelper objDropDownHelper;
	JavaScriptHelper objJavaScrHelper;
	AlertHelper objAlertHelper;
	WebDriver driver;
	ActionHelper objAction;

	public static final Logger log = Logger.getLogger(AttendanceSettingsShiftPage.class);
	

	public CreateAndManageLeavePoliciesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objWait = PageFactory.initElements(driver, WaitHelper.class);
		objGenHelper = PageFactory.initElements(driver, GenericHelper.class);
		objDropDownHelper = PageFactory.initElements(driver, DropDownHelper.class);
		objAlertHelper = PageFactory.initElements(driver, AlertHelper.class);
		objJavaScrHelper = PageFactory.initElements(driver, JavaScriptHelper.class);
		objAction = PageFactory.initElements(driver, ActionHelper.class);
	}

	/*
	 * Create Leave Policy object repository
	 */

	@FindBy(xpath = "//*[@id='leave_policy_create_btn']")
	private WebElement createLeavePolicySaveButton;

	@FindBy(xpath = "//*[@id='dept_grp_company']")
	private WebElement groupCompanyDropdown;

	@FindBy(xpath = "//*[@id='Leaves_description']")
	private WebElement descriptionTextBox;

	@FindBy(xpath = "//*[@id='Leaves_yearly_endowment']")
	private WebElement maximumLeavesAllowedPerYearTextBox;

	@FindBy(xpath = "//*[@id='Leaves_p3_max_consecutive_days_limit']")
	private WebElement consecutiveLeavesAllowedPerMonthTextBox;

	String chooseRestrictionFromListBoxLocator = "//*[@id='parent_dept_load_chosen']/ul/li/input";

	@FindBy(xpath = "//*[@id='Leaves_p4_carry_over_time']")
	private WebElement leaveCycleDropdown;

	@FindBy(xpath = "//*[@id='Leaves_push_leaves_to_admin']")
	private WebElement pushLeaveRequestToAdminCheckbox;

	String restrictLeaveToWeekDaysListBoxLocator = "//*[@id='week_days_chosen']/ul/li/input";

	@FindBy(xpath = "//*[@id='Leaves_auto_approve_days']")
	private WebElement autoApproveLeaveRequestTextBox;

	@FindBy(xpath = "//*[@id='Leaves_name']")
	private WebElement leaveTypeTextBox;

	@FindBy(xpath = "//*[@id='Leaves_restrictGender']")
	private WebElement genderApplicabilityDropdown;

	@FindBy(xpath = "//*[@id='Leaves_pre_approved_no_of_days']")
	private WebElement minimumNoticePeriodTextBox;

	@FindBy(xpath = "//input[@id='Leaves_p1_waiting_after_doj_status'][@value = 1]")
	private WebElement customMonthsRadioButton;
	
	@FindBy(xpath = "//*[@id='Leaves_p1_waiting_after_doj_status'][@value = 0]")
	private WebElement accordingToEmployeeProbationPeriodRadioButton;

	@FindBy(xpath = "//*[@id='Leaves_p1_waiting_after_doj'][@value = 0][@type = 'text']")
	private WebElement probationPeriodBeforeLeaveValidityMonthsTextBox;
	
	@FindBy(xpath = "//*[@id='Leaves_p2_max_per_month']")
	private WebElement maximumLeavesAllowedPerMonthTextBox;

	@FindBy(xpath = "//*[@id='Leaves_allow_in_notice_period']")
	private WebElement dontAllowLeavesInNoticePeriodCheckBox;

	@FindBy(xpath = "//*[@id='Leaves_max_number_of_leaves_accrued']")
	private WebElement maximumNumberofLeavesAccruedTextBox;

	@FindBy(xpath = "//*[@id='Leaves_min_consecutive_days_limit']")
	private WebElement minimumConsecutiveLeavesTextBox;

	@FindBy(xpath = "//*[@id='Leaves_is_special_leave']")
	private WebElement specialLeaveCheckBox;
	

	
	/*
	 * Leaves Additional Configuration Object Repository
	 */
	@FindBy(xpath = "//*[@id='leavePolicyAccordion']//span[contains(text(),'Credit on Pro-Rata basis')]/..")
	private WebElement creditOnProRataBasisAccordian;
	
//	@FindBy(xpath = "//*[@id='LeavePolicy_Prorated_status'][@value = 1]")
	@FindBy(xpath = "//*[@title = 'Leave balance will be credited depending on when the employee has joined during the annual leave cycle.']")
	private WebElement creditOnProRataBasisYesRadioButton;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Prorated_status'][@value = 0]")
	private WebElement creditOnProRataBasisNoRadioButton;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Prorated_probation_status'][@value = 0]")
	private WebElement calculateFromJoiningDateRadioButton;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Prorated_probation_status'][@value = 1]")
	private WebElement calculateAfterProbationPerioRadioButton;
	
	@FindBy(xpath = "//*[@name='LeavePolicy_Prorated[mid_joining_leaves_full]']")
	private WebElement midJoiningLeavesFullCheckBox;
	
	@FindBy(xpath = "//*[@name='LeavePolicy_Prorated[mid_joining_leaves]']")
	private WebElement midJoiningLeavesHalfCheckBox;
	
	@FindBy(xpath = "//*[@id='leavePolicyAccordion']//span[contains(text(),'Credit on accrual basis')]/..")
	private WebElement creditOnAccrualBasisAccordian;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Accural_status'][@value=1]")
	private WebElement creditOnAccrualBasisYesRadioButton;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Accrual_status'][@value=0]")
	private WebElement creditOnAccrualBasisNoRadioButton;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Accural_is_monthly_quaterly'][@value =0]")
	private WebElement AccrualTimeFrameMonthRadioButton;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Accrual_is_monthly_quaterly'][@title = 'Leave will be credited proportionately, Quarterly basis.'][@value =1]")
	private WebElement AccrualTimeFrameQuarterRadioButton;
	
	@FindBy(xpath = "//*[@id='LeavePolicy_Accrual_is_monthly_quaterly'][@value =2]")
	private WebElement AccrualTimeFrameBiannualRadioButton;
	
	@FindBy(xpath = "//*[@title='Leave will be credited proportionately, on the 1st of every month']")
	private WebElement AccrualPointBeginOfMonthRadioButton;
	
	@FindBy(xpath = "//*[@title='Leave will be credited proportionately, after the end of every month, at the start of next month.']")
	private WebElement AccrualPointEndOfMonthRadioButton;
	
	@FindBy(xpath = "//*[@title='Leave will be credited proportionately, on the start of Quarter']")
	private WebElement AccrualPointBeginOfQuarterRadioButton;
	
	@FindBy(xpath = "//*[@title='Leave will be credited proportionately, after the end of every Quarter']")
	private WebElement AccrualPointEndOfQuarterRadioButton;	
	
	@FindBy(xpath = "//*[@id='leavePolicyAccordion']//span[contains(text(),'Allow half-day')]/..")
	private WebElement allowHalfDayAccordian;
	
	@FindBy(xpath = "//*[@id='leavePolicyAccordion']//span[contains(text(),'Carry forward unused leaves')]/..")
	private WebElement carryForwardUnusedLeavesAccordian;
	
	@FindBy(xpath = "//*[@id='leavePolicyAccordion']//span[contains(text(),'Allow Past dated leave applications')]/..")
	private WebElement allowPastDatedLeaveApplicationsAccordian;
	
	@FindBy(xpath = "//*[@id='leavePolicyAccordion']")
	public WebElement leavePolicyAccordian;
	
	@FindBy(xpath = "//*[@id='Leaves_dont_show_in_probation_period']")
	private WebElement dontShowApplyInProbationPeriodCheckbox;


	
	/**
	 * This method select Restriction Condition Leaves Or And
	 * 
	 * @return
	 */
	public boolean selectRestrictionConditionLeavesOrAnd(String text) {
		String locator = "//*[@id='Leaves_or_and']/../label[contains(text(),'" + text + "')]/../input";
		WebElement element = driver.findElement(By.xpath(locator));
		return objGenHelper.elementClick(element, "Restriction Condition Leaves radio button");
	}

	/**
	 * This method clicks on Create Leave Policy Save button
	 * 
	 * @return
	 */
	public boolean clickCreateLeavePolicySaveButton() {
		objJavaScrHelper.scrollUpVertically();
		objAction.moveToTop(driver,createLeavePolicySaveButton, "Create Leave Policy Save button");
	return	objGenHelper.elementClick(createLeavePolicySaveButton, "Create Leave Policy Save button");
	}

	/**
	 * This method selects text from Group Company Drop down
	 * 
	 * @return
	 */
	public boolean selectGroupCompanyDropdown(String text) {
		return objDropDownHelper.selectUsingVisibleValue(groupCompanyDropdown, text, "Group Company");
	}
	

	/**
	 * This method selects text from Group Company Drop down
	 * 
	 * @return
	 */
	public boolean selectGroupCompanyDropdown(int index) {
		return objDropDownHelper.selectUsingIndex(groupCompanyDropdown, index, "Group Company");
	}
	
	/**
	 * This method insert text in Description text box
	 * 
	 * @param text
	 * @return
	 */
	public boolean insertDescription(String text) {
		return objGenHelper.setElementText(descriptionTextBox, text, "Description");
	}

	/**
	 * This method insert text in Maximum Leaves Allowed Per Year text box
	 * @param text
	 * @return
	 */
	public boolean insertMaximumLeavesAllowedPerYear(String text) {
		return objGenHelper.setElementText(maximumLeavesAllowedPerYearTextBox, "Maximum leaves allowed per year", text );
	}
	
	/**
	 * This method insert text in Maximum Leaves Allowed Per Year text box
	 * @param text
	 * @return
	 */
	public boolean insertMaximumLeavesAllowedPerYear(Integer num) {
		return objGenHelper.setElementText(maximumLeavesAllowedPerYearTextBox,"Maximum leaves allowed per year", num);
	}

	/**
	 * This method insert text in Maximum Leaves Allowed Per Year text box
	 * @param text
	 * @return
	 */

	public boolean insertConsecutiveLeavesAllowedPerMonthTextBox(String text) {
		
		driver.switchTo().defaultContent();
		objGenHelper.elementClick(consecutiveLeavesAllowedPerMonthTextBox, "Maximum leaves allowed per year");
		return objGenHelper.setElementText(consecutiveLeavesAllowedPerMonthTextBox, text, "Maximum leaves allowed per year");
	}

	/**
	 * This method select text from Leave Cycle Drop down
	 * @param text
	 * @return
	 */
	public boolean selectLeaveCycleDropdown(String text) {
		return objDropDownHelper.selectUsingVisibleValue(leaveCycleDropdown, text, "Leave Cycle");
	}

	/**
	 * This method enables or disable Push Leave Request To Admin Checkbox
	 * @param text
	 * @return
	 */
	public boolean pushLeaveRequestToAdminCheckbox(String text) {
		return objGenHelper.toggleElementStatus(pushLeaveRequestToAdminCheckbox, text, "Push all these leave requests to admin");
	}

	/**
	 * This method insert text in Maximum Leaves Allowed Per Year text box
	 * @param text
	 * @return
	 */
	public boolean insertAutoApproveLeaveRequestDays(String text) {
		return objGenHelper.setElementText(autoApproveLeaveRequestTextBox, text, "Auto Approve Leave Request Days");
	}

	/**
	 * This method insert text in Leave Type text box
	 * @param text
	 * @return
	 */
	public boolean insertLeaveType(String text) {
		return objGenHelper.setElementText(leaveTypeTextBox,"Leave Type", text);
	}
	
	/**
	 * This method select text from Gender applicability Drop down
	 * @param text
	 * @return
	 */
	public boolean selectGenderApplicabilityDropdown(String text) {
		return objDropDownHelper.selectUsingVisibleValue(genderApplicabilityDropdown, text, "Gender applicability");
	}
	
	/**
	 * This method insert text in Minimum Notice Period (days)text box
	 * @param text
	 * @return
	 */
	public boolean insertMinimumNoticePeriodDays(String text) {
		return objGenHelper.setElementText(minimumNoticePeriodTextBox, text, "Minimum Notice Period (days)");
	}
	
	/**
	 * This method clicks on Custom Months Radio button
	 * @param text
	 * @return
	 */
	public boolean clickCustomMonthsRadioButton() {
		objAction.moveToElement(driver, customMonthsRadioButton, "Custom Months Radio button");
		objWait.waitElementToBeClickable(customMonthsRadioButton);
		return objGenHelper.elementClick(customMonthsRadioButton, "Custom Months Radio button");
	}
	
	/**
	 * This method clicks on According to employee probation period Radio button
	 * @param text
	 * @return
	 */
	public boolean clickAccordingToEmployeeProbationPeriodRadioButton() {
		return objGenHelper.elementClick(accordingToEmployeeProbationPeriodRadioButton, "According to employee probation period Radio button");
	}
	
	/**
	 * This method insert text in Probation period before leave validity (months) text box
	 * @param text
	 * @return
	 */
	public boolean insertProbationPeriodBeforeLeaveValidityMonths(String value) {
		return objGenHelper.setElementText(probationPeriodBeforeLeaveValidityMonthsTextBox, "Probation period before leave validity (months)", value );
	}
	
	/**
	 * This method insert text in Maximum leaves allowed per month text box
	 * @param text
	 * @return
	 */
	public boolean insertMaximumLeavesAllowedPerMonth(String value) {
		return objGenHelper.setElementText(maximumLeavesAllowedPerMonthTextBox, "Maximum leaves allowed per month", value);
	}
	
	/**
	 * This method enables or disable Don't Allow these leaves in notice period Checkbox
	 * @param text
	 * @return
	 */
	public boolean dontAllowLeavesInNoticePeriodCheckbox(String text) {
		return objGenHelper.toggleElementStatus(dontAllowLeavesInNoticePeriodCheckBox, text, "Don't Allow these leaves in notice period");
	}
	
	/**
	 * This method insert text in Maximum Number of Leaves which can be accrued text box
	 * @param text
	 * @return
	 */
	public boolean insertMaximumNumberOfLeavesWhichCanBeAccrued(String text) {
		return objGenHelper.setElementText(maximumNumberofLeavesAccruedTextBox, text, "Maximum Number of Leaves which can be accrued");
	}
	
	/**
	 * This method insert text in Minimum Consecutive leaves text box
	 * @param text
	 * @return
	 */
	public boolean insertMinimumConsecutiveLeaves(String text) {
		return objGenHelper.setElementText(minimumConsecutiveLeavesTextBox, text, "Minimum Consecutive leaves");
	}
	
	/**
	 * This method enables or disable Push Is this a Special Leave Checkbox
	 * @param text
	 * @return
	 */
	public boolean isthisSpecialLeaveCheckBox(String text) {
		return objGenHelper.toggleElementStatus(specialLeaveCheckBox, text, "Is this a Special Leave");
	}

	/**
	 * This method collapse/uncollapse Credit on Pro-Rata basis accordian
	 * 
	 */
	public boolean clickCreditOnProRataBasisAccordian() {
		return objGenHelper.elementClick(creditOnProRataBasisAccordian, "Credit on Pro-Rata basis accordian");
	}
	
	/**
	 * This method clicks on Credit On ProRata Basis Yes Radio Button
	 * 
	 */
	public boolean clickCreditOnProRataBasisYesRadioButton() {
	objWait.waitElementToBeClickable(creditOnProRataBasisYesRadioButton);
	return objGenHelper.elementClick(creditOnProRataBasisYesRadioButton, "Credit On ProRata Basis Yes Radio Button");
	}
	
	/**
	 * This method clicks on Credit On ProRata Basis Yes Radio Button
	 * 
	 */
	public boolean clickCreditOnProRataBasisNoRadioButton() {
		return objGenHelper.elementClick(creditOnProRataBasisNoRadioButton, "Credit On ProRata Basis No Radio Button");
	}
	
	/**
	 * This method clicks on Calculate from joining date Radio Button
	 * 
	 */
	public boolean clickCalculateFromJoiningDateRadioButton() {
		return objGenHelper.elementClick(calculateFromJoiningDateRadioButton, "Calculate from joining date Radio Button");
	}
	
	/**
	 * This method clicks on Calculate after probation period Radio Button
	 * 
	 */
	public boolean clickCalculateAfterProbationPeriodRadioButton() {
		return objGenHelper.elementClick(calculateAfterProbationPerioRadioButton, "Calculate after probation period Radio Button");
	}
	
	/**
	 * This method enables Credit half month's leaves, if employee joins after 15th day of the month checkbox
	 * 
	 */
	public boolean clickHalfMidJoiningLeavesCheckBox() {
		return objAction.actionClick(driver, midJoiningLeavesHalfCheckBox, "Credit half month's leaves, if employee joins after 15th day of the month");
	}
	
	/**
	 * This method enables Credit half month's leaves, if employee joins after 15th day of the month checkbox
	 * 
	 */
	public boolean toggleHalfMidJoiningLeavesCheckBox(String status) {
		return objGenHelper.toggleElementStatus(midJoiningLeavesHalfCheckBox, status, "Credit half month's leaves, if employee joins after 15th day of the month");
	}
	
	/**
	 * This method enables Credit full month's leaves, if employee joins after 15th day of the month checkbox
	 * 
	 */
	public boolean clickFullMidJoiningLeavesCheckBox() {
		return objAction.actionClick(driver, midJoiningLeavesFullCheckBox, "Credit full month's leaves, if employee joins after 15th day of the month");
//		return objGenHelper.toggleElementStatus(midJoiningLeavesFullCheckBox, status, "Credit full month's leaves, if employee joins after 15th day of the month");
	}
	
	/**
	 * This method enables Credit full month's leaves, if employee joins after 15th day of the month checkbox
	 * 
	 */
	public boolean toggleFullMidJoiningLeavesCheckBox(String status) {
		return objGenHelper.toggleElementStatus(midJoiningLeavesFullCheckBox, status, "Credit full month's leaves, if employee joins after 15th day of the month");
	}
	
	/**
	 * This method collapse/uncollapse Credit on accrual basis accordian
	 * 
	 * @return
	 */
	public boolean clickCreditOnAccrualBasisAccordian() {
		return objGenHelper.elementClick(creditOnAccrualBasisAccordian, "Credit on accrual basis accordian");
	}
	
	/**
	 * This method clicks on Credit on accrual basis Yes Radio Button
	 * 
	 */
	public boolean clickCreditOnAccrualBasisYesRadioButton() {
		objWait.waitElementToBeClickable(creditOnAccrualBasisYesRadioButton);
		return objGenHelper.elementClick(creditOnAccrualBasisYesRadioButton, "Credit on accrual basis Yes Radio Button");
	}
	
	/**
	 * This method clicks on Credit on Accrual basis No Radio Button
	 * 
	 */
	public boolean clickCreditOnAccrualBasisNoRadioButton() {
		return objGenHelper.elementClick(creditOnAccrualBasisNoRadioButton, "Credit on accrual basis No Radio Button");
	}
	
	/**
	 * This method clicks on Accrual time frame Radio Button
	 * 
	 */
	public boolean clickAccrualTimeFrameMonthRadioButton() {
		return objGenHelper.elementClick(AccrualTimeFrameMonthRadioButton, "Accrual time frame 'Month' Radio Button");
	}
	
	/**
	 * This method clicks on Accrual time frame Quarter Radio Button
	 * 
	 */
	public boolean clickAccrualTimeFrameQuarterRadioButton() {
		return objGenHelper.elementClick(AccrualTimeFrameQuarterRadioButton, "Accrual time frame 'Quarter' Radio Button");
	}
	
	/**
	 * This method clicks on Accrual time frame Biannual Radio Button
	 * 
	 */
	public boolean clickAccrualTimeFrameBiannualRadioButton() {
		return objGenHelper.elementClick(AccrualTimeFrameBiannualRadioButton, "Accrual time frame 'Biannual' Radio Button");
	}
	
	/**
	 * This method clicks on Accrual point 'Begin of month' Radio Button
	 * 
	 */
	public boolean clickAccrualPointBeginOfMonthRadioButton() {
		return objGenHelper.elementClick(AccrualPointBeginOfMonthRadioButton, "Accrual point 'Begin of month' radio Button");
	}
	
	/**
	 * This method clicks on Accrual point 'End of month' Radio Button
	 * 
	 */
	public boolean clickAccrualPointEndOfMonthRadioButton() {
		return objGenHelper.elementClick(AccrualPointEndOfMonthRadioButton, "Accrual point 'End of month' radio Button");
	}
	
	/**
	 * This method clicks on Accrual point 'Begin of Quarter' Radio Button
	 * 
	 */
	public boolean clickAccrualPointBeginOfQuarterRadioButton() {
		objGenHelper.elementClick(AccrualPointBeginOfQuarterRadioButton, "Accrual point 'Begin of Quarter' radio Button");
	   if (AccrualPointBeginOfQuarterRadioButton.isSelected()) {
		   return true;
	   }else {
		   throw new RuntimeException();
	   }	
	}
	
	/**
	 * This method clicks on Accrual point 'Begin of Quarter' Radio Button
	 * 
	 */
	public WebElement getWebElementAccrualPointBeginOfQuarterRadioButton() {
		return AccrualPointBeginOfQuarterRadioButton;
	}
	
	/**
	 * This method clicks on Accrual point 'End of Quarter' Radio Button
	 * 
	 */
	public boolean clickAccrualPointEndOfQuarterRadioButton() {
		return objGenHelper.elementClick(AccrualPointEndOfQuarterRadioButton, "Accrual point 'End Of Quarter' radio Button");
	}
	
	/**
	 * This method collapse/uncollapse Allow half-day accordian
	 * 
	 * @return
	 */
	public boolean clickAllowHalfDayAccordian() {
		return objGenHelper.elementClick(allowHalfDayAccordian, "Allow half-day accordian");
	}
	
	/**
	 * This method collapse/uncollapse Carry forward unused leaves accordian
	 * 
	 * @return
	 */
	public boolean clickCarryForwardUnusedLeavesAccordian() {
		return objGenHelper.elementClick(carryForwardUnusedLeavesAccordian, "Carry forward unused leaves accordian");
	}
	
	/**
	 * This method will get don't show apply in Probation Period Check box
	 * @return
	 */
	public WebElement getWebElementDontShowApplyInProbationPeriodCheckbox() {
		return dontShowApplyInProbationPeriodCheckbox;
	}
	
	/**
	 * This method will get don't show apply in Probation Period Check box
	 * @return
	 */
	public WebElement getWebElementallowPastDatedLeaveApplicationsAccordian() {
		return allowPastDatedLeaveApplicationsAccordian;
	}
	
	/**
	 * This method will get Leave Type Delete Button WebElement
	 * @param leaveType
	 * @return WebElement
	 */
	public WebElement getWebElementLeaveTypeDeleteButton(String leaveType) throws NoSuchElementException {
		String leaveTypeNameXpath = "//*[contains(@id,'leaveContainerModal')][text()='"+ leaveType +"']";
		WebElement leaveTypeDeleteButton = driver.findElement(By.xpath(leaveTypeNameXpath));
		return leaveTypeDeleteButton;
	}
		
}
