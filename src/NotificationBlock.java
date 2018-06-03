import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class NotificationBlock extends JPanel {

    JPanel priorityPanel;
    JPanel toClientPanel;
    JPanel subjectPanel;
    String regName, clientName, Name, Surname, Lastname, subj;







    JPanel updateNotifications() throws Exception {
        Statement statement = DB.getConnection().createStatement();
        ResultSet notifies = statement.executeQuery("SELECT * FROM `tasks` WHERE Performer = " + Session.sessionId + " ORDER BY Priority, deadLine LIMIT 3");

        priorityPanel.removeAll();
        toClientPanel.removeAll();
        subjectPanel.removeAll();



        for (int i = 0; i<3; i++){
            if (notifies.next()) {
                UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 15));

                JLabel lbl1 = new JLabel();
                JLabel lbl2 = new JLabel();
                JLabel lbl3 = new JLabel();
                JLabel lbl4 = new JLabel();
                lbl1.setPreferredSize(new Dimension(40, 50));

                lbl2.setMinimumSize(new Dimension(175, 50));
                lbl2.setMaximumSize(new Dimension(175, 50));
                lbl3.setMinimumSize(new Dimension(200, 50));
                lbl3.setMaximumSize(new Dimension(200, 50));
                lbl4.setMinimumSize(new Dimension(Start.wwidth / 13 * 4, 50));
                lbl4.setMaximumSize(new Dimension(Start.wwidth / 13 * 4, 50));


                String priority = notifies.getString("Priority");
                ImageIcon lbl0_icon = null;
                if (priority.equals("High"))
                    lbl0_icon = new ImageIcon("D:\\_Diplom_suka_robu\\_DiplomMY\\resourses\\images\\dots\\red_dot.png");
                if (priority.equals("Medium"))
                    lbl0_icon = new ImageIcon("D:\\_Diplom_suka_robu\\_DiplomMY\\resourses\\images\\dots\\yellow_dot.png");
                if (priority.equals("Low"))
                    lbl0_icon = new ImageIcon("D:\\_Diplom_suka_robu\\_DiplomMY\\resourses\\images\\dots\\green_dot.png");
                lbl1.setIcon(lbl0_icon);




                int perf = notifies.getInt("RegisterBy");
                int toCl = notifies.getInt("toClient");
                subj = notifies.getString("Subject");

                Statement Statement = DB.getConnection().createStatement();
                ResultSet registers = Statement.executeQuery("SELECT manager_name FROM menegers WHERE id = "
                        + perf);

                if (registers.next())
                    regName = registers.getString("manager_name");


                ResultSet clients = Statement.executeQuery("SELECT * FROM clients WHERE id = "
                        + toCl);

                if (clients.next()) {
                    Name = clients.getString("Name");
                    Lastname = clients.getString("LastName");
                    Surname = clients.getString("Surname") + " ";
                }

                try {

                    lbl2.setToolTipText(regName);
                    lbl3.setToolTipText(Surname + " " + Name.substring(0, 1) + ". " +
                            Lastname.substring(0, 1));
                    lbl4.setToolTipText(subj + "");

                    clientName = Surname +
                            Name.substring(0, 1) + ". " +
                            Lastname.substring(0, 1);


                    if (subj.length() > 50)
                        subj = subj.substring(0, 45) + "...";


                    lbl2.setText("<html><div >" + regName + "</div></html>");
                    lbl3.setText("<html><div >" + clientName + ".</div></html>");
                    lbl4.setText(subj);

                    priorityPanel.add(lbl1);
                    priorityPanel.add(Box.createVerticalGlue());



                   /* toClientPanel.add(Box.createVerticalGlue());*/
                    toClientPanel.add(Box.createRigidArea(new Dimension(20, 15)));
                    toClientPanel.add(lbl3);
                    toClientPanel.add(Box.createVerticalGlue());

                   /* subjectPanel.add(Box.createVerticalGlue());*/
                    subjectPanel.add(Box.createRigidArea(new Dimension(20, 15)));
                    subjectPanel.add(lbl4);
                    subjectPanel.add(Box.createVerticalGlue());


                } catch (NullPointerException e) {

                }

            } else {
                break;
            }


        }
        this.repaint();
        return this;
    }

    JPanel createNotifications() throws Exception{
        JPanel notif = new JPanel();
        notif.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(notif);
        this.add(Box.createHorizontalGlue());

      /*  UIManager.put("Panel.background", new Color(250,50,50));*/
        JPanel headerPanel = new JPanel();
        JLabel header = new JLabel();
        JLabel emptyLabel = new JLabel();
        header.setText("Нагадування");
        notif.setLayout(new BoxLayout(notif, BoxLayout.PAGE_AXIS));
        notif.add(headerPanel);
        headerPanel.add(header);
        headerPanel.add(emptyLabel);
        Statement statement = DB.getConnection().createStatement();
        ResultSet notifies = statement.executeQuery("SELECT * FROM `tasks` WHERE Performer = " + Session.sessionId + " ORDER BY Priority, deadLine LIMIT 3");
        JPanel innerActualNotifications = new JPanel();
        UIManager.put("Panel.background", new Color(200,160,50));
        JPanel actualNotifications = new JPanel();
        notif.add(innerActualNotifications);
        innerActualNotifications.add(actualNotifications);
        innerActualNotifications.setLayout(new BoxLayout(innerActualNotifications, BoxLayout.LINE_AXIS));
        innerActualNotifications.add(actualNotifications);

        actualNotifications.setLayout(new BoxLayout(actualNotifications, BoxLayout.PAGE_AXIS));

        actualNotifications.setAlignmentX(Component.LEFT_ALIGNMENT);


        UIManager.put("Panel.background", new Color(160,160,160));
        JPanel panel = new JPanel();
        actualNotifications.add(panel);
        panel.setMaximumSize(new Dimension(Start.wwidth/10*4, 150));
        panel.setMinimumSize(new Dimension(Start.wwidth/10*4, 150));
        panel.setPreferredSize(new Dimension(Start.wwidth/10*4, 150));
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));



        priorityPanel = new JPanel();



        toClientPanel = new JPanel();

        subjectPanel = new JPanel();
        priorityPanel.setLayout(new BoxLayout(priorityPanel, BoxLayout.PAGE_AXIS));
        toClientPanel.setLayout(new BoxLayout(toClientPanel, BoxLayout.PAGE_AXIS));
        subjectPanel.setLayout(new BoxLayout(subjectPanel, BoxLayout.PAGE_AXIS));

        panel.add(Box.createRigidArea(new Dimension(15,80)));
        panel.add(priorityPanel);

        /*panel.add(registerPanel);*/

        panel.add(toClientPanel);

        panel.add(subjectPanel);


        for (int i=0; i<3; i++){
            if(notifies.next()){
                UIManager.put("Label.font", new Font("Arial",Font.PLAIN, 15));


                JLabel lbl1 = new JLabel();
                JLabel lbl2 = new JLabel();
                JLabel lbl3 = new JLabel();
                JLabel lbl4 = new JLabel();
                lbl1.setPreferredSize(new Dimension(40, 50));

                lbl2.setMinimumSize(new Dimension(175, 50));
                lbl2.setMaximumSize(new Dimension(175, 50));
                lbl3.setMinimumSize(new Dimension(200, 50));
                lbl3.setMaximumSize(new Dimension(200, 50));
                lbl4.setMinimumSize(new Dimension(Start.wwidth / 13 * 4, 50));
                lbl4.setMaximumSize(new Dimension(Start.wwidth / 13 * 4, 50));
                String priority = notifies.getString("Priority");
                ImageIcon lbl0_icon = null;
                if(priority.equals("High"))
                    lbl0_icon = new ImageIcon("D:\\_Diplom_suka_robu\\_DiplomMY\\resourses\\images\\dots\\red_dot.png");
                if(priority.equals("Medium"))
                    lbl0_icon = new ImageIcon("D:\\_Diplom_suka_robu\\_DiplomMY\\resourses\\images\\dots\\yellow_dot.png");
                if(priority.equals("Low"))
                    lbl0_icon = new ImageIcon("D:\\_Diplom_suka_robu\\_DiplomMY\\resourses\\images\\dots\\green_dot.png");
                lbl1.setIcon(lbl0_icon);




                String subj = notifies.getString("Subject");

                int perf = notifies.getInt("RegisterBy");
                int toCl = notifies.getInt("toClient");

                Statement Statement = DB.getConnection().createStatement();
                ResultSet registers = Statement.executeQuery("SELECT manager_name FROM menegers WHERE id = "
                        + perf);

                if(registers.next())
                    regName = registers.getString("manager_name");


                ResultSet clients = Statement.executeQuery("SELECT * FROM clients WHERE id = "
                        + toCl);

                if(clients.next()) {
                    Name = clients.getString("Name");
                    Lastname = clients.getString("LastName");
                    Surname = clients.getString("Surname") + " ";
                }

                try {
                    lbl2.setToolTipText(regName);
                    lbl3.setToolTipText(Surname + " " + Name.substring(0, 1) + ". " +
                            Lastname.substring(0, 1));
                    lbl4.setToolTipText(subj);

                    clientName = Surname +
                            Name.substring(0, 1) + ". " +
                            Lastname.substring(0, 1);



                    if(subj.length()>50)
                        subj = subj.substring(0,45) + "...";


                    lbl2.setText("<html><div >" + regName + "</div></html>");
                    lbl3.setText("<html><div >" + clientName + ".</div></html>");
                    lbl4.setText(subj);



                  /*  priorityPanel.add(Box.createVerticalGlue());
                    priorityPanel.add(Box.createRigidArea(new Dimension(20, 8)));*/
                    priorityPanel.add(lbl1);
                    priorityPanel.add(Box.createVerticalGlue());


                   /* toClientPanel.add(Box.createVerticalGlue());*/
                    toClientPanel.add(Box.createRigidArea(new Dimension(20, 15)));
                    toClientPanel.add(lbl3);
                    toClientPanel.add(Box.createVerticalGlue());

                   /* subjectPanel.add(Box.createVerticalGlue());*/
                    subjectPanel.add(Box.createRigidArea(new Dimension(20, 15)));
                    subjectPanel.add(lbl4);
                    subjectPanel.add(Box.createVerticalGlue());


                    priorityPanel.setPreferredSize(new Dimension(40, 150));

                    toClientPanel.setMinimumSize(new Dimension(200, 150));
                    toClientPanel.setMaximumSize(new Dimension(200, 150));
                    subjectPanel.setMinimumSize(new Dimension(Start.wwidth / 13 * 4, 150));
                    subjectPanel.setMaximumSize(new Dimension(Start.wwidth / 13 * 4, 150));
                }catch (NullPointerException e){

                }



            }else {
                break;
            }
        }

        return this;
    }


}
