package com.exam02;

import java.util.Calendar;

public class CalendarBean { // 日期类

    int year = 2013,month = 10,nextDay;

    public void setYear(int year){
        this.year = year;
    }

    public void setMonth(int month){
        this.month = month;
    }

    // 根据年月,在二维表格中按真实顺序排位
    public String[][] getCalendar(){
        String a[][] = new String[6][7];
        Calendar 日历 = Calendar.getInstance();
        日历.set(year,month-1,1);

        int 星期几 = 日历.get(Calendar.DAY_OF_WEEK)-1;
        int day = 0;

        // 判断一个月有多少天
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            day = 31;
        }
        if(month==4 || month==6 || month==9 || month==11){
            day = 30;
        }
        if(month == 2){
            if(((year%4==0)&&(year%100!=0))||(year%400==0)){
                day = 29;
            }else{
                day = 28;
            }
        }

        // 二维数组依次排序
        nextDay = 1;
        for(int k=0; k<6; k++){
            if(k == 0){
                for(int j=星期几; j<7; j++){
                    a[k][j] = "" + nextDay;
                    nextDay++;
                }
            }else{
                for(int j=0; j<7 && nextDay<=day; j++){
                    a[k][j] = "" + nextDay;
                    nextDay++;
                }
            }
        }
        return a; // 返回二维当前年月数组
    }
}

