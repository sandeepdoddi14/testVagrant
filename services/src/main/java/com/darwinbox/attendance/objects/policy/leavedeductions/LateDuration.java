package com.darwinbox.attendance.objects.policy.leavedeductions;

import com.darwinbox.attendance.objects.Shift;
import com.darwinbox.framework.uiautomation.Utility.DateTimeHelper;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LateDuration extends LeaveDeductionsBase implements Serializable {

    private int minTime;
    private int maxTime;

    public void toObject(Map<String, String> data) {

        boolean isApprovalRequired = getFilter(data, "RequiresApproval", "yes");
        boolean isHoliday = getFilter(data, "IsOnHoliday", "yes");
        boolean isWeeklyOff = getFilter(data, "IsOnWeeklyOff", "yes");
        boolean isInDay = getFilter(data, "IsInDay", "yes");

        String halfday [] = data.get("MinHrs").split(":");
        String fullday [] = data.get("MaxHrs").split(":");

        isApprovalRequired(isApprovalRequired);
        setHoliday(isHoliday);
        setWeekoff(isWeeklyOff);
        setInDay(isInDay);
        setLeaveId(data.get("LeaveToDeductId"));
        setWdhrs_fullday(fullday[0]);
        setWdmins_fullday(fullday[1]);
        setWdhrs_halfday(halfday[0]);
        setWdmins_halfday(halfday[1]);

    }

    public int getMinInTime() {
        return minTime;
    }

    public int getMaxInTime() {
        return maxTime;
    }

    public void setWdhrs_halfday(String wdhrs_halfday) {
        minTime = minTime + Integer.parseInt(wdhrs_halfday) * 60;
    }

    public void setWdhrs_fullday(String wdhrs_fullday) {
        maxTime = maxTime + Integer.parseInt(wdhrs_fullday) * 60;
    }

    public void setWdmins_halfday(String wdmins_halfday) {
        minTime = minTime + Integer.parseInt(wdmins_halfday);
    }

    public void setWdmins_fullday(String wdmins_fullday) {
        maxTime = maxTime + Integer.parseInt(wdmins_fullday);
    }

    public static LateDuration jsonToObject(Map<String, Object> data) {

        LateDuration lateDuration = null;

        if (data.get("maxin_policy").toString().equals("1")) {

            lateDuration = new LateDuration();

            boolean requiresApproval = getFilterObject(data, "maxin_deduct_after_approval", "1");
            boolean isHoliday = getFilterObject(data, "maxin_deduction_on_holiday", "1");
            boolean isWeeklyOff = getFilterObject(data, "maxin_deduction_on_weeklyoff", "1");
            boolean isInDay = getFilterObject(data, "maxin_deduction_on_leave", "1");

            String wdHrs_half = data.get("maxin_clock_in_hrs_half_day").toString();
            String wdmins_half = data.get("maxin_clock_in_min_half_day").toString();
            String wdHrs_full = data.get("maxin_clock_in_hrs_full_day").toString();
            String wdmins_full = data.get("maxin_clock_in_min_full_day").toString();

            lateDuration.isApprovalRequired(requiresApproval);
            lateDuration.setHoliday(isHoliday);
            lateDuration.setWeekoff(isWeeklyOff);
            lateDuration.setInDay(isInDay);
            lateDuration.setLeaveId(data.get("maxin_leave_type").toString());
            lateDuration.setWdhrs_fullday(wdHrs_full);
            lateDuration.setWdmins_fullday(wdmins_full);
            lateDuration.setWdhrs_halfday(wdHrs_half);
            lateDuration.setWdmins_halfday(wdmins_half);

        }

        return lateDuration;
    }

    public static Map<String,String> getMap(LateDuration lateDuration) {

        Map<String, String> data = new HashMap<>();

        if (lateDuration != null) {

            data.put("AttendancePolicyForm[maxin_policy]", parseToPHP(true));
            data.put("AttendancePolicyForm[maxin_deduct_after_approval]", parseToPHP(lateDuration.isApprovalRequired()));
            data.put("AttendancePolicyForm[maxin_deduction_on_holiday]", parseToPHP(lateDuration.isHoliday()));
            data.put("AttendancePolicyForm[maxin_deduction_on_weeklyoff]", parseToPHP(lateDuration.isWeekoff()));
            data.put("AttendancePolicyForm[maxin_deduction_on_leave]", parseToPHP(lateDuration.isInDay()));
            data.put("AttendancePolicyForm[maxin_leave_type]", lateDuration.getLeaveId());

            data.put("AttendancePolicyForm[maxin_clock_in_hrs_half_day]", (lateDuration.getMinInTime() / 60) + "");
            data.put("AttendancePolicyForm[maxin_clock_in_min_half_day]", (lateDuration.getMinInTime() % 60) + "");
            data.put("AttendancePolicyForm[maxin_clock_in_hrs_full_day]", (lateDuration.getMaxInTime() / 60) + "");
            data.put("AttendancePolicyForm[maxin_clock_in_min_full_day]", (lateDuration.getMaxInTime() % 60) + "");

        }

        return data;
    }

    public static boolean compareTo(LateDuration lateDuration, LateDuration lateDuration1) {

        if (lateDuration != null) {

            if (lateDuration1 != null) {

                boolean status = LeaveDeductionsBase.compareToSuper(lateDuration, lateDuration1);

                return status &&
                        lateDuration.getMaxInTime() == lateDuration1.getMaxInTime() &&
                        lateDuration.getMinInTime() == lateDuration1.getMinInTime();

            }

            return false;

        } else if (lateDuration1 != null) {

            return false;

        } else {

            return true;

        }
    }

    public Map<String,String> getLateDuration(String empId, String policyname,Shift shift, Date date, boolean forHalf, boolean isWeekOff) {

        DateTimeHelper helper = new DateTimeHelper();

        String shiftDate = helper.formatDateTo(date,"dd-MM-yyyy" );
        String inDate = shiftDate;
        String outDate =   shift.isOverNightShift() ? helper.getNextDate(shiftDate) : shiftDate;

        int shiftStart = shift.getStartTime();
        int shiftEnd = shift.getEndTime();

        if(forHalf) {
            shiftStart += getMinInTime();
        } else
            shiftStart += getMaxInTime();

        if (shiftStart > 1440) {
            shiftStart %= 1440;
            inDate =  helper.getNextDate(shiftDate);
        }

        String inTime = helper.parseTime(shiftStart);
        String outTime = helper.parseTime(shiftEnd);

        Map<String,String> body = new HashMap<>();

        body.put("UserAttendanceImportBack[2][0]", empId);
        body.put("UserAttendanceImportBack[2][1]",shiftDate);
        body.put("UserAttendanceImportBack[2][2]",inDate);
        body.put("UserAttendanceImportBack[2][3]",inTime);
        body.put("UserAttendanceImportBack[2][4]",outDate);
        body.put("UserAttendanceImportBack[2][5]",outTime);
        body.put("UserAttendanceImportBack[2][6]",shift.getShiftName());
        body.put("UserAttendanceImportBack[2][7]",policyname);
        body.put("UserAttendanceImportBack[2][8]",isWeekOff ? "All" : "None");
        body.put("UserAttendanceImportBack[2][9]","00:00:00");

        return body;

    }
}

