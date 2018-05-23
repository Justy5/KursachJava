import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;


public class SalesTab {
    JPanel innerPanel, innerAddPanel, innerAdditionalPanel;
    JPanel addSalePanel, overSalePanel, searchSalePanel;
    JTextField aid, aSubject, aPrice, aDuration;
    JComboBox aTimeValue;

    JButton searchButton;
    JScrollPane List;
    JPanel searchid, searchSubject, searchPrice, infoPanel, searchDuration, searchTimeValue,  reEditbtnPanel, deleteBtnPanel;
    JTextField sid, sSubject, sPrice, sDuration;
    JComboBox sTimeValue;


    TransparentJPanel create(TransparentJPanel panel){
        UIManager.put("Panel.background", new Color(180, 216, 219));
        innerPanel = new JPanel();
        panel.add(innerPanel);
        innerPanel.setPreferredSize(new Dimension(Start.wwidth / 8 * 7, Start.wheight));
        innerPanel.add(Box.createRigidArea(new Dimension(40, 40)));

        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));



        searchSalePanel = new JPanel();
        innerPanel.add(searchSalePanel);
        innerPanel.add(Box.createRigidArea(new Dimension(15, 15)));

        searchSalePanel.setMinimumSize(new Dimension(500, 100));


        searchSale();
        addSale();
        panel.repaint();
        return panel;
    }


    void searchSale() {

        searchSalePanel.setLayout(new BoxLayout(searchSalePanel, BoxLayout.PAGE_AXIS));

        UIManager.put("Panel.background", new Color(180, 208, 255));
        infoPanel = new JPanel();

        searchSalePanel.add(Box.createVerticalGlue());
        searchSalePanel.add(infoPanel);
        searchSalePanel.add(Box.createVerticalGlue());

        infoPanel.setMaximumSize(new Dimension(Start.wwidth/2*3-150, 800));

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.LINE_AXIS));
        infoPanel.setAlignmentX(Panel.LEFT_ALIGNMENT);

        infoPanel.add(Box.createHorizontalGlue());


        searchid = new JPanel();

        searchid.setLayout(new BoxLayout(searchid, BoxLayout.PAGE_AXIS));
        JLabel idLbl = new JLabel("ID");
        idLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        searchid.add(idLbl);
        infoPanel.add(Box.createRigidArea(new Dimension(10,5)));
        infoPanel.add(searchid);


        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));


        searchSubject = new JPanel();

        searchSubject.setLayout(new BoxLayout(searchSubject, BoxLayout.PAGE_AXIS));
        JLabel subjectLbl = new JLabel("Послуга");
        searchSubject.add(subjectLbl);
        subjectLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        infoPanel.add(searchSubject);

        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));

        searchPrice = new JPanel();

        searchPrice.setLayout(new BoxLayout(searchPrice, BoxLayout.PAGE_AXIS));
        JLabel priceLbl = new JLabel("Ціна ");
        priceLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        searchPrice.add(priceLbl);
        infoPanel.add(searchPrice);

        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));

        searchDuration = new JPanel();

        searchDuration.setLayout(new BoxLayout(searchDuration, BoxLayout.PAGE_AXIS));
        JLabel durationLbl = new JLabel("тривалість");
        durationLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        searchDuration.add(durationLbl);
        infoPanel.add(searchDuration);



        searchTimeValue = new JPanel();

        searchTimeValue.setLayout(new BoxLayout(searchTimeValue, BoxLayout.PAGE_AXIS));
        JLabel timeValue = new JLabel(" ");
        timeValue.setAlignmentX(Label.LEFT_ALIGNMENT);
        searchTimeValue.add(timeValue);
        infoPanel.add(searchTimeValue);

        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));

        reEditbtnPanel = new JPanel();

        reEditbtnPanel.add(new JLabel(" "));
        reEditbtnPanel.setLayout(new BoxLayout(reEditbtnPanel, BoxLayout.PAGE_AXIS));
        infoPanel.add(reEditbtnPanel);


        deleteBtnPanel = new JPanel();

        deleteBtnPanel.add(new JLabel(" "));
        deleteBtnPanel.setLayout(new BoxLayout(deleteBtnPanel, BoxLayout.PAGE_AXIS));
        infoPanel.add(deleteBtnPanel);


        infoPanel.add(Box.createHorizontalGlue());

        findSales("SELECT * FROM sales ORDER BY Subject");


        searchSalePanel.add(Box.createVerticalGlue());

        UIManager.put("Panel.background", new Color(180, 216, 219));


    }

    void findSales(String str) {

        try {



            Statement numState = DB.getConnection().createStatement();
            ResultSet num = numState.executeQuery(str);
            int rows = 0;
            if (num.next()) {
                rows = num.getInt(1);
            }

            if (rows != 0) {

                Statement statement = DB.getConnection().createStatement();
                ResultSet res = statement.executeQuery(str);

                while (res.next()) {
                    int localID = res.getInt("id");

                    JTextField sid = new JTextField();
                    sid.setEditable(false);
                    sid.setMaximumSize(new Dimension(20, 26));
                    sid.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchid.add(sid);


                    JTextField sSubject = new JTextField();
                    sSubject.setPreferredSize(new Dimension(500, 0));
                    sSubject.setMaximumSize(new Dimension(500, 26));
                    sSubject.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchSubject.add(sSubject);


                    JTextField sPrice = new JTextField();
                    sPrice.setPreferredSize(new Dimension(100, 26));
                    sPrice.setMaximumSize(new Dimension(100, 26));
                    sPrice.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchPrice.add(sPrice);


                    JTextField sDuration = new JTextField();
                    sDuration.setMaximumSize(new Dimension(50, 26));
                    sDuration.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    sDuration.setEditable(false);
                    searchDuration.add(sDuration);


                    JComboBox TimeValue = new JComboBox();
                    TimeValue.setMaximumSize(new Dimension(75, 26));
                    TimeValue.addItem("година");
                    TimeValue.addItem("12 годин");
                    TimeValue.addItem("доба");
                    TimeValue.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchTimeValue.add(TimeValue);



                    JButton submitAdd = new JButton("Оновити");
                    submitAdd.setPreferredSize(new Dimension(100, 50));
                    Statement state = DB.getConnection().createStatement();
                    reEditbtnPanel.add(submitAdd);
                    submitAdd.addActionListener(e -> {
                        try {
                            int query = state.executeUpdate(" UPDATE sales SET " +
                                    " Subject = '" + sSubject.getText() + "'," +
                                    " Price = '" + sPrice.getText() + "'," +
                                    " Duration = '" + sDuration.getText() + "'," +
                                    " TimeValue '" + TimeValue.getSelectedItem() + "')" +
                                    " WHERE id = " + localID);


                            Statement stateLog = DB.getConnection().createStatement();
                            int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                                    "VALUES ( + " + Session.sessionId + ", 'Оновив послугу << " + sSubject.getText() + " з ціною: " + sPrice.getText() + " за 1 " + sTimeValue.getSelectedItem() + " >> ', " + " " + ",'" + DateFormat.stringDateTime(new Date()) + "')");

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(innerAddPanel, "Помилка збереження!");
                        }
                    });

                    JButton delete = new JButton("Видалити");
                    delete.setPreferredSize(new Dimension(100, 50));
                    Statement stateDelete = DB.getConnection().createStatement();
                    deleteBtnPanel.add(delete);
                    delete.addActionListener(e -> {
                        try {
                            int query = stateDelete.executeUpdate(" DELETE FROM sales WHERE id = " + localID);

                            Statement stateLog = DB.getConnection().createStatement();
                            int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                                    "VALUES ( + " + Session.sessionId + ", 'Видалив послугу << " + sSubject.getText() + " з ціною: " + sPrice.getText() + " за 1 " + sTimeValue.getSelectedItem() + " >> ', " + " " + ",'" + DateFormat.stringDateTime(new Date()) + "')");

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(innerAddPanel, "Помилка видалення!");
                        }
                    });


                    sid.setText(localID + "");
                    sPrice.setText(res.getInt("Price") + "");
                    sSubject.setText(res.getString("Subject"));
                    sDuration.setText(res.getString("Duration"));
                    TimeValue.setSelectedItem(res.getString("TimeValue"));
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        infoPanel.add(Box.createVerticalGlue());
    }



    void addSale(){
        innerAddPanel = new JPanel();
        UIManager.put("Panel.background", new Color(180, 208, 255));
        innerPanel.add(innerAddPanel);
        innerAddPanel.setPreferredSize(new Dimension(Start.wwidth / 8 * 2, Start.wheight));
        innerAddPanel.setMaximumSize(new Dimension(Start.wwidth / 8 * 2, Start.wheight));
        innerAddPanel.setMinimumSize(new Dimension(Start.wwidth / 8 * 2, Start.wheight));
        innerAddPanel.setAlignmentX(0);
        innerAddPanel.setLayout(new BoxLayout(innerAddPanel, BoxLayout.PAGE_AXIS));




        addSalePanel = new JPanel();

        innerAddPanel.add(Box.createVerticalGlue());

        JPanel lblPanel = new JPanel();
        JLabel addSubjLabel = new JLabel("Додати послугу");
        lblPanel.setPreferredSize(new Dimension(400, 40));
        lblPanel.setMaximumSize(new Dimension(400, 40));
        lblPanel.add(addSubjLabel);
        addSubjLabel.setFont(new Font("Arial",Font.PLAIN, 24));
        innerAddPanel.add(lblPanel);
        innerAddPanel.add(addSalePanel);
        innerAddPanel.add(Box.createVerticalGlue());
        innerAddPanel.add(Box.createVerticalGlue());
        addSalePanel.setLayout(new BoxLayout(addSalePanel, BoxLayout.LINE_AXIS));
        addSalePanel.setPreferredSize(new Dimension(400, 220));
        addSalePanel.setMaximumSize(new Dimension(500, 220));


        innerAdditionalPanel = new JPanel();
        addSalePanel.add(Box.createHorizontalGlue());
        addSalePanel.add(innerAdditionalPanel);
        addSalePanel.add(Box.createHorizontalGlue());
        innerAdditionalPanel.setLayout(new BoxLayout(innerAdditionalPanel, BoxLayout.PAGE_AXIS));
        innerAdditionalPanel.setPreferredSize(new Dimension(400,200));
        innerAdditionalPanel.setMaximumSize(new Dimension(400,200));


        JPanel subjPanel = new JPanel();
        subjPanel.setLayout(new BoxLayout(subjPanel, BoxLayout.PAGE_AXIS));
        JLabel subjLbl = new JLabel("Послуга");
        subjLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        innerAdditionalPanel.add(subjLbl);
        aSubject = new JTextField();
        aSubject.setMaximumSize(new Dimension(280, 26));
        aSubject.setPreferredSize(new Dimension(280, 26));
        aSubject.setAlignmentX(TextField.LEFT_ALIGNMENT);
        innerAdditionalPanel.add(aSubject);

        innerAdditionalPanel.add(Box.createRigidArea(new Dimension(20,15)));

        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.PAGE_AXIS));
        JLabel priceLbl = new JLabel("Ціна");
        priceLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        innerAdditionalPanel.add(priceLbl);
        aPrice = new JTextField();
        aPrice.setMaximumSize(new Dimension(75, 26));
        aPrice.setPreferredSize(new Dimension(75, 26));
        aPrice.setAlignmentX(TextField.LEFT_ALIGNMENT);
        pricePanel.add(priceLbl);
        pricePanel.add(aPrice);



        JPanel durationPanel = new JPanel();
        durationPanel.setLayout(new BoxLayout(durationPanel, BoxLayout.PAGE_AXIS));
        JLabel duration = new JLabel("Тривалість");
        duration.setAlignmentX(Label.LEFT_ALIGNMENT);
        aDuration = new JTextField();
        aDuration.setMaximumSize(new Dimension(75, 26));
        aDuration.setPreferredSize(new Dimension(75, 26));
        aDuration.setAlignmentX(TextField.LEFT_ALIGNMENT);
        durationPanel.add(duration);
        durationPanel.add(aDuration);


        JPanel timeValuePanel = new JPanel();
        timeValuePanel.setLayout(new BoxLayout(timeValuePanel, BoxLayout.PAGE_AXIS));
        JLabel timeValue = new JLabel(" ");
        timeValue.setAlignmentX(Label.LEFT_ALIGNMENT);
        aTimeValue = new JComboBox();
        aTimeValue.setMaximumSize(new Dimension(75, 26));
        aTimeValue.setPreferredSize(new Dimension(75, 26));
        aTimeValue.setAlignmentX(TextField.LEFT_ALIGNMENT);
        aTimeValue.setSelectedItem("година");
        aTimeValue.addItem("година");
        aTimeValue.addItem("доба");
        aTimeValue.addItem("тиждень");
        timeValuePanel.add(timeValue);
        timeValuePanel.add(aTimeValue);


        JPanel priceDurationPanel = new JPanel();
        priceDurationPanel.setAlignmentX(TextField.LEFT_ALIGNMENT);
        priceDurationPanel.setLayout(new BoxLayout(priceDurationPanel, BoxLayout.LINE_AXIS));
        priceDurationPanel.add(pricePanel);
        priceDurationPanel.add(Box.createRigidArea(new Dimension(20,15)));
        priceDurationPanel.add(durationPanel);
        priceDurationPanel.add(timeValuePanel);
        innerAdditionalPanel.add(priceDurationPanel);
        innerAdditionalPanel.setMaximumSize(new Dimension(innerAdditionalPanel.getPreferredSize().width, innerAdditionalPanel.getPreferredSize().height));

        innerAdditionalPanel.add(Box.createRigidArea(new Dimension(20,35)));


        JButton submitAdd = new JButton("Додати");
        submitAdd.addActionListener(e -> {
            try {
                Statement statement = DB.getConnection().createStatement();
                if(aSubject.getText()=="" || aPrice.getText()=="" || aDuration.getText()=="") {
                    JOptionPane.showMessageDialog(innerAdditionalPanel, "Неповні дані! Перевірте правильність введених даних!");
                    throw new Exception("Неповні дані!");
                }
                int query = statement.executeUpdate("INSERT INTO sales (Subject, Price, Duration, TimeValue) " +
                        "VALUES (" +
                        "'" + aSubject.getText() + "'," +
                        "'" + aPrice.getText() + "'," +
                        "'" + aDuration.getText() + "'," +
                        "'" + aTimeValue.getSelectedItem() + "'" +
                        ")");



                Statement stateLog = DB.getConnection().createStatement();
                int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                        "VALUES ( + " + Session.sessionId + ", 'Дадав нову послугу << " + aSubject.getText() + " з ціною: " + aPrice.getText() + " за 1 " + aTimeValue.getSelectedItem() + " >> ', " + " " + ",'" + DateFormat.stringDateTime(new Date()) + "')");


            }catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(innerAdditionalPanel, "Помилка вводу! Перевірте правильність введених даних!");
            }
        });
        innerAdditionalPanel.add(submitAdd);

        addSalePanel.add(Box.createRigidArea(new Dimension(10,10)));

    }

}



