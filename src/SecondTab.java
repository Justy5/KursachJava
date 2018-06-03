import com.github.lgooddatepicker.components.DateTimePicker;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondTab implements ActionListener{
    JPanel createTaskPanel, perfPanel, toClientPanel, deadlinePanel, subjPanel, submitPanel, priorityPanel;
    JComboBox performText, toClientText, priorityBox;
    TransparentJPanel upperPanel;
    JTextArea subj;
    DateTimePicker calendar;
    JTabbedPane allTasksPanel;
    Button submit;
    JLabel thirdPageLbl;
    int thirdPanelPage = 0;

    TransparentJPanel createOne(TransparentJPanel two) throws Exception{
        upperPanel = new TransparentJPanel();
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.LINE_AXIS));
        upperPanel.setMinimumSize(new Dimension(Start.wwidth / 8 * 7, 100));

        UIManager.put("Panel.background", new Color(180,208,255));
        UIManager.put("Label.font", new Font("Times New Roman",Font.PLAIN, 30));
        upperPanel.add(new JLabel("Швидке завдання"));
        UIManager.put("Label.font", new Font("Arial",Font.PLAIN, 16));

        createTaskPanel = new JPanel();
        createTaskPanel.setLayout(new BoxLayout(createTaskPanel, BoxLayout.LINE_AXIS));
        createTaskPanel.setPreferredSize(new Dimension(Start.wwidth/5*4,50));
        createTaskPanel.setMaximumSize(new Dimension(Start.wwidth/5*4,50));



        performText = new JComboBox();
        toClientText = new JComboBox();
        subj = new JTextArea();

        try {
            Statement Statement = DB.getConnection().createStatement();
            ResultSet performers = Statement.executeQuery("SELECT manager_name FROM menegers WHERE id <> "
                    + Session.sessionId);
            performText.addItem("You");
            while(performers.next())
                performText.addItem(performers.getString("manager_name"));

            Statement otherState = DB.getConnection().createStatement();
            ResultSet clients = otherState.executeQuery("SELECT Name, SurName, LastName  FROM clients");
            toClientText.setSelectedItem("None");
            while(clients.next()){
                String fullName = clients.getString("Surname")+ " "
                        + clients.getString("Name").substring(0, 1) + ". "
                        + clients.getString("LastName").substring(0, 1);
                toClientText.addItem(fullName);
            }

        }catch (Exception e){
            e.printStackTrace();
        }



        createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth/40,10)));

        perfPanel = new JPanel();
        perfPanel.setLayout(new BoxLayout(perfPanel, BoxLayout.PAGE_AXIS));
        perfPanel.add(new JLabel("Виконавець"));
        perfPanel.add(performText);
        perfPanel.setMaximumSize(new Dimension(Start.wwidth/16,50));
        perfPanel.setMinimumSize(new Dimension(Start.wwidth/16,50));
        perfPanel.add(Box.createVerticalGlue());
        createTaskPanel.add(perfPanel);

        createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth/40,10)));

        toClientText.setEditable(true);


        priorityPanel = new JPanel();
        toClientPanel = new JPanel();
        toClientText.getEditor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Statement statement = DB.getConnection().createStatement();
                    ResultSet clients = statement.executeQuery("SELECT Name, SurName, LastName FROM clients WHERE SurName LIKE '%" + toClientText.getEditor().getItem() + "%'");
                    toClientText.removeAllItems();
                    toClientText.setEnabled(true);
                    while(clients.next()){
                        String fullName = clients.getString("Surname")+ " "
                                + clients.getString("Name").substring(0, 1) + ". "
                                + clients.getString("LastName").substring(0, 1);
                        toClientText.addItem(fullName);
                    }
                    toClientText.setPopupVisible(true);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        toClientPanel.setLayout(new BoxLayout(toClientPanel, BoxLayout.PAGE_AXIS));
        toClientPanel.add(new JLabel("До Клієнта"));
        toClientPanel.add(toClientText);
        toClientPanel.setMaximumSize(new Dimension(Start.wwidth/16,50));
        toClientPanel.setMinimumSize(new Dimension(Start.wwidth/16,50));
        toClientPanel.add(Box.createVerticalGlue());
        createTaskPanel.add(toClientPanel);

        createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth/40,10)));


        calendar = new DateTimePicker();
        deadlinePanel = new JPanel();
        deadlinePanel.setLayout(new BoxLayout(deadlinePanel, BoxLayout.PAGE_AXIS));
        deadlinePanel.add(new JLabel("Deadline"));
        deadlinePanel.add(calendar);
        deadlinePanel.setMaximumSize(new Dimension(Start.wwidth/7,50));
        deadlinePanel.setMinimumSize(new Dimension(Start.wwidth/7,50));

        deadlinePanel.add(calendar);
        deadlinePanel.add(Box.createVerticalGlue());

        createTaskPanel.add(deadlinePanel);

        createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth/40,10)));


        priorityBox = new JComboBox();
        priorityPanel.setLayout(new BoxLayout(priorityPanel, BoxLayout.PAGE_AXIS));
        priorityPanel.setMaximumSize(new Dimension(Start.wwidth/15,50));
        priorityPanel.setMinimumSize(new Dimension(Start.wwidth/15,50));
        priorityBox.getEditor().setItem("Low");
        priorityBox.addItem("Low");
        priorityBox.addItem("Medium");
        priorityBox.addItem("High");
        priorityPanel.add(new JLabel("Пріорітет"));

        priorityPanel.add(priorityBox);
        createTaskPanel.add(priorityPanel);
        createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth/40,10)));

        subjPanel = new JPanel();
        subjPanel.setLayout(new BoxLayout(subjPanel, BoxLayout.PAGE_AXIS));
        subjPanel.add(new JLabel("Опис"));
        subj.setMaximumSize(new Dimension(Start.wwidth/7,30));
        subj.setMinimumSize(new Dimension(Start.wwidth/7,30));
        subj.setPreferredSize(new Dimension(Start.wwidth/7,30));
        subjPanel.add(subj);
        createTaskPanel.add(subjPanel);


        createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth/40,10)));
        submitPanel = new JPanel();
        submit = new Button("Додати");
        submit.setMaximumSize(new Dimension(80,30));
        submit.setMinimumSize(new Dimension(80,30));
        submitPanel.setMaximumSize(new Dimension(80,50));
        submitPanel.setMinimumSize(new Dimension(80,50));
        submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.PAGE_AXIS));
        submitPanel.add(Box.createRigidArea(new Dimension(30,20)));
        submitPanel.add(submit);
        submit.addActionListener(this);

        createTaskPanel.add(submitPanel);
        createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth/40,10)));

        UIManager.put("TabbedPane.tabsOpaque", Boolean.TRUE);
        allTasksPanel = new JTabbedPane();
        two.setLayout(new BoxLayout(two, BoxLayout.PAGE_AXIS));
        two.add(upperPanel);
        two.add(Box.createRigidArea(new Dimension(40,10)));
        two.add(createTaskPanel);
        two.add(Box.createRigidArea(new Dimension(40,10)));
        two.add(allTasksPanel);

        MyTasks myTasks = new MyTasks();
        MyTasks toDoTasks = new MyTasks();
        Appoint registerTasks = new Appoint();
        MyTasks allTasks = new MyTasks();

        allTasksPanel.addTab("<html><h4 style='padding:5px;'>Задачі на сьогодні</h4></html>", myTasks);
        allTasksPanel.addTab("<html><h4 style='padding:5px;'>Виконати</h4></html>", toDoTasks);
        allTasksPanel.addTab("<html><h4 style='padding:5px;'>Всі мої завдання</h4></html>", allTasks);
        allTasksPanel.addTab("<html><h4 style='padding:5px;'>Назначені</h4></html>", registerTasks);
        String deadSearch = DateFormat.stringDateTime(new Date());

        myTasks.createMyTaskTable("SELECT * FROM tasks WHERE Performer = "
                + Session.sessionId + " and status <> 'Dropped' and status <> 'Done' and deadLine LIKE  '%" + deadSearch.substring(0, deadSearch.length()-6) + "%' ORDER BY deadLine DESC, priority DESC, id DESC");
        toDoTasks.createMyTaskTable("SELECT * FROM tasks WHERE Performer = " +
                + Session.sessionId + " and status <> 'Dropped' and status <> 'Done' and deadLine NOT LIKE  '%" + deadSearch.substring(0, deadSearch.length()-6) + "%' ORDER BY deadLine DESC, priority DESC, id DESC");
        allTasks.createMyTaskTable("SELECT * FROM tasks WHERE Performer = "
                + Session.sessionId + " ORDER BY deadLine DESC, Priority DESC");

        myTasks.addPageScroller();
        toDoTasks.addPageScroller();
        registerTasks.addPageScroller();
        allTasks.addPageScroller();
        /*--------------------------------------------------------------*/
      /*  func(registerTasks, thirdPanelPage, thirdPageLbl);*/


       /* thirdPanel.getComponent()*/
        myTasks.repaint();
        allTasksPanel.repaint();
        return two;
    }




    public void actionPerformed(ActionEvent e)  {
        try {
            Statement statement = DB.getConnection().createStatement();
            Statement findPerformer = DB.getConnection().createStatement();
            String performTextValue = (String) performText.getSelectedItem();

            int perf=0;
            if(performTextValue.equals("You")){
                performTextValue = Session.name;
            }

            ResultSet perfs = findPerformer.executeQuery("SELECT id FROM menegers WHERE manager_name = '" + performTextValue + "'");
            if(perfs.next()){
                perf = perfs.getInt("id");
            }


            Statement findClient = DB.getConnection().createStatement();
            String toClientTextSelectedItem = (String) toClientText.getSelectedItem();
            int toClientId=0;
            ResultSet client = findClient.executeQuery("SELECT id FROM clients WHERE SurName = '" + toClientTextSelectedItem.substring(0,toClientTextSelectedItem.length()-5) +"'");
            if(client.next()){
                toClientId = client.getInt("id");
            }

            String priority = (String) priorityBox.getSelectedItem();


            SimpleDateFormat fulldateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");



            String
                    timeCreated = fulldateformat.format(new Date()),
                    deadline = dateformat.format(java.sql.Date.valueOf(calendar.datePicker.getDate())) + " " + timeformat.format(java.sql.Time.valueOf(calendar.timePicker.getTime())),

                    subject = subj.getText(),
                    status = "New";

            int query = statement.executeUpdate("INSERT INTO tasks (" +
                    "RegisterBy, " +
                    "Performer, " +
                    "toClient, " +
                    "Subject, " +
                    "Priority, " +
                    "timeCreate, " +
                    "deadLine, " +
                    "status) " +
                    "VALUES (" +
                    Session.sessionId + ", "
                    + perf + ", "
                    + toClientId + ", '"
                    + subject + "', '"
                    + priority + "', '"
                    + timeCreated + "', '"
                    + deadline + "', '"
                    + status + "')");
            Statement stateLog = DB.getConnection().createStatement();
            int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                    "VALUES ( + " + Session.sessionId + ", 'Створив нове завдання << " + subject + " >> ', " + perf + " ,'" + timeCreated + "')" );
            JOptionPane.showMessageDialog(createTaskPanel, "Дані внесені успішно!");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



}

class MyTasks extends JPanel{
    int page=0;
    JLabel pageLbl;
    String Sql;
    void createMyTaskTable(String mainSql) throws Exception{
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel overPanel = new JPanel();
        JPanel myTasks = new JPanel();
        overPanel.add(myTasks);
        this.add(overPanel);
        Sql = mainSql;
        myTasks.setPreferredSize(new Dimension(Start.wwidth/5*4, Start.wheight/8*5));
        myTasks.setMinimumSize(new Dimension(Start.wwidth/5*4, Start.wheight/8*5));
        myTasks.setMaximumSize(new Dimension(Start.wwidth / 6 * 5, Start.wheight /8*5));
        myTasks.setVisible(true);
        myTasks.setLayout(new BoxLayout(myTasks, BoxLayout.X_AXIS));
        Statement statement = DB.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(mainSql + " LIMIT " + (page*15) + " ,15 ");
        JPanel register = new JPanel();
        JPanel client = new JPanel();
        JPanel subject = new JPanel();
        JPanel deadLine = new JPanel();
        JPanel status = new JPanel();
        JPanel options = new JPanel();

        JButton editButton = new JButton();

        UIManager.put("Label.font", new Font("Times New Roman",Font.BOLD, 18));
        register.setLayout(new BoxLayout(register, BoxLayout.PAGE_AXIS));
        register.add(new JLabel("Назначено"));
        client.setLayout(new BoxLayout(client, BoxLayout.PAGE_AXIS));
        client.add(new JLabel("Клієнт"));
        subject.setLayout(new BoxLayout(subject, BoxLayout.PAGE_AXIS));
        subject.add(new JLabel("Опис"));
        deadLine.setLayout(new BoxLayout(deadLine, BoxLayout.PAGE_AXIS));
        deadLine.add(new JLabel("Дедлайн"));
        status.setLayout(new BoxLayout(status, BoxLayout.PAGE_AXIS));
        status.add(new JLabel("Статус"));
        options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
        options.add(new JLabel("Опції"));



        register.add(Box.createRigidArea(new Dimension(15,15)));
        client.add(Box.createRigidArea(new Dimension(15,15)));
        subject.add(Box.createRigidArea(new Dimension(15,15)));

        deadLine.add(Box.createRigidArea(new Dimension(15,15)));
        status.add(Box.createRigidArea(new Dimension(15,15)));
        options.add(Box.createRigidArea(new Dimension(15,15)));

        UIManager.put("Label.font", new Font("Times New Roman",Font.PLAIN, 16));
        int up=1, down=4;
        while (resultSet.next()){
            int localId = resultSet.getInt("id");
            Statement regist = DB.getConnection().createStatement();
            ResultSet reg = regist.executeQuery("SELECT manager_name FROM menegers WHERE id = " + resultSet.getString("RegisterBy"));

            register.add(Box.createRigidArea(new Dimension(1, down)));
            if(reg.next())
                register.add(new JLabel(reg.getString("manager_name")));
            else
                register.add(new JLabel(""));
            register.add(Box.createRigidArea(new Dimension(down, down)));
            Statement toCL = DB.getConnection().createStatement();
            ResultSet toClient = toCL.executeQuery("SELECT SurName, Name, LastName FROM clients WHERE id = " + resultSet.getString("toClient"));
            client.add(Box.createRigidArea(new Dimension(up, down)));
            if(toClient.next())
                client.add(new JLabel(toClient.getString("SurName")
                        + " "  + toClient.getString("Name") + " "
                        + toClient.getString("LastName")
                ));
            else
                client.add(new JLabel(""));
            client.add(Box.createRigidArea(new Dimension(down, down)));
            subject.add(Box.createRigidArea(new Dimension(up, down)));
            subject.add(new JLabel(resultSet.getString("Subject")));
            subject.add(Box.createRigidArea(new Dimension(down, down)));

            deadLine.add(Box.createRigidArea(new Dimension(up, down)));
            deadLine.add(new JLabel(resultSet.getString("deadLine")));
            deadLine.add(Box.createRigidArea(new Dimension(down, down)));
            status.add(Box.createRigidArea(new Dimension(up, down)));
            status.add(new JLabel(resultSet.getString("status")));
            status.add(Box.createRigidArea(new Dimension(down, down)));

            options.add(Box.createRigidArea(new Dimension(1,1)));
            options.add(ButtonPanel(localId));

            editButton.setActionCommand(localId + "");





        }
        register.add(Box.createVerticalGlue());
        client.add(Box.createVerticalGlue());
        subject.add(Box.createVerticalGlue());
        deadLine.add(Box.createVerticalGlue());
        status.add(Box.createVerticalGlue());
        options.add(Box.createVerticalGlue());
        myTasks.add(register);
        myTasks.add(Box.createHorizontalGlue());
        myTasks.add(client);
        myTasks.add(Box.createHorizontalGlue());
        myTasks.add(subject);
        myTasks.add(Box.createHorizontalGlue());
        myTasks.add(deadLine);
        myTasks.add(Box.createHorizontalGlue());
        myTasks.add(status);
        myTasks.add(Box.createHorizontalGlue());
        myTasks.add(options);







    }

    void addPageScroller() throws Exception{
        JPanel btnPanel = new JPanel();
        JButton left = new JButton("<<");
        left.setEnabled(false);
        JButton right = new JButton(">>");
        JButton update = new JButton("↻");
        pageLbl = new JLabel("0");
        left.addActionListener(e -> {
            try {


                if (page > 0) {
                    --page;
                }else
                    left.setEnabled(true);

                this.remove(0);
                this.repaint();
                this.createMyTaskTable(Sql);
                pageLbl.setText((page+1) + "");
                ((JPanel) this.getComponent(0)).add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        right.addActionListener(e -> {
            try {

                left.setEnabled(true);
                ++page;
                this.remove(0);
                this.repaint();
                this.createMyTaskTable(Sql);
                pageLbl.setText((page+1) + "");
                ((JPanel) this.getComponent(0)).add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        update.addActionListener(e -> {
            try {

                this.remove(0);
                this.repaint();
                this.createMyTaskTable(Sql);
                pageLbl.setText((page+1) + "");
                ((JPanel) this.getComponent(0)).add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        btnPanel.add(left);

        btnPanel.add(pageLbl);
        btnPanel.add(right);
        btnPanel.add(update);
        JPanel overPanel = (JPanel) this.getComponent(0);
        pageLbl.setText(page+1 + "");
        overPanel.add(Box.createRigidArea(new Dimension(0,0)));
        overPanel.add(btnPanel);
        this.add(overPanel);

    }

    JPanel ButtonPanel(int localId){
        UIManager.put("Button.background", new Color(247, 188, 49, 255));
        JButton done = new JButton("✔");
        done.setActionCommand(localId + "");
        done.addActionListener(e -> {
            try {

                Statement statement1 = DB.getConnection().createStatement();
                int query = statement1.executeUpdate("UPDATE tasks SET status = 'Done' WHERE id = " +
                        done.getActionCommand() );

                Statement taskState = DB.getConnection().createStatement();
                ResultSet taskLog = taskState.executeQuery("SELECT Subject, toClient FROM tasks WHERE id = " + done.getActionCommand());
                if(taskLog.next()) {

                    Statement stateLog = DB.getConnection().createStatement();
                    int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                            "VALUES (" + Session.sessionId + ", 'Виконав завдання << " + taskLog.getString("Subject") +" >> ', " + taskLog.getString("toClient") + " ,'" + DateFormat.stringDateTime(new Date()) + "')");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

        UIManager.put("Button.background", new Color(125, 125, 125, 255));
        JButton inProcess = new JButton("...");
        inProcess.setActionCommand(localId + "");
        inProcess.addActionListener(e -> {
            try {

                Statement statement1 = DB.getConnection().createStatement();
                int query = statement1.executeUpdate("UPDATE tasks SET status = 'Not Done' WHERE id = " +
                        inProcess.getActionCommand() );

                Statement taskState = DB.getConnection().createStatement();
                ResultSet taskLog = taskState.executeQuery("SELECT Subject, toClient FROM tasks WHERE id = " + inProcess.getActionCommand());
                if(taskLog.next()) {
                    Statement stateLog = DB.getConnection().createStatement();
                    int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                            "VALUES ( + " + Session.sessionId + ", 'Відмітив завдання << " + taskLog.getString("Subject") +" >> як Невиконане', " + taskLog.getString("toClient") + " ,'" + DateFormat.stringDateTime(new Date()) + "')");
                }
            }catch (Exception exc){
                exc.printStackTrace();
            }
        });
        UIManager.put("Button.background", new Color(231,52,36,255));
        JButton dropped = new JButton("D");
        dropped.setActionCommand(localId + "");
        dropped.addActionListener(e -> {
            try {

                Statement statement1 = DB.getConnection().createStatement();
                int query = statement1.executeUpdate("UPDATE tasks SET status = 'Dropped' WHERE id = " +
                        dropped.getActionCommand() );
                Statement taskState = DB.getConnection().createStatement();
                ResultSet taskLog = taskState.executeQuery("SELECT Subject, toClient FROM tasks WHERE id = " + dropped.getActionCommand());
                if(taskLog.next()) {
                    Statement stateLog = DB.getConnection().createStatement();
                    int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                            "VALUES ( + " + Session.sessionId + ", 'Відмітив завдання << " + taskLog.getString("Subject") +" >> як Покинуте', " + taskLog.getString("toClient") + " ,'" + DateFormat.stringDateTime(new Date()) + "')");
                }
            }catch (Exception exc){
                exc.printStackTrace();
            }
        });

        UIManager.put("Button.background", new Color(247, 188, 49, 255));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
        /*btnPanel.add(neww);*/
        btnPanel.add(inProcess);
        btnPanel.add(done);
        btnPanel.add(dropped);



        return btnPanel;
    }

}


