import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Appoint extends JPanel implements ActionListener {
    JPanel createTaskPanel, perfPanel, toClientPanel, deadlinePanel, subjPanel, submitPanel, priorityPanel, statusPanel;
    String Name, Surname, Lastname;
    int page=0;
    JLabel pageLbl;
    JPanel createEditOne(int npage, JPanel btnPanel) throws Exception{

        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        myPanel.setPreferredSize(new Dimension(Start.wwidth/5*4,Start.wheight/8*4));
        myPanel.setMinimumSize(new Dimension(Start.wwidth/5*4,Start.wheight/8*4));
        myPanel.setMaximumSize(new Dimension(Start.wwidth/5*4,Start.wheight/8*4));

        Statement mainStatement = DB.getConnection().createStatement();
        ResultSet mainResultSet = mainStatement.executeQuery("SELECT * FROM tasks WHERE RegisterBy = " + Session.sessionId + " LIMIT "+ (9*npage) + ", " + 9);
        System.out.println(" LIMIT "+ (11*npage-10) + ", " + (11*npage));

        ((JLabel) btnPanel.getComponent(1)).setText((npage+1) + "");
        int checker = 0;
        while (mainResultSet.next()) {
            String actualStatus = mainResultSet.getString("status");

            int TaskId = mainResultSet.getInt("id");
            createTaskPanel = new JPanel();
            createTaskPanel.setLayout(new BoxLayout(createTaskPanel, BoxLayout.LINE_AXIS));
            createTaskPanel.setPreferredSize(new Dimension(Start.wwidth/5*4,60));
            createTaskPanel.setMaximumSize(new Dimension(Start.wwidth/5*4,60));
            JComboBox performText, toClientText, priorityBox, statusBox;
            JTextArea subj;
            DateTimePicker calendar;
            JButton submit;
            performText = new JComboBox();
            toClientText = new JComboBox();
            subj = new JTextArea();
            perfPanel = new JPanel();
            priorityPanel = new JPanel();
            toClientPanel = new JPanel();
            deadlinePanel = new JPanel();
            submitPanel = new JPanel();
            subjPanel = new JPanel();
            statusPanel = new JPanel();
            if(checker==0)
            {

                priorityPanel.add(new JLabel("Пріорітет"));
                toClientPanel.add(new JLabel("До Клієнта"));
                deadlinePanel.add(new JLabel("Deadline"));
                subjPanel.add(new JLabel("Опис"));
                perfPanel.add(new JLabel("Виконавець"));
                statusPanel.add(new JLabel("Статус"));
            }else{
                priorityPanel.add(new JLabel(" "));
                toClientPanel.add(new JLabel(" "));
                deadlinePanel.add(new JLabel(" "));
                subjPanel.add(new JLabel(" "));
                perfPanel.add(new JLabel(" "));
                statusPanel.add(new JLabel(" "));
            }


            checker++;

            try {
                Statement Statement = DB.getConnection().createStatement();
                ResultSet performers = Statement.executeQuery("SELECT id, manager_name FROM menegers");

                String performerName = null, realPerformer = null;
                while (performers.next()){
                    performerName = performers.getString("manager_name");
                    if (performers.getInt("id") == mainResultSet.getInt("Performer"))
                        realPerformer = performerName;
                    performText.addItem(performerName);
                }
                performText.setSelectedItem(realPerformer);

                Statement otherState = DB.getConnection().createStatement();
                ResultSet clients = otherState.executeQuery("SELECT Name, SurName, LastName, id  FROM clients WHERE 1");

                String fullName = null, realClient = null;
                while (clients.next()) {

                    String lName = clients.getString("Name"),
                            lSurname = clients.getString("SurName"),
                            lLastname = clients.getString("LastName");
                    fullName = lSurname + " "
                            + lName.substring(0,1) + ". "
                            + lLastname.substring(0,1) + ".";
                    if(clients.getInt("id") == mainResultSet.getInt("toClient")) {
                        realClient = fullName;
                        Name = lName;
                        Surname = lSurname;
                        Lastname = lLastname;
                    }
                    toClientText.addItem(fullName);
                }
                toClientText.setSelectedItem(realClient);
                System.out.println(realClient);
            } catch (Exception e) {
                e.printStackTrace();
            }

            perfPanel.setLayout(new BoxLayout(perfPanel, BoxLayout.PAGE_AXIS));

            perfPanel.add(performText);

            perfPanel.setMaximumSize(new Dimension(Start.wwidth / 10, 50));
            perfPanel.setMinimumSize(new Dimension(Start.wwidth / 10, 50));
            perfPanel.add(Box.createVerticalGlue());
            createTaskPanel.add(perfPanel);

            toClientText.setEditable(true);


            toClientText.getEditor().addActionListener(e -> {
                try {

                    Statement statement = DB.getConnection().createStatement();
                    ResultSet clients = statement.executeQuery("SELECT Name, SurName, LastName FROM clients WHERE SurName LIKE '%" + toClientText.getEditor().getItem() + "%' WHERE 1");
                    toClientText.removeAllItems();
                    toClientText.setEnabled(true);
                    while (clients.next()) {
                        String fullName = clients.getString("Surname") + " "
                                + clients.getString("Name").substring(0, 1) + ". "
                                + clients.getString("LastName").substring(0, 1);
                        toClientText.addItem(fullName);
                    }
                    toClientText.setPopupVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            toClientPanel.setLayout(new BoxLayout(toClientPanel, BoxLayout.PAGE_AXIS));
            toClientPanel.add(toClientText);
            toClientPanel.setMaximumSize(new Dimension(Start.wwidth / 15, 50));
            toClientPanel.setMinimumSize(new Dimension(Start.wwidth / 15, 50));
            toClientPanel.add(Box.createVerticalGlue());
            createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth / 40,10)));
            createTaskPanel.add(toClientPanel);

            createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth / 40, 10)));


            calendar = new DateTimePicker();

            deadlinePanel.setLayout(new BoxLayout(deadlinePanel, BoxLayout.PAGE_AXIS));
            deadlinePanel.add(calendar);
            deadlinePanel.setMaximumSize(new Dimension(Start.wwidth / 5, 50));
            deadlinePanel.setMinimumSize(new Dimension(Start.wwidth / 5, 50));

            SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
            String[] deadlineSplit = mainResultSet.getString("deadLine").split(" ");
            LocalDate date = dateformat.parse(deadlineSplit[0]).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime time = timeformat.parse(deadlineSplit[1]).toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
            calendar.datePicker.setDate(date);
            calendar.timePicker.setTime(time);
            deadlinePanel.add(calendar);
            deadlinePanel.add(Box.createVerticalGlue());

            createTaskPanel.add(deadlinePanel);

            createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth / 40, 10)));


            priorityBox = new JComboBox();
            priorityPanel.setLayout(new BoxLayout(priorityPanel, BoxLayout.PAGE_AXIS));
            priorityPanel.setMaximumSize(new Dimension(Start.wwidth / 16, 50));
            priorityPanel.setMinimumSize(new Dimension(Start.wwidth / 16, 50));
            priorityBox.addItem("Low");
            priorityBox.addItem("Medium");
            priorityBox.addItem("High");
            priorityBox.setSelectedItem(mainResultSet.getString("Priority"));
            priorityPanel.add(priorityBox);
            createTaskPanel.add(priorityPanel);

            createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth / 80, 10)));


            subjPanel.setLayout(new BoxLayout(subjPanel, BoxLayout.PAGE_AXIS));
            subj.setMaximumSize(new Dimension(Start.wwidth / 7, 30));
            subj.setMinimumSize(new Dimension(Start.wwidth / 7, 30));
            subj.setPreferredSize(new Dimension(Start.wwidth / 7, 30));
            subj.setText(mainResultSet.getString("Subject"));
            subjPanel.add(subj);
            createTaskPanel.add(subjPanel);


            createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth / 80, 10)));


            statusBox = new JComboBox();
            statusBox.addItem("Not Done");
            statusBox.addItem("In Process");
            statusBox.addItem("Done");
            statusBox.addItem("Dropped");
            statusBox.setSelectedItem(actualStatus);
            statusPanel.setMaximumSize(new Dimension(Start.wwidth / 20, 50));
            statusPanel.setMinimumSize(new Dimension(Start.wwidth / 20, 50));
            statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.PAGE_AXIS));
            statusPanel.add(statusBox);
            createTaskPanel.add(statusPanel);

            createTaskPanel.add(Box.createRigidArea(new Dimension(Start.wwidth / 80, 10)));

            UIManager.put("Button.background", new Color(246,202,12));

            submit = new JButton("Оновити");
            submit.setMaximumSize(new Dimension(80, 30));
            submit.setMinimumSize(new Dimension(80, 30));
            submitPanel.setMaximumSize(new Dimension(100, 50));
            submitPanel.setMinimumSize(new Dimension(100, 50));
            submitPanel.setLayout(new BoxLayout(submitPanel, BoxLayout.PAGE_AXIS));
            submitPanel.add(Box.createRigidArea(new Dimension(30, 20)));
            submitPanel.add(submit);


            createTaskPanel.add(statusPanel);
            createTaskPanel.add(submitPanel);


            submit.addActionListener(e -> {
                try {
                    Statement perfStatement = DB.getConnection().createStatement();
                    System.out.println("SELECT * FROM menegers WHERE manager_name = '" + performText.getSelectedItem() + "'");
                    ResultSet findperf = perfStatement.executeQuery("SELECT * FROM menegers WHERE manager_name = '" + performText.getSelectedItem() + "'");
                    Statement clientStatement = DB.getConnection().createStatement();

                    ResultSet findclient = clientStatement.executeQuery("SELECT * FROM clients WHERE Name LIKE '" +
                            toClientText.getSelectedItem().toString().substring(toClientText.getSelectedItem().toString().length()-5,toClientText.getSelectedItem().toString().length()-4) + "%' and LastName LIKE '" + toClientText.getSelectedItem().toString().substring(toClientText.getSelectedItem().toString().length()-2, toClientText.getSelectedItem().toString().length()-1) + "%' and Surname = '" + toClientText.getSelectedItem().toString().substring(0, toClientText.getSelectedItem().toString().length()-5) + "'");
                    int performerText = 0,
                            toClientId = 0;

                    java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(calendar.datePicker.getDate().toString());
                    String
                            subject = subj.getText(),
                            priority = (String)priorityBox.getSelectedItem(),
                            deadline = dateformat.format(d) + " " + calendar.timePicker.getText(),
                            status = (String)statusBox.getSelectedItem();
                    if(findperf.next())
                        performerText = findperf.getInt("id");
                    if(findclient.next())
                        toClientId = findclient.getInt("id");
                    System.out.println("SELECT * FROM clients WHERE Name = '" + Name + "' and SurName = '" + Surname + "' and LastName = '" + Lastname + "'");
                    Statement statement1 = DB.getConnection().createStatement();
                    System.out.println("deadline " + deadline);
                    int query = statement1.executeUpdate("UPDATE tasks SET " +
                            "Performer = " + performerText + ", " +
                            "toClient = " + toClientId + ", "  +
                            "Subject = '"  + subject + "', " +
                            "Priority = '" + priority + "', " +

                            "deadLine = '"  + deadline + "', " +
                            "status = '" + status + "' WHERE id = " + TaskId);




                    Statement stateLog = DB.getConnection().createStatement();
                    int insertLog = stateLog.executeUpdate("INSERT INTO logs(loger, Content, tosmbd, time) " +
                            "VALUES ( + " + Session.sessionId + ", 'Оновив завдання << " + subject +" >> ', " + toClientId + " ,'" + DateFormat.stringDateTime(new Date()) + "'");


                    JOptionPane.showMessageDialog(createTaskPanel, "Дані змінені успішно!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(createTaskPanel, "Помилка вводу!");
                }
            });
            myPanel.add(createTaskPanel);


        }


        myPanel.add(Box.createVerticalGlue());
        return myPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    void addPageScroller() throws Exception{
        JPanel btnPanel = new JPanel();
        JButton left = new JButton("<<");
        left.setEnabled(false);
        JButton right = new JButton(">>");
        JButton update = new JButton("↻");
        pageLbl = new JLabel(page + "");
        left.addActionListener(e -> {
            try {


                if (page > 0) {
                    --page;
                }else
                    left.setEnabled(true);

                this.remove(0);
                this.add(createEditOne(page, btnPanel));
                this.repaint();
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
                this.add(createEditOne(page, btnPanel));
                this.repaint();
                ((JPanel) this.getComponent(0)).add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        update.addActionListener(e -> {
            try {

                this.remove(0);
                this.add(createEditOne(page, btnPanel));
                this.repaint();
                ((JPanel) this.getComponent(0)).add(btnPanel);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });
        btnPanel.add(left);

        btnPanel.add(pageLbl);
        btnPanel.add(right);
        btnPanel.add(update);
        this.add(createEditOne(page, btnPanel));
        JPanel thirdPanel = (JPanel) this.getComponent(0);
        thirdPanel.add(Box.createRigidArea(new Dimension(40,20)));
        thirdPanel.add(btnPanel);

    }

}
