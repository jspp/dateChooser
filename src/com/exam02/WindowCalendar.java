package com.exam02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCalendar extends JFrame implements ActionListener{
    JTable table;
    CalendarBean calendar;
    JButton controlButton;
    JTextField year,month; // 可编辑区域年,月
    Object[] name = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"}; // 为了表格中的列名使用
    Object[][] rili; // 二维数组日历

    WindowCalendar(){ // 构造函数,用于初始化
        init();
        setSize(580,260);
        setVisible(true);
        this.setLocation(480, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init(){
        year = new JTextField(8);
        month = new JTextField(2);

        // 标签及文本显示
        JPanel pNorth = new JPanel();
        pNorth.add(new JLabel("请输入年分和月份:"));
        pNorth.add(year);
        pNorth.add(new JLabel("年 "));
        pNorth.add(month);
        pNorth.add(new JLabel("月   "));
        add(pNorth,BorderLayout.NORTH);

        // 按钮显示及消息响应
        controlButton = new JButton("显示日历");
        pNorth.add(controlButton);
        controlButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        calendar = new CalendarBean();
        Integer inputYear = 0;
        int inputMonth = 0;

        // 对输入进行容错处理,并对正确输入输出相应年月表格日历
        try{ // 控制年份和月份都为整数,且有范围限制,年份(-2^31~2^31-1)
            inputYear = Integer.parseInt(year.getText().trim());
            inputMonth = Integer.parseInt(month.getText().trim());

            if(inputMonth>=1 && inputMonth<=12){ // 控制月份为整数(1~12)
                calendar.setYear(inputYear);
                calendar.setMonth(inputMonth);
                rili = calendar.getCalendar();
                table = new JTable(rili,name);
                add(new JScrollPane(table));
                validate();
            }else{
                JOptionPane.showMessageDialog(this,"您输入的月份有错,月份范围为整数(1~12)\n      请重新输入","警告对话框",JOptionPane.WARNING_MESSAGE);
            }

        }catch(Exception ee){
            JOptionPane.showMessageDialog(this,"您的输入有错,年份和月份只能输入为整数。\n范围:年份(-2^31~2^31-1),月份(1~12)\n           请重新输入","警告对话框",JOptionPane.WARNING_MESSAGE);
        }
    }
}
