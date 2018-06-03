import com.github.lgooddatepicker.components.DateTimePicker;
import javafx.scene.control.ComboBox;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ClientTab {
    TransparentJPanel innerPanel;
    JPanel addClientPanel, transformPanel, overAddPanel, searchClientPanel;
    JTextField Name, Surname, Lastname, Email, PhoneNumber, CreditCardNumber;
    JComboBox gender;
    DateTimePicker calendar;
    float spendSum;

    JTextField search;
    JPanel row, findbtnPanel, reEditbtnPanel, infoPanel, searchPanel, sNamePanel, sEmailPanel, sPhonePanel, sCreditPanel, sCalendarPanel, sGenderPanel, sSpendSumPanel;

    JButton searchButton;
    JScrollPane List;
    JPanel innerList;
    JTabbedPane tabbedPane;

    ClientTab(JTabbedPane tab){
        tabbedPane = tab;
    }

    TransparentJPanel create(TransparentJPanel panel) {
        UIManager.put("Panel.background", new Color(180, 208, 255));
        innerPanel = new TransparentJPanel(new Color(180, 216, 219));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(Box.createRigidArea(new Dimension(40, 40)));
        panel.add(innerPanel);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.LINE_AXIS));
   /*     innerPanel.setPreferredSize(new Dimension(Start.wwidth / 8 * 7, Start.wheight));*/

        overAddPanel = new JPanel();
        transformPanel = new JPanel();
        searchClientPanel = new JPanel();

        searchClientPanel.setMinimumSize(new Dimension(500, 100));
        overAddPanel.setPreferredSize(new Dimension(Start.wwidth / 8 * 3, 270));
        overAddPanel.setMaximumSize(new Dimension(Start.wwidth / 8 * 3, 270));
        overAddPanel.setMinimumSize(new Dimension(Start.wwidth / 8 * 3, 270));
        overAddPanel.setAlignmentX(0);
        innerPanel.add(transformPanel);
        transformPanel.setPreferredSize(new Dimension(Start.wwidth / 5 * 4, 270));
        transformPanel.add(Box.createHorizontalGlue());
        transformPanel.add(overAddPanel);
        transformPanel.add(Box.createHorizontalGlue());

        /*innerPanel.add(searchClientPanel);*/

        innerList = new JPanel();
        List = new JScrollPane(innerList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel.add(Box.createRigidArea(new Dimension(20, 10)));
        List.setVerticalScrollBar( new JScrollBar() {
            public int getUnitIncrement( int direction ) {
                return 25;
            }
        } );
        panel.add(List);

        addClient();
        searchClient();
        createList();
        panel.repaint();
        return panel;
    }

    void createList() {

        innerPanel.setPreferredSize(new Dimension(Start.wwidth / 5 * 4, 270));
        innerPanel.setMinimumSize(new Dimension(Start.wwidth / 5 * 4, 270));
        innerPanel.setMaximumSize(new Dimension(Start.wwidth / 5 * 4, 270));

        innerList.setMinimumSize(new Dimension(1270, Start.wheight/3 ));

        List.setPreferredSize(new Dimension(Start.wwidth / 5 * 4, Start.wheight / 2));
        List.setMaximumSize(new Dimension(Start.wwidth / 5 * 4, Start.wheight / 2));
        List.setMinimumSize(new Dimension(Start.wwidth / 5 * 4, Start.wheight / 2));
        innerList.add(searchClientPanel);


    }

    void searchClient() {
        searchClientPanel.setLayout(new BoxLayout(searchClientPanel, BoxLayout.PAGE_AXIS));


        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(600, 50));
        search = new JTextField("Введіть дані клієнта...");
        search.setPreferredSize(new Dimension(300, 25));
        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Введіть дані клієнта..."))
                    search.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
        /******/
        UIManager.put("Panel.background", new Color(180, 208, 255));
        infoPanel = new JPanel();
        infoPanel.setMinimumSize(new Dimension(1270, 100));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));

        searchButton = new JButton("Пошук");
        searchClientPanel.add(searchPanel);
        searchPanel.add(search);
        searchPanel.add(searchButton);
        searchClientPanel.add(infoPanel);


        JPanel contactPanel = new JPanel();
        contactPanel.setMinimumSize(new Dimension(1270, 50));


        row = new JPanel();
        sNamePanel = new JPanel();
        sNamePanel.setLayout(new BoxLayout(sNamePanel, BoxLayout.PAGE_AXIS));
        JLabel sNameLbl = new JLabel("Ім'я");
        sNameLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        sNamePanel.add(sNameLbl);
        contactPanel.add(sNamePanel);



        contactPanel.add(Box.createHorizontalGlue());

        sCalendarPanel = new JPanel();
        sCalendarPanel.setLayout(new BoxLayout(sCalendarPanel, BoxLayout.PAGE_AXIS));
        JLabel sCalendarLbl = new JLabel("Дата народження");
        sCalendarPanel.add(sCalendarLbl);
        sCalendarLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        contactPanel.add(sCalendarPanel);


        contactPanel.add(Box.createHorizontalGlue());

        sGenderPanel = new JPanel();
        sGenderPanel.setLayout(new BoxLayout(sGenderPanel, BoxLayout.PAGE_AXIS));
        JLabel sGenderLbl = new JLabel("Стать");
        sCalendarLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        sGenderPanel.add(sGenderLbl);
        contactPanel.add(sGenderPanel);


        contactPanel.add(Box.createHorizontalGlue());

        sSpendSumPanel = new JPanel();
        sSpendSumPanel.setLayout(new BoxLayout(sSpendSumPanel, BoxLayout.PAGE_AXIS));
        JLabel Spendsum1 = new JLabel("Сума витрат");
        Spendsum1.setAlignmentX(Label.LEFT_ALIGNMENT);
        sSpendSumPanel.add(Spendsum1);
        contactPanel.add(sSpendSumPanel);


        contactPanel.add(Box.createHorizontalGlue());

        JLabel sEmailLbl = new JLabel("Email");
        sEmailPanel = new JPanel();
        sEmailPanel.setLayout(new BoxLayout(sEmailPanel, BoxLayout.PAGE_AXIS));
        sEmailLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        sEmailPanel.add(sEmailLbl);
        contactPanel.add(sEmailPanel);


        contactPanel.add(Box.createHorizontalGlue());

        JLabel sPhoneNumberLbl = new JLabel("Телефон '+380#########'");
        sPhonePanel = new JPanel();
        sPhonePanel.setLayout(new BoxLayout(sPhonePanel, BoxLayout.PAGE_AXIS));
        sPhoneNumberLbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        contactPanel.add(sPhoneNumberLbl);
        sPhonePanel.add(sPhoneNumberLbl);
        contactPanel.add(sPhonePanel);


        contactPanel.add(Box.createHorizontalGlue());

        sCreditPanel = new JPanel();
        sCreditPanel.setLayout(new BoxLayout(sCreditPanel, BoxLayout.PAGE_AXIS));
        JLabel sCredit = new JLabel("Кредитна карта '#### #### #### ####'");
        sCredit.setAlignmentX(Label.LEFT_ALIGNMENT);
        sCreditPanel.add(sCredit);
        contactPanel.add(sCreditPanel);


        contactPanel.add(Box.createHorizontalGlue());


        findbtnPanel = new JPanel();
        reEditbtnPanel = new JPanel();
        findbtnPanel.add(new JLabel(" "));
        reEditbtnPanel.add(new JLabel(" "));
        findbtnPanel.setLayout(new BoxLayout(findbtnPanel, BoxLayout.PAGE_AXIS));
        reEditbtnPanel.setLayout(new BoxLayout(reEditbtnPanel, BoxLayout.PAGE_AXIS));
        contactPanel.add(findbtnPanel);
        contactPanel.add(reEditbtnPanel);


        findClients("SELECT * FROM clients ORDER BY SpendSum DESC");


        searchClientPanel.add(Box.createVerticalGlue());

        /******/


        searchButton.addActionListener(e -> findClients("SELECT * FROM clients WHERE name LIKE '%" + search.getText() + "%' or SurName LIKE '%" + search.getText() + "%' or LastName  LIKE '%" + search.getText() + "%' or DateofBirth  LIKE '%" + search.getText() + "%' or clients.EmailAddress  LIKE '%" + search.getText() + "%' or PhoneNumber  LIKE '%" + search.getText() + "%' or CreditCard LIKE '%" + search.getText() + "%' "));


    }

    void findClients(String str) {

        try {
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
            ResultSet res;


            Statement numState = DB.getConnection().createStatement();
            ResultSet num = numState.executeQuery(str);
            int rows = 0;
            if (num.next()) {
                rows = num.getInt(1);
            }

            clearFindList();
            infoPanel.removeAll();
            row.removeAll();
            if (rows != 0) {

                Statement statement = DB.getConnection().createStatement();
                res = statement.executeQuery(str);

                while (res.next()) {

                    int localID = res.getInt("id");
                    JTextField sName = new JTextField();
                    sName.setPreferredSize(new Dimension(250, 26));
                    sName.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    sNamePanel.add(sName);
                    row.add(sNamePanel);

                    DateTimePicker sCalendar = new DateTimePicker();
                    sCalendar.setPreferredSize(new Dimension(200, 26));
                    sCalendar.timePicker.hide();
                    sCalendar.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    sCalendarPanel.add(sCalendar);
                    row.add(sCalendarPanel);

                    JComboBox sGender = new JComboBox();
                    sGender.setPreferredSize(new Dimension(50, 26));
                    sGender.addItem("Чоловік");
                    sGender.addItem("Жінка");
                    sGender.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    sGenderPanel.add(sGender);
                    row.add(sGenderPanel);

                    JTextField Spendsum2 = new JTextField(spendSum + " грн.");
                    Spendsum2.setPreferredSize(new Dimension(50, 26));
                    Spendsum2.setAlignmentX(Label.LEFT_ALIGNMENT);
                    Spendsum2.setEditable(false);
                    sSpendSumPanel.add(Spendsum2);
                    row.add(sSpendSumPanel);

                    JTextField sEmail = new JTextField();
                    sEmail.setPreferredSize(new Dimension(120, 26));
                    sEmail.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    sEmailPanel.add(sEmail);
                    row.add(sEmailPanel);

                    JTextField sPhoneNumber = new JTextField();
                    sPhoneNumber.setPreferredSize(new Dimension(120, 26));
                    sPhonePanel.add(sPhoneNumber);
                    sPhoneNumber.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    row.add(sPhonePanel);

                    JTextField sCreditCardNumber = new JTextField();
                    sCreditCardNumber.setPreferredSize(new Dimension(120, 26));
                    sCreditCardNumber.setAlignmentX(TextField.LEFT_ALIGNMENT);
                    sCreditPanel.add(sCreditCardNumber);
                    row.add(sCreditPanel);

                    JButton findOrdersButton = new JButton("Показати замовлення");
                    JButton reEditButton = new JButton("Зберегти");
                    findbtnPanel.add(findOrdersButton);
                    reEditbtnPanel.add(reEditButton);
                    row.add(findbtnPanel);
                    row.add(reEditbtnPanel);

                    findOrdersButton.addActionListener(e -> {
                        JPanel pane = (JPanel) tabbedPane.getComponentAt(3); //CLient
                        tabbedPane.setSelectedIndex(3);
                        pane = (JPanel) pane.getComponent(0); //three
                        pane = (JPanel) pane.getComponent(0); //iner
                        JPanel overOrder = (JPanel) pane.getComponent(0); //overOrder

                        JPanel overAdd = (JPanel) overOrder.getComponent(0); //overAdd
                        pane = (JPanel) overAdd.getComponent(1); //upper
                        pane = (JPanel) pane.getComponent(0); //upper
                        JTextField client = (JTextField) pane.getComponent(1);
                        client.setText(sName.getText());

                        JPanel phonePanel = (JPanel) overAdd.getComponent(3);
                        phonePanel = (JPanel) phonePanel.getComponent(5);
                        JLabel phone = (JLabel) phonePanel.getComponent(0);
                        phone.setText(sPhoneNumber.getText());

                        JPanel search = (JPanel) overOrder.getComponent(3);
                        JTextField searchField = (JTextField) search.getComponent(0);
                        searchField.setText(sPhoneNumber.getText());
                        JButton btn = (JButton) search.getComponent(1);
                        btn.doClick();

                        searchField.setText("");
                    });

                    JButton submitAdd = new JButton("Додати");
                    reEditButton.addActionListener(e -> {
                        try {

                            String[] fullName = sName.getText().split(" ");
                            Statement updateState = DB.getConnection().createStatement();

                            int query = updateState.executeUpdate("UPDATE clients SET " +
                                    " Name = '" + fullName[1] + "'," +
                                    " LastName = '" + fullName[2] + "'," +
                                    " SurName = '" + fullName[0] + "'," +
                                    " Gender = '" + sGender.getSelectedItem() + "'," +
                                    " DateofBirth = '" + DateFormat.date(sCalendar) + "'," +
                                    " SpendSum = '" + 0 + "'," +
                                    " EmailAddress = '" + sEmail.getText() + "'," +
                                    " PhoneNumber = '" + sPhoneNumber.getText() + "'," +
                                    " CreditCard = '" + sCreditCardNumber.getText() + "'" +
                                    " WHERE id = " + localID);

                            Statement stateLog = DB.getConnection().createStatement();
                            int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                                    "VALUES ( + " + Session.sessionId + ", 'Оновив дані клієнта << " + fullName[1] + " " + fullName[2] + " " + fullName[0] + " >> ', " + localID + " ,'" + DateFormat.stringDateTime(new Date()) + "')");


                            innerList.setPreferredSize(new Dimension(1270, innerList.getPreferredSize().height+50));
                            innerList.setMaximumSize(new Dimension(1270, innerList.getPreferredSize().height+50));
                            innerList.setMinimumSize(new Dimension(1270, innerList.getPreferredSize().height+50));
                            innerList.revalidate();


                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(overAddPanel, "Помилка оновлення клієнта! Перевірте правильність введених даних!");
                        }
                    });

                    infoPanel.add(row);

                    sName.setText(res.getString("SurName") + " " + res.getString("Name") + " " + res.getString("LastName"));

                    Date date = dateformat.parse(res.getString("DateofBirth"));
                    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    sCalendar.datePicker.setDate(localDate);
                    sCreditCardNumber.setText(res.getString("CreditCard"));
                    Spendsum2.setText(res.getInt("SpendSum") + " грн.");
                    sEmail.setText(res.getString("EmailAddress"));
                    sPhoneNumber.setText(res.getString("PhoneNumber"));
                    if (res.getString("Gender").equals("Male"))
                        sGender.setSelectedItem("Чоловік");
                    else
                        sGender.setSelectedItem("Жінка");
                }
            } else {

                row.removeAll();
                search.setText("Нічого не знайдено!");
            }

        } catch (Exception ex) {

        }

        infoPanel.add(Box.createVerticalGlue());
    }

    void clearFindList(){
        sNamePanel.removeAll();
        sNamePanel.add(new JLabel("Ім'я"));
        sPhonePanel.removeAll();
        sPhonePanel.add(new JLabel("Телефон"));
        sEmailPanel.removeAll();
        sEmailPanel.add(new JLabel("Email"));
        sGenderPanel.removeAll();
        sGenderPanel.add(new JLabel("Стать"));
        sSpendSumPanel.removeAll();
        sSpendSumPanel.add(new JLabel("Сума витрат"));
        sCalendarPanel.removeAll();
        sCalendarPanel.add(new JLabel("Дата народження"));
        sCreditPanel.removeAll();
        sCreditPanel.add(new JLabel("Кредитна карта"));
        findbtnPanel.removeAll();
        findbtnPanel.add(new JLabel(" "));
        reEditbtnPanel.removeAll();
        reEditbtnPanel.add(new JLabel(" "));

    }

    void addClient(){
        addClientPanel = new JPanel();
        addClientPanel.setLayout(new BoxLayout(addClientPanel, BoxLayout.LINE_AXIS));
        addClientPanel.setPreferredSize(new Dimension(Start.wwidth/3, Start.wheight/13*3));
        addClientPanel.setMaximumSize(new Dimension(Start.wwidth/3, Start.wheight/13*3));
        JLabel addClientLbl = new JLabel("Додати нового клієнта", SwingConstants.CENTER);
        addClientLbl.setFont(new Font("Arial", Font.PLAIN, 28));
        overAddPanel.add(addClientLbl);
        overAddPanel.add(addClientPanel);
        addClientPanel.add(Box.createRigidArea(new Dimension(40, 40)));
        addClientPanel.setPreferredSize(new Dimension(Start.wwidth/8*3,220));
        addClientPanel.setMinimumSize(new Dimension(Start.wwidth/8*3,220));


        JPanel leftAddPanel, rightAddPanel;
        leftAddPanel = new JPanel();
        rightAddPanel = new JPanel();
        leftAddPanel.setLayout(new BoxLayout(leftAddPanel, BoxLayout.PAGE_AXIS));
        rightAddPanel.setLayout(new BoxLayout(rightAddPanel, BoxLayout.PAGE_AXIS));
        addClientPanel.add(leftAddPanel);
        addClientPanel.add(rightAddPanel);

        JLabel namelbl = new JLabel("Ім'я");
        namelbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        leftAddPanel.add(namelbl);
        Name = new JTextField();
        Name.setAlignmentX(TextField.LEFT_ALIGNMENT);
        leftAddPanel.add(Name);

        JLabel surnamelbl = new JLabel("Прізвище");
        surnamelbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        leftAddPanel.add(surnamelbl);
        Surname = new JTextField();
        Surname.setAlignmentX(TextField.LEFT_ALIGNMENT);
        leftAddPanel.add(Surname);

        JLabel LastNamelbl = new JLabel("По-батькові");
        LastNamelbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        leftAddPanel.add(LastNamelbl);
        Lastname = new JTextField();
        Lastname.setAlignmentX(TextField.LEFT_ALIGNMENT);
        leftAddPanel.add(Lastname);

        JLabel genderlbl = new JLabel("Стать");
        genderlbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        leftAddPanel.add(genderlbl);
        gender = new JComboBox();
        gender.setAlignmentX(TextField.LEFT_ALIGNMENT);
        gender.setSelectedItem("Чоловік");
        gender.addItem("Чоловік");
        gender.addItem("Жінка");
        leftAddPanel.add(gender);

        JLabel datelbl = new JLabel("Дата народження");
        datelbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        leftAddPanel.add(datelbl);
        calendar = new DateTimePicker();
        calendar.setMaximumSize(new Dimension(Start.wwidth/7,50));
        calendar.setMinimumSize(new Dimension(Start.wwidth/7,50));
        leftAddPanel.add(calendar);
        calendar.timePicker.hide();
        calendar.setAlignmentX(TextField.LEFT_ALIGNMENT);

        JLabel spendSum1 = new JLabel("Сума витрат");
        JTextField spendSum2 = new JTextField(spendSum + " грн.");
        spendSum2.setEditable(false);
        spendSum1.setAlignmentX(Label.LEFT_ALIGNMENT);
        spendSum2.setAlignmentX(Label.LEFT_ALIGNMENT);
        rightAddPanel.add(spendSum1);
        rightAddPanel.add(spendSum2);

        JLabel emaillbl = new JLabel("Email");
        emaillbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        rightAddPanel.add(emaillbl);
        Email = new JTextField();
        Email.setAlignmentX(TextField.LEFT_ALIGNMENT);
        rightAddPanel.add(Email);

        JLabel telephonelbl = new JLabel("Телефон");
        telephonelbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        rightAddPanel.add(telephonelbl);
        PhoneNumber = new JTextField();
        PhoneNumber.setText("+380");
        PhoneNumber.setAlignmentX(Label.LEFT_ALIGNMENT);
        rightAddPanel.add(PhoneNumber);

        JLabel creditlbl = new JLabel("Кредитна карта");
        creditlbl.setAlignmentX(Label.LEFT_ALIGNMENT);
        rightAddPanel.add(creditlbl);
        CreditCardNumber = new JTextField();
        CreditCardNumber.setAlignmentX(TextField.LEFT_ALIGNMENT);
        rightAddPanel.add(CreditCardNumber);

        rightAddPanel.add(Box.createRigidArea(new Dimension(10,10)));


        JButton submitAdd = new JButton("Додати");
        submitAdd.addActionListener(e -> {
            addBtn();
        });
        rightAddPanel.add(submitAdd);

        rightAddPanel.add(Box.createRigidArea(new Dimension(10,3)));

        JButton addAndOrder = new JButton("Додати і перейти до замовлень");
        addAndOrder.addActionListener(e -> {
            addBtn();
            JPanel pane = (JPanel) tabbedPane.getComponentAt(3); //CLient
            tabbedPane.setSelectedIndex(3);
            pane = (JPanel) pane.getComponent(0); //three
            pane = (JPanel) pane.getComponent(0); //iner
            pane = (JPanel) pane.getComponent(0); //overOrder
            JPanel overAdd = (JPanel) pane.getComponent(0); //overAdd
            pane = (JPanel) overAdd.getComponent(0); //upper
            pane = (JPanel) pane.getComponent(0); //upper
            JTextField client = (JTextField) pane.getComponent(1);
            client.setText(Name.getText() + " " + Surname.getText() + " " + Lastname.getText());

            JPanel phonePanel = (JPanel) overAdd.getComponent(3);
            JTextField phone = (JTextField) phonePanel.getComponent(5);
            phone.setText(PhoneNumber.getText());
        });
        rightAddPanel.add(addAndOrder);

        addClientPanel.add(Box.createRigidArea(new Dimension(10,10)));

    }

    void addBtn(){
        try {
            String queryDate = "";
            LocalDate localDate =  calendar.datePicker.getDate();
            if(localDate != null){
                Date d = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                queryDate = format.format(d);
            }
            String name = Name.getText(), surname = Surname.getText(), lastname = Lastname.getText();
             /*   if(name=="" && surname==""  && lastname==""){
                    JOptionPane.showMessageDialog(overAddPanel, "Введіть повне імя клієнта");
                    throw new Exception("Pis");
                }*/
            if(PhoneNumber.getText().length() != 13 || !PhoneNumber.getText().substring(0,4).equals("+380") || !NumberUtils.isNumber(PhoneNumber.getText().substring(4, PhoneNumber.getText().length()))){
                JOptionPane.showMessageDialog(overAddPanel, "Перевірте правильність вводу телефону!");
                throw new Exception("phone");
            }

            if(Name.getText().matches("[a-zA-zАа-яА-Я]{1}") || Name.getText().equals("") || Surname.getText().matches("[a-zA-zАа-яА-Я]{1}") || Surname.getText().equals("") || Lastname.getText().matches("[a-zA-zАа-яА-Я]{1}") || Lastname.getText().equals("") ){
                JOptionPane.showMessageDialog(overAddPanel, "Перевірте правильність вводу ПІП!");
                throw new Exception("name");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Statement statement = DB.getConnection().createStatement();
            int query = statement.executeUpdate("INSERT INTO clients(Name, LastName, SurName, Gender, DateofBirth, SpendSum, EmailAddress, PhoneNumber, CreditCard, timeAdded) " +
                    "VALUES (" +
                    "'" + Name.getText() + "'," +
                    "'" + Lastname.getText() + "'," +
                    "'" + Surname.getText() + "'," +
                    "'" + gender.getSelectedItem() + "'," +
                    "'" + queryDate + "'," +
                    "'" + 0 + "'," +
                    "'" + Email.getText() + "'," +
                    "'" + PhoneNumber.getText() + "'," +
                    "'" + CreditCardNumber.getText() + "'," +
                    "'" + sdf.format(new Date()) + "'" +
                    ")");

            Statement clientState = DB.getConnection().createStatement();
            ResultSet client = clientState.executeQuery("SELECT id, Name FROM clients WHERE PhoneNumber = " + PhoneNumber.getText());



            if(client.next()){
                Statement stateLog = DB.getConnection().createStatement();
                int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                        "VALUES ( + " + Session.sessionId + ", 'Додав нового клієнта << " + Name.getText() + " " + Surname.getText() + " " + Lastname.getText() + " >> ', " + client.getInt("id") + " ,'" + DateFormat.stringDateTime(new Date()) + "')");

            }
            JOptionPane.showMessageDialog(overAddPanel, "Клієнт успішно доданий!");
        }catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(overAddPanel, "Помилка вводу! Перевірте правильність введених даних!");
        }
    }

}
