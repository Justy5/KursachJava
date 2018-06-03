import com.github.lgooddatepicker.components.DateTimePicker;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;

public class OrdersTab {
    JPanel innerPanel, overOrderPanel, searchPanel, overTablePanel;
    JTextField search;
    JButton searchButton;

    JPanel lidPanel, lSaleSubj, lSaleCount, lSaleType, lClient, lMeneger, ltimeStart, lprice, ldeadLine, btnPanel, OverOverTablePanel;

    JPanel tSaleSubj, tSaleCount, tSaleType, tClient, ttimeStart, tprice, tdeadLine, updatePanel, retrivePanel;
    JPanel overAddPanel;

    JTextField count;
    JComboBox type;
    JTextField price;
    int selectedSaleID = 0;
    int clientId = 0;
    int menegerId = 0;
    int actualSalePrice;
    int insertSaleCount;
    String insertSaleType;
    Vector<String> vecClient;
    Vector<Integer> vecId;
    Vector<String> vecSubj;
    Vector<Integer> vecCount;
    Vector<String> vecType;
    Vector<Integer> vecPrice;
    JComboBox subj;
    int pricePerOne;
    public int Client;

    TransparentJPanel create(TransparentJPanel panel) throws Exception{
        UIManager.put("Panel.background", new Color(180, 216, 219)); //219

        innerPanel = new JPanel();
        innerPanel.setPreferredSize(new Dimension(Start.wwidth, Start.wheight));

        panel.add(innerPanel);
        panel.setPreferredSize(new Dimension(Start.wwidth, Start.wheight));
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.PAGE_AXIS));


        UIManager.put("Panel.background", new Color(180, 208, 255));
        overOrderPanel = new JPanel();
        overOrderPanel.setPreferredSize(new Dimension(Start.wwidth/6*5, Start.wheight/6*5));
        overOrderPanel.setMaximumSize(new Dimension(Start.wwidth/6*5, Start.wheight/6*5));
        overOrderPanel.setMinimumSize(new Dimension(Start.wwidth/6*5, Start.wheight/6*5));
        innerPanel.add(overOrderPanel);
        createAddPanel();

        searchPanel = new JPanel();
        searchPanelCreate();
        JPanel searchLabelPanel = new JPanel();
        JLabel searchlbl = new JLabel("Пошук по замовленням");
        searchlbl.setFont(new Font("Arial",Font.PLAIN, 28));
        searchLabelPanel.add(Box.createHorizontalGlue());
        searchLabelPanel.add(searchlbl);
        searchLabelPanel.add(Box.createHorizontalGlue());
        searchLabelPanel.setMaximumSize(new Dimension(800, 50));
        searchLabelPanel.setPreferredSize(new Dimension(800, 50));
        overOrderPanel.add(Box.createRigidArea(new Dimension(10,25)));
        overOrderPanel.add(searchLabelPanel);

        overOrderPanel.add(searchPanel);
        overOrderPanel.setLayout(new BoxLayout(overOrderPanel, BoxLayout.PAGE_AXIS));

        overOrderPanel.add(Box.createRigidArea(new Dimension(15,25)));
        overTablePanel = new JPanel();

       /* overOrderPanel.add(overTablePanel);*/
        OverOverTablePanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(OverOverTablePanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBar( new JScrollBar() {
            public int getUnitIncrement( int direction ) {
                return 25;
            }
        } );
        scrollPane.setPreferredSize(new Dimension(Start.wwidth/5*4, Start.wheight/2-50));
        overOrderPanel.add(scrollPane);
        OverOverTablePanel.setLayout(new BoxLayout(OverOverTablePanel, BoxLayout.PAGE_AXIS));
        OverOverTablePanel.add(overTablePanel);
        generate(0, "SELECT * FROM orders ORDER BY id DESC, ClientID");

        return panel;
    }

    void createAddPanel() throws Exception{
        /*tSaleSubj, tSaleCount, tSaleType, tClient, ttimeStart, tdeadLine*/
        UIManager.put("Panel.background", new Color(180, 208, 255));
        overAddPanel = new JPanel();
        overOrderPanel.add(overAddPanel);
        overAddPanel.setPreferredSize(new Dimension(1100,160));
        overAddPanel.setMaximumSize(new Dimension(1100,160));
        overAddPanel.setLayout(new BoxLayout(overAddPanel, BoxLayout.PAGE_AXIS));
        JPanel addUpper = new JPanel();

        JPanel addLower = new JPanel();
        JPanel searchLabelPanel = new JPanel();
        JLabel searchlbl = new JLabel("Створення замовлення");
        searchlbl.setFont(new Font("Arial",Font.PLAIN, 28));
        searchLabelPanel.add(Box.createHorizontalGlue());
        searchLabelPanel.add(searchlbl);
        searchLabelPanel.add(Box.createHorizontalGlue());
        searchLabelPanel.setMaximumSize(new Dimension(800, 80));
        overAddPanel.add(searchLabelPanel);
        overAddPanel.add(addUpper);
        overAddPanel.add(Box.createRigidArea(new Dimension(10,7)));
        overAddPanel.add(addLower);
        overAddPanel.add(Box.createRigidArea(new Dimension(10,50)));

        tSaleSubj = new JPanel();
        tSaleCount = new JPanel();
        tSaleType = new JPanel();
        tprice = new JPanel();
        tClient = new JPanel();
        ttimeStart = new JPanel();
        tdeadLine = new JPanel();
        updatePanel = new JPanel();
        retrivePanel = new JPanel();
        JPanel hideNumber = new JPanel();

        addUpper.add(tClient);
        addUpper.add(Box.createRigidArea(new Dimension(15,5)));
        addUpper.add(tSaleSubj);
        addUpper.add(Box.createRigidArea(new Dimension(15,5)));
        addUpper.add(tSaleCount);
        addUpper.add(tSaleType);
        addUpper.add(Box.createRigidArea(new Dimension(15,5)));
        addUpper.add(tprice);

        addLower.add(ttimeStart);
        addLower.add(Box.createRigidArea(new Dimension(50,10)));
        addLower.add(tdeadLine);
        addLower.add(Box.createRigidArea(new Dimension(50,10)));
        addLower.add(updatePanel);
        addLower.add(hideNumber);


        /*******/
        JLabel number = new JLabel();
        number.hide();
        hideNumber.add(number);

        /******/
        addLower.add(retrivePanel);


        tSaleSubj.setLayout(new BoxLayout(tSaleSubj, BoxLayout.PAGE_AXIS));
        JLabel lbl3 = new JLabel("Послуга");
        lbl3.setAlignmentX(Label.CENTER_ALIGNMENT);
        tSaleSubj.add(lbl3);
        subj = new JComboBox();
        subj.setAlignmentX(Label.CENTER_ALIGNMENT);


        tSaleSubj.add(subj);


        tSaleCount.setLayout(new BoxLayout(tSaleCount, BoxLayout.PAGE_AXIS));
        JLabel lbl2 = new JLabel(" ");
        lbl2.setAlignmentX(Label.CENTER_ALIGNMENT);
        tSaleCount.add(lbl2);
        count = new JTextField();
        count.setPreferredSize(new Dimension(50, 27));
        count.setMinimumSize(new Dimension(50, 27));
        count.setAlignmentX(TextField.CENTER_ALIGNMENT);
        tSaleCount.add(count);

        count.addActionListener(e -> {
            price.setText(Integer.parseInt(count.getText()) * pricePerOne + "");
        });


        tSaleType.setLayout(new BoxLayout(tSaleType, BoxLayout.PAGE_AXIS));
        JLabel lbl4 = new JLabel(" ");
        lbl4.setAlignmentX(Label.CENTER_ALIGNMENT);
        tSaleType.add(lbl4);
        type = new JComboBox();
        type.setAlignmentX(TextField.CENTER_ALIGNMENT);
        type.addItem("година");
        type.addItem("доба");
        type.addItem("тиждень");
        type.setEditable(true);
        type.setEnabled(false);
        /*type.setFocusable(false);
*/
        tSaleType.add(type);

        tprice.setLayout(new BoxLayout(tprice, BoxLayout.PAGE_AXIS));
        JLabel lbl8 = new JLabel("Ціна");
        lbl8.setAlignmentX(Label.CENTER_ALIGNMENT);
        tprice.add(lbl8);
        price = new JTextField();
        price.setPreferredSize(new Dimension(65, 27));
        price.setMinimumSize(new Dimension(65, 27));
        price.setAlignmentX(TextField.CENTER_ALIGNMENT);
        price.setEditable(false);
        tprice.add(price);

        updateSales();


        /***/
        subj.addActionListener(e -> {
            try {

                count.setText(vecCount.get((subj.getSelectedIndex())) + "");
                type.setSelectedItem(vecType.get(subj.getSelectedIndex()));
                price.setText(vecPrice.get(subj.getSelectedIndex()) + "");
                pricePerOne = vecPrice.get(subj.getSelectedIndex());
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        /***/


        tClient.setLayout(new BoxLayout(tClient, BoxLayout.PAGE_AXIS));
        JLabel lbl5 = new JLabel("Клієнт");
        lbl5.setAlignmentX(Label.CENTER_ALIGNMENT);
        tClient.add(lbl5);
        JTextField client = new JTextField("Перейдіть на вкладку клієнти");
        client.setPreferredSize(new Dimension(250, 27));
        client.setMinimumSize(new Dimension(250, 27));
        client.setAlignmentX(TextField.CENTER_ALIGNMENT);
        client.setEditable(false);
        tClient.add(client);

        ttimeStart.setLayout(new BoxLayout(ttimeStart, BoxLayout.PAGE_AXIS));
        JLabel lbl7 = new JLabel("Початок");
        lbl7.setAlignmentX(Label.CENTER_ALIGNMENT);
        ttimeStart.add(lbl7);
        DateTimePicker start = new DateTimePicker();
        start.setAlignmentX(TextField.CENTER_ALIGNMENT);
        ttimeStart.add(start);


        tdeadLine.setLayout(new BoxLayout(tdeadLine, BoxLayout.PAGE_AXIS));
        JLabel lbl9 = new JLabel("Завершення");
        lbl9.setAlignmentX(Label.CENTER_ALIGNMENT);
        tdeadLine.add(lbl9);
        DateTimePicker end = new DateTimePicker();
        end.setAlignmentX(TextField.CENTER_ALIGNMENT);
        tdeadLine.add(end);

        updatePanel.setLayout(new BoxLayout(updatePanel, BoxLayout.PAGE_AXIS));
        JLabel lbl10 = new JLabel(" ");
        lbl10.setAlignmentX(Label.CENTER_ALIGNMENT);
        updatePanel.add(lbl10);
        JButton buttonAdd = new JButton("Додати");
        updatePanel.add(buttonAdd);
        buttonAdd.setAlignmentX(Button.CENTER_ALIGNMENT);

        retrivePanel.setLayout(new BoxLayout(retrivePanel, BoxLayout.PAGE_AXIS));
        JLabel lbl11 = new JLabel(" ");
        lbl10.setAlignmentX(Label.CENTER_ALIGNMENT);
        retrivePanel.add(lbl11);
        JButton buttonRetrive = new JButton("\t↻");
        retrivePanel.add(buttonRetrive);
        buttonRetrive.setAlignmentX(Button.CENTER_ALIGNMENT);
        buttonRetrive.addActionListener(e -> {
            try {
                overTablePanel.removeAll();

                Statement statement = DB.getConnection().createStatement();
                ResultSet res = statement.executeQuery("SELECT id FROM clients WHERE PhoneNumber = '" + number.getText() + "'  ");
                if (res.next()){
                    String sql = "SELECT * FROM orders WHERE ClientId = " + res.getInt("id");
                    UIManager.put("Panel.background", new Color(180, 208, 255));

                    generate(0, sql);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        buttonAdd.addActionListener(e -> {
            try{


                if (!NumberUtils.isNumber(count.getText()))
                    throw new Exception("letter");
                SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");

                Statement statement = DB.getConnection().createStatement();
                Statement findClient = DB.getConnection().createStatement();
                ResultSet clientID = findClient.executeQuery("SELECT id from clients WHERE PhoneNumber = '" + number.getText() + "'");
                if(clientID.next()) {
                    int idClient = clientID.getInt("id");


                    int insert = statement.executeUpdate("INSERT INTO orders(SaleID, SaleCount, " +
                            "SaleType, ClientID, ManegerID, timeReg, startTime, price, deadLine)  "
                            + " VALUES ("
                            + vecId.get(subj.getSelectedIndex()) + ",  "
                            + count.getText() + ",  '"
                            + type.getSelectedItem() + "',  "
                            + idClient +", "
                            + Session.sessionId + ", '"
                            + dateformat.format(new Date()) + "', '"
                            + DateFormat.dateTime(start) + "',  "
                            + price.getText() + ", '"
                            + DateFormat.dateTime(end) + "')");
                    Statement statement1 = DB.getConnection().createStatement();
                    int query = statement1.executeUpdate("UPDATE clients SET SpendSum = SpendSum + " + price.getText() + " WHERE id = " + idClient);

                    Statement stateLog = DB.getConnection().createStatement();
                    int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                            "VALUES ( + " + Session.sessionId + ", 'Оформив замовлення << " + subj.getSelectedItem() + " на " + count.getText() + " " + type.getSelectedItem() + " >> за ціною: " + price.getText() +  " грн.', " + idClient + " ,'" + DateFormat.stringDateTime(new Date()) + "')");

                    JOptionPane.showMessageDialog(overAddPanel, "Замовлення успішно створено!");
                }
            }catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(overAddPanel, "Помилка вводу даних!");
            }
        });

        subj.setSelectedItem(" ");
        count.setText(" ");
        type.setSelectedItem(" ");

    }

    void searchPanelCreate() {
        UIManager.put("Panel.background", new Color(180, 208, 255));

        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.LINE_AXIS));

        search = new JTextField();


        search.setMaximumSize(new Dimension(Start.wwidth/2, 27));
        search.setPreferredSize(new Dimension(Start.wwidth/2, 27));

        searchButton = new JButton("Пошук");

        searchPanel.add(search);
        searchPanel.add(searchButton);
        searchButton.addActionListener( e -> {
            try {
                overTablePanel.removeAll();

                Statement statement = DB.getConnection().createStatement();
                ResultSet res = statement.executeQuery("SELECT id FROM clients WHERE Name LIKE '%" + search.getText() + "%' or SurName LIKE '%" + search.getText() + "%' or LastName LIKE '%" + search.getText() + "%'or PhoneNumber LIKE '%" + search.getText() + "%'  ");
                String sql = "SELECT * FROM orders WHERE SaleType LIKE '%" + search.getText() + "%' or startTime LIKE '%" + search.getText() + "%' or deadLine LIKE '%" + search.getText() + "%' or Price = '" + search.getText() + "'  ";
                while (res.next()){
                    sql = sql + " or ClientID = " + res.getInt("id");
                }

                UIManager.put("Panel.background", new Color(180, 208, 255));
                generate(0, sql + " ORDER BY id DESC ");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
    }


    void generate(int page, String sql) throws Exception {


        OverOverTablePanel.setPreferredSize(new Dimension(28,28));
        overTablePanel.setPreferredSize(new Dimension(500,500));

        overTablePanel.setLayout(new BoxLayout(overTablePanel, BoxLayout.LINE_AXIS));
        Statement statement = DB.getConnection().createStatement();
        ResultSet res = statement.executeQuery(sql /*+ " LIMIT " + page + ", 15"*/);
        boolean gener = false;
        while(res.next()) {
            if (!gener) {

                lidPanel = new JPanel();
                lidPanel.setLayout(new BoxLayout(lidPanel, BoxLayout.PAGE_AXIS));
                JLabel lbl1 = new JLabel(" ");
                lbl1.setAlignmentX(Label.CENTER_ALIGNMENT);
                lidPanel.add(lbl1);
                lSaleCount = new JPanel();
                lSaleCount.setLayout(new BoxLayout(lSaleCount, BoxLayout.PAGE_AXIS));
                JLabel lbl2 = new JLabel(" ");
                lbl2.setAlignmentX(Label.CENTER_ALIGNMENT);
                lSaleCount.add(lbl2);
                lSaleSubj = new JPanel();
                lSaleSubj.setLayout(new BoxLayout(lSaleSubj, BoxLayout.PAGE_AXIS));
                JLabel lbl3 = new JLabel("Послуга");
                lbl3.setAlignmentX(Label.CENTER_ALIGNMENT);
                lSaleSubj.add(lbl3);
                lSaleType = new JPanel();
                lSaleType.setLayout(new BoxLayout(lSaleType, BoxLayout.PAGE_AXIS));
                JLabel lbl4 = new JLabel(" ");
                lbl4.setAlignmentX(Label.CENTER_ALIGNMENT);
                lSaleType.add(lbl4);
                lClient = new JPanel();
                lClient.setLayout(new BoxLayout(lClient, BoxLayout.PAGE_AXIS));
                JLabel lbl5 = new JLabel("Клієнт");
                lbl5.setAlignmentX(Label.CENTER_ALIGNMENT);
                lClient.add(lbl5);
                lMeneger = new JPanel();
                lMeneger.setLayout(new BoxLayout(lMeneger, BoxLayout.PAGE_AXIS));
                JLabel lbl6 = new JLabel("Менеджер");
                lbl6.setAlignmentX(Label.CENTER_ALIGNMENT);
                lMeneger.add(lbl6);
                ltimeStart = new JPanel();
                ltimeStart.setLayout(new BoxLayout(ltimeStart, BoxLayout.PAGE_AXIS));
                JLabel lbl7 = new JLabel("Початок");
                lbl7.setAlignmentX(Label.CENTER_ALIGNMENT);
                ltimeStart.add(lbl7);
                lprice = new JPanel();
                lprice.setLayout(new BoxLayout(lprice, BoxLayout.PAGE_AXIS));
                JLabel lbl8 = new JLabel("Ціна");
                lbl8.setAlignmentX(Label.CENTER_ALIGNMENT);
                lprice.add(lbl8);
                ldeadLine = new JPanel();
                ldeadLine.setLayout(new BoxLayout(ldeadLine, BoxLayout.PAGE_AXIS));
                JLabel lbl9 = new JLabel("Завершення");
                lbl9.setAlignmentX(Label.CENTER_ALIGNMENT);
                ldeadLine.add(lbl9);
                btnPanel = new JPanel();
                btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.PAGE_AXIS));
                JLabel lbl10 = new JLabel(" ");
                lbl10.setAlignmentX(Label.CENTER_ALIGNMENT);
                btnPanel.add(lbl10);
                overTablePanel.add(Box.createRigidArea(new Dimension(5, 4)));
                overTablePanel.add(lidPanel);
                overTablePanel.add(Box.createRigidArea(new Dimension(5, 4)));
                overTablePanel.add(lClient);
                overTablePanel.add(Box.createRigidArea(new Dimension(5, 4)));
                overTablePanel.add(lSaleSubj);
                overTablePanel.add(Box.createRigidArea(new Dimension(5, 4)));
                overTablePanel.add(lSaleCount);
                overTablePanel.add(lSaleType);
                overTablePanel.add(Box.createRigidArea(new Dimension(5, 4)));
                overTablePanel.add(lMeneger);
                overTablePanel.add(Box.createRigidArea(new Dimension(3, 4)));
                overTablePanel.add(lprice);
                overTablePanel.add(Box.createRigidArea(new Dimension(5, 4)));
                overTablePanel.add(ltimeStart);
                overTablePanel.add(Box.createRigidArea(new Dimension(5, 4)));
                overTablePanel.add(ldeadLine);
                overTablePanel.add(btnPanel);

            }

            gener = true;

            JTextField id, client, saleCount, startTime, pricer, deadline;
            JComboBox saleType, saleSubj, meneger;

            int localId = res.getInt("id");
            id = new JTextField(localId + "");
            id.setMinimumSize(new Dimension(50, 27));
            id.setMaximumSize(new Dimension(50, 27));
            id.setPreferredSize(new Dimension(20, 27));
            id.setAlignmentX(TextField.CENTER_ALIGNMENT);
            id.setEditable(false);
            lidPanel.add(Box.createRigidArea(new Dimension(1,4)));
            lidPanel.add(id);

            Statement statement1 = DB.getConnection().createStatement();
            int saleId = res.getInt("SaleID");

            saleSubj = new JComboBox();
            saleSubj.setPreferredSize(new Dimension(175, 27));
            saleSubj.setMaximumSize(new Dimension(175, 27));
            saleSubj.setMinimumSize(new Dimension(175, 27));
            saleSubj.setAlignmentX(TextField.CENTER_ALIGNMENT);
            ResultSet sales = statement1.executeQuery("SELECT * FROM sales");
            String selectedSale = null;

            JTextField localid = new JTextField();
            localid.setVisible(false);

            while(sales.next()) {
                int tempid = sales.getInt("id");
                if(tempid == saleId){
                    selectedSale = sales.getString("Subject");
                    selectedSaleID = tempid;
                    localid.setText(tempid + "");
                    saleSubj.addItem(selectedSale);
                } else {
                    saleSubj.addItem(sales.getString("Subject"));
                }
            }
            lSaleSubj.add(Box.createRigidArea(new Dimension(1,4)));
            lSaleSubj.add(saleSubj);
            saleSubj.setSelectedItem(selectedSale);

            insertSaleCount = res.getInt("SaleCount");

            insertSaleType = res.getString("SaleType");

            saleCount = new JTextField(insertSaleCount + "");
            saleCount.setPreferredSize(new Dimension(37, 27));
            saleCount.setMaximumSize(new Dimension(37, 27));
            saleCount.setMinimumSize(new Dimension(37, 27));
            saleCount.setAlignmentX(TextField.CENTER_ALIGNMENT);
            lSaleCount.add(Box.createRigidArea(new Dimension(1,4)));
            lSaleCount.add(saleCount);



            saleType = new JComboBox();
            saleType.addItem("година");
            saleType.addItem("доба");
            saleType.addItem("тиждень");
            saleType.setSelectedItem(insertSaleType);

            saleType.setPreferredSize(new Dimension(60, 27));
            saleType.setMaximumSize(new Dimension(60, 27));
            saleType.setMinimumSize(new Dimension(60, 27));
            saleType.setAlignmentX(TextField.CENTER_ALIGNMENT);
            lSaleType.add(Box.createRigidArea(new Dimension(1,4)));
            lSaleType.add(saleType);


            Statement statement2 = DB.getConnection().createStatement();
            ResultSet clients = statement2.executeQuery("SELECT clients.Name, LastName, SurName, PhoneNumber, id FROM clients WHERE id = " + res.getString("ClientID"));

            if(clients.next()) {
                clientId = clients.getInt("id");
                String name = clients.getString("Name"),
                        surname = clients.getString("SurName"),
                        lastname = clients.getString("LastName");

                client = new JTextField(surname + " " + name.substring(0,1) + ". " + lastname.substring(0,1) + ".");
                client.setToolTipText(surname + " " + name + " " +lastname);
                client.setPreferredSize(new Dimension(20, 27));
                client.setMaximumSize(new Dimension(100, 27));
                client.setMinimumSize(new Dimension(100, 27));
                client.setAlignmentX(TextField.CENTER_ALIGNMENT);
                client.setEditable(false);
                lClient.add(Box.createRigidArea(new Dimension(1,4)));
                lClient.add(client);
            }

            Statement statement3 = DB.getConnection().createStatement();
            ResultSet menegers = statement3.executeQuery("SELECT manager_name, id FROM menegers");

            menegerId = res.getInt("ManegerID");
            meneger = new JComboBox();
            meneger.setPreferredSize(new Dimension(175, 27));
            meneger.setMaximumSize(new Dimension(175, 27));
            meneger.setMinimumSize(new Dimension(175, 27));
            meneger.setAlignmentX(TextField.CENTER_ALIGNMENT);
            lMeneger.add(Box.createRigidArea(new Dimension(1,4)));
            lMeneger.add(meneger);
            String selectedMeneger = null;
            while (menegers.next()) {
                String selected = menegers.getString("manager_name");
                if(menegerId == menegers.getInt("id")) {
                    selectedMeneger = selected;
                    meneger.addItem(selectedMeneger);
                }
                else
                    meneger.addItem(selected);
            }
            meneger.setSelectedItem(selectedMeneger);

            String start = res.getString("startTime");
            startTime = new JTextField(start);
            startTime.setPreferredSize(new Dimension(115, 27));
            startTime.setMaximumSize(new Dimension(115, 27));
            startTime.setMinimumSize(new Dimension(115, 27));
            startTime.setAlignmentX(TextField.CENTER_ALIGNMENT);
            ltimeStart.add(Box.createRigidArea(new Dimension(1,4)));
            ltimeStart.add(startTime);


            /*****************************************************/




            pricer = new JTextField(actualSalePrice + "");
            pricer.setEditable(false);
            pricer.setPreferredSize(new Dimension(75, 27));
            pricer.setMaximumSize(new Dimension(75, 27));
            pricer.setMinimumSize(new Dimension(75, 27));
            lprice.add(Box.createRigidArea(new Dimension(1,4)));
            lprice.add(pricer);


            getPrice();




            saleCount.addActionListener(e -> {
                pricer.setText(getPrice(Integer.parseInt(localid.getText()), saleCount, saleType) + "");
            });


            String dead = res.getString("deadLine");
            deadline = new JTextField(dead);
            deadline.setPreferredSize(new Dimension(115, 27));
            deadline.setMinimumSize(new Dimension(115, 27));
            deadline.setMaximumSize(new Dimension(115, 27));
            deadline.setAlignmentX(TextField.CENTER_ALIGNMENT);
            ldeadLine.add(Box.createRigidArea(new Dimension(1,4)));
            ldeadLine.add(deadline);

            JPanel localBtnPanel = new JPanel();
            localBtnPanel.setPreferredSize(new Dimension(210,31));
            localBtnPanel.setMinimumSize(new Dimension(210,31));
            localBtnPanel.setMaximumSize(new Dimension(210,31));
            JButton update = new JButton("Оновити");



            update.addActionListener(e -> {
                try{
                    Statement statement4 = DB.getConnection().createStatement();
                    ResultSet findSale = statement4.executeQuery("SELECT id FROM sales WHERE Subject = '" + saleSubj.getSelectedItem() + "'");
                    int sale = 0;
                    if (findSale.next())
                        sale = findSale.getInt("id");



                    Statement updateState = DB.getConnection().createStatement();


                    int execute = updateState.executeUpdate(" UPDATE orders SET " +
                            " SaleID = " + sale + ", " +
                            " SaleCount = " + saleCount.getText() + ", " +
                            " SaleType = '" + saleType.getSelectedItem() + "', " +
                            " ClientID = " + clientId + ", " +
                            " ManegerID = " + menegerId + ", " +
                            " startTime = '" + startTime.getText().substring(0,16) + "', " +
                            " price = " + actualSalePrice + ", " +
                            " deadLine = '" + deadline.getText().substring(0,16) + "' " +
                            " WHERE id = " + localId);

                    Statement stateLog = DB.getConnection().createStatement();
                    int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                            "VALUES ( + " + Session.sessionId + ", 'Оновив замовлення << " + saleSubj.getSelectedItem() + " на " + saleCount.getText() + " " + saleType.getSelectedItem() + " >> ', " + clientId + " ,'" + DateFormat.stringDateTime(new Date()) + "')");

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });

            JButton delete = new JButton("Видалити");

            delete.addActionListener(e -> {
                try{
                    Statement deleteState = DB.getConnection().createStatement();
                    int execute = deleteState.executeUpdate("DELETE FROM orders WHERE id = " + localId);

                    Statement stateLog = DB.getConnection().createStatement();
                    int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                            "VALUES ( + " + Session.sessionId + ", 'Видалив замовленян << " + saleCount.getText() + " " + saleType.getSelectedItem() + " " + " >> ', " + clientId + " ,'" + DateFormat.stringDateTime(new Date()) + "')");

                }catch (Exception ex){

                }
            });
            localBtnPanel.add(update);

            localBtnPanel.add(delete);

            btnPanel.add(localBtnPanel);
            OverOverTablePanel.setPreferredSize(new Dimension(OverOverTablePanel.getPreferredSize().width, OverOverTablePanel.getPreferredSize().height+31));
        }

        lidPanel.add(Box.createVerticalGlue());
        lSaleSubj.add(Box.createVerticalGlue());
        lSaleCount.add(Box.createVerticalGlue());
        lSaleType.add(Box.createVerticalGlue());
        lClient.add(Box.createVerticalGlue());
        lMeneger.add(Box.createVerticalGlue());
        ltimeStart.add(Box.createVerticalGlue());
        lprice.add(Box.createVerticalGlue());
        ldeadLine.add(Box.createVerticalGlue());
        btnPanel.add(Box.createVerticalGlue());
        overTablePanel.add(Box.createVerticalGlue());
        OverOverTablePanel.revalidate();
    }

    void getPrice() {
        try {
            Statement priceState = DB.getConnection().createStatement();

            ResultSet pricement = priceState.executeQuery("SELECT * FROM sales WHERE id = " + selectedSaleID);
            float pricePerHour = 1;
            actualSalePrice = 1;
            if (pricement.next()) {
                pricePerHour = pricement.getInt("Price");
                int tempSaleCount = pricement.getInt("Duration");
                String tempSaleType = pricement.getString("TimeValue");

                if (tempSaleType.equals("доба")) {
                    pricePerHour /= 24;
                } else {
                    if (tempSaleType.equals("тиждень")) {
                        pricePerHour /= 168 * tempSaleCount;
                    } else {
                        pricePerHour *= tempSaleCount;
                    }
                }

            }



            if (insertSaleType.equals("доба")) {
                actualSalePrice = (int) pricePerHour * 24 * insertSaleCount;
            }
            if (insertSaleType.equals("тиждень")) {
                actualSalePrice = (int) pricePerHour * 168 * insertSaleCount;
            }
            if (insertSaleType.equals("година")) {
                actualSalePrice = (int) pricePerHour * insertSaleCount;
            }

        } catch (Exception ex) {

        }
    }


    int getPrice(int input, JTextField count, JComboBox type) {
        try {
            Statement priceState = DB.getConnection().createStatement();

            ResultSet pricement = priceState.executeQuery("SELECT * FROM sales WHERE id = " + input);
            float pricePerHour = 1;
            int actualSalePrice = 1;
            if (pricement.next()) {
                actualSalePrice = 1;
                pricePerHour = pricement.getInt("Price");
                String tempSaleType = pricement.getString("TimeValue");


                if (tempSaleType.equals("доба")) {
                    pricePerHour /= 24;
                } else {
                    if (tempSaleType.equals("тиждень")) {
                        pricePerHour /= 168;
                    }
                }
            }


            if (type.getSelectedItem().equals("доба")) {
                actualSalePrice =  (int)(pricePerHour * 24) * Integer.parseInt(count.getText());
            }
            if (type.getSelectedItem().equals("тиждень")) {
                actualSalePrice = (int)(pricePerHour * 168) * Integer.parseInt(count.getText());
            }
            if (type.getSelectedItem().equals("година")) {
                actualSalePrice = (int) (pricePerHour * Integer.parseInt(count.getText()));
            }
            return actualSalePrice;
        } catch (Exception ex) {
            return 0;
        }

    }

    void updateSales() throws Exception{

        Statement subjState = DB.getConnection().createStatement();
        ResultSet subjs = subjState.executeQuery("SELECT * FROM sales ");

        vecId = new Vector<>();
        vecSubj = new Vector<>();
        vecCount = new Vector<>();
        vecType = new Vector<>();
        vecPrice = new Vector<>();
        subj.removeAllItems();
        while (subjs.next()) {

            vecId.add(subjs.getInt("id"));

            String subject = subjs.getString("Subject");
            vecSubj.add(subject);
            subj.addItem(subject);

            int counter = subjs.getInt("Duration");
            vecCount.add(counter);
            count.setText(counter + "");

            String rtype = subjs.getString("TimeValue");
            vecType.add(rtype);
            type.setSelectedItem(rtype);

            int Price = subjs.getInt("Price");
            price.setText(Price + "");
            vecPrice.add(Price);

        }
    }
}

class DateFormat{
    static String date(DateTimePicker sCalendar) {
        String queryDate = "";
        LocalDate localDate = sCalendar.datePicker.getDate();
        if (localDate != null) {
            Date d = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            queryDate = format.format(d);
        }
        return queryDate;
    }

    static String time(DateTimePicker sCalendar) {
        String queryTime = "";
        LocalDate localDate = sCalendar.datePicker.getDate();
        if (localDate != null) {
            Date d = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            queryTime = format.format(d);
        }
        return queryTime;
    }

    static String dateTime(DateTimePicker sCalendar) {
        String dateTime = "";
        LocalDate localDate = sCalendar.datePicker.getDate();
        if (localDate != null) {
            Date d = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            dateTime = format.format(d);
        }
        return dateTime;
    }

    static String stringDateTime(Date date){
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return dateformat.format(date).toString();
    }

}