package com.softserve.edu.service.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TransformStringsToMonths {


    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public int[] parser(String dataFrom, String dataTo) {
        int arr[] = new int[2];
        String fromDate = (String) dataFrom.subSequence(3, 5);
        String toDate = (String) dataTo.subSequence(3, 5);
        int from = Integer.valueOf(fromDate);
        int to = Integer.valueOf(toDate);
        arr[0] = from;
        arr[1] = to;

        return arr;

    }


    public List<String> transferToMonthArray(String dataFrom, String dataTo) {
        Date from = convertToDate(dataFrom);
        Date to = convertToDate(dataTo);


//        int from = parser(dataFrom, dataTo)[0];
//        int to = parser(dataFrom, dataTo)[1];
        List list = new ArrayList();
//        if (to >= from) {
//            for (int i = from; i <= to; i++) {
//                list.add(getMonth(i));
//            }
//        } else {
//            for (int i = from; i < 12; i++) {
//                list.add(getMonth(i));
//            }
//            for (int i = 0; i <= to; i++) {
//                list.add(getMonth(i));
//            }
//        }
        return list;
    }


    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    }


    public Date convertToDate(String date) {
        Date result = null;
        if (StringUtils.isNotBlank(date)) {
            try {
                result = DATE_FORMAT.parse(date);
            } catch (ParseException e) {
                //logger add
            }
        }
        return result;
    }

    public List<Double> identifyProviderEmployee(int from, int to, List<Object[]> list) {
        List<Double> countOfWork = new ArrayList<>();
        double iterat = 0.0;
        double d = 0.0;
        for (int i = from; i <= to; i++) {
            boolean avaible = false;

            if (list.size() == 0) {
                countOfWork.add(0.0);
                avaible = true;
            }

            for (int j = 0; j < list.size(); j++) {
                iterat = Integer.valueOf(String.valueOf(list.get(j)[1]));
                if (i == iterat) {
                    d = Double.valueOf(String.valueOf(list.get(j)[0]));
                    countOfWork.add(d);
                    avaible = true;
                    break;
                }
            }
            if (!avaible) {
                countOfWork.add(0.0);
            }
        }
        return countOfWork;
    }


    public List<Double> identifyProviderEmployeeMulty(int[] arr, List<Object[]> list) {
        List<Double> countOfWork = new ArrayList<>();
        double iterat = 0.0;
        double d = 0.0;

        //first iteration to find match between dataCalendar and listOfMonth
        for (int i = arr[0]; i < 12; i++) {
            boolean avaible = false;

            if (list.size() == 0) {
                countOfWork.add(0.0);
                avaible = true;

            }

            for (int j = 0; j < list.size(); j++) {
                iterat = Integer.valueOf(String.valueOf(list.get(j)[1]));
                if (i == iterat) {
                    d = Double.valueOf(String.valueOf(list.get(j)[0]));
                    countOfWork.add(d);
                    avaible = true;
                    break;
                }
            }
            if (!avaible) {
                countOfWork.add(0.0);
            }
        }

        //second iteration to find match between dataCalendar and listOfMonth
        iterat = 0.0;
        d = 0.0;
        for (int i = 0; i <= arr[1]; i++) {
            boolean avaible = false;

            if (list.size() == 0) {
                countOfWork.add(0.0);
                avaible = true;
            }
            for (int j = 0; j < list.size(); j++) {
                iterat = Integer.valueOf(String.valueOf(list.get(j)[1]));
                if (i == iterat) {
                    d = Double.valueOf(String.valueOf(list.get(j)[0]));
                    countOfWork.add(d);
                    avaible = true;
                    break;
                }
            }
            if (!avaible) {
                countOfWork.add(0.0);
            }
        }

        return countOfWork;
    }

    public String getQueryProviderUsername() {
        String providerUsername = "SELECT distinct providerEmployee_username as username FROM verification " +
                " where provider_organizationId= ?1 and  providerEmployee_username is not null";
        return providerUsername;
    }

    public String getQuerytoGrafic() {
        String toGrafic = "select  count(v) as data, month(initialDate) as months" +
                " from verification v  " +
                " where v.providerEmployee_username= ?1 " +
                " and  initialDate Between ?2 and ?3 " +
                " group by month(initialDate) ";
        return toGrafic;
    }
}

