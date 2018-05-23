import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.List;



public class FirstTab {


    XYChart Chart;
    XYChart chart;
    JFrame ChartFrame, chartFrame;
    XYSeries series, Series;
    TaskPanel tasksPanel;
    TransparentJPanel statisticBlock;
    NotificationBlock notifications;
    JPanel companyStat, menegerStat, companyInfo, menegerInfo;
    TransparentJPanel inputClientBlock;

    JLabel countMessages, allCountMessages;


    public TransparentJPanel updateOne(TransparentJPanel one) throws Exception{

        updateStatisticClients();
        updateStatisticMoney();



        tasksPanel.updateOne(tasksPanel);
        notifications.updateNotifications();


        return one;
    }

    public TransparentJPanel createOne(TransparentJPanel one) throws Exception{



/*        one.setVisible(true);*/
// task panel on main panel
        tasksPanel = new TaskPanel();
        tasksPanel.create(tasksPanel);
        tasksPanel.setVisible(true);

        one.add(Box.createRigidArea(new Dimension(Start.wwidth/10*8, Start.wheight/40)));
        one.add(tasksPanel);

        /*  Statistic block ---------------------------------------------------------------------------------------------*/

        statisticBlock = new TransparentJPanel();
        statisticBlock.setPreferredSize(new Dimension(Start.wwidth/10*8, Start.wheight/3));
        companyStat = new JPanel();
        companyStat.setPreferredSize(new Dimension(Start.wwidth/10*4, Start.wwidth/100*25));
        menegerStat = new JPanel();
        menegerStat.setPreferredSize(new Dimension(Start.wwidth/10*4, Start.wwidth/100*25));
        statisticBlock.setLayout(new BoxLayout(statisticBlock, BoxLayout.LINE_AXIS));
        statisticBlock.add(companyStat);
        statisticBlock.add(Box.createRigidArea(new Dimension(5,Start.wheight/3)));
        statisticBlock.add(menegerStat);

        /* chart */



        chart = new XYChartBuilder().width(Start.wwidth/2).height(Start.wheight/3).build();
        chart.setTitle("Статистика по клієнтам");
        chart.setYAxisTitle("Нові клієнти");
        chart.setXAxisTitle("Дата");

        List<Date> xData = new ArrayList<Date>();
        xData.add(new Date());
        List<Double> yData = new ArrayList<Double>();
        yData.add(0.d);
        List<Double> error = new ArrayList<Double>();
        error.add(0.d);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        series = chart.addSeries(" ", xData, yData);
        series.setMarker(SeriesMarkers.NONE);
        chartFrame = new SwingWrapper<>(chart).displayChart();
        chartFrame.setVisible(false);


        /*end chart */

        /* chart */



        Chart = new XYChartBuilder().width(Start.wwidth/2).height(Start.wheight/3).build();
        Chart.setTitle("Прибуткова статистика");
        Chart.setYAxisTitle("Задачі");
        Chart.setXAxisTitle("Дата");

        java.util.List xdata = new ArrayList<Date>();
        xdata.add(new Date());
        java.util.List ydata = new ArrayList<Double>();
        ydata.add(0.d);
        Series = Chart.addSeries(" ", xdata, ydata);
        Series.setMarker(SeriesMarkers.NONE);
        ChartFrame = new SwingWrapper<>(Chart).displayChart();
        ChartFrame.setVisible(false);


        companyStat.setLayout(new BoxLayout(companyStat, BoxLayout.LINE_AXIS));

        companyStat.add(chartFrame.getContentPane());


        menegerStat.setLayout(new BoxLayout(menegerStat, BoxLayout.LINE_AXIS));
        menegerStat.add(ChartFrame.getContentPane());



        one.add(statisticBlock);
        one.add(Box.createRigidArea(new Dimension(Start.wwidth, 3)));
/*input client block*/
        inputClientBlock = new TransparentJPanel();
        inputClientBlock = createClientBlock(inputClientBlock);
        one.add(inputClientBlock);

        return one;
    }






/*
    TransparentJPanel updateClientBlock(TransparentJPanel inputClientBlock) throws Exception{

        return  inputClientBlock;
    }
*/

    TransparentJPanel createClientBlock(TransparentJPanel inputClientBlock) throws Exception{

        inputClientBlock.setPreferredSize(new Dimension(Start.wwidth/10*8, 200));
        inputClientBlock.setLayout(new BoxLayout(inputClientBlock, BoxLayout.LINE_AXIS));
        UIManager.put("Panel.background", new Color(231,195,70));
        JPanel mailBox = new JPanel();
        mailBox.setPreferredSize(new Dimension(Start.wwidth/10*2, 200));


        Statement findClientState = DB.getConnection().createStatement();
        ResultSet findAllClients = findClientState.executeQuery("SELECT COUNT(*) as clients FROM clients");


        Statement findYourClientsState = DB.getConnection().createStatement();
        ResultSet yourCliets = findYourClientsState.executeQuery("SELECT COUNT(*) as yClients FROM logs WHERE Content LIKE '%Додав нового клієнта%' and loger = " + Session.sessionId);

        mailBox.setVisible(true);
        UIManager.put("Label.foreground", new Color(255,255,255));
        mailBox.setLayout(new BoxLayout(mailBox, BoxLayout.PAGE_AXIS));
        JLabel messagelbl = new JLabel("Ваші клієнти");

        if(yourCliets.next())
            countMessages = new JLabel(yourCliets.getInt("yClients") + "");
        countMessages.setFont(new Font("Arial",Font.PLAIN, 72));
        if(findAllClients.next())
            allCountMessages = new JLabel("Всього: " + findAllClients.getInt("clients"));

        JPanel leftmail = new JPanel();
        JPanel rigthmail = new JPanel();

        leftmail.add(messagelbl);
        leftmail.setLayout(new BoxLayout(leftmail, BoxLayout.LINE_AXIS));
        leftmail.add(Box.createHorizontalGlue());
        rigthmail.setLayout(new BoxLayout(rigthmail, BoxLayout.LINE_AXIS));
        rigthmail.add(countMessages);
        rigthmail.add(Box.createHorizontalGlue());
        rigthmail.add(allCountMessages);
        mailBox.add(leftmail);
        mailBox.add(Box.createVerticalGlue());
        mailBox.add(Box.createVerticalGlue());
        mailBox.add(Box.createVerticalGlue());
        mailBox.add(Box.createVerticalGlue());
        mailBox.add(rigthmail);

        inputClientBlock.add(mailBox);
/****************************************************************************/
        UIManager.put("Panel.background", new Color(87,175,247));
        JPanel phoneInput = new JPanel();
        phoneInput.setPreferredSize(new Dimension(Start.wwidth/10*2, 200));

        phoneInput.setVisible(true);

        phoneInput.setLayout(new BoxLayout(phoneInput, BoxLayout.PAGE_AXIS));
        JLabel phonelbl = new JLabel("Оформлено замовлень");

        Statement myOrdersState = DB.getConnection().createStatement();
        ResultSet myOrders = myOrdersState.executeQuery("SELECT Count(*) as count FROM logs WHERE Content LIKE '%Оформив замовлення%' and loger = " + Session.sessionId);
        JLabel phoneCalls = null;
        if (myOrders.next())
            phoneCalls = new JLabel(myOrders.getInt("count") + "");
        phoneCalls.setFont(new Font("Arial",Font.PLAIN, 72));

        Statement sumState = DB.getConnection().createStatement();
        ResultSet allSum = sumState.executeQuery("SELECT * FROM logs WHERE Content LIKE '%Оформив замовлення%' and loger = " + Session.sessionId);
        int totalSum = 0;
        while (allSum.next()){
            String[] strs = allSum.getString("Content").split(": ");
            totalSum += Integer.parseInt(strs[1].substring(0, strs[1].length()-5));
        }

        JLabel allPhoneCalls = new JLabel("на: " + totalSum + " грн.");
        JPanel upPhone = new JPanel();
        JPanel downPhone = new JPanel();

        upPhone.add(phonelbl);
        upPhone.setLayout(new BoxLayout(upPhone, BoxLayout.LINE_AXIS));
        upPhone.add(Box.createHorizontalGlue());
        downPhone.setLayout(new BoxLayout(downPhone, BoxLayout.LINE_AXIS));
        downPhone.add(phoneCalls);
        downPhone.add(Box.createHorizontalGlue());
        downPhone.add(allPhoneCalls);
        phoneInput.add(upPhone);
        phoneInput.add(Box.createVerticalGlue());
        phoneInput.add(Box.createVerticalGlue());
        phoneInput.add(Box.createVerticalGlue());
        phoneInput.add(Box.createVerticalGlue());
        phoneInput.add(downPhone);

        inputClientBlock.add(phoneInput);


        UIManager.put("Label.font", new Font("Arial",Font.PLAIN, 20));
        UIManager.put("Panel.background", new Color(160,160,160));
        UIManager.put("Label.foreground", new Color(30,30,30));
        notifications = new NotificationBlock();
        notifications.createNotifications();
        notifications.setPreferredSize(new Dimension(Start.wwidth/10*4, 200));
        notifications.setMaximumSize(new Dimension(Start.wwidth/10*4, 200));
        System.out.println("notify " + notifications.getPreferredSize().width +" "+ notifications.getPreferredSize().height);
        inputClientBlock.add(notifications);

        return inputClientBlock;
    }



    void updateStatisticClients() throws Exception{
        List<Date> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        List<Double> errorBars = new ArrayList<>();
        /*
        yData = new double[]{4,random.nextInt()%10,random.nextInt()%10,8,random.nextInt()%10,7,random.nextInt()%10};

*/
        Statement CompanyStatement = DB.getConnection().createStatement();
        ResultSet clientSet = CompanyStatement.executeQuery("SELECT timeAdded from clients WHERE timeAdded LIKE '%" + DateFormat.stringDateTime(new Date()).substring(3, DateFormat.stringDateTime(new Date()).length()-6) + "%' ORDER BY timeAdded ");
        System.out.println("SELECT timeAdded from clients WHERE timeAdded LIKE '%" + DateFormat.stringDateTime(new Date()).substring(3, DateFormat.stringDateTime(new Date()).length()-6) + "%' ORDER BY timeAdded ");
        String prevtime = null;
        int iter = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if(clientSet.next()) {
            prevtime = clientSet.getString("timeAdded");

            xData.add(sdf.parse(prevtime));
            yData.add(Double.parseDouble("1"));
            errorBars.add(Double.parseDouble("0"));
        }
        while (clientSet.next()){

            String time = clientSet.getString("timeAdded");
            if(prevtime.equals(time)){
                yData.set(iter, yData.get(iter)+1);
            } else {
                ++iter;
                xData.add(sdf.parse(time));
                yData.add(Double.parseDouble("1"));
                errorBars.add(Double.parseDouble("0"));
            }
            prevtime = time;


        }

        List<Date> newXData = new ArrayList<>();
        List<Double> newYData = new ArrayList<>();

        LocalDate start = xData.get(0).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = xData.get(xData.size()-1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate next = start.minusDays(1);
        int i = 0, k = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
            if(next.format(formatter).equals(xData.get(i).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter))){
                newXData.add(k, Date.from(next.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                newYData.add(yData.get(i));
                i++;
            }
            else {
                newXData.add(k, Date.from(next.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                newYData.add(0.d);
            }


            k++;
        }
        errorBars = newYData;


        chart.getStyler().setDecimalPattern("#0");
        chart.getStyler().setDatePattern("dd.MM");
        chart.updateXYSeries(" ",newXData,newYData, errorBars);
    }

    void updateStatisticMoney() throws Exception{
        List<Date> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        List<Double> errorBars = new ArrayList<>();

        Statement MoneyStatement = DB.getConnection().createStatement();
        ResultSet moneySet = MoneyStatement.executeQuery("SELECT logs.Content, logs.time from logs WHERE Content LIKE '%Оформив замовлення%' and logs.time LIKE '%" + DateFormat.stringDateTime(new Date()).substring(3, DateFormat.stringDateTime(new Date()).length()-6) + "%' ORDER BY time ");
        String prevtime = null;

        int iter = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        if(moneySet.next()) {
            prevtime = moneySet.getString("time");
            prevtime = prevtime.substring(0, prevtime.length()-6);
            String[] tempMoneyString = moneySet.getString("Content").split(": ");
            double money = Double.parseDouble(tempMoneyString[1].substring(0,tempMoneyString[1].length()-5));

            xData.add(sdf.parse(prevtime));
            yData.add(money);
            errorBars.add(Double.parseDouble("0"));
        }
        while (moneySet.next()){
            String[] tempMoneyString = moneySet.getString("Content").split(": ");
            double money = Double.parseDouble(tempMoneyString[1].substring(0,tempMoneyString[1].length()-5));

            String time = moneySet.getString("time");
            System.out.println(prevtime + " " + time);
            time = time.substring(0, time.length()-6);
            if(prevtime.equals(time)){
                System.out.println("yes");
                yData.set(iter, yData.get(iter)+money);
            } else {
                System.out.println("no");
                ++iter;
                xData.add(sdf.parse(time));
                yData.add(money);
                errorBars.add(Double.parseDouble("0"));
            }
            prevtime = time;


        }

        for (int j = 0; j < xData.size(); j++) {
            System.out.println(xData.get(j) + " " + yData.get(j));
        }


        List<Date> newXData = new ArrayList<>();
        List<Double> newYData = new ArrayList<>();

        LocalDate start = xData.get(0).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate end = xData.get(xData.size()-1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate next = start.minusDays(1);
        int i = 0, k = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        while((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
            System.out.print("ty " + next.format(formatter) + " " + xData.get(i).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter));
            if(next.format(formatter).equals(xData.get(i).toInstant().atZone(ZoneId.systemDefault()).toLocalDate().format(formatter))){
                newYData.add(yData.get(i));
                newXData.add(k, Date.from(next.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                i++;
            }
            else {
                newXData.add(k, Date.from(next.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                newYData.add(0.d);
            }

            System.out.println(" " + newYData.get(k));
            k++;
        }
        errorBars = newYData;
       /* for (int j = 0; j < newXData.size(); j++) {
            System.out.println(newXData.get(j) + " " + newYData.get(j));
        }*/


        Chart.getStyler().setDecimalPattern("# грн.");
        Chart.getStyler().setDatePattern("dd.MM");
        Chart.updateXYSeries(" ",newXData,newYData, errorBars);
    }


}








