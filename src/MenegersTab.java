import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.util.Date;

public class MenegersTab {
    JPanel innerPanel, innerAddPanel, innerAdditionalPanel;
    JPanel addSalePanel, overSalePanel, searchSalePanel;
    JTextField aid, aSubject, aPrice, aDuration;
    JComboBox astatus;

    JButton searchButton;
    JScrollPane List;
    JPanel searchid, searchName, searchLogin, infoPanel, password, searchEmail, searchStatus,  reEditbtnPanel, deleteBtnPanel;
    JTextField sid, sName, sLogin, sEmail;
    JComboBox sstatus;


    TransparentJPanel create(TransparentJPanel panel){

        innerPanel = new JPanel();
        panel.add(innerPanel);
        innerPanel.setPreferredSize(new Dimension(Start.wwidth / 8 * 7, Start.wheight));

        searchSale();
        addSale();
        panel.repaint();
        return panel;
    }

    void updatePanel(){
        innerPanel.removeAll();
        searchSale();
        addSale();
    }

    void searchSale() {
        innerPanel.add(Box.createRigidArea(new Dimension(40, 40)));

        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));
        UIManager.put("Panel.background", new Color(181, 216, 219));
        searchSalePanel = new JPanel();
        innerPanel.add(searchSalePanel);
        innerPanel.add(Box.createRigidArea(new Dimension(15, 15)));

        searchSalePanel.setMinimumSize(new Dimension(500, 100));
        searchSalePanel.setLayout(new BoxLayout(searchSalePanel, BoxLayout.PAGE_AXIS));

        UIManager.put("Panel.background", new Color(181, 208, 255));
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


        searchName = new JPanel();

        searchName.setLayout(new BoxLayout(searchName, BoxLayout.PAGE_AXIS));
        JLabel nameLbl = new JLabel("Ім'я");
        searchName.add(nameLbl);
        nameLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        infoPanel.add(searchName);

        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));

        searchLogin = new JPanel();

        searchLogin.setLayout(new BoxLayout(searchLogin, BoxLayout.PAGE_AXIS));
        JLabel loginLbl = new JLabel("Логін");
        loginLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        searchLogin.add(loginLbl);
        infoPanel.add(searchLogin);

        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));

        searchEmail = new JPanel();

        searchEmail.setLayout(new BoxLayout(searchEmail, BoxLayout.PAGE_AXIS));
        JLabel emailLbl = new JLabel("Email");
        emailLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        searchEmail.add(emailLbl);
        infoPanel.add(searchEmail);

        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));

        searchStatus = new JPanel();

        searchStatus.setLayout(new BoxLayout(searchStatus, BoxLayout.PAGE_AXIS));
        JLabel status = new JLabel("Статус");
        status.setAlignmentX(Label.LEFT_ALIGNMENT);
        searchStatus.add(status);
        infoPanel.add(searchStatus);

        infoPanel.add(Box.createRigidArea(new Dimension(15,5)));

        password = new JPanel();

        password.setLayout(new BoxLayout(password, BoxLayout.PAGE_AXIS));
        JLabel passValue = new JLabel("Пароль");
        passValue.setAlignmentX(Label.LEFT_ALIGNMENT);
        password.add(passValue);
        infoPanel.add(password);

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

        findSales("SELECT * FROM menegers ORDER BY id");


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


                    JTextField sName = new JTextField();
                    sName.setPreferredSize(new Dimension(200, 0));
                    sName.setMaximumSize(new Dimension(200, 26));
                    sName.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchName.add(sName);


                    JTextField sLogin = new JTextField();
                    sLogin.setPreferredSize(new Dimension(100, 26));
                    sLogin.setMaximumSize(new Dimension(100, 26));
                    sLogin.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchLogin.add(sLogin);


                    JTextField sEmail = new JTextField();
                    sEmail.setMaximumSize(new Dimension(250, 26));
                    sEmail.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchEmail.add(sEmail);


                    JTextField sStatus = new JTextField();
                    sStatus.setMaximumSize(new Dimension(75, 26));
                    sStatus.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    searchStatus.add(sStatus);

                    JTextField sPass = new JTextField();
                    sPass.setMaximumSize(new Dimension(150, 26));
                    sPass.setPreferredSize(new Dimension(150, 26));
                    sPass.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    password.add(sPass);

                    JButton submitAdd = new JButton("Оновити");
                    submitAdd.setPreferredSize(new Dimension(100, 50));
                    Statement state = DB.getConnection().createStatement();
                    reEditbtnPanel.add(submitAdd);
                    submitAdd.addActionListener(e -> {
                        try {
                            int query = state.executeUpdate(" UPDATE menegers SET " +
                                    " manager_name = '" + sName.getText() + "'," +
                                    " login = '" + sLogin.getText() + "'," +
                                    " email = '" + sEmail.getText() + "'," +
                                    " status = '" + sStatus.getText() + "', " +
                                    " password = '" + new String(Base64.getEncoder().encode(sPass.getText().getBytes())) + "'" +
                                    " WHERE id = " + localID);

                            Statement stateLog = DB.getConnection().createStatement();
                            int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                                    "VALUES (" + Session.sessionId + ", 'Оновив користувача << " + sName.getText() + " >> ', " + "0" + ",'" + DateFormat.stringDateTime(new Date()) + "')");
                            updatePanel();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(searchSalePanel, "Помилка збереження!");
                        }
                    });

                    JButton delete = new JButton("Видалити");
                    delete.setPreferredSize(new Dimension(100, 50));
                    Statement stateDelete = DB.getConnection().createStatement();
                    deleteBtnPanel.add(delete);
                    delete.addActionListener(e -> {
                        try {
                            int query = stateDelete.executeUpdate(" DELETE FROM menegers WHERE id = " + localID);

                            Statement stateLog = DB.getConnection().createStatement();
                            int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                                    "VALUES ( + " + Session.sessionId + ", 'Видалив користувача << " + sName.getText() + " >> ', " + "0" + ",'" + DateFormat.stringDateTime(new Date()) + "')");
                            updatePanel();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(innerAddPanel, "Помилка видалення!");
                        }
                    });


                    sid.setText(localID + "");
                    sName.setText(res.getString("manager_name") + "");
                    sLogin.setText(res.getString("login"));
                    sEmail.setText(res.getString("email"));
                    sStatus.setText(res.getString("status"));
                    sPass.setText("");
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
        JLabel addSubjLabel = new JLabel("Додати користувача");
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
        JLabel subjLbl = new JLabel("Ім'я");
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
        JLabel loginLbl = new JLabel("Логін");
        loginLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        innerAdditionalPanel.add(loginLbl);
        aPrice = new JTextField();
        aPrice.setMaximumSize(new Dimension(150, 26));
        aPrice.setPreferredSize(new Dimension(150, 26));
        aPrice.setAlignmentX(TextField.LEFT_ALIGNMENT);
        pricePanel.add(loginLbl);
        pricePanel.add(aPrice);



        JPanel durationPanel = new JPanel();
        durationPanel.setLayout(new BoxLayout(durationPanel, BoxLayout.PAGE_AXIS));
        JLabel duration = new JLabel("Email");
        duration.setAlignmentX(Label.LEFT_ALIGNMENT);
        aDuration = new JTextField();
        aDuration.setMaximumSize(new Dimension(75, 26));
        aDuration.setPreferredSize(new Dimension(75, 26));
        aDuration.setAlignmentX(TextField.LEFT_ALIGNMENT);
        durationPanel.add(duration);
        durationPanel.add(aDuration);


        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.PAGE_AXIS));
        JLabel status = new JLabel("Статус");
        status.setAlignmentX(Label.LEFT_ALIGNMENT);
        astatus = new JComboBox();
        astatus.setMaximumSize(new Dimension(75, 26));
        astatus.setPreferredSize(new Dimension(75, 26));
        astatus.setAlignmentX(TextField.LEFT_ALIGNMENT);
        astatus.addItem("admin");
        astatus.addItem("user");
        astatus.setSelectedItem("user");
        statusPanel.add(status);
        statusPanel.add(astatus);


        JPanel priceDurationPanel = new JPanel();
        priceDurationPanel.setAlignmentX(TextField.LEFT_ALIGNMENT);
        priceDurationPanel.setLayout(new BoxLayout(priceDurationPanel, BoxLayout.LINE_AXIS));
        priceDurationPanel.add(pricePanel);
        priceDurationPanel.add(Box.createRigidArea(new Dimension(20,15)));
        priceDurationPanel.add(durationPanel);
        priceDurationPanel.add(Box.createRigidArea(new Dimension(20,15)));
        priceDurationPanel.add(statusPanel);
        innerAdditionalPanel.add(priceDurationPanel);
        innerAdditionalPanel.setMaximumSize(new Dimension(innerAdditionalPanel.getPreferredSize().width, innerAdditionalPanel.getPreferredSize().height+150));

        innerAdditionalPanel.add(Box.createRigidArea(new Dimension(20,15)));
        JPanel passPanel = new JPanel();
        passPanel.setLayout(new BoxLayout(passPanel, BoxLayout.PAGE_AXIS));
        JLabel passlbl = new JLabel("Пароль");
        passPanel.add(passlbl);
        passlbl.setAlignmentX(TextField.LEFT_ALIGNMENT);
        JTextField pass = new JTextField();
        pass.setAlignmentX(TextField.LEFT_ALIGNMENT);
        pass.setMaximumSize(new Dimension(175, 26));
        pass.setPreferredSize(new Dimension(175, 26));
        passPanel.add(pass);
        innerAdditionalPanel.add(passPanel);
        innerAdditionalPanel.add(Box.createRigidArea(new Dimension(20,15)));

        JButton submitAdd = new JButton("Додати");
        submitAdd.addActionListener(e -> {
            try {
                Statement statement = DB.getConnection().createStatement();
                if(aSubject.getText().length()<3 || aPrice.getText().length()<3 || aDuration.getText().length()<3) {
                    JOptionPane.showMessageDialog(innerAdditionalPanel, "Неповні дані! Перевірте правильність введених даних!");
                    throw new Exception("Неповні дані!");
                }
                int query = statement.executeUpdate("INSERT INTO menegers(manager_name, login, email, status, password) " +
                        "VALUES (" +
                        "'" + aSubject.getText() + "'," +
                        "'" + aPrice.getText() + "'," +
                        "'" + aDuration.getText() + "'," +
                        "'" + astatus.getSelectedItem() + "', " +
                        "'" + pass.getText() + "'" +
                        ")");

                Statement stateLog = DB.getConnection().createStatement();
                int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                        "VALUES ( + " + Session.sessionId + ", 'Додав користувача << " + aSubject.getText() + " з правами " + astatus.getSelectedItem() + " >> ', " + "0" + ",'" + DateFormat.stringDateTime(new Date()) + "')");
                updatePanel();
            }catch (Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(innerAdditionalPanel, "Помилка вводу! Перевірте правильність введених даних!");
            }
        });
        innerAdditionalPanel.add(submitAdd);

        addSalePanel.add(Box.createRigidArea(new Dimension(10,10)));
    }
}



